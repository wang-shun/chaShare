package com.holley.charging.dao.dcs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.dcs.DcsChargerecord;
import com.holley.charging.model.dcs.DcsChargerecordExample;

public interface DcsChargerecordMapper {

    int countByExample(DcsChargerecordExample example);

    int deleteByExample(DcsChargerecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcsChargerecord record);

    int insertSelective(DcsChargerecord record);

    List<DcsChargerecord> selectByExample(DcsChargerecordExample example);

    DcsChargerecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcsChargerecord record, @Param("example") DcsChargerecordExample example);

    int updateByExample(@Param("record") DcsChargerecord record, @Param("example") DcsChargerecordExample example);

    int updateByPrimaryKeySelective(DcsChargerecord record);

    int updateByPrimaryKey(DcsChargerecord record);

}
