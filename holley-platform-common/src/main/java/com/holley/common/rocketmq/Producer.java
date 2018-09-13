package com.holley.common.rocketmq;

import java.util.Calendar;
import java.util.Date;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.holley.common.rocketmq.charging.MsgAppointmentReq;
import com.holley.common.util.DateUtil;

public class Producer {

    public static void main(String[] args) {
        int i = 10;

        DefaultMQProducer producer = new DefaultMQProducer(MQConstants.PORDUCT_GROUP);
        producer.setNamesrvAddr("172.16.20.46:9876");// 10.175.200.141:9876
        SendResult result;
        try {
            producer.start();
            while (i-- > 0) {
                Calendar now = Calendar.getInstance();
                MsgAppointmentReq msg = new MsgAppointmentReq(Integer.valueOf(1), Integer.valueOf(1), "123456", now.getTime(), "123456");
                Message sendmsg = new Message(msg.getTopic(), msg.getTag(), msg.getKey(), msg.getBody());
                result = producer.send(sendmsg);
                System.out.println(i + " " + result + " " + DateUtil.DateToLongStr(new Date()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }

        // DefaultMQProducer producer = new DefaultMQProducer("testProductGroup");
        // producer.setNamesrvAddr("10.175.200.141:9876");// 10.175.200.141:9876
        // try {
        // producer.start();
        // Message msg = new Message("tagChargeStart", "push", "1", "Just for test.11".getBytes());
        //
        // SendResult result = producer.send(msg);
        // System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus() + " " +
        // DateUtil.DateToLongStr(new Date()));
        //
        // msg = new Message("tagChargeStart", "push", "2", "Just for test.22".getBytes());
        //
        // result = producer.send(msg);
        // System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus() + " " +
        // DateUtil.DateToLongStr(new Date()));
        //
        // msg = new Message("tagChargeStart", "push", "3", "Just for test.33".getBytes());
        //
        // result = producer.send(msg);
        // System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus() + " " +
        // DateUtil.DateToLongStr(new Date()));
        // } catch (Exception e) {
        // e.printStackTrace();
        // } finally {
        // producer.shutdown();
        // }
    }
}
