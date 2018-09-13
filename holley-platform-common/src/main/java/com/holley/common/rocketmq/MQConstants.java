package com.holley.common.rocketmq;

public class MQConstants {

    /**
     * 监听的主题
     */
    public static final String TOPIC_DCSERVER        = "APP2DCS";              // 前置机主题
    public static final String TOPIC_MESSAGE         = "TOPICMESSAGE";         // 信息主题

    public static final String CONSUMER_GROUP        = "chargingConsumerGroup";
    public static final String PORDUCT_GROUP         = "chargingProductGroup";

    /**
     * 监听的tag
     */
    public static final String TAG_APPOINTMENTCANCEL = "tagAppointmentCancle";
    public static final String TAG_APPOINTMENTREQ    = "tagAppointmentReq";
    public static final String TAG_CHARGESTART       = "tagChargeStart";
    public static final String TAG_CHARGESTOP        = "tagChargeStop";

    public static final String TAG_LOG_ERR           = "tagLogErr";            // 异常日期
    public static final String TAG_LOG_DOCUMENT      = "tagLogDocument";       // 档案日志
    public static final String TAG_LOG_ACCESS        = "tagLogAccess";         // 系统访问

    public static final String TAG_MSG_MESSAGE       = "tagMsgMessage";        // 站内信
    public static final String TAG_MSG_EMAIL         = "tagMsgEmail";          // 邮箱
    public static final String TAG_MSG_SMS           = "tagMsgSMS";            // 短信

}
