package com.holley.common.dataobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.holley.common.constants.charge.PileAppStatusEnum;
import com.holley.common.constants.charge.PileStatusEnum;

/**
 * Created by lw on 16/4/5.
 */
public class PileStatusBean implements Serializable {

    private static final long serialVersionUID = 6098497446916700431L;

    private Integer           stationid;
    private Integer           id;                                                 // 桩id
    private String            pilecode;                                           // 桩编号
    private Integer           chalen;                                             // 当前充电时长
    private Double            chapower;                                           // 当前充电量
    private BigDecimal        money;                                              // 当前充电金额
    private BigDecimal        chaMoney;                                           // 当前充电金额
    private BigDecimal        serviceMoney;                                       // 当前服务费金额
    private String            outv;                                               // 输出电压
    private String            outi;                                               // 输出电流
    private PileStatusEnum    status;                                             // 当前状态
    private Integer           userid;                                             // 在充电的或者预约中userid
    private Short             isonline;                                           // 是否在线
    private String            tradeno;                                            // 交易号

    private Date              updatetime       = Calendar.getInstance().getTime();

    private PileAppStatusEnum appstatus;                                          // 预约状态
    private Date              appendtime;                                         // 预约截止时间
    private Integer           apprecordid;                                        // 预约记录ID

    private Integer           scanuserid;                                         // 扫描用户id
    private Date              scantime;                                           // 扫描时间

    private int               errorcode;                                          // 桩返回的错误码

    private String            plateNum;                                           // 车牌号
    private Date              starttime;                                          // 充电开始时间
    private Double            soc;                                                // 电池剩余电量

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPilecode() {
        return pilecode;
    }

    public void setPilecode(String pilecode) {
        this.pilecode = pilecode;
    }

    public Integer getChalen() {
        return chalen;
    }

    public void setChalen(Integer chalen) {
        this.chalen = chalen;
    }

    public Double getChapower() {
        return chapower;
    }

    public void setChapower(Double chapower) {
        this.chapower = chapower;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getOutv() {
        return outv;
    }

    public void setOutv(String outv) {
        this.outv = outv;
    }

    public String getOuti() {
        return outi;
    }

    public void setOuti(String outi) {
        this.outi = outi;
    }

    public PileStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PileStatusEnum status) {
        this.status = status;
    }

    public PileAppStatusEnum getAppstatus() {
        return appstatus;
    }

    public void setAppstatus(PileAppStatusEnum appstatus) {
        this.appstatus = appstatus;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Short getIsonline() {
        return isonline;
    }

    public void setIsonline(Short isonline) {
        this.isonline = isonline;
    }

    public Date getAppendtime() {
        return appendtime;
    }

    public void setAppendtime(Date appendtime) {
        this.appendtime = appendtime;
    }

    public Integer getApprecordid() {
        return apprecordid;
    }

    public void setApprecordid(Integer apprecordid) {
        this.apprecordid = apprecordid;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getScanuserid() {
        return scanuserid;
    }

    public void setScanuserid(Integer scanuserid) {
        this.scanuserid = scanuserid;
    }

    public Date getScantime() {
        return scantime;
    }

    public void setScantime(Date scantime) {
        this.scantime = scantime;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getTradeno() {
        return tradeno;
    }

    public void setTradeno(String tradeno) {
        this.tradeno = tradeno;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Double getSoc() {
        return soc;
    }

    public void setSoc(Double soc) {
        this.soc = soc;
    }

    public BigDecimal getChaMoney() {
        return chaMoney;
    }

    public void setChaMoney(BigDecimal chaMoney) {
        this.chaMoney = chaMoney;
    }

    public BigDecimal getServiceMoney() {
        return serviceMoney;
    }

    public void setServiceMoney(BigDecimal serviceMoney) {
        this.serviceMoney = serviceMoney;
    }

}
