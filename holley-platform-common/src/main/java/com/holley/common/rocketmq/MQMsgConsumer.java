package com.holley.common.rocketmq;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import com.holley.common.rocketmq.charging.MsgAPP2DCS;
import com.holley.common.rocketmq.charging.MsgAppointmentCancle;
import com.holley.common.rocketmq.charging.MsgAppointmentReq;
import com.holley.common.rocketmq.charging.MsgChargeStart;
import com.holley.common.rocketmq.charging.MsgChargeStop;
import com.holley.common.util.DateUtil;

/**
 * 前置服务消息消费者
 * 
 * @author zhouli
 */
public class MQMsgConsumer {

    protected static Logger        logger = Logger.getLogger(MQMsgConsumer.class);

    /**
     * 地址组，已逗号分隔
     */
    public String                  namesrvAddrs;
    public DefaultMQPushConsumer   consumer;
    private MQListener             mqListener;                                    // 需要注入
    private MQListenerConcurrently messageListenerConcurrently;
    int                            no     = 0;

    /**
     * 初始化,仅调用一次，可在spring配置调用
     */
    public synchronized void init() {
        InputStream is = null;
        try {
            is = MQMsgConsumer.class.getClassLoader().getResourceAsStream("rocketMq.properties");
            Properties prop = new Properties();
            prop.load(is);

            namesrvAddrs = prop.getProperty("nameAddrs");
            if (StringUtils.isEmpty(namesrvAddrs)) {
                throw new Exception("rocketMq.properties配置地址不正确！");
            }
            if (consumer != null) {
                consumer.shutdown();
            }

            consumer = new DefaultMQPushConsumer(MQConstants.CONSUMER_GROUP);

            consumer.setNamesrvAddr(namesrvAddrs);
            consumer.setMessageModel(MessageModel.BROADCASTING);
            // 订阅dcserver下所有Tag的消息
            consumer.subscribe(MQConstants.TOPIC_DCSERVER, "*");

            // 程序第一次启动从消息队列头取数据
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

            messageListenerConcurrently = new MQListenerConcurrently();
            messageListenerConcurrently.mqListner = mqListener;
            consumer.registerMessageListener(messageListenerConcurrently);
            /*
             * consumer.registerMessageListener(new MessageListenerConcurrently() { public ConsumeConcurrentlyStatus
             * consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext Context) { Message msg = list.get(0);
             * System.out.println(msg.toString()); return ConsumeConcurrentlyStatus.CONSUME_SUCCESS; } });
             */
            consumer.start();
        } catch (Exception e) {
            logger.error("First create MsgPooductUtil error : " + e.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setMqListener(MQListener mqListener) {
        this.mqListener = mqListener;
        if (messageListenerConcurrently != null) {
            messageListenerConcurrently.mqListner = mqListener;
        }
    }

    public void setNamesrvAddrs(String namesrvAddrs) {
        this.namesrvAddrs = namesrvAddrs;
    }

    public void setConsumer(DefaultMQPushConsumer consumer) {
        this.consumer = consumer;
    }

    public boolean alive() {
        return consumer != null;
    }

    private class MQListenerConcurrently implements MessageListenerConcurrently {

        public MQListener mqListner = null;

        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
            if (msgs == null || msgs.size() == 0) {
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
            try {
                List<MsgBase> msgList = new ArrayList<MsgBase>(msgs.size());
                for (int i = 0; i < msgs.size(); i++) {
                    System.out.println(no++ + "  " + DateUtil.DateToLongStr(new Date()) + "         " + msgs.get(i).toString());

                    MessageExt msg = msgs.get(i);
                    MsgBase msgDeal = null;
                    if (msg != null && msg.getBody() != null) {
                        if (StringUtils.equals(msg.getTags(), MQConstants.TAG_APPOINTMENTCANCEL)) {
                            msgDeal = (MsgAppointmentCancle) MsgAPP2DCS.generator(msg.getBody());
                        } else if (StringUtils.equals(msg.getTags(), MQConstants.TAG_APPOINTMENTREQ)) {
                            msgDeal = (MsgAppointmentReq) MsgAPP2DCS.generator(msg.getBody());
                        } else if (StringUtils.equals(msg.getTags(), MQConstants.TAG_CHARGESTART)) {
                            msgDeal = (MsgChargeStart) MsgAPP2DCS.generator(msg.getBody());
                        } else if (StringUtils.equals(msg.getTags(), MQConstants.TAG_CHARGESTOP)) {
                            msgDeal = (MsgChargeStop) MsgAPP2DCS.generator(msg.getBody());
                        }
                    }
                    msgList.add(msgDeal);
                }
                if (mqListner != null) {
                    mqListner.consumeMessage(msgList);
                }
            } catch (Exception e) {
                logger.error("consumeMessage error : " + e.getMessage());
            } finally {
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }

        }

    }
}
