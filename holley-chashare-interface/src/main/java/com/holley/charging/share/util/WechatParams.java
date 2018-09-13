package com.holley.charging.share.util;

import java.math.BigDecimal;

public class WechatParams {

    private String     appid;       // 微信分配的公众账号ID（企业号corpid即为此appId）,例如：wxd678efh567hg6787
    private String     mch_id;      // 商户id
    private String     out_trade_no; // 商户系统内部的订单号
    private String     notify_url;  // 接收微信支付异步通知回调地址
    private String     body;        // 商品或支付单简要描述
    private String     detail;      // 商品名称明细列表
    private BigDecimal total_fee;   // 总金额

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(BigDecimal total_fee) {
        this.total_fee = total_fee;
    }

}
