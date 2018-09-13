package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusChargeRule;
import com.holley.charging.model.bus.BusChargeRuleExample;

public interface BusChargeRuleMapper {

    int countByExample(BusChargeRuleExample example);

    int deleteByExample(BusChargeRuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusChargeRule record);

    int insertSelective(BusChargeRule record);

    List<BusChargeRule> selectByExample(BusChargeRuleExample example);

    BusChargeRule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusChargeRule record, @Param("example") BusChargeRuleExample example);

    int updateByExample(@Param("record") BusChargeRule record, @Param("example") BusChargeRuleExample example);

    int updateByPrimaryKeySelective(BusChargeRule record);

    int updateByPrimaryKey(BusChargeRule record);

}
