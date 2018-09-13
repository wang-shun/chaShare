package com.holley.charging.share.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.math.NumberUtils;

import com.holley.charging.action.BaseAction;
import com.holley.charging.common.util.ChargeInfo;
import com.holley.charging.common.util.JobInitBase;
import com.holley.charging.common.util.LocalCacheUtil;
import com.holley.charging.common.util.ShareChargeCache;
import com.holley.charging.model.bus.BusPayment;
import com.holley.charging.model.bus.BusPaymentExample;
import com.holley.charging.model.def.ChargingConfig;
import com.holley.charging.model.def.EquipAuthBase;
import com.holley.charging.model.def.EquipBusinessPolicyInfo;
import com.holley.charging.model.def.EquipChargeStatusBase;
import com.holley.charging.model.def.OperatorSecretKeyBase;
import com.holley.charging.model.def.StartChargeBase;
import com.holley.charging.model.def.StopChargeBase;
import com.holley.charging.model.pob.PobChargingPile;
import com.holley.charging.service.share.CommonService;
import com.holley.common.constants.Globals;
import com.holley.common.constants.ResultBean;
import com.holley.common.constants.charge.ChargeModeEnum;
import com.holley.common.constants.charge.ChargeStepEnum;
import com.holley.common.constants.charge.PileStatusEnum;
import com.holley.common.constants.share.ConnectorStatusTypeEnum;
import com.holley.common.constants.share.EquipAuthFailReasonTypeEnum;
import com.holley.common.constants.share.FailReasonTypeEnum;
import com.holley.common.constants.share.QueryEquipBusinessPolicyFailReasonTypeEnum;
import com.holley.common.constants.share.QueryStartChargeFailReasonTypeEnum;
import com.holley.common.constants.share.QueryStopChargeFailReasonTypeEnum;
import com.holley.common.constants.share.StartChargeSeqStatEnum;
import com.holley.common.constants.share.SuccStatTypeEnum;
import com.holley.common.dataobject.PileStatusBean;
import com.holley.common.jms.MessageSendService;
import com.holley.common.rocketmq.charging.MsgChargeStart;
import com.holley.common.rocketmq.charging.MsgChargeStop;
import com.holley.common.util.DateUtil;
import com.holley.platform.model.sys.SysSecretKey;

/**
 * 共享信息
 * 
 * @author sc
 */
public class ServiceAction extends BaseAction {

    @Resource
    private CommonService      commonService;
    private ResultBean         resultBean = new ResultBean(new Date());
    @Resource
    private MessageSendService messageSendService;
    @Resource
    private JobInitBase        jobInitBase;
    @Resource
    private LocalCacheUtil     localCacheUtil;

    /**
     * 请求token
     * 
     * @return
     * @throws Exception
     */
    public String queryToken() throws Exception {
        // TEST START
        // String tradeno = DateUtil.DateToLong14Str(new Date()) + StringUtil.zeroPadString("129", 18);
        // Globals.SESSION_USERID_MAP.put("tradeno", tradeno);
        // MsgChargeStart startMsg = new MsgChargeStart(129, null, "13777862839",
        // ChargeModeEnum.BY_TIME.getShortValue().byteValue(), 60, tradeno);
        // MsgChargeStop stopMsg = new MsgChargeStop(129, null, "13777862839",
        // Globals.SESSION_USERID_MAP.get("tradeno"));
        // System.out.println("tradeno>>" + Globals.SESSION_USERID_MAP.get("tradeno"));
        // messageSendService.sendTopic(startMsg);// 发送消息通知前置启动充电
        // TEST END
        JSONObject jobj = readerLine();
        String operatorID = getDataStringForJsonObj(jobj, "OperatorID");
        OperatorSecretKeyBase secretKey = new OperatorSecretKeyBase();
        secretKey.setOperatorID(ChargingConfig.getDomainOperatorId());
        resultBean.setOperatorID(operatorID);

        SysSecretKey sk = localCacheUtil.getSecretKeyByOperatorID(operatorID);
        if (sk == null) {// 无此运营商
            secretKey.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            secretKey.setFailReason(FailReasonTypeEnum.UNKNOWN_OPERATOR.getValue());
            secretKey.setOperatorID(operatorID);
            resultBean.setData(secretKey);
            return SUCCESS;
        }
        if (!sk.getOperatorsecret().equals(getDecodeData(jobj.getString("Data"), sk).getString("OperatorSecret"))) {
            secretKey.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            secretKey.setFailReason(FailReasonTypeEnum.ERROR_SECRET_KEY.getValue());
            secretKey.setOperatorID(operatorID);
            resultBean.setData(secretKey);
            return SUCCESS;
        }
        String token = returnOperatorToken(operatorID);
        secretKey.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
        secretKey.setFailReason(FailReasonTypeEnum.NIL.getValue());
        secretKey.setTokenAvailableTime(Globals.TOKEN_AVAILABLE_TIME);
        secretKey.setAccessToken(token != null ? token : saveOperatorToken(operatorID));
        resultBean.setData(secretKey);
        return SUCCESS;
    }

