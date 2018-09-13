package com.holley.platform.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.holley.platform.dao.sys.SysAccountroleMapper;
import com.holley.platform.dao.sys.SysButtondefMapper;
import com.holley.platform.dao.sys.SysModuledefMapper;
import com.holley.platform.dao.sys.SysRoleMapper;
import com.holley.platform.dao.sys.SysRolemoduleMapper;
import com.holley.platform.dao.sys.SysRuleMapper;
import com.holley.platform.model.sys.SysAccountroleExample;
import com.holley.platform.model.sys.SysAccountroleKey;
import com.holley.platform.model.sys.SysButtondef;
import com.holley.platform.model.sys.SysModuledef;
import com.holley.platform.model.sys.SysModuledefExample;
import com.holley.platform.model.sys.SysRole;
import com.holley.platform.model.sys.SysRoleExample;
import com.holley.platform.model.sys.SysRolemoduleExample;
import com.holley.platform.model.sys.SysRolemoduleKey;
import com.holley.platform.model.sys.SysRule;
import com.holley.platform.service.RoleService;
import com.holley.platform.util.CachedModuledefUtil;

public class RoleServiceImpl implements RoleService {

    private SysAccountroleMapper sysAccountroleMapper;
    private SysModuledefMapper   sysModuledefMapper;
    private SysButtondefMapper   sysButtondefMapper;
    @SuppressWarnings("unused")
    private SysRoleMapper        sysRoleMapper;
    @SuppressWarnings("unused")
    private SysRolemoduleMapper  sysRolemoduleMapper;
    private SysRuleMapper        sysRuleMapper;

    // -----------------sysAccountroleMapper------------------
    public int insertAccountRole(SysAccountroleKey record) {
        return sysAccountroleMapper.insert(record);
    }

    public SysAccountroleKey selectAccountRoleByUserid(Integer userid) {
        return sysAccountroleMapper.selectAccountRoleByUserid(userid);
    }

    public List<SysAccountroleKey> selectAccountroleByExample(SysAccountroleExample example) {
        return sysAccountroleMapper.selectByExample(example);
    }

    @Override
    public int deleteAccountroleByExample(SysAccountroleExample example) {
        return sysAccountroleMapper.deleteByExample(example);
    }

    // -----------------sysRoleMapper------------------
    public SysRole selectRoleByUserid(Integer userid) {
        return sysRoleMapper.selectRoleByUserid(userid);
    }

    public List<SysRole> selectRoleByExample(SysRoleExample example) {
        return sysRoleMapper.selectByExample(example);
    }

    public List<SysRole> selectRoleByParam(Map<String, Object> params) {
        return sysRoleMapper.selectRoleByParam(params);
    }

    public int insertRole(SysRole record) {
        return sysRoleMapper.insert(record);
    }

