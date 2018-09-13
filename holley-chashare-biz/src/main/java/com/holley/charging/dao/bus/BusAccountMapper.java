package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bms.UserAccount;
import com.holley.charging.model.bus.BusAccount;
import com.holley.charging.model.bus.BusAccountExample;

public interface BusAccountMapper {

    int countByExample(BusAccountExample example);

    int deleteByExample(BusAccountExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(BusAccount record);

    int insertSelective(BusAccount record);

    List<BusAccount> selectByExample(BusAccountExample example);

    BusAccount selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") BusAccount record, @Param("example") BusAccountExample example);

    int updateByExample(@Param("record") BusAccount record, @Param("example") BusAccountExample example);

    int updateByPrimaryKeySelective(BusAccount record);

    int updateByPrimaryKey(BusAccount record);


}
