package com.holley.platform.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.platform.model.sys.SysRule;
import com.holley.platform.model.sys.SysRuleExample;

public interface SysRuleMapper {

    int countByExample(SysRuleExample example);

    int deleteByExample(SysRuleExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRule record);

    int insertSelective(SysRule record);

    List<SysRule> selectByExample(SysRuleExample example);

    SysRule selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRule record, @Param("example") SysRuleExample example);

    int updateByExample(@Param("record") SysRule record, @Param("example") SysRuleExample example);

    int updateByPrimaryKeySelective(SysRule record);

    int updateByPrimaryKey(SysRule record);

    List<SysRule> selectRuleByPage(Map<String, Object> params);
}
