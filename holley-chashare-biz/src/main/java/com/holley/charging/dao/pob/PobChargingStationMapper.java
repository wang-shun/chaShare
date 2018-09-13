package com.holley.charging.dao.pob;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.pob.PobChargingStation;
import com.holley.charging.model.pob.PobChargingStationExample;

public interface PobChargingStationMapper {

    int countByExample(PobChargingStationExample example);

    int deleteByExample(PobChargingStationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PobChargingStation record);

    int insertSelective(PobChargingStation record);

    List<PobChargingStation> selectByExample(PobChargingStationExample example);

    PobChargingStation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PobChargingStation record, @Param("example") PobChargingStationExample example);

    int updateByExample(@Param("record") PobChargingStation record, @Param("example") PobChargingStationExample example);

    int updateByPrimaryKeySelective(PobChargingStation record);

    int updateByPrimaryKey(PobChargingStation record);

    // ADD
    /**
     * 分页查询站点信息
     * 
     * @param param
     * @return
     */
    List<PobChargingStation> queryStationInfoByPage(Map<String, Object> param);
}
