package com.holley.common.rocketmq.charging;

import com.holley.common.constants.charge.ChargeModeEnum;
import com.holley.common.rocketmq.MQConstants;
import com.holley.common.util.ProtocolUtils;

public class MsgChargeStart extends MsgAPP2DCS {

    byte   chargeMode; // // 00 自动；01 按电量；02 按时间； 03 按金额
    int    value;      // 电量：0.01kWh,金额：0.01元，时间：分钟,自动充满:账户余额
    String tradeNo;    // 16字节

    public MsgChargeStart(Integer pileID, Integer userID, String phone, byte chargeMode, double value, String tradeNo) {
        super(pileID, userID, phone);
        this.tag = MQConstants.TAG_CHARGESTART;
        this.cmd = CMD_CHARGE_START;
        this.chargeMode = chargeMode;
        if (chargeMode == (byte) ChargeModeEnum.BY_EQ.getValue()) {
            this.value = (int) (value * 1000);
        } else {
            this.value = (int) (value * 100);
        }
        this.tradeNo = tradeNo;
    }

    protected MsgChargeStart(byte[] body) {
        super(body);
        if (body.length >= BASELEN + 21) {
            chargeMode = body[BASELEN];
            value = ProtocolUtils.byteToInteger(body, BASELEN + 1);
            tradeNo = ProtocolUtils.getByteToHexStringDesc(body, BASELEN + 5, 16, "");
        }
        this.cmd = CMD_CHARGE_START;
    }

    public byte getChargeMode() {
        return chargeMode;
    }

    public void setChargeMode(byte chargeMode) {
        this.chargeMode = chargeMode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public byte[] getBody() {
        byte[] body = new byte[BASELEN + 21];
        System.arraycopy(super.getBody(), 0, body, 0, BASELEN);

        body[BASELEN] = chargeMode;

        body[BASELEN + 1] = (byte) (value % 0x100);
        body[BASELEN + 2] = (byte) (value / 0x100 % 0x100);
        body[BASELEN + 3] = (byte) (value / 0x10000 % 0x100);
        body[BASELEN + 4] = (byte) (value / 0x1000000 % 0x100);

        System.arraycopy(ProtocolUtils.StringToHex(tradeNo, 16), 0, body, BASELEN + 5, 16);
        return body;
    }

}
