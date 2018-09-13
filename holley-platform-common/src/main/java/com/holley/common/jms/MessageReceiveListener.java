package com.holley.common.jms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageReceiveListener implements MessageListener {

    private static Logger   logger      = LoggerFactory.getLogger(MessageReceiveListener.class);

    private int             count       = 0;

    private MessageDeal     messageDeal;

    private boolean         isRunThread = true;
    private ExecutorService threadPool  = Executors.newCachedThreadPool();

    /**
     * MessageListener回调函数.
     */
    @Override
    public void onMessage(Message message) {
        try {
            if (message != null) {
                logger.info("收到消息!");
                // if (message instanceof ActiveMQObjectMessage) {
                // ActiveMQObjectMessage msg = (ActiveMQObjectMessage) message;
                //
                // if (isRunThread) {
                // threadPool.execute(new RunDeal(msg.getObject()));
                // } else {
                // messageDeal.deal(msg);
                // }
                //
                // }
                //
                if (message instanceof ObjectMessage) {
                    ObjectMessage msg = (ObjectMessage) message;

                    if (isRunThread) {
                        threadPool.execute(new RunDeal(msg.getObject()));
                    } else {
                        messageDeal.deal(msg);
                    }
                } else if (message instanceof TextMessage) {
                    TextMessage msg = (TextMessage) message;
                    logger.info(count++ + "----------" + msg.getText());
                } else if (message instanceof MapMessage) {
                    MapMessage mapMessage = (MapMessage) message;
                    logger.info(count++ + "----------" + mapMessage.toString());
                }
            }
        } catch (Exception e) {
            logger.error("处理消息时发生异常.", e);
        }
    }

    private class RunDeal implements Runnable {

        private Object msgCmd;

        public RunDeal(Object msgCmd) {
            this.msgCmd = msgCmd;
        }

        @Override
        public void run() {
            messageDeal.deal(msgCmd);
        }
    }

    public MessageDeal getMessageDeal() {
        return messageDeal;
    }

    public void setMessageDeal(MessageDeal messageDeal) {
        this.messageDeal = messageDeal;
    }

    public boolean isRunThread() {
        return isRunThread;
    }

    public void setRunThread(boolean isRunThread) {
        this.isRunThread = isRunThread;
    }

}
