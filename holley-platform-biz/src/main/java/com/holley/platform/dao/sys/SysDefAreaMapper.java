package com.holley.platform.dao.sys;

import com.holley.platform.model.sys.SysDefArea;
import com.holley.platform.model.sys.SysDefAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDefAreaMapper {
    int countByExample(SysDefAreaExample example);

    int deleteByExample(SysDefAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysDefArea record);

    int insertSelective(SysDefArea record);

    List<SysDefArea> selectByExample(SysDefAreaExample example);

    SysDefArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysDefArea record, @Param("example") SysDefAreaExample example);

    int updateByExample(@Param("record") SysDefArea record, @Param("example") SysDefAreaExample example);

    int updateByPrimaryKeySelective(SysDefArea record);

    int updateByPrimaryKey(SysDefArea record);
}