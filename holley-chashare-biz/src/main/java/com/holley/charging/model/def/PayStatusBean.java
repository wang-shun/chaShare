package com.holley.charging.model.def;

/**
 * 支付状态查询 Description:
 *
 * @author shen.cheng@holley.cn
 */
public class PayStatusBean {

    private String  result_code;      // success,fail
    private String  result_msg;       // 信息ok
    private String  from;             // 请求方组织机构代码
    private String  seq;              // 订单号
    private Integer total_fee;        // 订单金额单位：分
    private String  trade_status;     // 交易状态
    private String  sign;             // 签名
    private String  sign_type = "md5"; // 签名方式默认：md5
    private String  t;                // 请求时间戳

    public PayStatusBean(String from, String seq, String t) {
        this.from = from;
        this.seq = seq;
        this.t = t;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getResult_msg() {
        return result_msg;
    }

    public void setResult_msg(String result_msg) {
        this.result_msg = result_msg;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

}
