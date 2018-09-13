package com.holley.platform.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.platform.model.sys.SysButtondef;
import com.holley.platform.model.sys.SysButtondefExample;

public interface SysButtondefMapper {

    int countByExample(SysButtondefExample example);

    int deleteByExample(SysButtondefExample example);

    int deleteByPrimaryKey(Integer buttonid);

    int insert(SysButtondef record);

    int insertSelective(SysButtondef record);

    List<SysButtondef> selectByExample(SysButtondefExample example);

    SysButtondef selectByPrimaryKey(Integer buttonid);

    int updateByExampleSelective(@Param("record") SysButtondef record, @Param("example") SysButtondefExample example);

    int updateByExample(@Param("record") SysButtondef record, @Param("example") SysButtondefExample example);

    int updateByPrimaryKeySelective(SysButtondef record);

    int updateByPrimaryKey(SysButtondef record);

    List<SysButtondef> selectButtondefByUserid(Integer userid);

    List<SysButtondef> selectButtondefBySystemid(Short systemid);
}
