package com.holley.charging.common.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.holley.charging.model.def.ChargingConfig;
import com.holley.charging.model.def.CheckChargeOrdersBase;
import com.holley.charging.model.def.ConnectorStatusInfo;
import com.holley.charging.model.def.EquipChargeStatusBase;
import com.holley.charging.model.def.NotificationChargeOrderInfoBase;
import com.holley.charging.model.def.NotificationStartChargeResultBase;
import com.holley.charging.model.def.NotificationStopChargeResultBase;
import com.holley.common.constants.QueryBean;
import com.holley.common.util.StringUtil;
import com.holley.platform.model.sys.SysSecretKey;

public class QueryActionUtil {

    private final static Logger logger = Logger.getLogger(QueryActionUtil.class);

    public static JSONObject notificationStationStatus(ConnectorStatusInfo cinfo, SysSecretKey sysSecretKey) throws Exception {
        synchronized (cinfo.getConnectorID()) {
            String token = queryToken(sysSecretKey);
            if (StringUtil.isNotEmpty(token)) {
                Map<String, Object> param = new HashMap<String, Object>();
                param.put("ConnectorStatusInfo", cinfo);
                QueryBean qb = new QueryBean(new Date());
                qb.setOperatorID(ChargingConfig.getDomainOperatorId());
                JSONObject jsonobj = HttpRequestUtil.httpTest(sysSecretKey.getOperatorid(), "notification_stationStatus", param, qb, token, sysSecretKey.getOperatorsecret(),
                                                              sysSecretKey.getDatasecret(), sysSecretKey.getDatasecretiv(), sysSecretKey.getSigsecret());
                logger.info("resultMsg:" + ShareUtil.getDataStr(jsonobj, "Msg"));
                return jsonobj;
            }
            return null;
        }
    }

    /**
     * 推送启动充电结果信息
     * 
     * @param cinfo
     * @return
     * @throws Exception
     */
    public static JSONObject notificationStartChargeResult(NotificationStartChargeResultBase startChargeResult, SysSecretKey sysSecretKey) throws Exception {
        String token = queryToken(sysSecretKey);
        if (StringUtil.isNotEmpty(token)) {
            synchronized (startChargeResult.getStartChargeSeq()) {
                QueryBean qb = new QueryBean(new Date());
                qb.setOperatorID(ChargingConfig.getDomainOperatorId());
                JSONObject jsonobj = HttpRequestUtil.httpTest(sysSecretKey.getOperatorid(), "notification_start_charge_result", startChargeResult, qb, token,
                                                              sysSecretKey.getOperatorsecret(), sysSecretKey.getDatasecret(), sysSecretKey.getDatasecretiv(),
                                                              sysSecretKey.getSigsecret());
                logger.info("resultMsg:" + ShareUtil.getDataStr(jsonobj, "Msg"));
                return jsonobj;
            }
        }
        return null;
    }

    /**
     * 推送停止充电结果信息
     * 
     * @param cinfo
     * @return
     * @throws Exception
     */
    public static JSONObject notificationStopChargeResult(NotificationStopChargeResultBase stopChargeResult, SysSecretKey sysSecretKey) throws Exception {
        String token = queryToken(sysSecretKey);
        if (StringUtil.isNotEmpty(token)) {
            synchronized (stopChargeResult.getStartChargeSeq()) {
                QueryBean qb = new QueryBean(new Date());
                qb.setOperatorID(ChargingConfig.getDomainOperatorId());
                JSONObject jsonobj = HttpRequestUtil.httpTest(sysSecretKey.getOperatorid(), "notification_stop_charge_result", stopChargeResult, qb, token,
                                                              sysSecretKey.getOperatorsecret(), sysSecretKey.getDatasecret(), sysSecretKey.getDatasecretiv(),
                                                              sysSecretKey.getSigsecret());
                logger.info("resultMsg:" + ShareUtil.getDataStr(jsonobj, "Msg"));
                return jsonobj;
            }
        }
        return null;
    }

