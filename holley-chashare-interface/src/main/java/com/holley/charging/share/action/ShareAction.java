package com.holley.charging.share.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

import com.holley.charging.action.BaseAction;
import com.holley.charging.common.util.ShareUtil;
import com.holley.charging.model.bus.BusChargeRule;
import com.holley.charging.model.bus.BusPayment;
import com.holley.charging.model.bus.BusPaymentExample;
import com.holley.charging.model.bus.BusPileModel;
import com.holley.charging.model.def.ConnectorInfo;
import com.holley.charging.model.def.ConnectorStatsInfo;
import com.holley.charging.model.def.ConnectorStatusInfo;
import com.holley.charging.model.def.EquipmentInfo;
import com.holley.charging.model.def.EquipmentStatsInfo;
import com.holley.charging.model.def.StationInfo;
import com.holley.charging.model.def.StationInfoBase;
import com.holley.charging.model.def.StationStatsInfo;
import com.holley.charging.model.def.StationStatsInfoBase;
import com.holley.charging.model.def.StationStatusInfo;
import com.holley.charging.model.def.StationStatusInfoBase;
import com.holley.charging.model.pob.PobChargingPile;
import com.holley.charging.model.pob.PobChargingStation;
import com.holley.charging.service.share.CommonService;
import com.holley.charging.share.util.EchongwangUtil;
import com.holley.common.cache.charging.ChargingCacheUtil;
import com.holley.common.constants.Globals;
import com.holley.common.constants.ResultBean;
import com.holley.common.constants.charge.LinkTypeEnum;
import com.holley.common.constants.charge.PileStatusEnum;
import com.holley.common.constants.share.ConnectorStatusTypeEnum;
import com.holley.common.constants.share.RetTypeEnum;
import com.holley.common.dataobject.Page;
import com.holley.common.dataobject.PileStatusBean;
import com.holley.common.util.DateUtil;
import com.holley.common.util.NumberUtil;
import com.holley.common.util.StringUtil;
import com.holley.platform.util.CacheSysHolder;

/**
 * 业务服务接口
 * 
 * @author sc
 */
public class ShareAction extends BaseAction {

    private final static Logger logger     = Logger.getLogger(ShareAction.class);
    @Resource
    private CommonService       commonService;
    private ResultBean          resultBean = new ResultBean(new Date());

    /**
     * 查询充电站信息
     * 
     * @return
     * @throws IOException
     * @throws UnsupportedEncodingException
     */
    public String queryStationsInfo() throws Exception {
        JSONObject obj = readerLine();
        String operatorID = getDataStringForJsonObj(obj, "OperatorID");
        resultBean.setOperatorID(operatorID);
        JSONObject obj2 = getDecodeData(obj.getString("Data"), localCacheUtil.getSecretKeyByOperatorID(operatorID));
        int pageSize = getDataInt(obj2, "PageSize");
        int pageNo = getDataInt(obj2, "PageNo");// 页码
        String lastQueryTime = getDataStringForJsonObj(obj2, "LastQueryTime");

        Map<String, Object> param = new HashMap<String, Object>();
        Page page = this.returnPage(pageNo, pageSize);
        if (StringUtil.isNotEmpty(lastQueryTime)) {
            param.put("lastQueryTime", DateUtil.StrToDate(lastQueryTime, DateUtil.TIME_LONG));
        }
        param.put(Globals.PAGE, page);
        List<PobChargingStation> stations = commonService.queryStationInfoByPage(param);
        StationInfoBase data = new StationInfoBase();
        data.setItemSize(page.getTotalProperty());
        double tempItemSize = data.getItemSize();
        double tempLimit = page.getEndRow() - page.getStartRow();
        Double tempTotalPage = Math.ceil(tempItemSize / tempLimit);
        Double tempPageNo = page.getStartRow() / tempLimit + 1;
        data.setPageCount(tempTotalPage.intValue());
        data.setPageNo(tempPageNo.intValue());
        data.setStationInfos(wrapStationInfos(stations));
        resultBean.setData(data);
        return SUCCESS;
    }

