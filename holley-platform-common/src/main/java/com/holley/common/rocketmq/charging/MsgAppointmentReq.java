package com.holley.common.rocketmq.charging;

import java.util.Calendar;
import java.util.Date;

import com.holley.common.rocketmq.MQConstants;
import com.holley.common.util.DateUtil;
import com.holley.common.util.ProtocolUtils;

public class MsgAppointmentReq extends MsgAPP2DCS {

    Date   endTime;
    String appointmentID;

    public MsgAppointmentReq(Integer pileID, Integer userID, String phone, Date endTime, String appointmentID) {
        super(pileID, userID, phone);
        this.tag = MQConstants.TAG_APPOINTMENTREQ;
        this.cmd = CMD_APPOINTMENT_REQ;
        this.endTime = endTime;

        this.appointmentID = appointmentID;
    }

    protected MsgAppointmentReq(byte[] body) {
        super(body);
        if (body.length >= BASELEN + 23) {
            byte[] time = new byte[7];
            System.arraycopy(body, BASELEN, time, 0, 7);
            endTime = DateUtil.Cp56time2atoDate(time).getTime();

            appointmentID = ProtocolUtils.getByteToHexStringDesc(body, BASELEN + 7, 16, "");
        }
        this.cmd = CMD_APPOINTMENT_REQ;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public byte[] getBody() {
        byte[] body = new byte[BASELEN + 23];
        System.arraycopy(super.getBody(), 0, body, 0, BASELEN);

        Calendar time = Calendar.getInstance();
        time.setTime(endTime);

        // endTime
        System.arraycopy(DateUtil.Cp56time2atoByte(time), 0, body, BASELEN, 7);

        System.arraycopy(ProtocolUtils.StringToHex(appointmentID, 16), 0, body, BASELEN + 7, 16);

        return body;
    }
}