    /**
     * 推送充电信息
     * 
     * @param equipChargeStatusBase
     * @return
     * @throws Exception
     */
    public static JSONObject notificationEquipChargeStatus(EquipChargeStatusBase equipChargeStatusBase, SysSecretKey sysSecretKey) throws Exception {
        String token = queryToken(sysSecretKey);
        if (StringUtil.isNotEmpty(token)) {
            synchronized (equipChargeStatusBase.getStartChargeSeq()) {
                QueryBean qb = new QueryBean(new Date());
                qb.setOperatorID(ChargingConfig.getDomainOperatorId());
                JSONObject jsonobj = HttpRequestUtil.httpTest(sysSecretKey.getOperatorid(), "notification_equip_charge_status", equipChargeStatusBase, qb, token,
                                                              sysSecretKey.getOperatorsecret(), sysSecretKey.getDatasecret(), sysSecretKey.getDatasecretiv(),
                                                              sysSecretKey.getSigsecret());
                logger.info("resultMsg:" + ShareUtil.getDataStr(jsonobj, "Msg"));
                return jsonobj;
            }
        }
        return null;
    }

    /**
     * 推送充电订单信息
     * 
     * @param chargeOrderInfo
     * @return
     * @throws Exception
     */
    public static JSONObject notificationChargeOrderInfo(NotificationChargeOrderInfoBase chargeOrderInfo, SysSecretKey sysSecretKey) throws Exception {
        String token = queryToken(sysSecretKey);
        if (StringUtil.isNotEmpty(token)) {
            synchronized (chargeOrderInfo.getStartChargeSeq()) {
                QueryBean qb = new QueryBean(new Date());
                qb.setOperatorID(ChargingConfig.getDomainOperatorId());
                JSONObject jsonobj = HttpRequestUtil.httpTest(sysSecretKey.getOperatorid(), "notification_charge_order_info", chargeOrderInfo, qb, token,
                                                              sysSecretKey.getOperatorsecret(), sysSecretKey.getDatasecret(), sysSecretKey.getDatasecretiv(),
                                                              sysSecretKey.getSigsecret());
                logger.info("resultMsg:" + ShareUtil.getDataStr(jsonobj, "Msg"));
                return jsonobj;
            }
        }
        return null;
    }

    /**
     * 推送支付结果
     * 
     * @param notificationPayStatusInfoBase
     * @return
     */
    public static String notificationPayStatus(String params, String oid) {
        return HttpRequestUtil.sendPost(params, oid);
    }

    /**
     * 订单对账
     * 
     * @param checkBase
     * @param sysSecretKey
     * @return
     * @throws Exception
     */
    public static JSONObject checkChargeOrders(CheckChargeOrdersBase checkBase, SysSecretKey sysSecretKey) throws Exception {
        String token = queryToken(sysSecretKey);
        if (StringUtil.isNotEmpty(token)) {
            QueryBean qb = new QueryBean(new Date());
            qb.setOperatorID(ChargingConfig.getDomainOperatorId());
            JSONObject jsonobj = HttpRequestUtil.httpTest(sysSecretKey.getOperatorid(), "check_charge_orders", checkBase, qb, token, sysSecretKey.getOperatorsecret(),
                                                          sysSecretKey.getDatasecret(), sysSecretKey.getDatasecretiv(), sysSecretKey.getSigsecret());
            logger.info("resultMsg:" + ShareUtil.getDataStr(jsonobj, "Msg"));
            return jsonobj;
        }
        return null;
    }

    private synchronized static String queryToken(SysSecretKey sysSecretKey) throws Exception {
        return HttpRequestUtil.queryToken(sysSecretKey.getOperatorid(), sysSecretKey.getOperatorsecret(), sysSecretKey.getDatasecret(), sysSecretKey.getDatasecretiv(),
                                          sysSecretKey.getSigsecret());
    }

}
