package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusCardRecharge;
import com.holley.charging.model.bus.BusCardRechargeExample;

public interface BusCardRechargeMapper {

    int countByExample(BusCardRechargeExample example);

    int deleteByExample(BusCardRechargeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusCardRecharge record);

    int insertSelective(BusCardRecharge record);

    List<BusCardRecharge> selectByExample(BusCardRechargeExample example);

    BusCardRecharge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusCardRecharge record, @Param("example") BusCardRechargeExample example);

    int updateByExample(@Param("record") BusCardRecharge record, @Param("example") BusCardRechargeExample example);

    int updateByPrimaryKeySelective(BusCardRecharge record);

    int updateByPrimaryKey(BusCardRecharge record);

}
