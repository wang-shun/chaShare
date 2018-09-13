package com.holley.charging.dao.bus;

import com.holley.charging.model.bus.BusBussinessReal;
import com.holley.charging.model.bus.BusBussinessRealExample;
import com.holley.charging.model.bus.BusBussinessRealKey;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BusBussinessRealMapper {
    int countByExample(BusBussinessRealExample example);

    int deleteByExample(BusBussinessRealExample example);

    int deleteByPrimaryKey(BusBussinessRealKey key);

    int insert(BusBussinessReal record);

    int insertSelective(BusBussinessReal record);

    List<BusBussinessReal> selectByExample(BusBussinessRealExample example);

    BusBussinessReal selectByPrimaryKey(BusBussinessRealKey key);

    int updateByExampleSelective(@Param("record") BusBussinessReal record, @Param("example") BusBussinessRealExample example);

    int updateByExample(@Param("record") BusBussinessReal record, @Param("example") BusBussinessRealExample example);

    int updateByPrimaryKeySelective(BusBussinessReal record);

    int updateByPrimaryKey(BusBussinessReal record);
    
}