    /**
     * 请求设备认证
     * 
     * @return
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public String queryEquipAuth() throws Exception {
        EquipAuthBase auth = new EquipAuthBase();
        JSONObject obj = readerLine();
        String operatorID = getDataStringForJsonObj(obj, "OperatorID");
        resultBean.setOperatorID(operatorID);
        JSONObject obj2 = getDecodeData(obj.getString("Data"), localCacheUtil.getSecretKeyByOperatorID(operatorID));
        String equipAuthSeq = getDataStringForJsonObj(obj2, "EquipAuthSeq");// 设备认证流水号：运营商ID+yyyyMMddHHmmss+4位随机数
        String connectorID = getDataStringForJsonObj(obj2, "ConnectorID");// 设备code
        auth.setConnectorID(connectorID);
        auth.setEquipAuthSeq(equipAuthSeq);

        PobChargingPile pile = localCacheUtil.getPileByCode(connectorID);
        if (pile == null) {
            auth.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            auth.setFailReason(EquipAuthFailReasonTypeEnum.UNKNOWN_EQUIP.getValue());
            resultBean.setData(auth);
            return SUCCESS;
        }
        ChargeInfo chargeInfo = new ChargeInfo();
        chargeInfo.setConnectorID(connectorID);
        chargeInfo.setPileId(pile.getId());
        chargeInfo.setUpdateTime(new Date());
        jobInitBase.pushTask(chargeInfo, operatorID);
        PileStatusBean pileStatusBean = localCacheUtil.returnPileStatusBean(pile.getId());
        // TEST
        // pileStatusBean.setStatus(PileStatusEnum.BUSYING);
        // TEST
        if (pileStatusBean == null) {
            auth.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            auth.setFailReason(EquipAuthFailReasonTypeEnum.UNKNOWN_EQUIP.getValue());
            resultBean.setData(auth);
        } else if (PileStatusEnum.BUSYING != pileStatusBean.getStatus() && PileStatusEnum.FINISH != pileStatusBean.getStatus()) {
            auth.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            auth.setFailReason(EquipAuthFailReasonTypeEnum.UN_READY.getValue());
            resultBean.setData(auth);
        } else {
            auth.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
            auth.setFailReason(EquipAuthFailReasonTypeEnum.NIL.getValue());
            resultBean.setData(auth);
        }
        return SUCCESS;
    }

    /**
     * 查询业务策略信息结果
     * 
     * @return
     */
    public String queryEquipBusinessPolicy() throws Exception {
        JSONObject obj = readerLine();
        String operatorID = getDataStringForJsonObj(obj, "OperatorID");
        resultBean.setOperatorID(operatorID);
        JSONObject obj2 = getDecodeData(obj.getString("Data"), localCacheUtil.getSecretKeyByOperatorID(operatorID));
        String connectorID = getDataStringForJsonObj(obj2, "ConnectorID");// 充电设备接口编码
        String equipBizSeq = getDataStringForJsonObj(obj2, "EquipBizSeq");// 查询流水号
        // QueryEquipBusinessPolicyFailReasonTypeEnum
        EquipBusinessPolicyInfo rs = new EquipBusinessPolicyInfo();
        rs.setConnectorID(connectorID);
        rs.setEquipBizSeq(equipBizSeq);
        rs.setFailReason(QueryEquipBusinessPolicyFailReasonTypeEnum.UNKNOWN_POLICY.getValue());
        rs.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
        resultBean.setData(rs);

        return SUCCESS;
    }

