package com.holley.charging.common.util;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.math.NumberUtils;

import com.holley.charging.service.share.CommonService;
import com.holley.common.security.SecurityUtil;
import com.holley.platform.model.sys.SysSecretKey;

public abstract class BaseTask {

    @Resource
    protected CommonService  commonService;
    @Resource
    protected LocalCacheUtil localCacheUtil;

    protected JSONObject getDecodeData(String enData, SysSecretKey sk) throws Exception {
        String str = SecurityUtil.aesDecrypt(enData, sk.getDatasecret(), sk.getDatasecretiv());
        return JSONObject.fromObject(str);
    }

    protected String getDataString(JSONObject data, String key) {
        if (data == null) {
            return "";
        }
        return data.containsKey(key) ? data.getString(key) : "";
    }

    protected int getDataInt(JSONObject data, String key) {
        if (data == null) {
            return 0;
        }
        return data.containsKey(key) ? NumberUtils.toInt(data.getString(key)) : 0;
    }

    protected String getEStartChargeSeq(String localStartChargeSeq) {
        String temp = localStartChargeSeq;
        int len = temp.length() - 27;
        if (len > 0) {
            temp = temp.substring(len, temp.length());
        }
        return temp;
    }
}
