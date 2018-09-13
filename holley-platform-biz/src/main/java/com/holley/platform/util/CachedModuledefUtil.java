package com.holley.platform.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.holley.platform.dao.sys.SysModuledefMapper;
import com.holley.platform.model.sys.SysModuledef;
import com.holley.platform.model.sys.SysModuledefExample;

/**
 * sys_module缓存和操作方法
 * 
 * @author road
 */
public class CachedModuledefUtil {

    private static SysModuledefMapper      sysModuledefMapper;

    /**
     * 系统菜单缓存
     */
    public static final List<SysModuledef> MODULEDEF = new ArrayList<SysModuledef>();

    public static void init() {
        // 初始化载入系统模块信息 double check
        if (CachedModuledefUtil.MODULEDEF.size() == 0) {
            synchronized (CachedModuledefUtil.MODULEDEF) {
                SysModuledefExample example = new SysModuledefExample();
                example.setOrderByClause("ModuleID");
                CachedModuledefUtil.MODULEDEF.addAll(sysModuledefMapper.selectByExample(example));
            }
        }
    }

    /**
     * 取当前id对应的模块
     * 
     * @param moduleid
     * @return
     */
    public static SysModuledef getModuledefByPrimaryKey(String moduleid) {
        for (SysModuledef sysModuledef : MODULEDEF) {
            if (moduleid.equals(sysModuledef.getModuleid())) {
                return sysModuledef;
            }
        }
        return null;
    }

    public static List<SysModuledef> getTopModuledefList() {
        List<SysModuledef> result = new LinkedList<SysModuledef>();
        // moduleid 与 parentmoduleid 不等
        for (SysModuledef sysModuledef : MODULEDEF) {
            if (sysModuledef.getModuleid().equalsIgnoreCase(sysModuledef.getParentmoduleid())) {
                result.add(sysModuledef);
            }
        }

        return result;
    }

    /**
     * 通过父模块ID取子模块列表,但不包括moduleid = parendmoduleid的数据
     * 
     * @param parentmoduleid
     * @return
     */
    public static List<SysModuledef> getChildModuleList(String parentmoduleid) {
        List<SysModuledef> result = new LinkedList<SysModuledef>();
        for (SysModuledef sysModuledef : MODULEDEF) {
            if (parentmoduleid.equals(sysModuledef.getParentmoduleid()) && !sysModuledef.getModuleid().equals(sysModuledef.getParentmoduleid())) {
                result.add(sysModuledef);
            }
        }
        return result;
    }

    /**
     * 通过父模块ID取子模块列表,但不包括moduleid = parendmoduleid的数据,同时排序
     * 
     * @param parentmoduleid
     * @return
     */
    public static List<SysModuledef> getChildModuleList(String parentmoduleid, Comparator<SysModuledef> comp) {
        List<SysModuledef> result = new LinkedList<SysModuledef>();
        for (SysModuledef sysModuledef : MODULEDEF) {
            if (parentmoduleid.equals(sysModuledef.getParentmoduleid()) && !sysModuledef.getModuleid().equals(sysModuledef.getParentmoduleid())) {
                result.add(sysModuledef);
            }
        }

        Collections.sort(result, comp);
        return result;
    }

    /**
     * 递归调用某个父模块下的所有子父模块
     * 
     * @param moduleid
     * @return
     */
    public static Map<String, SysModuledef> getChildModuleListAll(String moduleid) {
        Map<String, SysModuledef> moduleMap = new HashMap<String, SysModuledef>();
        List<SysModuledef> subModuleList = getChildModuleList(moduleid);
        if (subModuleList != null && subModuleList.size() > 0) {
            for (SysModuledef sysModuledef : subModuleList) {
                moduleMap.put(sysModuledef.getModuleid(), sysModuledef);
                moduleMap.putAll(getChildModuleListAll(sysModuledef.getModuleid()));
            }
        }
        return moduleMap;
    }

