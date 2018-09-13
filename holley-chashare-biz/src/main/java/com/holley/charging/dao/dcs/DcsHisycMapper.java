package com.holley.charging.dao.dcs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.dcs.DcsHisyc;
import com.holley.charging.model.dcs.DcsHisycExample;

public interface DcsHisycMapper {

    int countByExample(DcsHisycExample example);

    int deleteByExample(DcsHisycExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcsHisyc record);

    int insertSelective(DcsHisyc record);

    List<DcsHisyc> selectByExample(DcsHisycExample example);

    DcsHisyc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcsHisyc record, @Param("example") DcsHisycExample example);

    int updateByExample(@Param("record") DcsHisyc record, @Param("example") DcsHisycExample example);

    int updateByPrimaryKeySelective(DcsHisyc record);

    int updateByPrimaryKey(DcsHisyc record);

}
