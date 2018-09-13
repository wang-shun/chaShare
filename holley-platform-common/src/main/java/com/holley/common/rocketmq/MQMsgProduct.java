package com.holley.common.rocketmq;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * 消息生产者
 * 
 * @author zhouli
 */
public class MQMsgProduct {

    protected static Logger   logger        = Logger.getLogger(MQMsgProduct.class);

    /**
     * 地址组，如果有集群配置用逗号分隔
     */
    public String             namesrvAddrs;

    /**
     * 可根据需要spring注入修改
     */
    public String             producerGroup = MQConstants.PORDUCT_GROUP;
    private DefaultMQProducer producer;

    /**
     * 初始化,仅调用一次，可在spring配置调用
     */
    public synchronized void init() {

        InputStream is = null;
        try {
            is = MQMsgProduct.class.getClassLoader().getResourceAsStream("rocketMq.properties");
            Properties prop = new Properties();
            prop.load(is);
            namesrvAddrs = prop.getProperty("nameAddrs");
            if (StringUtils.isEmpty(namesrvAddrs)) {
                throw new Exception("rocketMq.properties配置地址不正确！");
            }
            producer = new DefaultMQProducer(producerGroup);
            producer.setNamesrvAddr(namesrvAddrs);
            producer.start();

        } catch (Exception e) {
            logger.error("First create MsgPooductUtil error : " + e.getMessage()+":"+e.toString());
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

    public void shutdown() {
        producer.shutdown();
    }

    /**
     * 发送消息
     * 
     * @param msg
     * @return
     */
    public SendResult sendMQMsg(MsgBase msg) {
        if (msg != null && msg.getTopic() != null) {
            Message sendmsg = new Message(msg.getTopic(), msg.getTag(), msg.getKey(), msg.getBody());
            SendResult result = null;
            try {
                result = producer.send(sendmsg);
            } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
                logger.error("send mq message error : " + e.getMessage());
            }
            return result;
        }
        return null;
    }

    /*
     * public static void main(String[] args) throws IOException { InputStream s =
     * MQMsgProduct.class.getClassLoader().getResourceAsStream("rocketMQ.properties"); Properties p = new Properties();
     * p.load(s); System.out.println(p.get("nameAddrs")); }
     */
}
