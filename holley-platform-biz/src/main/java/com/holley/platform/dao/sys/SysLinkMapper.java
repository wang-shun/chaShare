package com.holley.platform.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.platform.model.sys.SysLink;
import com.holley.platform.model.sys.SysLinkExample;

public interface SysLinkMapper {

    int countByExample(SysLinkExample example);

    int deleteByExample(SysLinkExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysLink record);

    int insertSelective(SysLink record);

    List<SysLink> selectByExample(SysLinkExample example);

    SysLink selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysLink record, @Param("example") SysLinkExample example);

    int updateByExample(@Param("record") SysLink record, @Param("example") SysLinkExample example);

    int updateByPrimaryKeySelective(SysLink record);

    int updateByPrimaryKey(SysLink record);

    List<SysLink> selectLinkByPage(Map<String, Object> params);
}
