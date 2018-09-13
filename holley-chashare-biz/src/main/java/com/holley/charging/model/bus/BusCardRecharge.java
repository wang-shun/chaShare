package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.util.DateUtil;

public class BusCardRecharge {

    private Integer    id;

    private String     tradeNo;

    private Integer    cardInfoId;

    private BigDecimal money;

    private Integer    worker;

    private Date       addTime;

    private String     addIp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Integer getCardInfoId() {
        return cardInfoId;
    }

    public void setCardInfoId(Integer cardInfoId) {
        this.cardInfoId = cardInfoId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getWorker() {
        return worker;
    }

    public void setWorker(Integer worker) {
        this.worker = worker;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp == null ? null : addIp.trim();
    }

}
