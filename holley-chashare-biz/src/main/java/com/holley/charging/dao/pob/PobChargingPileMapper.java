package com.holley.charging.dao.pob;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.pob.PobChargingPile;
import com.holley.charging.model.pob.PobChargingPileExample;

public interface PobChargingPileMapper {

    int countByExample(PobChargingPileExample example);

    int deleteByExample(PobChargingPileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PobChargingPile record);

    int insertSelective(PobChargingPile record);

    List<PobChargingPile> selectByExample(PobChargingPileExample example);

    PobChargingPile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PobChargingPile record, @Param("example") PobChargingPileExample example);

    int updateByExample(@Param("record") PobChargingPile record, @Param("example") PobChargingPileExample example);

    int updateByPrimaryKeySelective(PobChargingPile record);

    int updateByPrimaryKey(PobChargingPile record);

    // ADD
    /**
     * 根据站点ID查询充电设备列表信息
     * 
     * @param stationId
     * @return
     */
    List<PobChargingPile> queryEquipmentInfoByStationId(Integer stationId);

}
