package com.holley.charging.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

import com.holley.charging.model.bus.BusChargeRule;
import com.holley.charging.model.bus.BusPileModel;
import com.holley.charging.model.bus.BusPileModelExample;
import com.holley.charging.model.def.ChargingConfig;
import com.holley.charging.model.pob.PobChargingPile;
import com.holley.charging.model.pob.PobChargingPileExample;
import com.holley.charging.model.pob.PobChargingStation;
import com.holley.charging.model.pob.PobChargingStationExample;
import com.holley.charging.service.share.CommonService;
import com.holley.common.cache.RedisUtil;
import com.holley.common.cache.charging.CacheKeyProvide;
import com.holley.common.cache.charging.ChargingCacheUtil;
import com.holley.common.constants.charge.PileStatusEnum;
import com.holley.common.constants.share.ConnectorStatusTypeEnum;
import com.holley.common.dataobject.PileStatusBean;
import com.holley.common.util.ObjectUtil;
import com.holley.platform.model.sys.SysSecretKey;
import com.holley.platform.model.sys.SysSecretKeyExample;

public class LocalCacheUtil {

    private final static Logger                        logger           = Logger.getLogger(LocalCacheUtil.class);
    @Resource
    private CommonService                              commonService;
    private Map<Integer, PobChargingStation>           chargeStationMap = new HashMap<Integer, PobChargingStation>();
    private Date                                       stationUpdateTime;
    private Map<Integer, List<PobChargingPile>>        chargePileMap    = new HashMap<Integer, List<PobChargingPile>>();
    private Date                                       pileUpdateTime;
    private List<BusChargeRule>                        chargeRuleList   = new ArrayList<BusChargeRule>();
    private List<BusPileModel>                         pileModelList    = new ArrayList<BusPileModel>();
    private Date                                       pileModelUpdateTime;
    private Map<String, SysSecretKey>                  sysSecretKeyMap  = new HashMap<String, SysSecretKey>();
    private Date                                       secretKeyUpdateTime;
    private List<PobChargingPile>                      allpile          = new ArrayList<PobChargingPile>();
    private Date                                       refreshPileUpdateTime;

    private ConcurrentHashMap<String, PobChargingPile> pileList         = new ConcurrentHashMap<String, PobChargingPile>();

    public void init() {
        ChargingConfig.init();
        initChargeStation();
        initChargePile();
        initPileModel();
        initSecretKey();
        initChargeFeeRule();

    }

    private void initChargeFeeRule() {
        chargeRuleList = commonService.queryChargeRuleByExample(null);
    }

    public PobChargingPile getPileByCode(String pileCode) {
        if (pileList.containsKey(pileCode)) {
            return pileList.get(pileCode);
        } else {

            PobChargingPileExample emp = new PobChargingPileExample();
            PobChargingPileExample.Criteria cr = emp.createCriteria();
            cr.andPileCodeEqualTo(pileCode);
            // cr.andPileToTypeEqualTo(UseToTypeEnum.CAR.getShortValue());
            List<PobChargingPile> piles = commonService.queryPileByExample(emp);
            if (piles != null && !piles.isEmpty()) {
                PobChargingPile pile = piles.get(0);
                pileList.put(pile.getPileCode(), pile);
                ChargeInfo chargeInfo = new ChargeInfo();
                chargeInfo.setConnectorID(pile.getPileCode());
                chargeInfo.setPileId(pile.getId());
                chargeInfo.setUpdateTime(new Date());
                return pile;
            }
        }
        return null;
    }

    public BusChargeRule getChargeFeeRuleById(int id) {
        if (chargeRuleList != null && chargeRuleList.size() > 0) {
            for (BusChargeRule rule : chargeRuleList) {
                if (rule.getId() == id) {
                    return rule;
                }
            }
        }
        return null;
    }

    public void initSecretKey() {
        List<SysSecretKey> list = commonService.querySysSecretKeyByExample(null);
        Date tempDate = null;
        if (list != null && list.size() > 0) {
            for (SysSecretKey record : list) {
                sysSecretKeyMap.put(record.getOperatorid(), record);
                if (record.getTime() == null) continue;
                if (tempDate == null) {
                    tempDate = record.getTime();
                } else if (tempDate.compareTo(record.getTime()) < 0) {
                    tempDate = record.getTime();
                }
            }
        }
        if (tempDate == null) {
            stationUpdateTime = new Date();
        } else {
            stationUpdateTime = tempDate;
        }
    }

    public List<PobChargingPile> getAllPile() {
        return allpile;
    }

