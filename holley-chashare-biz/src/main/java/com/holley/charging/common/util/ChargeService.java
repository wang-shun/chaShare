package com.holley.charging.common.util;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

import redis.clients.jedis.exceptions.JedisException;

import com.holley.charging.model.bus.BusPayment;
import com.holley.charging.model.bus.BusPaymentExample;
import com.holley.charging.model.def.ChargingConfig;
import com.holley.charging.model.def.EquipChargeStatusBase;
import com.holley.charging.model.def.NotificationChargeOrderInfoBase;
import com.holley.charging.model.def.NotificationStartChargeResultBase;
import com.holley.charging.model.def.NotificationStopChargeResultBase;
import com.holley.charging.service.share.CommonService;
import com.holley.common.constants.charge.ChargeDealStatusEnum;
import com.holley.common.constants.charge.ChargeStepEnum;
import com.holley.common.constants.charge.IsBillStatusEnum;
import com.holley.common.constants.charge.PileStatusEnum;
import com.holley.common.constants.share.ConfirmResultTypeEnum;
import com.holley.common.constants.share.FailReasonTypeEnum;
import com.holley.common.constants.share.RetTypeEnum;
import com.holley.common.constants.share.StartChargeSeqStatEnum;
import com.holley.common.constants.share.SuccStatTypeEnum;
import com.holley.common.dataobject.PileStatusBean;
import com.holley.common.security.SecurityUtil;
import com.holley.common.util.DateUtil;
import com.holley.common.util.JsonUtil;
import com.holley.platform.model.sys.SysSecretKey;

/**
 * Description: 充电服务类
 *
 * @author shen.cheng@holley.cn
 */
public class ChargeService {

    private final static Logger               logger            = Logger.getLogger(ChargeService.class);
    private ChargeStepEnum                    step;                                                       // 充电过程步骤
    private ChargeInfo                        cinfo;
    private String                            operatorId;
    private String                            localTradeNo;
    private LocalCacheUtil                    localCacheUtil;
    private CommonService                     commonService;
    private NotificationStartChargeResultBase startChargeResult = new NotificationStartChargeResultBase();
    private EquipChargeStatusBase             equipChargeStatus = new EquipChargeStatusBase();
    private NotificationChargeOrderInfoBase   chargeOrderInfo   = new NotificationChargeOrderInfoBase();
    private NotificationStopChargeResultBase  stopChargeResult  = new NotificationStopChargeResultBase();
    private BusPaymentExample                 emp               = new BusPaymentExample();
    private SysSecretKey                      sysSecretKey;

    public ChargeService(ChargeInfo cinfo, String operatorId, LocalCacheUtil localCacheUtil, CommonService commonService) {
        this.step = cinfo.getStep();
        this.cinfo = cinfo;
        this.operatorId = operatorId;
        this.localCacheUtil = localCacheUtil;
        this.commonService = commonService;
        this.localTradeNo = getLocalStartChargeSeq(cinfo.getTradeNo());

        startChargeResult.setConnectorID(cinfo.getConnectorID());
        startChargeResult.setStartChargeSeq(cinfo.getTradeNo());

        equipChargeStatus.setConnectorID(cinfo.getConnectorID());
        equipChargeStatus.setStartChargeSeq(cinfo.getTradeNo());

        chargeOrderInfo.setConnectorID(cinfo.getConnectorID());
        chargeOrderInfo.setStartChargeSeq(cinfo.getTradeNo());

        stopChargeResult.setConnectorID(cinfo.getConnectorID());
        stopChargeResult.setStartChargeSeq(cinfo.getTradeNo());

        sysSecretKey = localCacheUtil.getSecretKeyByOperatorID(operatorId);
    }