    /**
     * 请求启动充电
     * 
     * @return
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public String queryStartCharge() throws Exception {
        JSONObject obj = readerLine();
        String operatorID = getDataStringForJsonObj(obj, "OperatorID");
        resultBean.setOperatorID(operatorID);
        JSONObject obj2 = getDecodeData(obj.getString("Data"), localCacheUtil.getSecretKeyByOperatorID(operatorID));
        String startChargeSeq = getDataStringForJsonObj(obj2, "StartChargeSeq");// 充电订单号
        String connectorID = getDataStringForJsonObj(obj2, "ConnectorID");// 充电设备接口编码
        String qRCode = getDataStringForJsonObj(obj2, "QRCode");// 二维码信息
        StartChargeBase startChargeBase = new StartChargeBase();
        startChargeBase.setConnectorID(connectorID);
        startChargeBase.setStartChargeSeq(startChargeSeq);

        PobChargingPile pile = localCacheUtil.getPileByCode(connectorID);
        if (pile == null) {
            startChargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            startChargeBase.setFailReason(QueryStartChargeFailReasonTypeEnum.UNKNOWN_EQUIP.getValue());
            resultBean.setData(startChargeBase);
            return SUCCESS;
        }

        PileStatusBean pileStatusBean = localCacheUtil.returnPileStatusBean(pile.getId());
        // TEST
        // pileStatusBean.setStatus(PileStatusEnum.BUSYING);
        // TEST
        if (pileStatusBean == null) {
            startChargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            startChargeBase.setFailReason(QueryStartChargeFailReasonTypeEnum.UNKNOWN_EQUIP.getValue());
            resultBean.setData(startChargeBase);
            return SUCCESS;
        } else if (pileStatusBean.getStatus() == PileStatusEnum.OFFLINE) {// 离线
            startChargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            startChargeBase.setFailReason(QueryStartChargeFailReasonTypeEnum.EQUIP_UNLINE.getValue());
            resultBean.setData(startChargeBase);
            return SUCCESS;
        } else if (pileStatusBean.getStatus() == PileStatusEnum.BUSYING || pileStatusBean.getStatus() == PileStatusEnum.FINISH) {
            startChargeBase.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
            startChargeBase.setFailReason(QueryStartChargeFailReasonTypeEnum.NIL.getValue());
            startChargeBase.setStartChargeSeqStat(StartChargeSeqStatEnum.STRTING.getValue());
            resultBean.setData(startChargeBase);

            // 放入启动任务队列
            ChargeInfo cinfo = new ChargeInfo();
            cinfo.setConnectorID(pile.getPileCode());
            cinfo.setPileId(pile.getId());
            cinfo.setTradeNo(startChargeSeq);
            cinfo.setUpdateTime(new Date());
            // ShareChargeCache.addOrUpdateStartChargeInfo(cinfo);// 启动信息放入缓存队列old
            // 发送消息给前置
            MsgChargeStart startMsg = new MsgChargeStart(pile.getId(), null, ChargingConfig.getChargingPhone(operatorID), ChargeModeEnum.BY_AUTO.getShortValue().byteValue(), 0,
                                                         getLocalStartChargeSeq(startChargeSeq));
            messageSendService.sendTopic(startMsg);// 发送消息通知前置启动充电
            ShareChargeCache.addOrUpdateChargeInfo(cinfo, operatorID);
            jobInitBase.pushChargeJob(cinfo, operatorID);
            return SUCCESS;
        } else {
            startChargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            resultBean.setData(startChargeBase);
            return SUCCESS;
        }
    }

    /**
     * 推送请求充电结果
     * 
     * @return
     */
    public String notificationStartChargeResult() {
        return SUCCESS;
    }

