package com.holley.common.rocketmq.charging;

import com.holley.common.rocketmq.MQConstants;
import com.holley.common.rocketmq.MsgBase;
import com.holley.common.util.ProtocolUtils;

public class MsgAPP2DCS extends MsgBase {

    protected final static byte CMD_APPOINTMENT_REQ    = 1;
    protected final static byte CMD_APPOINTMENT_CANCLE = 2;
    protected final static byte CMD_CHARGE_START       = 3;
    protected final static byte CMD_CHARGE_STOP        = 4;
    protected final static int  BASELEN                = 15;

    protected byte              cmd;

    protected Integer           userID;
    protected Integer           pileID;
    protected String            phone;

    public MsgAPP2DCS(Integer pileID, Integer userID, String phone) {
        this.topic = MQConstants.TOPIC_DCSERVER;
        this.tag = "";
        this.pileID = pileID;
        this.userID = userID;
        this.phone = phone;
    }

    protected MsgAPP2DCS(byte[] body) {
        pileID = ProtocolUtils.byteToInteger(body, 1);
        userID = ProtocolUtils.byteToInteger(body, 5);
        phone = ProtocolUtils.getByteToHexStringDesc(body, 9, 6, "");
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPileID() {
        return pileID;
    }

    public void setPileID(Integer pileID) {
        this.pileID = pileID;
    }

    public String getKey() {
        if (this.pileID != null) {
            return pileID.toString();
        }
        return null;
    }

    public byte[] getBody() {
        byte[] body = new byte[BASELEN];
        // 命令类型
        body[0] = cmd;

        // pileID;
        body[1] = (byte) (pileID % 0x100);
        body[2] = (byte) (pileID / 0x100 % 0x100);
        body[3] = (byte) (pileID / 0x10000 % 0x100);
        body[4] = (byte) (pileID / 0x1000000 % 0x100);

        // userID
        body[5] = (byte) (userID % 0x100);
        body[6] = (byte) (userID / 0x100 % 0x100);
        body[7] = (byte) (userID / 0x10000 % 0x100);
        body[8] = (byte) (userID / 0x1000000 % 0x100);

        // phone
        System.arraycopy(ProtocolUtils.StringToHex(phone, 6), 0, body, 9, 6);
        return body;
    }

    public static MsgAPP2DCS generator(byte[] body) {
        MsgAPP2DCS msg = null;
        if (body != null && body.length >= BASELEN) {
            byte type = body[0];
            switch (type) {
                case CMD_APPOINTMENT_REQ:
                    msg = new MsgAppointmentReq(body);
                    break;
                case CMD_APPOINTMENT_CANCLE:
                    msg = new MsgAppointmentCancle(body);
                    break;
                case CMD_CHARGE_START:
                    msg = new MsgChargeStart(body);
                    break;
                case CMD_CHARGE_STOP:
                    msg = new MsgChargeStop(body);
                    break;
                default:
                    break;
            }
        }
        return msg;
    }

}