    private List<StationInfo> wrapStationInfos(List<PobChargingStation> stations) {

        List<PobChargingPile> equipmentInfos = null;// 设备列表
        List<EquipmentInfo> equipmentInfosResult = null;// 设备列表封装结果
        List<StationInfo> stationInfos = new ArrayList<StationInfo>();
        StationInfo stationInfo = null;
        if (stations != null && stations.size() > 0) {
            for (PobChargingStation station : stations) {
                List<PobChargingPile> plist = this.localCacheUtil.getChargePileListByStationid(station.getId());
                stationInfo = new StationInfo();
                if (plist != null && plist.size() > 0) {
                    PobChargingPile p = plist.get(0);
                    BigDecimal servicefee = ShareUtil.returnBigDecimal(p.getServiceFee());
                    Integer feeRule = p.getFeeRule() == null ? 0 : p.getFeeRule();
                    BigDecimal parkfee = ShareUtil.returnBigDecimal(p.getParkFee());
                    BigDecimal onlyChargeFee = ShareUtil.returnBigDecimal(p.getChargeFee());
                    if (feeRule > 0) {
                        BusChargeRule feerule = localCacheUtil.getChargeFeeRuleById(feeRule);
                        if (feerule != null) {
                            stationInfo.setElectricityFee("尖：" + feerule.getJianFee() + "峰：" + feerule.getFengFee() + "平：" + feerule.getPingFee() + "谷：" + feerule.getGuFee());
                        }
                    } else if (feeRule == 0) {
                        stationInfo.setElectricityFee(onlyChargeFee.toString());
                    }

                    stationInfo.setServiceFee(servicefee.toString());
                    stationInfo.setParkFee("免费");
                }
                stationInfo.setAddress(station.getAddress());
                stationInfo.setStationID(EchongwangUtil.wrapStationId(station.getId()));// 设置充电站编码不同的充电站运营商对应不同的站ID规则
                stationInfo.setEquipmentOwnerID(station.getBusMec().toString());
                stationInfo.setOperationID(station.getBusMec().toString());
                stationInfo.setRemark(station.getRemark());
                stationInfo.setServiceTel(station.getLinkPhone());
                stationInfo.setStationTel(station.getLinkPhone());
                stationInfo.setStationLat(station.getLat());
                stationInfo.setStationLng(station.getLng());
                stationInfo.setStationName(station.getStationName());
                stationInfo.setBusineHours(CacheSysHolder.getSysLinkName(LinkTypeEnum.OPEN_TIME.getValue(), station.getOpenTime().toString()));

                // equipmentInfos = commonService.queryEquipmentInfoByStationId(station.getId());
                equipmentInfos = localCacheUtil.queryEquipmentInfoByStationId(station.getId());
                equipmentInfosResult = wrapEquipmentInfos(equipmentInfos);
                stationInfo.setEquipmentInfos(equipmentInfosResult);
                stationInfos.add(stationInfo);
            }
        }

        return stationInfos;
    }

    private List<EquipmentInfo> wrapEquipmentInfos(List<PobChargingPile> equipmentInfos) {
        List<EquipmentInfo> eInfos = new ArrayList<EquipmentInfo>();
        EquipmentInfo eInfo = null;
        if (equipmentInfos != null && equipmentInfos.size() > 0) {
            for (PobChargingPile e : equipmentInfos) {
                BusPileModel model = localCacheUtil.getChargeModelById(e.getPileModel());
                eInfo = new EquipmentInfo();
                eInfo.setEquipmentID(e.getComAddr());
                eInfo.setEquipmentName(e.getEquipmentName());
                eInfo.setEquipmentType(e.getEquipmentType());
                eInfo.setEquipmentModel(model.getBrand());
                eInfo.setPower(model.getRatP());
                eInfo.setProductionDate(e.getProductionDate());
                // eInfo.setConnectorInfos(wrapConnectorInfos(commonService.queryConnectorInfoByComAddr(e.getComAddr())));
                eInfo.setConnectorInfos(wrapConnectorInfos(localCacheUtil.queryConnectorInfoByComAddrAndStationId(e.getComAddr(), e.getStationId())));
                eInfos.add(eInfo);
            }
        }
        return eInfos;
    }

