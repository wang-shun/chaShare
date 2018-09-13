package com.holley.common.rocketmq;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

/**
 * WEB工程用消息消费
 * 
 * @author zhouli
 */
public class MQWebConsumer {

    protected static Logger        logger        = Logger.getLogger(MQWebConsumer.class);

    /**
     * 地址组，以逗号分隔
     */
    private String                 namesrvAddrs;
    private DefaultMQPushConsumer  consumer;
    private MQListener             mqListener;                                           // 需要注入
    private MQListenerConcurrently messageListenerConcurrently;
    private String                 consumerGroup = MQConstants.CONSUMER_GROUP;
    private String                 topic         = MQConstants.TOPIC_MESSAGE;

    /**
     * 初始化,仅调用一次，可在spring配置调用
     */
    public synchronized void init() {
        System.out.println("---------------init-----------------");
        InputStream is = null;
        try {
            is = MQWebConsumer.class.getClassLoader().getResourceAsStream("rocketMq.properties");
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

            // 订阅dcserver下所有Tag的消息

            consumer.subscribe(topic, "*");

            // 日志采用批量处理
            // consumer.setConsumeMessageBatchMaxSize(32);

            // 程序第一次启动从消息队列头取数据
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

            messageListenerConcurrently = new MQListenerConcurrently();
            messageListenerConcurrently.mqListener = mqListener;
            consumer.registerMessageListener(messageListenerConcurrently);

            consumer.start();
            System.out.println("---------------init end-----------------");
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
            messageListenerConcurrently.mqListener = mqListener;
        }
    }

    public boolean alive() {
        return consumer != null;
    }

    private class MQListenerConcurrently implements MessageListenerConcurrently {

        public MQListener mqListener = null;

        @Override
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
            if (msgs == null || msgs.size() == 0) {
                return null;
            }
            List<MsgBase> msgList = new ArrayList<MsgBase>(msgs.size());
            for (int i = 0; i < msgs.size(); i++) {
                MessageExt msg = msgs.get(i);
                MsgBase msgDeal = null;
                System.out.println("---------------received-----------------");
                if (msg != null && msg.getBody() != null) {
                    msgDeal = new MsgBase();
                    msgDeal.setId(msg.getMsgId());
                    msgDeal.setTopic(msg.getTopic());
                    msgDeal.setTag(msg.getTags());
                    msgDeal.setBody(msg.getBody());
                    msgDeal.setKey(msg.getKeys());
                }
                msgList.add(msgDeal);

                System.out.println("id=" + msg.getMsgId());
            }
            if (mqListener != null) {
                mqListener.consumeMessage(msgList);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }

    }

    public void setMessageListenerConcurrently(MQListenerConcurrently messageListenerConcurrently) {
        this.messageListenerConcurrently = messageListenerConcurrently;
    }

    public void setNamesrvAddrs(String namesrvAddrs) {
        this.namesrvAddrs = namesrvAddrs;
    }

    public void setConsumer(DefaultMQPushConsumer consumer) {
        this.consumer = consumer;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