    /**
     * 启动充电
     */
    private void startCharge() {
        long lastUpdate = cinfo.getUpdateTime().getTime();
        long nowTime = System.currentTimeMillis();
        int count = cinfo.getCount();
        boolean isChain = false;
        try {
            PileStatusBean pileStatusBean = localCacheUtil.returnPileStatusBean(cinfo.getPileId());
            logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "桩状态：" + pileStatusBean.getStatus());
            if (ShareChargeCache.islocal()) {// 本地
                logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "已经启动。。。");
                setStep(ChargeStepEnum.DO);
                cinfo.setUpdateTime(new Date());
                cinfo.setCount(0);
                cinfo.setStep(getStep());
                ShareChargeCache.addOrUpdateChargeInfo(cinfo, operatorId);
                isChain = true;
            } else if (PileStatusEnum.CHARGING == pileStatusBean.getStatus() && localTradeNo.equals(pileStatusBean.getTradeno())) {
                if (count >= 10) {// 指定次数以上认为OK
                    startChargeResult.setStartTime(DateUtil.DateToLongStr(pileStatusBean.getStarttime()));
                    startChargeResult.setStartChargeSeqStat(StartChargeSeqStatEnum.CHARGING.getValue());
                    JSONObject jsonobj = QueryActionUtil.notificationStartChargeResult(startChargeResult, sysSecretKey);
                    if (jsonobj != null) {
                        int ret = getDataInt(jsonobj, "Ret");
                        String endata = getDataStr(jsonobj, "Data");
                        JSONObject data = getDecodeData(endata, sysSecretKey);
                        if (RetTypeEnum.SUCCESS.getValue() == ret && (getDataInt(data, "SuccStat") == SuccStatTypeEnum.SUCCESS.getValue())) {
                            logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送startChaInfo成功。。。");
                            setStep(ChargeStepEnum.DO);
                            cinfo.setUpdateTime(new Date());
                            cinfo.setCount(0);
                            cinfo.setStep(getStep());
                            ShareChargeCache.addOrUpdateChargeInfo(cinfo, operatorId);
                            isChain = true;
                        } else {
                            logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送startChaInfo失败。。。");
                        }
                    } else {
                        logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送startChaInfo失败。。。");
                    }

                } else {
                    cinfo.setCount(count + 1);
                    cinfo.setUpdateTime(new Date());
                    isChain = true;
                }
            }
        } catch (JedisException je) {
            logger.info("redisPool error");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!isChain) {
                if ((nowTime - lastUpdate) / 1000 > ChargingConfig.getMaxDelayTime()) {// 超过90秒未启动则失败
                    setStep(ChargeStepEnum.CLOSE);
                    ShareChargeCache.removeChargeInfo(cinfo, operatorId);
                    logger.info(operatorId + "超时删除startChargeJob任务：" + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo);
                }
            }
        }

    }

    /**
     * 充电过程
     */
    private void doCharge() {
        long lastUpdate = cinfo.getUpdateTime().getTime();
        long nowTime = System.currentTimeMillis();
        int count = cinfo.getCount();
        boolean isChain = false;
        try {
            PileStatusBean pileStatusBean = localCacheUtil.returnPileStatusBean(cinfo.getPileId());
            long t = (nowTime - lastUpdate) / 1000;
            System.err.println(t);
            if (ShareChargeCache.islocal() && t > 40) {// 本地
                logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "结束充电进入结束阶段。。。");
                // 更新状态
                setStep(ChargeStepEnum.END);
                cinfo.setUpdateTime(new Date());
                cinfo.setCount(0);
                cinfo.setStep(getStep());
                ShareChargeCache.addOrUpdateChargeInfo(cinfo, operatorId);// 放入结束充电队列
            } else if (localTradeNo.equals(pileStatusBean.getTradeno())) {// 充电中推送充电信息
                if (PileStatusEnum.CHARGING == pileStatusBean.getStatus()) {
                    if (t > 40) {
                        equipChargeStatus.setStartChargeSeqStat(StartChargeSeqStatEnum.CHARGING.getValue());
                        equipChargeStatus.setConnectorStatus(localCacheUtil.returnPileStatus(pileStatusBean.getStatus()).getValue());
                        equipChargeStatus.setElecMoney(pileStatusBean.getChaMoney() != null ? pileStatusBean.getChaMoney().doubleValue() : 0.0);
                        equipChargeStatus.setSeviceMoney(pileStatusBean.getServiceMoney() != null ? pileStatusBean.getServiceMoney().doubleValue() : 0.0);
                        equipChargeStatus.setEndTime(DateUtil.DateToLongStr(pileStatusBean.getUpdatetime()));
                        equipChargeStatus.setSoc(pileStatusBean.getSoc() != null ? pileStatusBean.getSoc() : 0.0);
                        equipChargeStatus.setStartTime(DateUtil.DateToLongStr(pileStatusBean.getStarttime()));
                        equipChargeStatus.setTotalMoney(pileStatusBean.getMoney() != null ? pileStatusBean.getMoney().doubleValue() : 0.0);// 总金额包含充电费？服务费？
                        equipChargeStatus.setTotalPower(pileStatusBean.getChapower() != null ? pileStatusBean.getChapower() : 0.0);
                        equipChargeStatus.setCurrentA(NumberUtils.toDouble(pileStatusBean.getOuti()));
                        equipChargeStatus.setVoltageA(NumberUtils.toDouble(pileStatusBean.getOutv()));
                        logger.info("equipChargeStatus:" + JsonUtil.bean2json(equipChargeStatus));
                        JSONObject jsonobj = QueryActionUtil.notificationEquipChargeStatus(equipChargeStatus, sysSecretKey);
                        if (jsonobj != null) {
                            int ret = getDataInt(jsonobj, "Ret");// 请求状态
                            String endata = getDataStr(jsonobj, "Data");
                            JSONObject data = getDecodeData(endata, sysSecretKey);
                            if (RetTypeEnum.SUCCESS.getValue() == ret && (getDataInt(data, "SuccStat") == SuccStatTypeEnum.SUCCESS.getValue())) {
                                logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送doChaInfo成功。。。");
                            } else {
                                logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送doChaInfo失败。。。");
                            }
                            // 更新状态
                            cinfo.setUpStatus(pileStatusBean.getStatus().getValue());
                            cinfo.setUpdateTime(new Date());
                            cinfo.setCount(0);
                        } else {
                            logger.info(operatorId + "token获取失败。。。");
                        }

                    }
                } else {
                    // 充电结束转充电结束账单推送 故障？正常结束？手动停止？
                    if (count >= 10) {// 防止虚假状态导致充电结束
                        System.err.println(operatorId + "doChargeJob达到监测次数删除，进入结束阶段。。。");
                        logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "结束充电进入结束阶段。。。");
                        setStep(ChargeStepEnum.END);
                        cinfo.setUpdateTime(new Date());
                        cinfo.setCount(0);
                        cinfo.setStep(getStep());
                        ShareChargeCache.addOrUpdateChargeInfo(cinfo, operatorId);// 放入结束充电队列
                    } else {
                        cinfo.setCount(count + 1);
                        cinfo.setUpdateTime(new Date());
                        System.err.println(operatorId + "DoChargeJob监测次数：" + cinfo.getCount());
                    }
                    isChain = true;
                }
            }
        } catch (JedisException je) {
            logger.info(operatorId + "redisPool error");
        } catch (Exception ee) {
            ee.printStackTrace();
            logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送doChaInfo失败。。。");
        } finally {
            if (!isChain) {
                if ((nowTime - lastUpdate) / 1000 > ChargingConfig.getMaxDelayTime()) {// 超时删除
                    setStep(ChargeStepEnum.END);
                    cinfo.setUpdateTime(new Date());
                    cinfo.setCount(0);
                    cinfo.setStep(getStep());
                    logger.info(operatorId + "doChargeJob任务超进入endChargeJob：" + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo);
                }
            }
        }

    }

    /**
     * 停止充电
     */
    private void stopCharge() {
        long lastUpdate = cinfo.getUpdateTime().getTime();
        long nowTime = System.currentTimeMillis();
        int count = cinfo.getCount();
        boolean isChain = false;
        boolean pileStatus = false;
        boolean traderStatus = false;
        try {
            PileStatusBean pileStatusBean = localCacheUtil.returnPileStatusBean(cinfo.getPileId());
            emp.clear();
            BusPaymentExample.Criteria cr = emp.createCriteria();
            cr.andPileIdEqualTo(cinfo.getPileId());
            cr.andTradeNoEqualTo(localTradeNo);
            cr.andDealStatusEqualTo(ChargeDealStatusEnum.SUCCESS.getShortValue());
            List<BusPayment> list = commonService.queryPaymentByExample(emp);
            BusPayment payment = (list != null && list.size() > 0) ? list.get(0) : null;
            if (!localTradeNo.equals(pileStatusBean.getTradeno())) {
                pileStatus = true;
            } else if (localTradeNo.equals(pileStatusBean.getTradeno()) && PileStatusEnum.CHARGING != pileStatusBean.getStatus()) {
                pileStatus = true;
            }
            if (payment != null && ChargeDealStatusEnum.SUCCESS.getShortValue().equals(payment.getDealStatus())) {
                traderStatus = true;
            }
            if (pileStatus || traderStatus) {
                stopChargeResult.setFailReason(FailReasonTypeEnum.NIL.getValue());
                stopChargeResult.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
                stopChargeResult.setStartChargeSeqStat(StartChargeSeqStatEnum.END.getValue());
                if (ShareChargeCache.islocal()) {// 本地
                    logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "桩停止充电。。。");
                    logger.info(operatorId + "info:" + JSONObject.fromObject(stopChargeResult));
                    setStep(ChargeStepEnum.CLOSE);
                    isChain = true;
                } else {
                    JSONObject jsonobj = QueryActionUtil.notificationStopChargeResult(stopChargeResult, sysSecretKey);
                    if (jsonobj != null) {
                        int ret = getDataInt(jsonobj, "Ret");
                        String endata = getDataStr(jsonobj, "Data");
                        JSONObject data = getDecodeData(endata, sysSecretKey);
                        if (RetTypeEnum.SUCCESS.getValue() == ret && (getDataInt(data, "SuccStat") == SuccStatTypeEnum.SUCCESS.getValue())) {
                            logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送stopChaInfo成功。。。");
                            setStep(ChargeStepEnum.CLOSE);
                            isChain = true;
                        } else {
                            logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送stopChaInfo失败。。。");
                        }
                    } else {
                        logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送stopChaInfo失败。。。");
                    }
                }
            }
        } catch (JedisException je) {
            logger.info(operatorId + "redisPool error");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!isChain) {
                if ((nowTime - lastUpdate) / 1000 > ChargingConfig.getMaxDelayTime()) {// 超时未推送删除
                    logger.info(operatorId + "超时删除stopChargeJob任务：" + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo);
                    setStep(ChargeStepEnum.CLOSE);
                    // stopChargeResult.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
                    // stopChargeResult.setStartChargeSeqStat(StartChargeSeqStatEnum.UNKNOWN.getValue());
                    //
                    // if (!ShareChargeCache.islocal()) {// 本地
                    // JSONObject jsonobj = QueryActionUtil.notificationStopChargeResult(stopChargeResult,
                    // sysSecretKey);
                    // }
                }
            }
        }
    }

    /**
     * 结束充电
     */
    private void endCharge() {
        long lastUpdate = cinfo.getUpdateTime().getTime();
        long nowTime = System.currentTimeMillis();
        int count = cinfo.getCount();
        boolean isChain = false;
        try {
            emp.clear();
            BusPaymentExample.Criteria cr = emp.createCriteria();
            cr.andPileIdEqualTo(cinfo.getPileId());
            cr.andTradeNoEqualTo(localTradeNo);
            cr.andDealStatusEqualTo(ChargeDealStatusEnum.SUCCESS.getShortValue());
            List<BusPayment> list = commonService.queryPaymentByExample(emp);
            BusPayment payment = (list != null && list.size() > 0) ? list.get(0) : null;
            if (payment != null) {
                if (IsBillStatusEnum.PUSH.getShortValue().equals(payment.getIsBill())) {
                    logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "已经推送。。。");
                    ShareChargeCache.removeChargeInfo(cinfo, operatorId);
                    setStep(ChargeStepEnum.CLOSE);
                    PileStatusBean pileStatusBean = localCacheUtil.returnPileStatusBean(cinfo.getPileId());
                    if (pileStatusBean.getStatus() == PileStatusEnum.FINISH) {
                        pileStatusBean.setStatus(PileStatusEnum.IDLE);
                        localCacheUtil.refreshPileStatusBean(pileStatusBean);
                    }
                    return;
                }
                chargeOrderInfo.setEndTime(DateUtil.DateToLongStr(payment.getEndTime()));
                chargeOrderInfo.setStartTime(DateUtil.DateToLongStr(payment.getStartTime()));
                // chargeOrderInfo.setStopReason(stopReason);//TODO停止充电原因
                chargeOrderInfo.setTotalElecMoney(ShareUtil.returnBigDecimal(payment.getChaFee()));
                chargeOrderInfo.setTotalMoney(ShareUtil.returnBigDecimal(payment.getShouldMoney()));
                chargeOrderInfo.setTotalPower(ShareUtil.returnBigDecimal(payment.getChaPower()));
                chargeOrderInfo.setTotalSeviceMoney(ShareUtil.returnBigDecimal(payment.getServiceFee()));
                logger.info("chargeOrderInfo:" + JsonUtil.bean2json(chargeOrderInfo));
                JSONObject jsonobj = QueryActionUtil.notificationChargeOrderInfo(chargeOrderInfo, sysSecretKey);
                if (jsonobj != null) {
                    int ret = getDataInt(jsonobj, "Ret");
                    String endata = getDataStr(jsonobj, "Data");
                    JSONObject data = getDecodeData(endata, sysSecretKey);
                    if (RetTypeEnum.SUCCESS.getValue() == ret) {
                        logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送endChaInfo成功。。。");
                        int rs = getDataInt(data, "ConfirmResult");
                        logger.info(operatorId + ConfirmResultTypeEnum.getText(rs));
                        if (rs == ConfirmResultTypeEnum.SUCCESS.getValue()) {
                            BusPayment updatePaymen = new BusPayment();
                            updatePaymen.setId(payment.getId());
                            updatePaymen.setIsBill(IsBillStatusEnum.PUSH.getShortValue());
                            int cunt = commonService.updatePaymentByPrimaryKeySelective(updatePaymen);
                            if (cunt > 0) {
                                ShareChargeCache.removeChargeInfo(cinfo, operatorId);
                                setStep(ChargeStepEnum.CLOSE);
                                isChain = true;
                                PileStatusBean pileStatusBean = localCacheUtil.returnPileStatusBean(cinfo.getPileId());
                                if (pileStatusBean.getStatus() == PileStatusEnum.FINISH) {
                                    pileStatusBean.setStatus(PileStatusEnum.IDLE);
                                    localCacheUtil.refreshPileStatusBean(pileStatusBean);
                                }
                            }
                        }
                    } else {
                        logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送endChaInfo失败。。。");
                    }

                } else {
                    logger.info(operatorId + "token获取失败。。。");
                    logger.info(operatorId + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo + "推送endChaInfo失败。。。");
                }

            } else if (count >= 20) {
                System.err.println(operatorId + "EndChargeJob达到监测次数删除结束。。。");
                ShareChargeCache.removeChargeInfo(cinfo, operatorId);
                setStep(ChargeStepEnum.CLOSE);
                isChain = true;
                PileStatusBean pileStatusBean = localCacheUtil.returnPileStatusBean(cinfo.getPileId());
                if (pileStatusBean.getStatus() == PileStatusEnum.FINISH) {
                    pileStatusBean.setStatus(PileStatusEnum.IDLE);
                    localCacheUtil.refreshPileStatusBean(pileStatusBean);
                }
            } else {
                cinfo.setCount(count + 1);
                cinfo.setUpdateTime(new Date());
                System.err.println(operatorId + "EndChargeJob监测次数：" + cinfo.getCount());
                isChain = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!isChain) {
                if ((nowTime - lastUpdate) / 1000 > ChargingConfig.getMaxDelayTime()) {// 超时未推送删除
                    logger.info(operatorId + "超时删除endChargeJob任务：" + "桩：" + cinfo.getConnectorID() + "订单号：" + localTradeNo);
                    ShareChargeCache.removeChargeInfo(cinfo, operatorId);
                    setStep(ChargeStepEnum.CLOSE);
                    PileStatusBean pileStatusBean = localCacheUtil.returnPileStatusBean(cinfo.getPileId());
                    if (pileStatusBean.getStatus() == PileStatusEnum.FINISH) {
                        pileStatusBean.setStatus(PileStatusEnum.IDLE);
                        localCacheUtil.refreshPileStatusBean(pileStatusBean);
                    }
                }
            }
        }
    }

    /**
     * 充电主方法
     */
    public void charging() {
        switch (step) {
            case START:
                startCharge();
                break;
            case DO:
                doCharge();
                break;
            case END:
                endCharge();
                break;
            case STOP:
                stopCharge();
                break;
            default:
                break;
        }
    }

    public ChargeStepEnum getStep() {
        return step;
    }

    public void setStep(ChargeStepEnum step) {
        this.step = step;
    }

    public boolean isClose() {
        return step != null ? step == ChargeStepEnum.CLOSE : true;
    }

    private JSONObject getDecodeData(String enData, SysSecretKey sk) throws Exception {
        String str = SecurityUtil.aesDecrypt(enData, sk.getDatasecret(), sk.getDatasecretiv());
        return JSONObject.fromObject(str);
    }

    private int getDataInt(JSONObject data, String key) {
        if (data == null) {
            return 0;
        }
        return data.containsKey(key) ? NumberUtils.toInt(data.getString(key)) : 0;
    }

    private String getDataStr(JSONObject data, String key) {
        if (data == null) {
            return "";
        }
        return data.containsKey(key) ? data.getString(key) : "";
    }

    private String getLocalStartChargeSeq(String startChargeSeq) {
        String temp = startChargeSeq;
        int len = temp.length();
        if (len == 32) {
            return temp;
        } else if (len < 32) {
            int x = 32 - len;
            for (int i = 0; i < x; i++) {
                temp = "0" + temp;
            }
        } else if (len > 32) {
            temp = temp.substring(0, 32);
        }
        return temp;
    }

}
