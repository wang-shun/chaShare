package com.holley.platform.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;

import com.holley.common.rocketmq.MQConstants;
import com.holley.common.rocketmq.MQListener;
import com.holley.common.rocketmq.MsgBase;
import com.holley.platform.model.EmailModel;
import com.holley.platform.model.SMSModel;
import com.holley.platform.model.sys.SysNotice;
import com.holley.platform.service.MessageService;

public class MsgConsumer implements MQListener {

    private MessageService messageService;

    @Override
    public int consumeMessage(List<MsgBase> msgs) {
        if (msgs != null && msgs.size() > 0) {
            int result = 0;
            List<SysNotice> messageList = new ArrayList<SysNotice>();
            List<EmailModel> emailList = new ArrayList<EmailModel>();
            List<SMSModel> smsList = new ArrayList<SMSModel>();

            String tag;
            for (MsgBase msg : msgs) {
                System.out.println("msg=" + new String(msg.getBody()));
                tag = msg.getTag();
                if (tag.equals(MQConstants.TAG_MSG_MESSAGE)) {
                    SysNotice record = SerializationUtils.deserialize(msg.getBody());
                    messageList.add(record);
                } else if (tag.equals(MQConstants.TAG_MSG_EMAIL)) {
                    EmailModel record = SerializationUtils.deserialize(msg.getBody());
                    emailList.add(record);
                } else if (tag.equals(MQConstants.TAG_MSG_SMS)) {
                    SMSModel record = SerializationUtils.deserialize(msg.getBody());
                    smsList.add(record);
                }
            }
            result += messageService.sendMessageList(messageList);
            result += messageService.sendEmailList(emailList);
            result += messageService.sendSMSList(smsList);
            return result;
        }
        return 0;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

}
