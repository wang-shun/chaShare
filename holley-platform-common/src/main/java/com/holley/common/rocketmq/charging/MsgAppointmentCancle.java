package com.holley.common.rocketmq.charging;

import com.holley.common.rocketmq.MQConstants;
import com.holley.common.util.ProtocolUtils;

public class MsgAppointmentCancle extends MsgAPP2DCS {

    String appointmentID;

    public MsgAppointmentCancle(Integer pileID, Integer userID, String phone, String appointmentID) {
        super(pileID, userID, phone);
        this.tag = MQConstants.TAG_APPOINTMENTCANCEL;
        this.cmd = CMD_APPOINTMENT_CANCLE;
        this.appointmentID = appointmentID;
    }

    protected MsgAppointmentCancle(byte[] body) {
        super(body);
        if (body.length >= BASELEN + 16) {
            appointmentID = ProtocolUtils.getByteToHexStringDesc(body, BASELEN, 16, "");
        }
        this.cmd = CMD_APPOINTMENT_CANCLE;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public byte[] getBody() {
        byte[] body = new byte[BASELEN + 16];
        System.arraycopy(super.getBody(), 0, body, 0, BASELEN);

        // appointmentID
        System.arraycopy(ProtocolUtils.StringToHex(appointmentID, 16), 0, body, BASELEN, 16);

        return body;
    }
}
