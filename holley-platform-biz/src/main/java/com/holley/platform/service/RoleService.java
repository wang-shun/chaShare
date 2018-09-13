package com.holley.platform.service;

import java.util.List;
import java.util.Map;

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

/**
 * 权限服务
 * 
 * @author zhouli
 */
public interface RoleService {

    // -----------------sysAccountroleMapper------------------

    /**
     * 插入用户角色
     * 
     * @param record
     * @return
     */
    int insertAccountRole(SysAccountroleKey record);

    /**
     * 查询用户所属角色
     * 
     * @param userid
     * @return
     */
    SysAccountroleKey selectAccountRoleByUserid(Integer userid);

    List<SysAccountroleKey> selectAccountroleByExample(SysAccountroleExample example);

    int deleteAccountroleByExample(SysAccountroleExample example);

    // -----------------sysRoleMapper------------------
    /**
     * 查询用户所属角色类型
     * 
     * @param userid
     * @return
     */
    SysRole selectRoleByUserid(Integer userid);

    List<SysRole> selectRoleByExample(SysRoleExample example);

    List<SysRole> selectRoleByParam(Map<String, Object> params);

    int insertRole(SysRole record);

    int updateRoleByPKSelective(SysRole record);

    SysRole selectRoleByPK(Integer id);

    int deleteRoleByPK(Integer id);

    int saveRole(Integer roleid, String[] moduleList);

    // -----------------sysModuledefMapper------------------

    /**
     * 查询用户权限
     * 
     * @param userid
     * @return
     */
    List<SysModuledef> selectModuledefByUserid(Integer userid);

    List<SysModuledef> selectModuledefByExample(SysModuledefExample example);

    // -----------------sysButtondefMapper------------------

    /**
     * 查询用户权限按钮
     * 
     * @param userid
     * @return
     */
    List<SysButtondef> selectButtondefByUserid(Integer userid);

    List<SysButtondef> selectButtondefBySystemid(Short systemid);

    // -----------------sysRolemoduleMapper------------------
    int deleteRolemoduleByExample(SysRolemoduleExample example);

    List<SysRolemoduleKey> selectRolemoduleByExample(SysRolemoduleExample example);

    // -----------------sysRuleMapper------------------

    /**
     * 系统规则查询
     * 
     * @param id
     * @return
     */
    SysRule selectRuleByPrimaryKey(String id);

}
