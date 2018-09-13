package com.holley.platform.dao.sys;

import com.holley.platform.model.sys.SysCarBrand;
import com.holley.platform.model.sys.SysCarBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCarBrandMapper {
    int countByExample(SysCarBrandExample example);

    int deleteByExample(SysCarBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysCarBrand record);

    int insertSelective(SysCarBrand record);

    List<SysCarBrand> selectByExample(SysCarBrandExample example);

    SysCarBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysCarBrand record, @Param("example") SysCarBrandExample example);

    int updateByExample(@Param("record") SysCarBrand record, @Param("example") SysCarBrandExample example);

    int updateByPrimaryKeySelective(SysCarBrand record);

    int updateByPrimaryKey(SysCarBrand record);
}