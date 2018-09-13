package com.holley.platform.util;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.SerializationUtils;

import com.alibaba.rocketmq.client.producer.SendResult;
import com.holley.common.rocketmq.MQConstants;
import com.holley.common.rocketmq.MQMsgProduct;
import com.holley.common.rocketmq.MsgBase;
import com.holley.platform.model.EmailModel;
import com.holley.platform.model.SMSModel;
import com.holley.platform.model.sys.SysNotice;

/**
 * 日志发送，借助消息中间件异步发送
 * 
 * @author zhouli
 */
public class MsgProduct {

    private static MQMsgProduct mqMsgProduct;

    public static SendResult sendMsg(Object obj) {
        if (obj == null) return null;

        MsgBase msg = new MsgBase();
        msg.setTopic(MQConstants.TOPIC_MESSAGE);

        String msgTag = null;
        if (obj instanceof SysNotice) {
            msgTag = MQConstants.TAG_MSG_MESSAGE;
        } else if (obj instanceof EmailModel) {
            msgTag = MQConstants.TAG_MSG_EMAIL;
        } else if (obj instanceof SMSModel) {
            msgTag = MQConstants.TAG_MSG_SMS;
        }
        if (msgTag == null) return null;
        msg.setTag(msgTag);
        msg.setBody(SerializationUtils.serialize((Serializable) obj));
        msg.setKey(new Date().getTime() + "");
        return mqMsgProduct.sendMQMsg(msg);
    }

    public void setMqMsgProduct(MQMsgProduct mqMsgProduct) {
        MsgProduct.mqMsgProduct = mqMsgProduct;
    }

}
