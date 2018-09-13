package com.holley.charging.dao.bus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusRecharge;
import com.holley.charging.model.bus.BusRechargeExample;

public interface BusRechargeMapper {

    int countByExample(BusRechargeExample example);

    int deleteByExample(BusRechargeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusRecharge record);

    int insertSelective(BusRecharge record);

    List<BusRecharge> selectByExample(BusRechargeExample example);

    BusRecharge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusRecharge record, @Param("example") BusRechargeExample example);

    int updateByExample(@Param("record") BusRecharge record, @Param("example") BusRechargeExample example);

    int updateByPrimaryKeySelective(BusRecharge record);

    int updateByPrimaryKey(BusRecharge record);

}