    public List<PobChargingPile> refreshPile() {
        Date updateTime = ChargingCacheUtil.getUpdateTime(CacheKeyProvide.KEY_PILE_UPDATETIME);
        if (refreshPileUpdateTime == null || updateTime == null) return null;
        if (refreshPileUpdateTime.getTime() < updateTime.getTime()) {
            PobChargingPileExample emp = new PobChargingPileExample();
            PobChargingPileExample.Criteria cr = emp.createCriteria();
            cr.andUpdateTimeGreaterThan(refreshPileUpdateTime);
            // cr.andPileToTypeEqualTo(UseToTypeEnum.CAR.getShortValue());
            List<PobChargingPile> list = commonService.queryPileByExample(emp);
            refreshPileUpdateTime = updateTime;
            return list;
        }
        return null;
    }

    /**
     * 充电站信息初始化
     */
    public void initChargeStation() {
        PobChargingStationExample emp = new PobChargingStationExample();
        PobChargingStationExample.Criteria cr = emp.createCriteria();
        // cr.andStationToTypeEqualTo(UseToTypeEnum.CAR.getShortValue());
        List<PobChargingStation> list = commonService.queryStationByExample(emp);
        Date tempDate = null;
        for (PobChargingStation record : list) {
            chargeStationMap.put(record.getId(), record);
            if (record.getUpdateTime() == null) continue;
            if (tempDate == null) {
                tempDate = record.getUpdateTime();
            } else if (tempDate.compareTo(record.getUpdateTime()) < 0) {
                tempDate = record.getUpdateTime();
            }
        }
        if (tempDate == null) {
            stationUpdateTime = new Date();
        } else {
            stationUpdateTime = tempDate;
        }
    }

    /**
     * 初始化充电桩数据
     */
    public void initChargePile() {
        PobChargingPileExample emp = new PobChargingPileExample();
        PobChargingPileExample.Criteria cr = emp.createCriteria();
        // cr.andPileToTypeEqualTo(UseToTypeEnum.CAR.getShortValue());
        allpile = commonService.queryPileByExample(emp);
        logger.info("allpile数量：" + allpile.size());
        Integer stationid;
        List<PobChargingPile> tempList;
        Date tempDate = null;
        for (PobChargingPile record : allpile) {
            pileList.put(record.getPileCode(), record);
            stationid = record.getStationId();
            if (chargePileMap.containsKey(stationid)) {
                tempList = chargePileMap.get(stationid);
                tempList.add(record);
            } else {
                tempList = new ArrayList<PobChargingPile>();
                tempList.add(record);
                chargePileMap.put(stationid, tempList);
            }
            if (record.getUpdateTime() == null) continue;
            if (tempDate == null) {
                tempDate = record.getUpdateTime();
            } else if (tempDate.compareTo(record.getUpdateTime()) < 0) {
                tempDate = record.getUpdateTime();
            }
        }
        if (tempDate == null) {
            pileUpdateTime = new Date();
            refreshPileUpdateTime = pileUpdateTime;
        } else {
            pileUpdateTime = tempDate;
            refreshPileUpdateTime = tempDate;
        }
    }

    /**
     * 初始化充电桩型号
     */
    public void initPileModel() {
        List<BusPileModel> list = commonService.queryChargeModelByExample(null);
        Date tempDate = null;
        for (BusPileModel record : list) {
            if (record.getUpdateTime() == null) continue;
            if (tempDate == null) {
                tempDate = record.getUpdateTime();
            } else if (tempDate.compareTo(record.getUpdateTime()) < 0) {
                tempDate = record.getUpdateTime();
            }
        }
        if (list != null && list.size() > 0) {
            pileModelList.addAll(list);
        }
        if (tempDate == null) {
            pileModelUpdateTime = new Date();
        } else {
            pileModelUpdateTime = tempDate;
        }
    }