    private List<ConnectorInfo> wrapConnectorInfos(List<PobChargingPile> connectorInfos) {
        List<ConnectorInfo> cInfos = new ArrayList<ConnectorInfo>();
        ConnectorInfo cInfo = null;
        if (connectorInfos != null && connectorInfos.size() > 0) {
            for (PobChargingPile c : connectorInfos) {
                cInfo = new ConnectorInfo();
                cInfo.setConnectorID(c.getPileCode());
                cInfo.setConnectorName(c.getPileName());
                cInfos.add(cInfo);
            }
        }
        return cInfos;
    }

    /**
     * 设备状态变化推送 暂留
     * 
     * @return
     * @throws Exception
     */
    public String notificationStationStatus() throws Exception {
        // RedisUtil.delKey(Globals.KEY_PUSH_TOKEN + "348375727");// 删除刷新token
        // HttpRequestUtil.queryToken("348375727");
        // RedisUtil.delKey(Globals.KEY_PUSH_TOKEN + "348375727");
        // String t = HttpRequestUtil.queryToken("348375727");
        // logger.info("刷新推送token：" + t);
        // messageSendProducer.sendTopic(r);
        // RedisUtil.delKey(Globals.KEY_PUSH_TOKEN + "348375727");
        // logger.info("token:" + HttpRequestUtil.queryToken("348375727"));
        // ConnectorStatusInfo cinfo = new ConnectorStatusInfo();
        // cinfo.setConnectorID("201705240000000101");
        // cinfo.setStatus(ConnectorStatusTypeEnum.OFF_LINE.getValue());
        // cinfo.setLockStatus(0);
        // cinfo.setParkStatus(0);
        //
        // Map<String, Object> param = new HashMap<String, Object>();
        //
        // param.put("ConnectorStatusInfo", cinfo);
        //
        // String token = HttpRequestUtil.queryToken();
        // String OperatorID = "chuangrui";
        // String OperatorSecret = "qu31xLHf8PoZ9xro";
        //
        // ResultBean rs = new ResultBean(new Date());
        // Map<String, Object> data = new HashMap<String, Object>();
        // data.put("OperatorID", "chuangrui");
        // data.put("Ret", rs.getRet());
        // data.put("TimeStamp", rs.getTimeStamp());
        // data.put("Seq", rs.getSeq());
        //
        // if (StringUtil.isNotEmpty(token)) {
        // JSONObject jsonobj = HttpRequestUtil.httpTest("notification_stationStatus", param, data, token);
        // System.out.println(jsonobj.getString("Msg"));
        // }
        return SUCCESS;
    }

    /**
     * 设备接口状态查询
     * 
     * @return
     * @throws Exception
     */
    public String queryStationStatus() throws Exception {
        // String stationIDsStr = getStrAttribute("stationIDs");
        // String stationIDsStr = getParameter("StationIDs");
        // String operatorID = getParameter("OperatorID");// 运营商id

        JSONObject obj = readerLine();
        String operatorID = getDataStringForJsonObj(obj, "OperatorID");
        resultBean.setOperatorID(operatorID);
        JSONObject obj2 = getDecodeData(obj.getString("Data"), localCacheUtil.getSecretKeyByOperatorID(operatorID));
        JSONArray stationIDs = obj2.containsKey("StationIDs") ? obj2.getJSONArray("StationIDs") : null;

        if (stationIDs == null && stationIDs.size() == 0) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }

        String[] stationIDsStr = new String[stationIDs.size()];
        for (int x = 0; x < stationIDsStr.length; x++) {
            stationIDsStr[x] = EchongwangUtil.crateStationId(stationIDs.getString(x)).toString();
        }
        System.out.println("stationIDsStr:" + Arrays.asList(stationIDsStr));
        // if (stationIDsStr.contains("[")) {
        // stationIDsStr = stationIDsStr.replace("[", "").replace("]", "");
        //
        // }
        // stationIDsStr = "1,2,3";

