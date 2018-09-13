package com.holley.charging.dao.pob;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.pob.PobChargingTempStation;
import com.holley.charging.model.pob.PobChargingTempStationExample;

public interface PobChargingTempStationMapper {

    int countByExample(PobChargingTempStationExample example);

    int deleteByExample(PobChargingTempStationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PobChargingTempStation record);

    int insertSelective(PobChargingTempStation record);

    List<PobChargingTempStation> selectByExample(PobChargingTempStationExample example);

    PobChargingTempStation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PobChargingTempStation record, @Param("example") PobChargingTempStationExample example);

    int updateByExample(@Param("record") PobChargingTempStation record, @Param("example") PobChargingTempStationExample example);

    int updateByPrimaryKeySelective(PobChargingTempStation record);

    int updateByPrimaryKey(PobChargingTempStation record);

}
