package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusAccountLog;
import com.holley.charging.model.bus.BusAccountLogExample;

public interface BusAccountLogMapper {

    int countByExample(BusAccountLogExample example);

    int deleteByExample(BusAccountLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusAccountLog record);

    int insertSelective(BusAccountLog record);

    List<BusAccountLog> selectByExample(BusAccountLogExample example);

    BusAccountLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusAccountLog record, @Param("example") BusAccountLogExample example);

    int updateByExample(@Param("record") BusAccountLog record, @Param("example") BusAccountLogExample example);

    int updateByPrimaryKeySelective(BusAccountLog record);

    int updateByPrimaryKey(BusAccountLog record);

}
