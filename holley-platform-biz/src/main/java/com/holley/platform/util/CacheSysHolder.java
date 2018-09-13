package com.holley.platform.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.holley.common.cache.charging.CacheKeyProvide.KeySessionTypeEnum;
import com.holley.common.cache.charging.ChargingCacheUtil;
import com.holley.platform.model.sys.SysCarBrand;
import com.holley.platform.model.sys.SysCarBrandExample;
import com.holley.platform.model.sys.SysDefArea;
import com.holley.platform.model.sys.SysDefAreaExample;
import com.holley.platform.model.sys.SysLink;
import com.holley.platform.service.DictionaryService;

/**
 * 缓存服务
 * 
 * @author zdd
 */
public class CacheSysHolder {

    private static DictionaryService               dictionaryService;
    private static List<SysDefArea>                provinceList   = new ArrayList<SysDefArea>();
    private static Map<Integer, List<SysDefArea>>  cityMap        = new HashMap<Integer, List<SysDefArea>>();
    public static Map<String, List<SysLink>>       linkMap        = new HashMap<String, List<SysLink>>();
    private static List<SysCarBrand>               carBrandList   = new ArrayList<SysCarBrand>();             // 汽车品牌
    private static Map<Integer, List<SysCarBrand>> carSubBrandMap = new HashMap<Integer, List<SysCarBrand>>(); // 汽车品牌子型号

    public static void init() {
        initProvince();
        initCity();
        initLink();
    }

    public static void initLink() {
        List<SysLink> list = dictionaryService.selectLinkByExample(null);
        List<SysLink> tempList;
        String typeId;
        for (SysLink record : list) {
            typeId = record.getTypeId();
            if (linkMap.containsKey(typeId)) {
                tempList = linkMap.get(typeId);
                tempList.add(record);
            } else {
                tempList = new ArrayList<SysLink>();
                tempList.add(record);
                linkMap.put(record.getTypeId(), tempList);
            }

        }
    }

    /**
     * 初始化车品牌缓存数据
     */
    public static void initCarBrand() {
        SysCarBrandExample emp = new SysCarBrandExample();
        SysCarBrandExample.Criteria cr = emp.createCriteria();
        cr.andPidEqualTo(0);
        carBrandList = dictionaryService.selectCarBrandByExample(emp);
    }

    /**
     * 初始品牌子参数缓存数据
     */
    public static void initCarSubBrand() {
        SysCarBrandExample emp = new SysCarBrandExample();
        SysCarBrandExample.Criteria cr = emp.createCriteria();
        cr.andPidGreaterThan(0);

        Integer pid;
        List<SysCarBrand> list = dictionaryService.selectCarBrandByExample(emp);
        List<SysCarBrand> tempList;
        for (SysCarBrand record : list) {
            pid = record.getPid();
            if (carSubBrandMap.containsKey(pid)) {
                tempList = carSubBrandMap.get(pid);
                tempList.add(record);
            } else {
                tempList = new ArrayList<SysCarBrand>();
                tempList.add(record);
                carSubBrandMap.put(record.getPid(), tempList);
            }

        }

    }

    /**
     * 初始化省份缓存数据
     */
    public static void initProvince() {
        SysDefAreaExample emp = new SysDefAreaExample();
        SysDefAreaExample.Criteria cr = emp.createCriteria();
        cr.andPidEqualTo(0);
        provinceList = dictionaryService.selectByAreaExample(emp);
    }

    /**
     * 初始化城市缓存数据
     */
    public static void initCity() {
        SysDefAreaExample emp = new SysDefAreaExample();
        SysDefAreaExample.Criteria cr = emp.createCriteria();
        cr.andPidGreaterThan(0);

        Integer pid;
        List<SysDefArea> list = dictionaryService.selectByAreaExample(emp);
        List<SysDefArea> tempList;
        for (SysDefArea record : list) {
            pid = record.getPid();
            if (cityMap.containsKey(pid)) {
                tempList = cityMap.get(pid);
                tempList.add(record);
            } else {
                tempList = new ArrayList<SysDefArea>();
                tempList.add(record);
                cityMap.put(record.getPid(), tempList);
            }

        }

    }

    /**
     * 重载车品牌信息
     */
    public static void reloadCarBrand() {
        clearCarBrand();
        initCarBrand();
        initCarSubBrand();
    }

    /**
     * 重载地域信息
     */
    public static void reloadArea() {
        clearSysArea();
        initProvince();
        initCity();
    }

