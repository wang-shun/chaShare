package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusPileChargerule;
import com.holley.charging.model.bus.BusPileChargeruleExample;

public interface BusPileChargeruleMapper {

    int countByExample(BusPileChargeruleExample example);

    int deleteByExample(BusPileChargeruleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusPileChargerule record);

    int insertSelective(BusPileChargerule record);

    List<BusPileChargerule> selectByExample(BusPileChargeruleExample example);

    BusPileChargerule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusPileChargerule record, @Param("example") BusPileChargeruleExample example);

    int updateByExample(@Param("record") BusPileChargerule record, @Param("example") BusPileChargeruleExample example);

    int updateByPrimaryKeySelective(BusPileChargerule record);

    int updateByPrimaryKey(BusPileChargerule record);

}
