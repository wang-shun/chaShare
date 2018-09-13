package com.holley.common.constants;

import java.io.Serializable;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.holley.common.constants.share.RetTypeEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.StringUtil;

/**
 * 通用数据调用结果返回bean
 * 
 * @author sc
 */
public class ResultBean implements Serializable {

    private static final long serialVersionUID = -8974675040908912236L;
    private int               ret              = 0;                    // 返回参数编码
    private String            msg;                                     // 返回信息
    private Object            data;                                    // 数据
    private String            sig;                                     // 参数签名
    private String            timeStamp;                               // 请求接口时间yyyyMMddHHmmss
    private String            operatorID;                              // 运营商Id
    private String            seq;                                     // 自增序列

    public ResultBean() {
        super();
    }

    public ResultBean(Date date) {
        long t = date.getTime();
        this.timeStamp = DateUtil.DateToLong14Str(date);
        if (Globals.TIME_STTEMP == 0) {
            Globals.TIME_STTEMP = t;
            this.seq = String.format("%04d", 1);
        } else {
            if (t - Globals.TIME_STTEMP <= 999) {
                this.seq = String.format("%04d", ++Globals.COUNT_TIME);
            }
        }
    }

    @JSON(name = "Ret")
    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    @JSON(name = "Msg")
    public String getMsg() {
        if (StringUtil.isNotEmpty(msg)) {
            return msg;
        }
        return RetTypeEnum.getText(ret);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @JSON(name = "Data")
    public Object getData() throws Exception {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @JSON(name = "Sig")
    public String getSig() {

        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    @JSON(name = "TimeStamp")
    public String getTimeStamp() {

        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JSON(name = "OperatorID")
    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    @JSON(name = "Seq")
    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
