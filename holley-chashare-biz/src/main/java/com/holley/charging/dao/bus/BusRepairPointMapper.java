package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusRepairPoint;
import com.holley.charging.model.bus.BusRepairPointExample;

public interface BusRepairPointMapper {

    int countByExample(BusRepairPointExample example);

    int deleteByExample(BusRepairPointExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusRepairPoint record);

    int insertSelective(BusRepairPoint record);

    List<BusRepairPoint> selectByExample(BusRepairPointExample example);

    BusRepairPoint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusRepairPoint record, @Param("example") BusRepairPointExample example);

    int updateByExample(@Param("record") BusRepairPoint record, @Param("example") BusRepairPointExample example);

    int updateByPrimaryKeySelective(BusRepairPoint record);

    int updateByPrimaryKey(BusRepairPoint record);

}
