package com.holley.common.dataobject.charging.dcs;

import java.io.Serializable;
import java.util.Date;

public class PileMonitor_CRDC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1564291663466155815L;
	
	private Integer           stationid;
    private Integer           id;              //桩id
    private String            pilecode;        //桩编号
    private Date              updateTime;
    
    private float dcOutV;
    private float dcOutI;
    private int SOC;
    private float BatTempLow;	//电池组最低温度
    private float BatTempHigh;
    private int totalTime;
    private int workstatus;
    private boolean BmsError;
    private boolean dcOutOver;	//直流母线输出过压告警
    private boolean dcOutLoss;
    private boolean BatCurOver;	//蓄电池充电过流告警
    private boolean BatPntempOver;
    private float ygZong;		//有功总电能
    private boolean BatLinked;	//是否连接电池
    private float BatSvHigh;	//单体电池最高电压
    private float BatSvLow;	//单体电池最低电压
    private boolean plugBaseStatus;	//0:未收枪	1:收枪	壁挂式不需要此状态
    private boolean plugCoverStatus;	// 0:开;1:关闭		壁挂式不需要此状态
    private boolean connectCar;		//0:未建立通讯		1:建立通讯		没有填 0
    private boolean parkBusy;		//1：表示有车：		0：表示没车
	
    private boolean recordOverflow;	//交 易 记 录 已满告警
    private boolean cardReadError;	//读 卡 器 通 讯异常
    private boolean meterError;		//电度表异常
	
    private float chargedMoney;		//已充金额	精确到小数点后两位，倍数 100
    private float energyPrice;		//电价	精确到小数点后两位，		倍数 100
    private float chargedEnergy;	//已充总度数  精确到小数点后两位，倍数 100
    private int parkLockStatus;		//0：地锁硬件无法找到		1:降下		2:升起		3:运动中		4:故障
	
	
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

	public float getDcOutV() {
		return dcOutV;
	}

	public void setDcOutV(float dcOutV) {
		this.dcOutV = dcOutV;
	}

	public float getDcOutI() {
		return dcOutI;
	}

	public void setDcOutI(float dcOutI) {
		this.dcOutI = dcOutI;
	}

	public int getSOC() {
		return SOC;
	}

	public void setSOC(int sOC) {
		SOC = sOC;
	}

	public float getBatTempLow() {
		return BatTempLow;
	}

	public void setBatTempLow(float batTempLow) {
		BatTempLow = batTempLow;
	}

	public float getBatTempHigh() {
		return BatTempHigh;
	}

	public void setBatTempHigh(float batTempHigh) {
		BatTempHigh = batTempHigh;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public int getWorkstatus() {
		return workstatus;
	}

	public void setWorkstatus(int workstatus) {
		this.workstatus = workstatus;
	}

	public boolean isBmsError() {
		return BmsError;
	}

	public void setBmsError(boolean bmsError) {
		BmsError = bmsError;
	}

	public boolean isDcOutOver() {
		return dcOutOver;
	}

	public void setDcOutOver(boolean dcOutOver) {
		this.dcOutOver = dcOutOver;
	}

	public boolean isDcOutLoss() {
		return dcOutLoss;
	}

	public void setDcOutLoss(boolean dcOutLoss) {
		this.dcOutLoss = dcOutLoss;
	}

	public boolean isBatCurOver() {
		return BatCurOver;
	}

	public void setBatCurOver(boolean batCurOver) {
		BatCurOver = batCurOver;
	}

	public boolean isBatPntempOver() {
		return BatPntempOver;
	}

	public void setBatPntempOver(boolean batPntempOver) {
		BatPntempOver = batPntempOver;
	}

	public float getYgZong() {
		return ygZong;
	}

	public void setYgZong(float ygZong) {
		this.ygZong = ygZong;
	}

	public boolean isBatLinked() {
		return BatLinked;
	}

	public void setBatLinked(boolean batLinked) {
		BatLinked = batLinked;
	}

	public float getBatSvHigh() {
		return BatSvHigh;
	}

	public void setBatSvHigh(float batSvHigh) {
		BatSvHigh = batSvHigh;
	}

	public float getBatSvLow() {
		return BatSvLow;
	}

	public void setBatSvLow(float batSvLow) {
		BatSvLow = batSvLow;
	}

	public boolean isPlugBaseStatus() {
		return plugBaseStatus;
	}

	public void setPlugBaseStatus(boolean plugBaseStatus) {
		this.plugBaseStatus = plugBaseStatus;
	}

	public boolean isPlugCoverStatus() {
		return plugCoverStatus;
	}

	public void setPlugCoverStatus(boolean plugCoverStatus) {
		this.plugCoverStatus = plugCoverStatus;
	}

	public boolean isConnectCar() {
		return connectCar;
	}

	public void setConnectCar(boolean connectCar) {
		this.connectCar = connectCar;
	}

	public boolean isParkBusy() {
		return parkBusy;
	}

	public void setParkBusy(boolean parkBusy) {
		this.parkBusy = parkBusy;
	}

	public boolean isRecordOverflow() {
		return recordOverflow;
	}

	public void setRecordOverflow(boolean recordOverflow) {
		this.recordOverflow = recordOverflow;
	}

	public boolean isCardReadError() {
		return cardReadError;
	}

	public void setCardReadError(boolean cardReadError) {
		this.cardReadError = cardReadError;
	}

	public boolean isMeterError() {
		return meterError;
	}

	public void setMeterError(boolean meterError) {
		this.meterError = meterError;
	}

	public float getChargedMoney() {
		return chargedMoney;
	}

	public void setChargedMoney(float chargedMoney) {
		this.chargedMoney = chargedMoney;
	}

	public float getEnergyPrice() {
		return energyPrice;
	}

	public void setEnergyPrice(float energyPrice) {
		this.energyPrice = energyPrice;
	}

	public float getChargedEnergy() {
		return chargedEnergy;
	}

	public void setChargedEnergy(float chargedEnergy) {
		this.chargedEnergy = chargedEnergy;
	}

	public int getParkLockStatus() {
		return parkLockStatus;
	}

	public void setParkLockStatus(int parkLockStatus) {
		this.parkLockStatus = parkLockStatus;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
