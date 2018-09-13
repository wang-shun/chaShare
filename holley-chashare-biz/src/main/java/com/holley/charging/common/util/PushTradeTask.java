package com.holley.charging.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.holley.charging.model.bus.BusPayment;
import com.holley.charging.model.def.BusPaymentVo;
import com.holley.charging.model.def.ChargingConfig.ChargingBussinessTypeEnum;
import com.holley.charging.model.def.NotificationChargeOrderInfoBase;
import com.holley.common.constants.charge.ChargeDealStatusEnum;
import com.holley.common.constants.charge.IsBillStatusEnum;
import com.holley.common.constants.share.ConfirmResultTypeEnum;
import com.holley.common.constants.share.RetTypeEnum;
import com.holley.common.util.DateUtil;
import com.holley.platform.model.sys.SysSecretKey;

/**
 * 账单推送定时任务 Description:
 *
 * @author shen.cheng@holley.cn
 */
public class PushTradeTask extends BaseTask {

    private final static Logger logger = Logger.getLogger(PushTradeTask.class);
    private Map<String, Object> param  = new HashMap<String, Object>();

    public void execute() {
        String operatorId = ChargingBussinessTypeEnum.ECW_CHARGING.getValue();
        SysSecretKey sysSecretKey = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        param.put("tradeKey", operatorId);
        param.put("dealStatus", ChargeDealStatusEnum.SUCCESS.getValue());
        param.put("isBill", IsBillStatusEnum.UN_BILL.getValue());
        // param.put("payStatus", ChargePayStatusEnum.UNPAID.getValue());
        List<BusPaymentVo> list = commonService.queryEchongPushPayment(param);

        if (list != null && !list.isEmpty()) {
            logger.info(operatorId + "有" + list.size() + "个推送账单任务。。。");
            for (BusPaymentVo pay : list) {
                try {
                    NotificationChargeOrderInfoBase chargeOrderInfo = new NotificationChargeOrderInfoBase();
                    chargeOrderInfo.setConnectorID(pay.getPileCode());
                    chargeOrderInfo.setEndTime(DateUtil.DateToLongStr(pay.getEndTime()));
                    chargeOrderInfo.setStartChargeSeq(getEStartChargeSeq(pay.getTradeNo()));
                    chargeOrderInfo.setStartTime(DateUtil.DateToLongStr(pay.getStartTime()));
                    // chargeOrderInfo.setStopReason(stopReason);//TODO停止充电原因
                    chargeOrderInfo.setTotalElecMoney(ShareUtil.returnBigDecimal(pay.getChaFee()));
                    chargeOrderInfo.setTotalMoney(ShareUtil.returnBigDecimal(pay.getShouldMoney()));
                    chargeOrderInfo.setTotalPower(ShareUtil.returnBigDecimal(pay.getChaPower()));
                    chargeOrderInfo.setTotalSeviceMoney(ShareUtil.returnBigDecimal(pay.getServiceFee()));
                    JSONObject jsonobj = QueryActionUtil.notificationChargeOrderInfo(chargeOrderInfo, sysSecretKey);
                    if (jsonobj != null) {
                        int ret = getDataInt(jsonobj, "Ret");
                        String endata = getDataString(jsonobj, "Data");
                        String msg = getDataString(jsonobj, "Msg");
                        JSONObject data = getDecodeData(endata, sysSecretKey);
                        BusPayment updatePaymen = new BusPayment();
                        updatePaymen.setId(pay.getId());
                        if (RetTypeEnum.SUCCESS.getValue() == ret) {
                            logger.info(operatorId + "桩：" + pay.getPileCode() + "订单号：" + pay.getTradeNo() + "推送成功。。。");
                            int rs = getDataInt(data, "ConfirmResult");
                            logger.info(operatorId + ConfirmResultTypeEnum.getText(rs));
                            if (rs == ConfirmResultTypeEnum.SUCCESS.getValue()) {
                                updatePaymen.setIsBill(IsBillStatusEnum.PUSH.getShortValue());
                                commonService.updatePaymentByPrimaryKeySelective(updatePaymen);
                            }
                        } else if (msg.contains("Invalid")) {
                            logger.info(operatorId + "桩：" + pay.getPileCode() + "订单号：" + pay.getTradeNo() + "无效订单。。。");
                            updatePaymen.setIsBill(IsBillStatusEnum.INVALID.getShortValue());
                            commonService.updatePaymentByPrimaryKeySelective(updatePaymen);
                        } else {
                            logger.info(operatorId + "桩：" + pay.getPileCode() + "订单号：" + pay.getTradeNo() + "推送失败。。。");
                        }

                    }
                    TimeUnit.MICROSECONDS.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            logger.info(operatorId + "推送账单结束。。。");
        }
    }

}
