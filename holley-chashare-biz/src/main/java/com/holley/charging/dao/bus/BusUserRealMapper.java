package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusUserReal;
import com.holley.charging.model.bus.BusUserRealExample;
import com.holley.charging.model.bus.BusUserRealKey;

public interface BusUserRealMapper {

    int countByExample(BusUserRealExample example);

    int deleteByExample(BusUserRealExample example);

    int deleteByPrimaryKey(BusUserRealKey key);

    int insert(BusUserReal record);

    int insertSelective(BusUserReal record);

    List<BusUserReal> selectByExample(BusUserRealExample example);

    BusUserReal selectByPrimaryKey(BusUserRealKey key);

    int updateByExampleSelective(@Param("record") BusUserReal record, @Param("example") BusUserRealExample example);

    int updateByExample(@Param("record") BusUserReal record, @Param("example") BusUserRealExample example);

    int updateByPrimaryKeySelective(BusUserReal record);

    int updateByPrimaryKey(BusUserReal record);
}