    /**
     * 增量更新电桩型号缓存数据
     */
    public void reloadPileModel() {
        Date updateTime = ChargingCacheUtil.getUpdateTime(CacheKeyProvide.KEY_PILEMODEL_UPDATETIME);
        if (pileModelUpdateTime == null || updateTime == null) return;
        if (pileModelUpdateTime.getTime() < updateTime.getTime()) {
            BusPileModelExample emp = new BusPileModelExample();
            BusPileModelExample.Criteria cr = emp.createCriteria();
            cr.andUpdateTimeGreaterThan(pileModelUpdateTime);
            List<BusPileModel> list = commonService.queryChargeModelByExample(emp);
            boolean isExist = false;
            List<BusPileModel> tempList = new ArrayList<BusPileModel>();
            for (BusPileModel record : list) {
                isExist = false;
                for (BusPileModel pileModel : pileModelList) {
                    if (pileModel.getId().intValue() == record.getId().intValue()) {
                        ObjectUtil.copyProperty(record, pileModel);
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) tempList.add(record);
            }
            if (tempList.size() > 0) {
                pileModelList.addAll(tempList);
            }
            pileModelUpdateTime = updateTime;
        }

    }

    /**
     * 更新充电站缓存数据
     */
    public synchronized void reloadChargeStation() {
        Date updateTime = ChargingCacheUtil.getUpdateTime(CacheKeyProvide.KEY_STATION_UPDATETIME);
        if (stationUpdateTime == null || updateTime == null) return;
        if (stationUpdateTime.getTime() < updateTime.getTime()) {
            PobChargingStationExample emp = new PobChargingStationExample();
            PobChargingStationExample.Criteria cr = emp.createCriteria();
            cr.andUpdateTimeGreaterThan(stationUpdateTime);
            // cr.andStationToTypeEqualTo(UseToTypeEnum.CAR.getShortValue());
            List<PobChargingStation> list = commonService.queryStationByExample(emp);
            for (PobChargingStation record : list) {
                chargeStationMap.put(record.getId(), record);
            }
            stationUpdateTime = updateTime;
        }

    }

    /**
     * 更新充电桩缓存数据
     */
    public synchronized void reloadChargePile() {

        Date updateTime = ChargingCacheUtil.getUpdateTime(CacheKeyProvide.KEY_PILE_UPDATETIME);
        if (pileUpdateTime == null || updateTime == null) return;
        if (pileUpdateTime.getTime() < updateTime.getTime()) {
            PobChargingPileExample emp = new PobChargingPileExample();
            PobChargingPileExample.Criteria cr = emp.createCriteria();
            cr.andUpdateTimeGreaterThan(pileUpdateTime);
            // cr.andPileToTypeEqualTo(UseToTypeEnum.CAR.getShortValue());
            List<PobChargingPile> list = commonService.queryPileByExample(emp);
            List<PobChargingPile> tempList;
            boolean isExist = false;
            for (PobChargingPile record : list) {
                isExist = false;
                if (chargePileMap.containsKey(record.getStationId())) {
                    tempList = chargePileMap.get(record.getStationId());
                    for (PobChargingPile pile : tempList) {
                        if (pile.getId().intValue() == record.getId().intValue()) {
                            ObjectUtil.copyProperty(record, pile);
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist) tempList.add(record);
                } else {
                    tempList = new ArrayList<PobChargingPile>();
                    tempList.add(record);
                    chargePileMap.put(record.getStationId(), tempList);
                }
            }
            pileUpdateTime = updateTime;
        }

    }

    /**
     * 获取可显示充电点List
     */
    public List<PobChargingStation> getChargeStationList() {
        reloadChargeStation();
        if (chargeStationMap == null || chargeStationMap.size() == 0) return null;
        Collection<PobChargingStation> csCollection = chargeStationMap.values();
        List<PobChargingStation> list = new ArrayList<PobChargingStation>(csCollection);
        // int pileNum = 0;
        // for (PobChargingStation record : csCollection) {
        // pileNum = (record.getFastNum() == null ? 0 : record.getFastNum()) + (record.getSlowNum() == null ? 0 :
        // record.getSlowNum());
        // if (record.getIsShow().intValue() == WhetherEnum.YES.getValue() && pileNum > 0) {
        // list.add(record);
        // }
        // }
        return list;
    }

    public List<BusPileModel> getChargeModel() {
        reloadPileModel();
        return pileModelList;
    }

    public BusPileModel getChargeModelById(int modelId) {
        for (BusPileModel m : pileModelList) {
            if (m.getId() == modelId) {
                return m;
            }
        }
        return null;
    }

    /**
     * 获取某充电点下充电桩List
     */
    public List<PobChargingPile> getChargePileListByStationid(Integer stationid) {
        reloadChargePile();
        if (stationid == null || chargePileMap == null || chargePileMap.size() == 0) return null;
        return chargePileMap.get(stationid);
    }

    public List<Integer> getChargePileIdListByStationid(Integer stationid) {
        reloadChargePile();
        if (stationid == null || chargePileMap == null || chargePileMap.size() == 0) return null;
        List<PobChargingPile> list = chargePileMap.get(stationid);
        List<Integer> pIds = new ArrayList<Integer>();
        if (list != null && list.size() > 0) {
            for (PobChargingPile p : list) {
                pIds.add(p.getId());
            }
        }
        return pIds;
    }

    public Map<String, List<Integer>> getEquipmentIdListByStationId(Integer stationid) {
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        List<PobChargingPile> piles = getChargePileListByStationid(stationid);
        if (piles != null && piles.size() > 0) {
            for (PobChargingPile p : piles) {
                String comAddr = p.getComAddr();
                if (map.containsKey(comAddr)) {
                    List<Integer> ps = map.get(comAddr);
                    ps.add(p.getId());
                } else {
                    List<Integer> nps = new ArrayList<Integer>();
                    nps.add(p.getId());
                    map.put(comAddr, nps);
                }
            }
        }
        return map;

    }

    public Map<String, List<PobChargingPile>> getEquipmentListByStationId(Integer stationid) {
        Map<String, List<PobChargingPile>> map = new HashMap<String, List<PobChargingPile>>();
        List<PobChargingPile> piles = getChargePileListByStationid(stationid);
        if (piles != null && piles.size() > 0) {
            for (PobChargingPile p : piles) {
                String comAddr = p.getComAddr();
                if (map.containsKey(comAddr)) {
                    List<PobChargingPile> ps = map.get(comAddr);
                    ps.add(p);
                } else {
                    List<PobChargingPile> nps = new ArrayList<PobChargingPile>();
                    nps.add(p);
                    map.put(comAddr, nps);
                }
            }
        }
        return map;

    }

    public List<PobChargingPile> queryEquipmentInfoByStationId(Integer stationid) {
        List<PobChargingPile> list = getChargePileListByStationid(stationid);
        List<PobChargingPile> result = null;
        Map<String, PobChargingPile> map = null;
        if (list != null && list.size() > 0) {
            map = new HashMap<String, PobChargingPile>();
            for (PobChargingPile eq : list) {
                if (!map.containsKey(eq.getComAddr())) {
                    map.put(eq.getComAddr(), eq);
                }
            }
        }
        if (map != null && map.size() > 0) {
            result = new ArrayList<PobChargingPile>(map.values());
        }
        return result;
    }

    public List<PobChargingPile> queryConnectorInfoByComAddrAndStationId(String comAddr, Integer stationid) {
        List<PobChargingPile> list = getChargePileListByStationid(stationid);
        List<PobChargingPile> result = null;
        if (list != null && list.size() > 0) {
            result = new ArrayList<PobChargingPile>();
            for (PobChargingPile con : list) {
                if (con.getComAddr().equals(comAddr)) {
                    result.add(con);
                }
            }
        }
        return result;
    }

    /**
     * 根据运营商ID获取密钥信息
     * 
     * @param operatorID
     * @return
     */
    public SysSecretKey getSecretKeyByOperatorID(String operatorID) {
        reloadSecretKey();
        return sysSecretKeyMap.get(operatorID);
    }

    /**
     * 更新运营商密钥
     */
    public synchronized void reloadSecretKey() {
        Date updateTime = ChargingCacheUtil.getUpdateTime(CacheKeyProvide.KEY_SECTET_KEY_UPDATETIME);
        if (secretKeyUpdateTime == null || updateTime == null) return;
        if (secretKeyUpdateTime.getTime() < updateTime.getTime()) {
            SysSecretKeyExample emp = new SysSecretKeyExample();
            SysSecretKeyExample.Criteria cr = emp.createCriteria();
            cr.andTimeGreaterThanOrEqualTo(secretKeyUpdateTime);
            List<SysSecretKey> list = commonService.querySysSecretKeyByExample(emp);
            for (SysSecretKey record : list) {
                sysSecretKeyMap.put(record.getOperatorid(), record);
            }
            secretKeyUpdateTime = updateTime;
        }

    }

    public PileStatusBean returnPileStatusBean(Integer pileId) {
        byte[] value = RedisUtil.getByte(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PILESTATUS_BEAN, pileId.toString()).getBytes());
        if (value != null) {
            return (PileStatusBean) SerializationUtils.deserialize(value);
        }
        return null;
    }

    public void refreshPileStatusBean(PileStatusBean pileStatusBean) {
        RedisUtil.setByte(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PILESTATUS_BEAN, pileStatusBean.getId().toString()).getBytes(), SerializationUtils.serialize(pileStatusBean));
    }

    public PileStatusEnum returnPileStatus(Integer pileId) {
        if (pileId != null) {
            int status = NumberUtils.toInt(RedisUtil.getString(pileId.toString()));
            return PileStatusEnum.getEnmuByValue(status);
        }
        return null;
    }

    public ConnectorStatusTypeEnum returnPileStatus(PileStatusEnum temp) {
        if (PileStatusEnum.OFFLINE == temp) {
            return ConnectorStatusTypeEnum.OFF_LINE;
        } else if (PileStatusEnum.IDLE == temp) {
            return ConnectorStatusTypeEnum.IDLE;
        } else if (PileStatusEnum.BUSYING == temp || PileStatusEnum.FINISH == temp) {
            return ConnectorStatusTypeEnum.UN_CHARGING;
        } else if (PileStatusEnum.CHARGING == temp) {
            return ConnectorStatusTypeEnum.CHARGING;
        } else if (PileStatusEnum.FAULT == temp) {
            return ConnectorStatusTypeEnum.FAULT;
        } else {
            return ConnectorStatusTypeEnum.OFF_LINE;
        }
    }
}
