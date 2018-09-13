package com.holley.platform.service;

import java.util.List;

import com.holley.common.constants.EmailSubjectEnum;
import com.holley.common.constants.charge.NoticeTypeEnum;
import com.holley.platform.model.EmailModel;
import com.holley.platform.model.SMSModel;
import com.holley.platform.model.sys.SysNotice;
import com.holley.platform.model.sys.SysNoticeMessage;

/**
 * 消息服务
 * 
 * @author zhouli
 */
public interface MessageService {

    /**
     * 发送验证短信--消息不存库
     */
    boolean sendPhoneCode(String phone, String content);

    /**
     * 发送审核通知短信--消息不存库
     */
    boolean sendPhoneVerify(String phone, String content, String result);

    /**
     * 发送账户通知短信--消息不存库
     */
    boolean sendPhoneAccount(String phone, String content, String usablemoney);

    /**
     * 发送邮箱--消息不存库
     */
    boolean sendEmail(EmailSubjectEnum emailSubject, String content, String email);

    /**
     * 发送站内信
     */
    boolean insertMessage(Integer reciveUser, Integer messageid);

    boolean insertMessage(Integer reciveUser, String content, String title);

    boolean insertNoticeAndMessage(Integer reciveUser, String content, String title, NoticeTypeEnum noticeType);

    /**
     * 发送短信--消息存库
     */
    int sendSMSList(List<SMSModel> list);

    /**
     * 发送邮箱--消息存库
     */
    int sendEmailList(List<EmailModel> list);

    /**
     * 发送站内信
     */
    int sendMessageList(List<SysNotice> list);

    /**
     * 插入消息内容
     */
    int insertNoticeMessage(SysNoticeMessage record);

    /**
     * 插入消息发送记录
     */
    int insertNotice(SysNotice record);

}
