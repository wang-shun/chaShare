package com.holley.charging.service.shareImpl;

import com.holley.common.jms.MessageDeal;
import com.holley.common.rocketmq.charging.MsgChargeStart;
import com.holley.common.rocketmq.charging.MsgChargeStop;

/**
 * 消息中间件接受的消息命令
 * 
 * @author zhoulide
 */
public class MessageReciveService implements MessageDeal {

    @Override
    public boolean deal(Object msg) {
        if (msg instanceof MsgChargeStart) {
            MsgChargeStart msgDeal = (MsgChargeStart) msg;
            System.out.println("start:" + msgDeal.getTradeNo());
        } else if (msg instanceof MsgChargeStop) {
            MsgChargeStop msgDeal = (MsgChargeStop) msg;
            System.out.println("stop:" + msgDeal.getTradeNo());
        }
        return false;
    }

}
