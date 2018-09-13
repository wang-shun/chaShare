package com.holley.platform.dao.sys;

import com.holley.platform.model.sys.SysSecretKey;
import com.holley.platform.model.sys.SysSecretKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysSecretKeyMapper {
    int countByExample(SysSecretKeyExample example);

    int deleteByExample(SysSecretKeyExample example);

    int deleteByPrimaryKey(String operatorid);

    int insert(SysSecretKey record);

    int insertSelective(SysSecretKey record);

    List<SysSecretKey> selectByExample(SysSecretKeyExample example);

    SysSecretKey selectByPrimaryKey(String operatorid);

    int updateByExampleSelective(@Param("record") SysSecretKey record, @Param("example") SysSecretKeyExample example);

    int updateByExample(@Param("record") SysSecretKey record, @Param("example") SysSecretKeyExample example);

    int updateByPrimaryKeySelective(SysSecretKey record);

    int updateByPrimaryKey(SysSecretKey record);
}