        // String[] stationIDs = stationIDsStr.split(",");
        // for (int x = 0; x < stationIDsStr.length; x++) {
        // stationIDsStr[x] = EchongwangUtil.crateStationId(stationIDsStr[x]).toString();
        // }
        if (stationIDsStr.length > 50) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        List<StationStatusInfo> list = wrapStationStatusInfos(stationIDsStr);
        StationStatusInfoBase base = new StationStatusInfoBase();
        base.setTotal(stationIDsStr.length);
        base.setStationStatusInfos(list);
        resultBean.setData(base);
        return SUCCESS;
    }

    private List<StationStatusInfo> wrapStationStatusInfos(String[] stationIDs) {
        List<StationStatusInfo> stationStatusInfos = new ArrayList<StationStatusInfo>();
        StationStatusInfo stationInfos = null;
        for (String sId : stationIDs) {
            System.out.println("sId:" + sId);
            List<PobChargingPile> pList = localCacheUtil.getChargePileListByStationid(NumberUtils.toInt(sId));
            stationInfos = new StationStatusInfo();
            stationInfos.setStationID(sId);
            stationInfos.setConnectorStatusInfos(wrapConnectorStatusInfos(pList));
            stationStatusInfos.add(stationInfos);
        }
        return stationStatusInfos;
    }

    private List<ConnectorStatusInfo> wrapConnectorStatusInfos(List<PobChargingPile> pList) {
        List<ConnectorStatusInfo> connectorStatusInfos = new ArrayList<ConnectorStatusInfo>();
        ConnectorStatusInfo cStatusInfo = null;
        if (pList != null && pList.size() > 0) {
            for (PobChargingPile p : pList) {
                cStatusInfo = new ConnectorStatusInfo();
                cStatusInfo.setConnectorID(p.getPileCode());
                cStatusInfo.setStatus(checkConnectorStatus(p.getId()));
                connectorStatusInfos.add(cStatusInfo);
            }
        }
        return connectorStatusInfos;
    }

    private Integer checkConnectorStatus(Integer cId) {
        PileStatusBean sBean = ChargingCacheUtil.getPileStatusBean(cId);
        if (sBean == null || sBean.getStatus() == PileStatusEnum.OFFLINE) {
            return ConnectorStatusTypeEnum.OFF_LINE.getValue();
        } else if (sBean.getStatus() == PileStatusEnum.CHARGING) {
            return ConnectorStatusTypeEnum.CHARGING.getValue();
        } else if (sBean.getStatus() == PileStatusEnum.IDLE || sBean.getStatus() == PileStatusEnum.FINISH) {
            return ConnectorStatusTypeEnum.IDLE.getValue();
        } else if (sBean.getStatus() == PileStatusEnum.BUSYING) {
            return ConnectorStatusTypeEnum.UN_CHARGING.getValue();
        } else if (sBean.getStatus() == PileStatusEnum.FAULT) {
            return ConnectorStatusTypeEnum.FAULT.getValue();
        }
        return ConnectorStatusTypeEnum.OFF_LINE.getValue();
    }

    /**
     * 查询统计信息
     * 
     * @return
     * @throws Exception
     */
    public String queryStationStats() throws Exception {
        JSONObject obj = readerLine();
        String operatorID = getDataStringForJsonObj(obj, "OperatorID");
        resultBean.setOperatorID(operatorID);
        JSONObject obj2 = getDecodeData(obj.getString("Data"), localCacheUtil.getSecretKeyByOperatorID(operatorID));
        String startTime = getDataStringForJsonObj(obj2, "StartTime");
        String endTime = getDataStringForJsonObj(obj2, "EndTime");
        String stationIDstr = getDataStringForJsonObj(obj2, "StationID");
        int stationID = EchongwangUtil.crateStationId(stationIDstr);
        // stationID = 1;
        // startTime = "2016-12-16";
        // endTime = "2016-12-17";
        // operatorID = "123456789";
        if (stationID <= 0 || StringUtil.isEmpty(startTime) || StringUtil.isEmpty(endTime)) {
            resultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        Date startDate = DateUtil.StrToDate(startTime, DateUtil.TIME_SHORT);
        Date endDate = DateUtil.StrToDate(endTime, DateUtil.TIME_SHORT);
        BusPaymentExample emp = new BusPaymentExample();
        BusPaymentExample.Criteria cr = emp.createCriteria();
        cr.andUpdateTimeGreaterThanOrEqualTo(startDate);
        cr.andUpdateTimeLessThanOrEqualTo(endDate);
        cr.andPileIdIn(localCacheUtil.getChargePileIdListByStationid(stationID));
        List<BusPayment> payments = this.commonService.queryPaymentByExample(emp);
        StationStatsInfo stationStatsInfo = wrapStationStatsInfo(payments, startTime, endTime, stationID);
        StationStatsInfoBase stationStatsInfoBase = new StationStatsInfoBase();
        stationStatsInfoBase.setStationStats(stationStatsInfo);
        this.resultBean.setData(stationStatsInfoBase);
        return SUCCESS;
    }

    /**
     * 封装充电站统计信息
     * 
     * @param payments
     * @param connectors
     * @return
     */
    private StationStatsInfo wrapStationStatsInfo(List<BusPayment> payments, String startTime, String endTime, Integer stationID) {
        List<PobChargingPile> list = localCacheUtil.getChargePileListByStationid(stationID);
        StationStatsInfo sStatsInfo = new StationStatsInfo();
        sStatsInfo.setStartTime(startTime);
        sStatsInfo.setEndTime(endTime);
        sStatsInfo.setStationID(stationID.toString());
        sStatsInfo.setStationElectricity(countAllPower(payments));
        sStatsInfo.setEquipmentStatsInfos(wrapEquipmentStatsInfo(stationID, payments));
        return sStatsInfo;
    }

    private String countAllPower(List<BusPayment> payments) {
        Double power = new Double(0);
        Double temp;
        if (payments != null && payments.size() > 0) {
            for (BusPayment pay : payments) {
                temp = pay.getChaPower();
                temp = temp != null ? temp : 0;
                power += temp;
            }
        }
        return NumberUtil.get4Out5In(power.toString()).toString();
    }

    /**
     * 封装设备统计信息
     * 
     * @param stationID
     * @return
     */
    private List<EquipmentStatsInfo> wrapEquipmentStatsInfo(Integer stationID, List<BusPayment> payments) {
        List<EquipmentStatsInfo> eStatsInfos = new ArrayList<EquipmentStatsInfo>();
        EquipmentStatsInfo eStatsInfo = null;
        Map<String, List<Integer>> map = localCacheUtil.getEquipmentIdListByStationId(stationID);
        Map<String, List<PobChargingPile>> map2 = localCacheUtil.getEquipmentListByStationId(stationID);
        for (String comAddr : map.keySet()) {
            eStatsInfo = new EquipmentStatsInfo();
            eStatsInfo.setEquipmentElectricity(countPowerByEquipmentId(payments, map.get(comAddr)));
            eStatsInfo.setEquipmentID(comAddr);
            eStatsInfo.setConnectorStatsInfos(wrapConnectorStatsInfo(payments, map2.get(comAddr)));
            eStatsInfos.add(eStatsInfo);
        }
        return eStatsInfos;
    }

    private String countPowerByEquipmentId(List<BusPayment> payments, List<Integer> cons) {
        Double power = new Double(0);
        Double temp;
        if (payments != null && payments.size() > 0) {
            for (BusPayment pay : payments) {
                if (cons.contains(pay.getPileId())) {
                    temp = pay.getChaPower();
                    temp = temp != null ? temp : 0;
                    power += temp;
                }
            }
        }
        return NumberUtil.get4Out5In(power.toString()).toString();
    }

    /**
     * 封装接口统计信息
     * 
     * @param stationID
     * @return
     */
    private List<ConnectorStatsInfo> wrapConnectorStatsInfo(List<BusPayment> payments, List<PobChargingPile> cons) {
        List<ConnectorStatsInfo> cStatsInfos = new ArrayList<ConnectorStatsInfo>();
        ConnectorStatsInfo cStatsInfo = null;
        for (PobChargingPile c : cons) {
            cStatsInfo = new ConnectorStatsInfo();
            cStatsInfo.setConnectorID(c.getPileCode());
            cStatsInfo.setConnectorElectricity(countPowerByConnectorId(payments, c.getId()));
            cStatsInfos.add(cStatsInfo);
        }
        return cStatsInfos;
    }

    private String countPowerByConnectorId(List<BusPayment> payments, Integer cId) {
        Double power = new Double(0);
        Double temp;
        if (payments != null && payments.size() > 0) {
            for (BusPayment pay : payments) {
                if (pay.getPileId().equals(cId)) {
                    temp = pay.getChaPower();
                    temp = temp != null ? temp : 0;
                    power += temp;
                }
            }
        }
        return NumberUtil.get4Out5In(power.toString()).toString();
    }

    public ResultBean getResultBean() {
        return resultBean;
    }

}
