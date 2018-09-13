package com.holley.common.rocketmq.charging;

import com.holley.common.rocketmq.MQConstants;
import com.holley.common.util.ProtocolUtils;

public class MsgChargeStop extends MsgAPP2DCS {

    String tradeNo; // 16字节

    public MsgChargeStop(Integer pileID, Integer userID, String phone, String tradeNo) {
        super(pileID, userID, phone);
        this.tag = MQConstants.TAG_CHARGESTOP;
        this.cmd = CMD_CHARGE_STOP;

        this.tradeNo = tradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    protected MsgChargeStop(byte[] body) {
        super(body);
        if (body.length >= BASELEN + 16) {
            tradeNo = ProtocolUtils.getByteToHexStringDesc(body, BASELEN, 16, "");
        }
        this.cmd = CMD_CHARGE_STOP;
    }

    public byte[] getBody() {
        byte[] body = new byte[BASELEN + 16];
        System.arraycopy(super.getBody(), 0, body, 0, BASELEN);

        System.arraycopy(ProtocolUtils.StringToHex(tradeNo, 16), 0, body, BASELEN, 16);

        return body;
    }
}
