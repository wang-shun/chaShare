package com.holley.charging.model.bus;

public class BusUserReal extends BusUserRealKey {

    private String cardNum;

    private String front;

    private String con;

    private String realName;

    private Short  status;

    private String remark;


    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum == null ? null : cardNum.trim();
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front == null ? null : front.trim();
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con == null ? null : con.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }


}
