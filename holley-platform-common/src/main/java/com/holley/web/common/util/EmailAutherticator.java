package com.holley.web.common.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 邮件发送者
 * 
 * @author shencheng
 */
public class EmailAutherticator extends Authenticator {

    // String username = "welkinrook@163.com";
    // String password = "76712144";
    // String username = "shenchengvs88@163.com"; // 企业邮箱地址
    // String password = "senama14jj"; // 密码
    String username = "teng.zhang@holley.cn"; // 企业邮箱地址
    String password = "holley1992";          // 密码

    public EmailAutherticator(String username, String password) {
        super();
        this.username = username;
        this.password = password;

    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
