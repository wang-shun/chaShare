package com.holley.platform.job;

import java.util.Date;

import org.apache.log4j.Logger;

import com.holley.common.constants.Globals;
import com.holley.common.constants.charge.NoticeSendStatusEnum;
import com.holley.common.constants.charge.NoticeTypeEnum;
import com.holley.common.constants.charge.WhetherEnum;
import com.holley.platform.model.sys.SysNotice;
import com.holley.platform.service.MessageService;

/**
 * 站内信任务
 * 
 * @author lenovo
 */
public class MessageTask extends AbstractLoanTask {

    private Logger         logger = Logger.getLogger(EmailTask.class);
    private MessageService messageService;

    public MessageTask(MessageService messageService) {
        super();
        this.task.setName("Message.task");
        this.messageService = messageService;
    }

    @Override
    public void doLoan() {
        while (MessageJobQueue.MESSAGETASK != null && MessageJobQueue.MESSAGETASK.size() > 0) {
            logger.info("站内信任务处理......start");
            SysNotice record = MessageJobQueue.MESSAGETASK.peek();
            if (record != null) {
                try {
                    logger.info("进入站内信任务处理......");

                    record.setType(NoticeTypeEnum.MESSAGE.getShortValue());
                    record.setStatus(NoticeSendStatusEnum.SUCCESS.getShortValue());
                    record.setIsRead(WhetherEnum.NO.getShortValue());
                    record.setSendTime(new Date());
                    record.setSentUser(-1);
                    if (messageService.insertNotice(record) > 0) {
                        Globals.MESSAGE_RESULT_MAP.put("result", true);
                    }
                } catch (Exception e) {
                    Globals.MESSAGE_RESULT_MAP.put("result", false);
                    logger.info(e.getMessage());
                    e.printStackTrace();
                } finally {
                    MessageJobQueue.MESSAGETASK.remove(record);
                }
                logger.info("站内信任务处理......end");
            }
        }
    }

    @Override
    public Object getLock() {
        return this.MSG_LOCK;
    }

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

}
