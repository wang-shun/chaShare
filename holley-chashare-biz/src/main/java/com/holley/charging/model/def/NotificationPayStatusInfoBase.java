package com.holley.charging.model.def;

import java.io.Serializable;

/**
 * Description: 推送支付结果
 *
 * @author shen.cheng@holley.cn
 */
public class NotificationPayStatusInfoBase implements Serializable {

    private static final long serialVersionUID = -5616669355968022388L;
    private String            from;                                    // 请求方组织ID
    private String            seq;                                     // 订单号
    private Integer           total_fee;                               // 金额
    private String            trade_status;                            // 支付状态 success:支付成功 fail：支付失败 notpay 未支付 close
                                                                        // 交易关闭
    private String            sign;                                    // 签名
    private String            sign_type        = "md5";                // 签名方式
    private String            t;                                       // 请求时间戳

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
