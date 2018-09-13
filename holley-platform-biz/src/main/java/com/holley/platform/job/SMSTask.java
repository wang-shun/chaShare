package com.holley.platform.job;

import java.util.Date;

import org.apache.log4j.Logger;

import com.holley.common.constants.Globals;
import com.holley.common.constants.charge.NoticeSendStatusEnum;
import com.holley.common.constants.charge.NoticeTypeEnum;
import com.holley.common.constants.charge.WhetherEnum;
import com.holley.platform.model.SMSModel;
import com.holley.platform.model.sys.SysNotice;
import com.holley.platform.service.MessageService;
import com.holley.web.common.util.BaiduSendPhone;

/**
 * 发送短信任务
 * 
 * @author lenovo
 */
public class SMSTask extends AbstractLoanTask {

    private Logger         logger = Logger.getLogger(SMSTask.class);
    private MessageService messageService;

    public SMSTask(MessageService messageService) {
        super();
        this.task.setName("SMS.task");
        this.messageService = messageService;
    }

    @Override
    public void doLoan() {
        while (SMSJobQueue.SMSTASK != null && SMSJobQueue.SMSTASK.size() > 0) {
            logger.info("短信任务处理......start");
            SMSModel smsModel = SMSJobQueue.SMSTASK.peek();
            if (smsModel != null) {
                try {
                    logger.info("进入短信任务处理......");

                    boolean result = BaiduSendPhone.sendPhoneCode(smsModel.getMobile(), smsModel.getContent());
                    Globals.SMS_RESULT_MAP.put("result", result);
                    SysNotice notice = smsModel.getNotice();
                    if (notice != null) {
                        short sendstatus = result ? NoticeSendStatusEnum.SUCCESS.getShortValue() : NoticeSendStatusEnum.FAILURE.getShortValue();
                        notice.setType(NoticeTypeEnum.SMS.getShortValue());
                        notice.setStatus(sendstatus);
                        notice.setIsRead(WhetherEnum.NO.getShortValue());
                        notice.setSendTime(new Date());
                        notice.setSentUser(-1);
                        messageService.insertNotice(notice);
                    }

                } catch (Exception e) {
                    Globals.SMS_RESULT_MAP.put("result", false);
                    logger.info(e.getMessage());
                    e.printStackTrace();
                } finally {
                    SMSJobQueue.SMSTASK.remove(smsModel);
                }
                logger.info("短信任务处理......end");
            }

        }

    }

    @Override
    public Object getLock() {
        return LoanTask.SMS_LOCK;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

}
