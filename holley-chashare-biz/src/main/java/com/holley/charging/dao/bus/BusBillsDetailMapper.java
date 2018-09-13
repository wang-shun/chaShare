package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bms.BillsDetail;
import com.holley.charging.model.bms.BillsDetailIn;
import com.holley.charging.model.bus.BusBillsDetail;
import com.holley.charging.model.bus.BusBillsDetailExample;

public interface BusBillsDetailMapper {

    int countByExample(BusBillsDetailExample example);

    int deleteByExample(BusBillsDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusBillsDetail record);

    int insertSelective(BusBillsDetail record);

    List<BusBillsDetail> selectByExample(BusBillsDetailExample example);

    BusBillsDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusBillsDetail record, @Param("example") BusBillsDetailExample example);

    int updateByExample(@Param("record") BusBillsDetail record, @Param("example") BusBillsDetailExample example);

    int updateByPrimaryKeySelective(BusBillsDetail record);

    int updateByPrimaryKey(BusBillsDetail record);

}
