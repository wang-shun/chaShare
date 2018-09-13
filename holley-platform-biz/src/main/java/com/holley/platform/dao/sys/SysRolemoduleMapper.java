package com.holley.platform.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.platform.model.sys.SysRolemoduleExample;
import com.holley.platform.model.sys.SysRolemoduleKey;

public interface SysRolemoduleMapper {

    int countByExample(SysRolemoduleExample example);

    int deleteByExample(SysRolemoduleExample example);

    int deleteByPrimaryKey(SysRolemoduleKey key);

    int insert(SysRolemoduleKey record);

    int insertSelective(SysRolemoduleKey record);

    List<SysRolemoduleKey> selectByExample(SysRolemoduleExample example);

    int updateByExampleSelective(@Param("record") SysRolemoduleKey record, @Param("example") SysRolemoduleExample example);

    int updateByExample(@Param("record") SysRolemoduleKey record, @Param("example") SysRolemoduleExample example);

    int insertRolemoduleBatch(List<SysRolemoduleKey> list);

    List<SysRolemoduleKey> selectChildRoleModule(Integer roleid);

    int deleteRolemoduleBatch(List<SysRolemoduleKey> list);
}