    /**
     * 递归调用父对象模块
     * 
     * @param parentModuleid
     * @return
     */
    public static Map<String, SysModuledef> getParentModule(String parentModuleid) {
        Map<String, SysModuledef> moduleMap = new HashMap<String, SysModuledef>();
        SysModuledef sysModuledef = getModuledefByPrimaryKey(parentModuleid);
        if (sysModuledef != null) {
            moduleMap.put(sysModuledef.getModuleid(), sysModuledef);
            if (!sysModuledef.getModuleid().equals(sysModuledef.getParentmoduleid())) {
                moduleMap.putAll(getParentModule(sysModuledef.getParentmoduleid()));
            }
        }
        return moduleMap;
    }

    /**
     * 移除不能用的权限，通过逗号风格的id批量处理
     * 
     * @param moduleMap
     * @param ids
     */
    public static void removeModuleByIds(Map<String, SysModuledef> moduleMap, String ids) {
        if (moduleMap != null && ids != null) {
            String[] idArray = StringUtils.split(ids, ",");
            if (idArray != null) {
                for (String id : idArray) {
                    moduleMap.remove(id);
                }
            }
        }
    }

    /**
     * 判断url是否在模块列表中
     * 
     * @param url
     * @return
     */
    public static boolean constains(String url) {
        for (SysModuledef sysModuledef : MODULEDEF) {
            if (url.equals(sysModuledef.getUrl())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 构建一级菜单
     * 
     * @param moduleList
     * @return
     */
    public static List<SysModuledef> getTopMenu(List<SysModuledef> moduleList) {
        List<SysModuledef> menuList = new ArrayList<SysModuledef>();
        for (SysModuledef moduledef : moduleList) {
            if (moduledef.getParentmoduleid().equals(moduledef.getModuleid())) {
                menuList.add(moduledef);
            }
        }
        return menuList;
    }

    /**
     * 构建二级菜单
     * 
     * @param moduleid
     * @param moduleList
     * @return
     */
    public static List<SysModuledef> getSubMenuByParentid(String moduleid, List<SysModuledef> moduleList) {
        List<SysModuledef> menuList = new ArrayList<SysModuledef>();
        for (SysModuledef moduledef : moduleList) {
            if (!moduledef.getParentmoduleid().equals(moduledef.getModuleid()) && moduledef.getParentmoduleid().equals(moduleid)) {
                menuList.add(moduledef);
            }
        }
        return menuList;
    }

    public static List<SysModuledef> getSubMenu(List<SysModuledef> moduleList) {
        List<SysModuledef> menuList = new ArrayList<SysModuledef>();
        for (SysModuledef moduledef : moduleList) {
            if (!moduledef.getParentmoduleid().equals(moduledef.getModuleid())) {
                menuList.add(moduledef);
            }
        }
        return menuList;
    }

    public static List<SysModuledef> getModuleBySystemid(short systemid) {
        List<SysModuledef> moduleList = new ArrayList<SysModuledef>();
        for (SysModuledef sysModuledef : MODULEDEF) {
            if (sysModuledef.getSystemid() != null && sysModuledef.getSystemid().shortValue() == systemid) {
                moduleList.add(sysModuledef);
            }
        }
        return moduleList;
    }

    public static void sortModuleList(List<SysModuledef> list) {
        if (list == null || list.size() == 0) return;
        Collections.sort(list, new Comparator<SysModuledef>() {

            public int compare(SysModuledef module1, SysModuledef module2) {
                return module1.getModuleid().compareTo(module2.getModuleid());
            }
        });

        Collections.sort(list, new Comparator<SysModuledef>() {

            public int compare(SysModuledef module1, SysModuledef module2) {
                if (module1.getSortno() != null && module2.getSortno() != null) {
                    return module1.getSortno().compareTo(module2.getSortno());
                }
                return 0;
            }
        });
    }

    public void setSysModuledefMapper(SysModuledefMapper sysModuledefMapper) {
        CachedModuledefUtil.sysModuledefMapper = sysModuledefMapper;
    }
}
