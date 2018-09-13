package com.holley.charging.model.dcs;

import java.math.BigDecimal;
import java.util.Date;

public class DcsChargerecord {
    private Integer id;

    private Integer chargeid;

    private Short chargeType;

    private Short pileNum;

    private String tradeNo;

    private String payNo;

    private String cardNo;

    private Short isTimes;

    private Date startTime;

    private Date endTime;

    private Double bmj1;

    private Double bmj2;

    private Double bmf1;

    private Double bmf2;

    private Double bmp1;

    private Double bmp2;

    private Double bmg1;

    private Double bmg2;

    private Double metType;

    private Double bmz1;

    private Double bmz2;

    private BigDecimal djj;

    private Double dlj;

    private BigDecimal jej;

    private BigDecimal djf;

    private Double dlf;

    private BigDecimal jef;

    private BigDecimal djp;

    private Double dlp;

    private BigDecimal jep;

    private BigDecimal djg;

    private Double dlg;

    private BigDecimal jeg;

    private Double dlz;

    private Short busType;

    private BigDecimal afterMoney;

    private BigDecimal xfdj;

    private BigDecimal xfje;

    private String mark;

    private Short payStatus;

    private String clientNo;

    private BigDecimal beforeMoney;

    private String bagNo;

    private BigDecimal payMoney;

    private String dateTime;

    private String radomNo;

    private Short payType;

    private String tac;

    private String keyVersion;

    private String terminalNo;

    private BigDecimal chaPrice;

    private BigDecimal chaMoney;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChargeid() {
        return chargeid;
    }

    public void setChargeid(Integer chargeid) {
        this.chargeid = chargeid;
    }

    public Short getChargeType() {
        return chargeType;
    }

    public void setChargeType(Short chargeType) {
        this.chargeType = chargeType;
    }

    public Short getPileNum() {
        return pileNum;
    }

    public void setPileNum(Short pileNum) {
        this.pileNum = pileNum;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public Short getIsTimes() {
        return isTimes;
    }

    public void setIsTimes(Short isTimes) {
        this.isTimes = isTimes;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getBmj1() {
        return bmj1;
    }

    public void setBmj1(Double bmj1) {
        this.bmj1 = bmj1;
    }

    public Double getBmj2() {
        return bmj2;
    }

    public void setBmj2(Double bmj2) {
        this.bmj2 = bmj2;
    }

    public Double getBmf1() {
        return bmf1;
    }

    public void setBmf1(Double bmf1) {
        this.bmf1 = bmf1;
    }

    public Double getBmf2() {
        return bmf2;
    }

    public void setBmf2(Double bmf2) {
        this.bmf2 = bmf2;
    }

    public Double getBmp1() {
        return bmp1;
    }

    public void setBmp1(Double bmp1) {
        this.bmp1 = bmp1;
    }

    public Double getBmp2() {
        return bmp2;
    }

    public void setBmp2(Double bmp2) {
        this.bmp2 = bmp2;
    }

    public Double getBmg1() {
        return bmg1;
    }

    public void setBmg1(Double bmg1) {
        this.bmg1 = bmg1;
    }

    public Double getBmg2() {
        return bmg2;
    }

    public void setBmg2(Double bmg2) {
        this.bmg2 = bmg2;
    }

    public Double getMetType() {
        return metType;
    }

    public void setMetType(Double metType) {
        this.metType = metType;
    }

    public Double getBmz1() {
        return bmz1;
    }

    public void setBmz1(Double bmz1) {
        this.bmz1 = bmz1;
    }

    public Double getBmz2() {
        return bmz2;
    }

    public void setBmz2(Double bmz2) {
        this.bmz2 = bmz2;
    }

    public BigDecimal getDjj() {
        return djj;
    }

    public void setDjj(BigDecimal djj) {
        this.djj = djj;
    }

    public Double getDlj() {
        return dlj;
    }

    public void setDlj(Double dlj) {
        this.dlj = dlj;
    }

    public BigDecimal getJej() {
        return jej;
    }

    public void setJej(BigDecimal jej) {
        this.jej = jej;
    }

    public BigDecimal getDjf() {
        return djf;
    }

    public void setDjf(BigDecimal djf) {
        this.djf = djf;
    }

    public Double getDlf() {
        return dlf;
    }

    public void setDlf(Double dlf) {
        this.dlf = dlf;
    }

    public BigDecimal getJef() {
        return jef;
    }

    public void setJef(BigDecimal jef) {
        this.jef = jef;
    }

    public BigDecimal getDjp() {
        return djp;
    }

    public void setDjp(BigDecimal djp) {
        this.djp = djp;
    }

    public Double getDlp() {
        return dlp;
    }

    public void setDlp(Double dlp) {
        this.dlp = dlp;
    }

    public BigDecimal getJep() {
        return jep;
    }

    public void setJep(BigDecimal jep) {
        this.jep = jep;
    }

    public BigDecimal getDjg() {
        return djg;
    }

    public void setDjg(BigDecimal djg) {
        this.djg = djg;
    }

    public Double getDlg() {
        return dlg;
    }

    public void setDlg(Double dlg) {
        this.dlg = dlg;
    }

    public BigDecimal getJeg() {
        return jeg;
    }

    public void setJeg(BigDecimal jeg) {
        this.jeg = jeg;
    }

    public Double getDlz() {
        return dlz;
    }

    public void setDlz(Double dlz) {
        this.dlz = dlz;
    }

    public Short getBusType() {
        return busType;
    }

    public void setBusType(Short busType) {
        this.busType = busType;
    }

    public BigDecimal getAfterMoney() {
        return afterMoney;
    }

    public void setAfterMoney(BigDecimal afterMoney) {
        this.afterMoney = afterMoney;
    }

    public BigDecimal getXfdj() {
        return xfdj;
    }

    public void setXfdj(BigDecimal xfdj) {
        this.xfdj = xfdj;
    }

    public BigDecimal getXfje() {
        return xfje;
    }

    public void setXfje(BigDecimal xfje) {
        this.xfje = xfje;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Short getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Short payStatus) {
        this.payStatus = payStatus;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo == null ? null : clientNo.trim();
    }

    public BigDecimal getBeforeMoney() {
        return beforeMoney;
    }

    public void setBeforeMoney(BigDecimal beforeMoney) {
        this.beforeMoney = beforeMoney;
    }

    public String getBagNo() {
        return bagNo;
    }

    public void setBagNo(String bagNo) {
        this.bagNo = bagNo == null ? null : bagNo.trim();
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime == null ? null : dateTime.trim();
    }

    public String getRadomNo() {
        return radomNo;
    }

    public void setRadomNo(String radomNo) {
        this.radomNo = radomNo == null ? null : radomNo.trim();
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac == null ? null : tac.trim();
    }

    public String getKeyVersion() {
        return keyVersion;
    }

    public void setKeyVersion(String keyVersion) {
        this.keyVersion = keyVersion == null ? null : keyVersion.trim();
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo == null ? null : terminalNo.trim();
    }

    public BigDecimal getChaPrice() {
        return chaPrice;
    }

    public void setChaPrice(BigDecimal chaPrice) {
        this.chaPrice = chaPrice;
    }

    public BigDecimal getChaMoney() {
        return chaMoney;
    }

    public void setChaMoney(BigDecimal chaMoney) {
        this.chaMoney = chaMoney;
    }
}