    /**
     * 查询充电状态
     * 
     * @return
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public String queryEquipChargeStatus() throws Exception {
        JSONObject obj = readerLine();
        String operatorID = getDataStringForJsonObj(obj, "OperatorID");
        resultBean.setOperatorID(operatorID);
        JSONObject obj2 = getDecodeData(obj.getString("Data"), localCacheUtil.getSecretKeyByOperatorID(operatorID));
        String startChargeSeq = getDataStringForJsonObj(obj2, "StartChargeSeq");// 充电订单号
        BusPaymentExample emp = new BusPaymentExample();
        BusPaymentExample.Criteria cr = emp.createCriteria();
        cr.andTradeNoEqualTo(startChargeSeq);
        List<BusPayment> list = this.commonService.queryPaymentByExample(emp);

        // StartChargeSeqStatEnum
        EquipChargeStatusBase equipChargeStatus = new EquipChargeStatusBase();
        if (list == null || list.isEmpty()) {
            equipChargeStatus.setStartChargeSeqStat(StartChargeSeqStatEnum.UNKNOWN.getValue());
            resultBean.setData(equipChargeStatus);
            return SUCCESS;
        }
        BusPayment payment = list.get(0);
        PileStatusBean pileStatusBean = this.localCacheUtil.returnPileStatusBean(payment.getPileId());
        equipChargeStatus.setConnectorID(pileStatusBean != null ? pileStatusBean.getPilecode() : null);
        if (payment.getEndTime() != null) {
            equipChargeStatus.setStartChargeSeqStat(StartChargeSeqStatEnum.END.getValue());
            equipChargeStatus.setTotalMoney(payment.getShouldMoney() != null ? payment.getShouldMoney().doubleValue() : 0.0);
            equipChargeStatus.setTotalPower(payment.getChaPower());
            equipChargeStatus.setElecMoney(payment.getChaFee() != null ? payment.getChaFee().doubleValue() : 0.0);
            equipChargeStatus.setStartTime(DateUtil.DateToLongStr(payment.getStartTime()));
            equipChargeStatus.setEndTime(DateUtil.DateToLongStr(payment.getEndTime()));
            equipChargeStatus.setSeviceMoney(payment.getServiceFee() != null ? payment.getServiceFee().doubleValue() : 0.0);
            resultBean.setData(equipChargeStatus);
            return SUCCESS;
        }
        if (startChargeSeq.equals(pileStatusBean.getTradeno())) {
            ConnectorStatusTypeEnum cstatus = this.localCacheUtil.returnPileStatus(pileStatusBean.getStatus());
            if (cstatus == ConnectorStatusTypeEnum.CHARGING) {
                equipChargeStatus.setStartChargeSeqStat(StartChargeSeqStatEnum.CHARGING.getValue());
            } else {
                equipChargeStatus.setStartChargeSeqStat(StartChargeSeqStatEnum.UNKNOWN.getValue());
            }
            equipChargeStatus.setConnectorStatus(cstatus.getValue());
            equipChargeStatus.setElecMoney(pileStatusBean.getMoney().doubleValue());
            equipChargeStatus.setEndTime(DateUtil.DateToLongStr(pileStatusBean.getUpdatetime()));
            equipChargeStatus.setSoc(pileStatusBean.getSoc());
            equipChargeStatus.setStartChargeSeq(pileStatusBean.getTradeno());
            equipChargeStatus.setStartTime(DateUtil.DateToLongStr(pileStatusBean.getStarttime()));
            equipChargeStatus.setTotalMoney(pileStatusBean.getMoney().doubleValue());// 总金额包含充电费？服务费？
            equipChargeStatus.setTotalPower(pileStatusBean.getChapower());
            equipChargeStatus.setCurrentA(NumberUtils.toDouble(pileStatusBean.getOuti()));
            equipChargeStatus.setVoltageA(NumberUtils.toDouble(pileStatusBean.getOutv()));
            // equipChargeStatus.setSeviceMoney(seviceMoney);//服务费前置没有设置此参数
        }
        resultBean.setData(equipChargeStatus);
        return SUCCESS;
    }

    /**
     * 推送充电状态
     * 
     * @return
     */
    public String notificationEquipChargeStatus() {
        return SUCCESS;
    }