    /**
     * 重载link信息
     */
    public static void reloadLink() {
        clearSysLink();
        initLink();
    }

    public static void reloadLink(KeySessionTypeEnum type) {
        if (type == null) return;
        if (ChargingCacheUtil.getLinkUpdate(type)) {
            reloadLink();
            ChargingCacheUtil.removeLinkUpdate(type);
        }
    }

    /**
     * 根据typeId获取子列表
     * 
     * @param typeId
     * @return
     */
    public static List<SysLink> getLinkListBytypeId(String typeId) {
        return linkMap.get(typeId);
    }

    /**
     * 这里value作为有父子管理的link对象来使用
     * 
     * @param type
     * @param id
     * @return
     */
    public static List<SysLink> getSyslinkByTypeAndValue(String type, String id) {
        if (linkMap != null) {
            List<SysLink> linkList = linkMap.get(type);
            if (linkList != null) {
                List<SysLink> returnList = new ArrayList<SysLink>();
                for (SysLink sysLink : linkList) {
                    if (StringUtils.equals(sysLink.getValue(), id)) {
                        returnList.add(sysLink);
                    }
                }
                return returnList;
            }
        }
        return null;

    }

    /**
     * 获取省级列表
     * 
     * @return
     */
    public static List<SysDefArea> getProvinceList() {
        return provinceList;
    }

    /**
     * 根据PID获取子市区列表
     * 
     * @param pid
     * @return
     */
    public static List<SysDefArea> getCityListByPid(Integer pid) {
        return cityMap.get(pid);
    }

    /**
     * 获取汽车品牌
     * 
     * @return
     */
    public static List<SysCarBrand> getCarBrandList() {
        return carBrandList;
    }

    /**
     * 根据PID获取汽车品牌型号
     * 
     * @param pid
     * @return
     */
    public static List<SysCarBrand> getCarModelListByPid(Integer pid) {
        if (pid == null) return null;
        return carSubBrandMap.get(pid);
    }

    /**
     * @param pid
     * @param id
     * @return
     */
    public static String getCarSubBrandName(Integer pid, Integer id) {
        if (pid == null || id == null) return null;
        List<SysCarBrand> carSubBrandList = carSubBrandMap.get(pid);
        if (carSubBrandList == null || carSubBrandList.size() == 0) return null;
        for (SysCarBrand record : carSubBrandList) {
            if (record.getId().equals(id)) return record.getName();
        }
        return null;
    }

    /**
     * 根据id汽车品牌的名称
     * 
     * @param id
     * @return
     */
    public static String getCarBrandName(Integer id) {
        if (id == null) return null;
        for (SysCarBrand record : carBrandList) {
            if (record.getId().equals(id)) return record.getName();
        }
        return null;
    }

    /**
     * 根据id获取省的名称
     * 
     * @param id
     * @return
     */
    public static String getProvinceName(Integer id) {
        if (id == null) return null;
        for (SysDefArea record : provinceList) {
            if (record.getId().equals(id)) return record.getName();
        }
        return null;
    }

    /**
     * @param pid
     * @param id
     * @return
     */
    public static String getCityName(Integer pid, Integer id) {
        if (pid == null || id == null) return null;
        List<SysDefArea> cityList = cityMap.get(pid);
        if (cityList == null || cityList.size() == 0) return null;
        for (SysDefArea record : cityList) {
            if (record.getId().equals(id)) return record.getName();
        }
        return null;
    }

    /**
     * 清空地域缓存数据
     */
    public static void clearSysArea() {
        if (provinceList != null) provinceList.clear();
        if (cityMap != null) cityMap.clear();
    }

    /**
     * 清车品牌缓存数据
     */
    public static void clearCarBrand() {
        if (carBrandList != null) carBrandList.clear();
        if (carSubBrandMap != null) carSubBrandMap.clear();
    }

    /**
     * 清空link缓存数据
     */
    public static void clearSysLink() {
        if (linkMap != null) linkMap.clear();
    }

    /**
     * 根据typeid和id获取name
     * 
     * @param typeid
     * @param id
     * @return
     */
    public static String getSysLinkName(String typeid, String id) {
        if (typeid == null || id == null) return "";
        List<SysLink> list = linkMap.get(typeid);
        if (list == null || list.size() == 0) return "";
        for (SysLink record : list) {
            if (record.getValue().equals(id)) return record.getName();
        }
        return "";
    }

    public static void setDictionaryService(DictionaryService dictionaryService) {
        CacheSysHolder.dictionaryService = dictionaryService;
    }

}
