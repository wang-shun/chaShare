package com.holley.charging.common.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.holley.charging.model.bus.BusPayment;
import com.holley.charging.model.bus.BusPaymentExample;
import com.holley.charging.model.def.ChargeOrder;
import com.holley.charging.model.def.ChargingConfig.ChargingBussinessTypeEnum;
import com.holley.charging.model.def.CheckChargeOrdersBase;
import com.holley.common.constants.charge.ChargeDealStatusEnum;
import com.holley.common.constants.charge.DisputeReasonEnum;
import com.holley.common.constants.charge.IsBillStatusEnum;
import com.holley.common.constants.share.RetTypeEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.StringUtil;
import com.holley.platform.model.sys.SysSecretKey;

/**
 * 账单对账定时任务 Description:
 *
 * @author shen.cheng@holley.cn
 */
public class CheckTradeTask extends BaseTask {

    private final static Logger logger = Logger.getLogger(CheckTradeTask.class);

    public void execute() {
        String operatorId = ChargingBussinessTypeEnum.ECW_CHARGING.getValue();
        SysSecretKey sysSecretKey = localCacheUtil.getSecretKeyByOperatorID(operatorId);
        List<String> dateStrList = commonService.queryCheckCheckTrade();
        List<Date> dateList = null;
        Date date = new Date();
        // Date startTime = ShareUtil.getStartTime(date, ShareUtil.PRE_DAY);
        Date endTime = ShareUtil.getEndTime(date, ShareUtil.PRE_DAY);
        long maxTime = endTime.getTime();
        if (dateStrList != null && !dateStrList.isEmpty()) {
            dateList = new ArrayList<Date>();
            for (String ds : dateStrList) {
                Date tempdate = DateUtil.StrToDate(ds, DateUtil.TIME_SHORT);
                if (tempdate != null && tempdate.getTime() <= maxTime) {
                    dateList.add(tempdate);
                }
            }
        }
        if (dateList != null && !dateList.isEmpty()) {
            for (Date dateTime : dateList) {
                try {
                    Date start = ShareUtil.getStartTime(dateTime, 0);
                    Date end = ShareUtil.getEndTime(dateTime, 0);
                    BusPaymentExample emp = new BusPaymentExample();
                    BusPaymentExample.Criteria cr = emp.createCriteria();
                    cr.andTradeNoLike("%" + operatorId + "%");
                    cr.andDealStatusEqualTo(ChargeDealStatusEnum.SUCCESS.getShortValue());
                    cr.andIsBillEqualTo(IsBillStatusEnum.PUSH.getShortValue());
                    cr.andUpdateTimeGreaterThanOrEqualTo(start);
                    cr.andUpdateTimeLessThanOrEqualTo(end);
                    List<BusPayment> list = commonService.queryPaymentByExample(emp);
                    pushTask(operatorId, sysSecretKey, list, start, end);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

    }

    private void pushTask(String operatorId, SysSecretKey sysSecretKey, List<BusPayment> list, Date startTime, Date endTime) {

        if (list != null && list.size() > 0) {
            try {
                logger.info(operatorId + "有" + list.size() + "个对账账单。。。");
                List<String> okOrderSeq = new ArrayList<String>();// 无争议的订单
                CheckChargeOrdersBase checkBase = new CheckChargeOrdersBase();
                checkBase.setCheckOrderSeq(ShareUtil.getTradeNo());
                checkBase.setOrderCount(list.size());
                checkBase.setStartTime(DateUtil.DateToLongStr(startTime));
                checkBase.setEndTime(DateUtil.DateToLongStr(endTime));
                ChargeOrder order = null;
                for (BusPayment pay : list) {
                    okOrderSeq.add(pay.getTradeNo());
                    order = new ChargeOrder();
                    order.setStartChargeSeq(pay.getTradeNo());
                    order.setTotalPower(ShareUtil.returnBigDecimal(pay.getChaPower()));
                    order.setTotalMoney(ShareUtil.returnBigDecimal(pay.getShouldMoney()));
                    checkBase.getCargeOrders().add(order);
                    checkBase.setTotalOrderPower(ShareUtil.add(checkBase.getTotalOrderPower(), ShareUtil.returnBigDecimal(pay.getChaPower())));
                    checkBase.setTotalOrderMoney(ShareUtil.add(checkBase.getTotalOrderMoney(), ShareUtil.returnBigDecimal(pay.getShouldMoney())));
                }
                JSONObject jsonobj = QueryActionUtil.checkChargeOrders(checkBase, sysSecretKey);
                // checkBase.setTotalOrderPower(ShareUtil.formateScale(4, checkBase.getTotalOrderPower()));
                // checkBase.setTotalOrderMoney(ShareUtil.formateScale(2, checkBase.getTotalOrderMoney()));
                if (jsonobj != null) {
                    int ret = getDataInt(jsonobj, "Ret");
                    String endata = getDataString(jsonobj, "Data");
                    JSONObject data = getDecodeData(endata, sysSecretKey);
                    if (RetTypeEnum.SUCCESS.getValue() == ret) {// 请求成功
                        int totalDisputeOrder = getDataInt(data, "TotalDisputeOrder");// 争议订单数
                        String disputeOrders = getDataString(data, "DisputeOrders");// 具体争议订单
                        // List<String> disputeOrderSeq = new ArrayList<String>();// 争议的订单

                        if (totalDisputeOrder > 0 && StringUtil.isNotEmpty(disputeOrders)) {
                            JSONArray disputeJSONArray = JSONArray.fromObject(disputeOrders);
                            for (int i = 0; i < okOrderSeq.size(); i++) {
                                for (int x = 0; x < disputeJSONArray.size(); x++) {
                                    JSONObject jo = JSONObject.fromObject(disputeJSONArray.get(x));
                                    String startChargeSeq = getDataString(jo, "StartChargeSeq");
                                    int disputeReason = getDataInt(jo, "DisputeReason");
                                    String totalPower = getDataString(jo, "TotalPower");
                                    String totalMoney = getDataString(jo, "TotalMoney");
                                    logger.info(operatorId + "争议原因：" + DisputeReasonEnum.getText(disputeReason));
                                    logger.info(operatorId + "订单号：" + startChargeSeq + ";充电量：" + totalPower + ";充电金额：" + totalMoney);
                                    if (startChargeSeq.equals(okOrderSeq.get(i))) {
                                        okOrderSeq.remove(i);
                                    }
                                }
                            }
                        }
                        if (okOrderSeq.size() > 0) {
                            logger.info(operatorId + "共" + okOrderSeq.size() + "个对账成功。。。");
                            BusPayment updatePay = new BusPayment();
                            updatePay.setIsBill(IsBillStatusEnum.BILL.getShortValue());
                            BusPaymentExample payEmp = new BusPaymentExample();
                            BusPaymentExample.Criteria payCr = payEmp.createCriteria();
                            payCr.andTradeNoIn(okOrderSeq);
                            // payCr.andIsBillEqualTo(IsBillStatusEnum.PUSH.getShortValue());
                            commonService.updatePaymentByExampleSelective(updatePay, payEmp);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
