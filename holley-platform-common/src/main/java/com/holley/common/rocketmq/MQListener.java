package com.holley.common.rocketmq;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.holley.common.rocketmq.charging.MsgAPP2DCS;
import com.holley.common.rocketmq.charging.MsgAppointmentCancle;
import com.holley.common.rocketmq.charging.MsgAppointmentReq;
import com.holley.common.rocketmq.charging.MsgChargeStart;
import com.holley.common.rocketmq.charging.MsgChargeStop;

/**
 * 前置消息接收处理
 * 
 * @author zhouli
 */
public interface MQListener{

	public int consumeMessage(List<MsgBase> msgs);
    
}
