package com.holley.charging.dao.bus;

import com.holley.charging.model.bus.BusChargeCard;
import com.holley.charging.model.bus.BusChargeCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusChargeCardMapper {
    int countByExample(BusChargeCardExample example);

    int deleteByExample(BusChargeCardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusChargeCard record);

    int insertSelective(BusChargeCard record);

    List<BusChargeCard> selectByExample(BusChargeCardExample example);

    BusChargeCard selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusChargeCard record, @Param("example") BusChargeCardExample example);

    int updateByExample(@Param("record") BusChargeCard record, @Param("example") BusChargeCardExample example);

    int updateByPrimaryKeySelective(BusChargeCard record);

    int updateByPrimaryKey(BusChargeCard record);
}