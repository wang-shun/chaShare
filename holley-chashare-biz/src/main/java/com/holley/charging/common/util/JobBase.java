package com.holley.charging.common.util;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.math.NumberUtils;

import com.holley.charging.service.share.CommonService;
import com.holley.common.security.SecurityUtil;
import com.holley.platform.model.sys.SysSecretKey;

public abstract class JobBase implements Runnable {

    protected boolean        isRun   = true;
    protected LocalCacheUtil localCacheUtil;
    protected String         operatorID;
    protected CommonService  commonService;
    protected boolean        isChain = false;

    public JobBase(String operatorID, LocalCacheUtil localCacheUtil, CommonService commonService) {
        this.operatorID = operatorID;
        this.localCacheUtil = localCacheUtil;
        this.commonService = commonService;
    }

    // protected ConnectorStatusTypeEnum returnPileStatus(PileStatusEnum temp) {
    // if (PileStatusEnum.OFFLINE == temp) {
    // return ConnectorStatusTypeEnum.OFF_LINE;
    // } else if (PileStatusEnum.IDLE == temp || PileStatusEnum.FINISH == temp) {
    // return ConnectorStatusTypeEnum.IDLE;
    // } else if (PileStatusEnum.BUSYING == temp) {
    // return ConnectorStatusTypeEnum.UN_CHARGING;
    // } else if (PileStatusEnum.CHARGING == temp) {
    // return ConnectorStatusTypeEnum.CHARGING;
    // } else if (PileStatusEnum.FAULT == temp) {
    // return ConnectorStatusTypeEnum.FAULT;
    // } else {
    // return ConnectorStatusTypeEnum.OFF_LINE;
    // }
    // }

    protected JSONObject getDecodeData(String enData, SysSecretKey sk) throws Exception {
        String str = SecurityUtil.aesDecrypt(enData, sk.getDatasecret(), sk.getDatasecretiv());
        return JSONObject.fromObject(str);
    }

    protected int getDataInt(JSONObject data, String key) {
        if (data == null) {
            return 0;
        }
        return data.containsKey(key) ? NumberUtils.toInt(data.getString(key)) : 0;
    }

    protected String getDataStr(JSONObject data, String key) {
        if (data == null) {
            return "";
        }
        return data.containsKey(key) ? data.getString(key) : "";
    }

    protected String getLocalStartChargeSeq(String startChargeSeq) {
        String temp = "00000" + startChargeSeq;// 充电订单号
        return temp;
    }

    protected void stop() {
        isRun = false;
    }

}
