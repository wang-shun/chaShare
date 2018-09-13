package com.holley.platform.job;

import java.util.Date;

import org.apache.log4j.Logger;

import com.holley.common.constants.Globals;
import com.holley.common.constants.charge.NoticeSendStatusEnum;
import com.holley.common.constants.charge.NoticeTypeEnum;
import com.holley.common.constants.charge.WhetherEnum;
import com.holley.platform.model.EmailModel;
import com.holley.platform.model.sys.SysNotice;
import com.holley.platform.service.MessageService;
import com.holley.web.common.util.MailUtil;

/**
 * 邮箱任务
 * 
 * @author cheng.shen@holley.cn
 */
public class EmailTask extends AbstractLoanTask {

    private Logger         logger = Logger.getLogger(EmailTask.class);
    private MessageService messageService;

    public EmailTask(MessageService messageService) {
        super();
        this.task.setName("Eamil.task");
        this.messageService = messageService;
    }

    @Override
    public void doLoan() {
        while (EmailJobQueue.EMAILTASK != null && EmailJobQueue.EMAILTASK.size() > 0) {
            logger.info("邮件信息任务处理......start");
            EmailModel emailModel = EmailJobQueue.EMAILTASK.peek();
            if (emailModel != null) {
                try {
                    logger.info("进入邮件任务处理......");
                    Globals.EMAIL_RESULT_MAP.put("result", true);
                    MailUtil.getInstance().sendMail(emailModel.getSubject(), emailModel.getContent(), emailModel.getEmail());

                    SysNotice notice = emailModel.getNotice();
                    if (notice != null) {
                        notice.setType(NoticeTypeEnum.MAIL.getShortValue());
                        notice.setStatus(NoticeSendStatusEnum.SUCCESS.getShortValue());
                        notice.setIsRead(WhetherEnum.NO.getShortValue());
                        notice.setSendTime(new Date());
                        notice.setSentUser(-1);
                        messageService.insertNotice(notice);
                    }

                } catch (Exception e) {
                    Globals.EMAIL_RESULT_MAP.put("result", false);
                    logger.info(e.getMessage());
                    e.printStackTrace();
                } finally {
                    EmailJobQueue.EMAILTASK.remove(emailModel);
                }
                logger.info("邮件信息任务处理......end");
            }

        }

    }

    @Override
    public Object getLock() {
        return LoanTask.EMAIL_LOCK;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

}
