package com.holley.platform.serviceimpl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.holley.common.constants.EmailSubjectEnum;
import com.holley.common.constants.charge.NoticeSendStatusEnum;
import com.holley.common.constants.charge.NoticeTypeEnum;
import com.holley.common.constants.charge.WhetherEnum;
import com.holley.platform.dao.sys.SysNoticeMapper;
import com.holley.platform.dao.sys.SysNoticeMessageMapper;
import com.holley.platform.model.EmailModel;
import com.holley.platform.model.SMSModel;
import com.holley.platform.model.sys.SysNotice;
import com.holley.platform.model.sys.SysNoticeMessage;
import com.holley.platform.service.MessageService;
import com.holley.web.common.util.AlidayuSendPhone;
import com.holley.web.common.util.MailUtil;

public class MessageServiceImpl implements MessageService {

    private Logger                 logger = Logger.getLogger(MessageServiceImpl.class);
    private SysNoticeMessageMapper sysNoticeMessageMapper;
    private SysNoticeMapper        sysNoticeMapper;

    public boolean sendPhoneCode(String phone, String content) {
        return AlidayuSendPhone.sendCodeMsg(phone, content);
    }

    public boolean sendPhoneVerify(String phone, String content, String result) {
        return AlidayuSendPhone.sendVerifyMsg(phone, content, result);
    }

    public boolean sendPhoneAccount(String phone, String content, String usablemoney) {
        return AlidayuSendPhone.sendAccountMsg(phone, content, usablemoney);
    }

