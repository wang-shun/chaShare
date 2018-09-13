package com.holley.platform.dao.sys;

import com.holley.platform.model.sys.SysLinkType;
import com.holley.platform.model.sys.SysLinkTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysLinkTypeMapper {
    int countByExample(SysLinkTypeExample example);

    int deleteByExample(SysLinkTypeExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysLinkType record);

    int insertSelective(SysLinkType record);

    List<SysLinkType> selectByExample(SysLinkTypeExample example);

    SysLinkType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysLinkType record, @Param("example") SysLinkTypeExample example);

    int updateByExample(@Param("record") SysLinkType record, @Param("example") SysLinkTypeExample example);

    int updateByPrimaryKeySelective(SysLinkType record);

    int updateByPrimaryKey(SysLinkType record);
}