    /**
     * 请求停止充电
     * 
     * @return
     * @throws Exception
     */
    public String queryStopCharge() throws Exception {
        JSONObject obj = readerLine();
        String operatorID = getDataStringForJsonObj(obj, "OperatorID");
        resultBean.setOperatorID(operatorID);
        JSONObject obj2 = getDecodeData(obj.getString("Data"), localCacheUtil.getSecretKeyByOperatorID(operatorID));
        String startChargeSeq = getDataStringForJsonObj(obj2, "StartChargeSeq");// 充电订单号
        String connectorID = getDataStringForJsonObj(obj2, "ConnectorID");// 充电设备接口编码
        StopChargeBase stopChargeBase = new StopChargeBase();
        stopChargeBase.setStartChargeSeq(startChargeSeq);
        String localStartChargeSeq = getLocalStartChargeSeq(startChargeSeq);

        PobChargingPile pile = localCacheUtil.getPileByCode(connectorID);
        if (pile == null) {
            stopChargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            stopChargeBase.setFailReason(QueryStopChargeFailReasonTypeEnum.UNKNOWN_EQUIP.getValue());
            stopChargeBase.setStartChargeSeqStat(StartChargeSeqStatEnum.UNKNOWN.getValue());
            resultBean.setData(stopChargeBase);
            return SUCCESS;
        }

        PileStatusBean pileStatusBean = localCacheUtil.returnPileStatusBean(pile.getId());

        // DcsChargerecordExample dcsChargerecordEmp = new DcsChargerecordExample();
        // DcsChargerecordExample.Criteria dcsChargerecordCr = dcsChargerecordEmp.createCriteria();
        // dcsChargerecordCr.andTradeNoEqualTo(localStartChargeSeq);
        //
        // List<DcsChargerecord> dcsChargerecords = commonService.queryDcsChargerecordByExample(dcsChargerecordEmp);
        // DcsChargerecord dcsChargerecord = null;

        // if (dcsChargerecords != null && dcsChargerecords.size() > 0) {
        // dcsChargerecord = dcsChargerecords.get(0);
        // }
        // if (dcsChargerecord == null) {
        // stopChargeBase.setStartChargeSeqStat(StartChargeSeqStatEnum.UNKNOWN.getValue());
        // } else if (dcsChargerecord.getEndTime() != null) {
        // stopChargeBase.setStartChargeSeqStat(StartChargeSeqStatEnum.END.getValue());
        // } else if (startChargeSeq.equals(pileStatusBean.getTradeno()) && pileStatusBean.getStatus() ==
        // PileStatusEnum.CHARGING) {
        // stopChargeBase.setStartChargeSeqStat(StartChargeSeqStatEnum.CHARGING.getValue());
        // }

        // 未知设备
        if (pileStatusBean == null) {
            stopChargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            stopChargeBase.setFailReason(QueryStopChargeFailReasonTypeEnum.UNKNOWN_EQUIP.getValue());
            stopChargeBase.setStartChargeSeqStat(StartChargeSeqStatEnum.UNKNOWN.getValue());
            resultBean.setData(stopChargeBase);
            return SUCCESS;
        }
        // 设备离线
        if (pileStatusBean.getStatus() == PileStatusEnum.OFFLINE) {
            stopChargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            stopChargeBase.setFailReason(QueryStopChargeFailReasonTypeEnum.EQUIP_UNLINE.getValue());
            stopChargeBase.setStartChargeSeqStat(StartChargeSeqStatEnum.UNKNOWN.getValue());
            resultBean.setData(stopChargeBase);
            return SUCCESS;
        }
        // 设备不在充电
        if (pileStatusBean.getStatus() != PileStatusEnum.CHARGING && localStartChargeSeq.equals(pileStatusBean.getTradeno())) {
            // 放入停止任务队列
            ChargeInfo cinfo = new ChargeInfo();
            cinfo.setConnectorID(pile.getPileCode());
            cinfo.setPileId(pile.getId());
            cinfo.setTradeNo(startChargeSeq);
            cinfo.setUpdateTime(new Date());
            cinfo.setStep(ChargeStepEnum.STOP);
            jobInitBase.pushChargeJob(cinfo, operatorID);
            // ShareChargeCache.addOrUpdateStopChargeInfo(cinfo);// 停止信息放入缓存队列
            stopChargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
            stopChargeBase.setFailReason(QueryStopChargeFailReasonTypeEnum.UN_CHARGE.getValue());
            stopChargeBase.setStartChargeSeqStat(StartChargeSeqStatEnum.END.getValue());
            resultBean.setData(stopChargeBase);
            return SUCCESS;
        }
        if (pileStatusBean.getStatus() == PileStatusEnum.CHARGING && localStartChargeSeq.equals(pileStatusBean.getTradeno())) {
            stopChargeBase.setSuccStat(SuccStatTypeEnum.SUCCESS.getValue());
            stopChargeBase.setFailReason(QueryStopChargeFailReasonTypeEnum.NIL.getValue());
            stopChargeBase.setStartChargeSeqStat(StartChargeSeqStatEnum.STOPING.getValue());
            resultBean.setData(stopChargeBase);
            // 放入停止任务队列
            ChargeInfo cinfo = new ChargeInfo();
            cinfo.setConnectorID(pile.getPileCode());
            cinfo.setPileId(pile.getId());
            cinfo.setTradeNo(startChargeSeq);
            cinfo.setUpdateTime(new Date());
            cinfo.setStep(ChargeStepEnum.STOP);
            // ShareChargeCache.addOrUpdateStopChargeInfo(cinfo);// 停止信息放入缓存队列
            // 发送停止充电信息给前置
            MsgChargeStop stopMsg = new MsgChargeStop(pile.getId(), null, ChargingConfig.getChargingPhone(operatorID), getLocalStartChargeSeq(startChargeSeq));
            messageSendService.sendTopic(stopMsg);// 发送消息通知前置停止充电
            this.jobInitBase.pushChargeJob(cinfo, operatorID);
            return SUCCESS;
        }
        stopChargeBase.setSuccStat(SuccStatTypeEnum.FAIL.getValue());
        stopChargeBase.setFailReason(QueryStopChargeFailReasonTypeEnum.UN_CHARGE.getValue());
        stopChargeBase.setStartChargeSeqStat(StartChargeSeqStatEnum.UNKNOWN.getValue());
        resultBean.setData(stopChargeBase);
        return SUCCESS;
    }

    /**
     * 推送停止充电结果
     * 
     * @return
     */
    public String notificationStopChargeResult() {
        return SUCCESS;
    }

    /**
     * 推送充电订单信息
     * 
     * @return
     */
    public String notificationChargeOrderInfo() {
        return SUCCESS;
    }

    /**
     * 推送订单对账结果信息
     * 
     * @return
     */
    public String checkChargeOrders() {
        return SUCCESS;
    }

    public ResultBean getResultBean() {
        return resultBean;
    }

}
