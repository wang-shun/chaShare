package com.holley.common.dataobject.charging.dcs;

import java.io.Serializable;
import java.util.Date;

public class PileMonitor_CRAC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1166962831235927176L;
	
	private Integer           stationid;
    private Integer           id;              //桩id
    private String            pilecode;        //桩编号
    private Date              updateTime;

	private boolean linkcon;
	private int workstatus;
	private boolean plugBaseStatus;	//0:未收枪	1:收枪	壁挂式不需要此状态
	private boolean plugCoverStatus;	// 0:开;1:关闭		壁挂式不需要此状态
	private boolean connectCar;		//0:未建立通讯		1:建立通讯		没有填 0
	private boolean acInOver;
	private boolean acInLoss;
	private boolean iOver;
	private float acOutV;
	private float acOutI;
	private boolean relayOut;
	private float ygZong;
	private int totalTime;
	private boolean parkBusy;		//1：表示有车：		0：表示没车
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

	public boolean isLinkcon() {
		return linkcon;
	}

	public void setLinkcon(boolean linkcon) {
		this.linkcon = linkcon;
	}

	public int getWorkstatus() {
		return workstatus;
	}

	public void setWorkstatus(int workstatus) {
		this.workstatus = workstatus;
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

	public boolean isAcInOver() {
		return acInOver;
	}

	public void setAcInOver(boolean acInOver) {
		this.acInOver = acInOver;
	}

	public boolean isAcInLoss() {
		return acInLoss;
	}

	public void setAcInLoss(boolean acInLoss) {
		this.acInLoss = acInLoss;
	}

	public boolean isiOver() {
		return iOver;
	}

	public void setiOver(boolean iOver) {
		this.iOver = iOver;
	}

	public float getAcOutV() {
		return acOutV;
	}

	public void setAcOutV(float acOutV) {
		this.acOutV = acOutV;
	}

	public float getAcOutI() {
		return acOutI;
	}

	public void setAcOutI(float acOutI) {
		this.acOutI = acOutI;
	}

	public boolean isRelayOut() {
		return relayOut;
	}

	public void setRelayOut(boolean relayOut) {
		this.relayOut = relayOut;
	}

	public float getYgZong() {
		return ygZong;
	}

	public void setYgZong(float ygZong) {
		this.ygZong = ygZong;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public boolean isParkBusy() {
		return parkBusy;
	}

	public void setParkBusy(boolean parkBusy) {
		this.parkBusy = parkBusy;
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
