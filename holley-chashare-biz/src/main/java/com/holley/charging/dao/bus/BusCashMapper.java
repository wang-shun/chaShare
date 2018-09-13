package com.holley.charging.dao.bus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusCash;
import com.holley.charging.model.bus.BusCashExample;

public interface BusCashMapper {

    int countByExample(BusCashExample example);

    int deleteByExample(BusCashExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusCash record);

    int insertSelective(BusCash record);

    List<BusCash> selectByExample(BusCashExample example);

    BusCash selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusCash record, @Param("example") BusCashExample example);

    int updateByExample(@Param("record") BusCash record, @Param("example") BusCashExample example);

    int updateByPrimaryKeySelective(BusCash record);

    int updateByPrimaryKey(BusCash record);
}
