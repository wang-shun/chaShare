package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: tonken获取
 *
 * @author shen.cheng@holley.cn
 */
public class OperatorSecretKeyBase {

    @JSONField(name = "OperatorID")
    private String  operatorID;        // 运营商机构ID
    @JSONField(name = "SuccStat")
    private Integer succStat;          // 0：成功1：失败
    @JSONField(name = "AccessToken")
    private String  accessToken;       // 唯一token凭证
    @JSONField(name = "TokenAvailableTime")
    private Integer tokenAvailableTime; // 凭证有效期秒
    @JSONField(name = "FailReason")
    private Integer failReason;        // 失败原因0：无1：无此运营商2.密钥错误

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public Integer getSuccStat() {
        return succStat;
    }

    public void setSuccStat(Integer succStat) {
        this.succStat = succStat;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getTokenAvailableTime() {
        return tokenAvailableTime;
    }

    public void setTokenAvailableTime(Integer tokenAvailableTime) {
        this.tokenAvailableTime = tokenAvailableTime;
    }

    public Integer getFailReason() {
        return failReason;
    }

    public void setFailReason(Integer failReason) {
        this.failReason = failReason;
    }

}
