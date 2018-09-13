package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusPileApply;
import com.holley.charging.model.bus.BusPileApplyExample;

public interface BusPileApplyMapper {

    int countByExample(BusPileApplyExample example);

    int deleteByExample(BusPileApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusPileApply record);

    int insertSelective(BusPileApply record);

    List<BusPileApply> selectByExample(BusPileApplyExample example);

    BusPileApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusPileApply record, @Param("example") BusPileApplyExample example);

    int updateByExample(@Param("record") BusPileApply record, @Param("example") BusPileApplyExample example);

    int updateByPrimaryKeySelective(BusPileApply record);

    int updateByPrimaryKey(BusPileApply record);

}
