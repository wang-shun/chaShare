package com.holley.charging.common.util;

import java.util.concurrent.TimeUnit;

import com.holley.charging.service.share.CommonService;

/**
 * Description: 充电主类
 *
 * @author shen.cheng@holley.cn
 */
public class ChargeJob extends JobBase {

    private ChargeService chargeService;

    public ChargeJob(String operatorID, LocalCacheUtil localCacheUtil, CommonService commonService, ChargeInfo chargeInfo) {
        super(operatorID, localCacheUtil, commonService);
        this.chargeService = new ChargeService(chargeInfo, operatorID, localCacheUtil, commonService);
    }

    @Override
    public void run() {

        while (!chargeService.isClose()) {
            try {
                chargeService.charging();
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
