package com.holley.platform.job;

public interface LoanTask {

    public final static String BASE_LOCK  = "base_lock"; // 基本锁
    public final static String MSG_LOCK   = "msg_lock";  // 站内信锁
    public final static String SMS_LOCK   = "sms_lock";  // 短信锁
    public final static String EMAIL_LOCK = "email_lock";// 邮件锁

    void doLoan();// 主执行任务方法

    void doWait();// 等待，交出锁

    void stop();// 停止任务

    Object getLock();// 获取对象锁

    void execute();// 停止等待，执行任务
}
