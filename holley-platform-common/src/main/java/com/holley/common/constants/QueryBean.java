package com.holley.common.constants;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.holley.common.util.DateUtil;

/**
 * 通用数据推送bean
 * 
 * @author sc
 */
public class QueryBean implements Serializable {

    private static final long serialVersionUID = -9049583643864024290L;
    @JSONField(name = "Data")
    private Object            data;                                    // 数据
    @JSONField(name = "Sig")
    private String            sig;                                     // 参数签名
    @JSONField(name = "TimeStamp")
    private String            timeStamp;                               // 请求接口时间yyyyMMddHHmmss
    @JSONField(name = "OperatorID")
    private String            operatorID;                              // 运营商Id
    @JSONField(name = "Seq")
    private String            seq;                                     // 自增序列

    public QueryBean() {
        super();
    }

    public QueryBean(Date date) {
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

}