    public boolean sendEmail(EmailSubjectEnum emailSubject, String content, String email) {
        try {
            MailUtil.getInstance().sendMail(emailSubject == null ? email : emailSubject.getText(), content, email);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertMessage(Integer reciveUser, Integer messageid) {
        SysNotice record = new SysNotice();
        record.setReciveUser(reciveUser);
        record.setMessageid(messageid);
        record.setType(NoticeTypeEnum.MESSAGE.getShortValue());
        record.setStatus(NoticeSendStatusEnum.SUCCESS.getShortValue());
        record.setIsRead(WhetherEnum.NO.getShortValue());
        record.setSendTime(new Date());
        record.setSentUser(-1);
        return sysNoticeMapper.insert(record) > 0 ? true : false;
    }

    /**
     * 插入站内信
     */
    public boolean insertMessage(Integer reciveUser, String content, String title) {
        int row = 0;
        // 插入信息内容表
        SysNoticeMessage noticeMessage = new SysNoticeMessage();
        noticeMessage.setContent(content);
        noticeMessage.setAddTime(new Date());
        noticeMessage.setTitle(title);
        row += insertNoticeMessage(noticeMessage);

        // 插入用户消息关系表
        SysNotice record = new SysNotice();
        record.setReciveUser(reciveUser);
        record.setMessageid(noticeMessage.getId());
        record.setType(NoticeTypeEnum.MESSAGE.getShortValue());
        record.setStatus(NoticeSendStatusEnum.SUCCESS.getShortValue());
        record.setIsRead(WhetherEnum.NO.getShortValue());
        record.setSendTime(new Date());
        record.setSentUser(-1);
        row += sysNoticeMapper.insert(record);
        return row > 0 ? true : false;
    }

    /**
     * 插入信息（站内信、短信、邮箱）
     */
    public boolean insertNoticeAndMessage(Integer reciveUser, String content, String title, NoticeTypeEnum noticeType) {
        int row = 0;
        // 插入信息内容表
        SysNoticeMessage noticeMessage = new SysNoticeMessage();
        noticeMessage.setContent(content);
        noticeMessage.setAddTime(new Date());
        noticeMessage.setTitle(title);
        row += insertNoticeMessage(noticeMessage);

        // 插入用户消息关系表
        SysNotice record = new SysNotice();
        record.setReciveUser(reciveUser);
        record.setMessageid(noticeMessage.getId());
        record.setType(NoticeTypeEnum.MESSAGE.getShortValue());
        record.setStatus(NoticeSendStatusEnum.SUCCESS.getShortValue());
        record.setIsRead(WhetherEnum.NO.getShortValue());
        record.setSendTime(new Date());
        record.setSentUser(-1);
        row += sysNoticeMapper.insert(record);
        return row > 0 ? true : false;
    }

    @Override
    public int sendSMSList(List<SMSModel> list) {
        if (list == null || list.size() == 0) return 0;
        int row = 0;
        for (SMSModel record : list) {
            try {
                logger.info("进入短信任务处理......");
                boolean result = AlidayuSendPhone.sendCodeMsg(record.getMobile(), record.getContent());
                SysNotice notice = record.getNotice();
                if (notice != null) {
                    short sendstatus = result ? NoticeSendStatusEnum.SUCCESS.getShortValue() : NoticeSendStatusEnum.FAILURE.getShortValue();
                    notice.setType(NoticeTypeEnum.SMS.getShortValue());
                    notice.setStatus(sendstatus);
                    notice.setIsRead(WhetherEnum.NO.getShortValue());
                    notice.setSendTime(new Date());
                    notice.setSentUser(-1);
                    row = insertNotice(notice);
                }
            } catch (Exception e) {
                logger.info(e.getMessage());
                e.printStackTrace();
            }
            logger.info("短信任务处理......end");
        }
        return row;
    }

    @Override
    public int sendEmailList(List<EmailModel> list) {
        if (list == null || list.size() == 0) return 0;
        int row = 0;
        NoticeSendStatusEnum sendStatus = NoticeSendStatusEnum.FAILURE;
        for (EmailModel record : list) {
            try {
                logger.info("邮件任务处理......start......");
                MailUtil.getInstance().sendMail(record.getSubject(), record.getContent(), record.getEmail());
                sendStatus = NoticeSendStatusEnum.SUCCESS;
            } catch (Exception e) {
                logger.info(e.getMessage());
                sendStatus = NoticeSendStatusEnum.FAILURE;
                e.printStackTrace();
            }
            SysNotice notice = record.getNotice();
            if (notice != null) {
                notice.setType(NoticeTypeEnum.MAIL.getShortValue());
                notice.setStatus(sendStatus.getShortValue());
                notice.setIsRead(WhetherEnum.NO.getShortValue());
                notice.setSendTime(new Date());
                notice.setSentUser(-1);
                row = insertNotice(notice);
            }
            logger.info("邮件任务处理......end......");
        }
        return row;
    }

    public int sendMessageList(List<SysNotice> list) {
        if (list == null || list.size() == 0) return 0;
        logger.info("站内信任务处理......start.....");
        int row = 0;
        for (SysNotice record : list) {
            record.setType(NoticeTypeEnum.MESSAGE.getShortValue());
            record.setStatus(NoticeSendStatusEnum.SUCCESS.getShortValue());
            record.setIsRead(WhetherEnum.NO.getShortValue());
            record.setSendTime(new Date());
            record.setSentUser(-1);
            // row += sysNoticeMapper.insert(record);
        }
        row = sysNoticeMapper.insertNoticeBatch(list);
        logger.info("站内信任务处理......end......");
        return row;
    }

    @Override
    public int insertNoticeMessage(SysNoticeMessage record) {
        return sysNoticeMessageMapper.insert(record);
    }

    @Override
    public int insertNotice(SysNotice record) {
        return sysNoticeMapper.insert(record);
    }

    public void setSysNoticeMapper(SysNoticeMapper sysNoticeMapper) {
        this.sysNoticeMapper = sysNoticeMapper;
    }

    public void setSysNoticeMessageMapper(SysNoticeMessageMapper sysNoticeMessageMapper) {
        this.sysNoticeMessageMapper = sysNoticeMessageMapper;
    }

}
