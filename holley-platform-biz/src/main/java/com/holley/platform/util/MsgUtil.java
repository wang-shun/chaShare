package com.holley.platform.util;

import com.holley.common.constants.EmailSubjectEnum;
import com.holley.platform.service.MessageService;

public class MsgUtil {

    private static MessageService messageService;

    /**
     * 不走队列发送验证短信
     */
    public static boolean sendSMS(String phone, String content) {
        return messageService.sendPhoneCode(phone, content);
    }

    /**
     * 不走队列发送审核通知短信
     */
    public static boolean sendVerifySMS(String phone, String content, String result) {
        return messageService.sendPhoneVerify(phone, content, result);
    }

    /**
     * 不走队列发送平台人工充值通知短信
     */
    public static boolean sendAccountSMS(String phone, String content, String usablemoney) {
        return messageService.sendPhoneAccount(phone, content, usablemoney);
    }

    /**
     * 不走队列发送邮箱
     */
    public static boolean sendEmail(EmailSubjectEnum emailSubject, String content, String email) {
        return messageService.sendEmail(emailSubject, content, email);
    }

    /**
     * 不走队列发送站内信，插入用户站内信关系表
     * 
     * @return
     */
    public static boolean sendMessage(Integer reciveUser, Integer messageid) {
        return messageService.insertMessage(reciveUser, messageid);
    }

    /**
     * 不走队列发送单条站内信，同时插入站内信内容和用户站内信关系表
     */
    public static boolean sendMessage(Integer reciveUser, String content, String title) {
        return messageService.insertMessage(reciveUser, content, title);
    }

    // /**
    // * 队列发送短信
    // *
    // * @param record
    // */
    // public static SendResult sendSMS(SMSModel record) {
    // return MsgProduct.sendMsg(record);
    // }
    //
    // /**
    // * 队列发送邮箱
    // *
    // * @param record
    // */
    // public static SendResult sendEmail(EmailModel record) {
    // return MsgProduct.sendMsg(record);
    // }
    //
    // /**
    // * 队列发送站内信
    // *
    // * @param record
    // */
    // public static SendResult sendMessage(SysNotice record) {
    // return MsgProduct.sendMsg(record);
    // }

    // SET
    public void setMessageService(MessageService messageService) {
        MsgUtil.messageService = messageService;
    }

}