    public int updateRoleByPKSelective(SysRole record) {
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    public SysRole selectRoleByPK(Integer id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    public int deleteRoleByPK(Integer id) {
        // 删除角色
        int row = sysRoleMapper.deleteByPrimaryKey(id);
        if (row > 0) {
            // 删除角色模块关系表相关记录
            SysRolemoduleExample rmemp = new SysRolemoduleExample();
            SysRolemoduleExample.Criteria rmcr = rmemp.createCriteria();
            rmcr.andRoleidEqualTo(id);
            row += deleteRolemoduleByExample(rmemp);
        }
        return row;
    }

    @Override
    public int saveRole(Integer roleid, String[] moduleList) {
        int row = 0;
        SysRolemoduleExample emp = new SysRolemoduleExample();
        SysRolemoduleExample.Criteria cr = emp.createCriteria();
        cr.andRoleidEqualTo(roleid);

        // 删除角色原来的功能模块
        List<SysRolemoduleKey> oldList = sysRolemoduleMapper.selectByExample(emp);
        if (oldList != null && oldList.size() > 0) {
            sysRolemoduleMapper.deleteByExample(emp);
        }

        // 插入角色新分配的功能模块
        Map<String, String> moduleidMap = new HashMap<String, String>();
        List<SysRolemoduleKey> insertRoleModuleList = new ArrayList<SysRolemoduleKey>();
        SysRolemoduleKey roleModule;
        for (String moduleid : moduleList) {
            moduleidMap.put(moduleid, moduleid);
            roleModule = new SysRolemoduleKey();
            roleModule.setRoleid(roleid);
            roleModule.setModuleid(moduleid);
            insertRoleModuleList.add(roleModule);
        }
        if (insertRoleModuleList != null && insertRoleModuleList.size() > 0) {
            row += sysRolemoduleMapper.insertRolemoduleBatch(insertRoleModuleList);
        }

        // 父角色中删除的模块，在子角色中也要删除
        List<SysRolemoduleKey> roleModuleList = sysRolemoduleMapper.selectChildRoleModule(roleid);
        List<SysRolemoduleKey> deleteRoleModuleList = new ArrayList<SysRolemoduleKey>();
        for (SysRolemoduleKey key : roleModuleList) {
            if (!moduleidMap.containsKey(key.getModuleid())) {
                deleteRoleModuleList.add(key);
            }
        }
        if (deleteRoleModuleList != null && deleteRoleModuleList.size() > 0) {
            sysRolemoduleMapper.deleteRolemoduleBatch(deleteRoleModuleList);
        }
        return 0;
    }

    // -----------------sysModuledefMapper------------------
    public List<SysModuledef> selectModuledefByUserid(Integer userid) {
        List<SysModuledef> modules = sysModuledefMapper.selectModuledefByUserid(userid);
        Map<String, SysModuledef> moduleMap = new HashMap<String, SysModuledef>();
        for (SysModuledef module : modules) {
            if (module != null) {
                moduleMap.put(module.getModuleid(), module);
                moduleMap.putAll(CachedModuledefUtil.getParentModule(module.getParentmoduleid()));
            }
        }
        List<SysModuledef> moduleList = new ArrayList<SysModuledef>();
        moduleList.addAll(moduleMap.values());
        // 排序
        if (moduleList.size() > 0) {
            CachedModuledefUtil.sortModuleList(moduleList);
        }
        return moduleList;
    }

    public List<SysModuledef> selectModuledefByExample(SysModuledefExample example) {
        return sysModuledefMapper.selectByExample(example);
    }

    // -----------------sysButtondefMapper------------------
    public List<SysButtondef> selectButtondefByUserid(Integer userid) {
        return sysButtondefMapper.selectButtondefByUserid(userid);
    }

    public List<SysButtondef> selectButtondefBySystemid(Short systemid) {
        return sysButtondefMapper.selectButtondefBySystemid(systemid);
    }

    // -----------------sysRolemoduleMapper------------------
    public int deleteRolemoduleByExample(SysRolemoduleExample example) {
        return sysRolemoduleMapper.deleteByExample(example);
    }

    public List<SysRolemoduleKey> selectRolemoduleByExample(SysRolemoduleExample example) {
        return sysRolemoduleMapper.selectByExample(example);
    }

    // -----------------sysRuleMapper------------------
    @Override
    public SysRule selectRuleByPrimaryKey(String id) {
        return sysRuleMapper.selectByPrimaryKey(id);
    }

    // -----------------get and set------------------
    public void setSysAccountroleMapper(SysAccountroleMapper sysAccountroleMapper) {
        this.sysAccountroleMapper = sysAccountroleMapper;
    }

    public void setSysModuledefMapper(SysModuledefMapper sysModuledefMapper) {
        this.sysModuledefMapper = sysModuledefMapper;
    }

    public void setSysButtondefMapper(SysButtondefMapper sysButtondefMapper) {
        this.sysButtondefMapper = sysButtondefMapper;
    }

    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    public void setSysRolemoduleMapper(SysRolemoduleMapper sysRolemoduleMapper) {
        this.sysRolemoduleMapper = sysRolemoduleMapper;
    }

    public void setSysRuleMapper(SysRuleMapper sysRuleMapper) {
        this.sysRuleMapper = sysRuleMapper;
    }

}
