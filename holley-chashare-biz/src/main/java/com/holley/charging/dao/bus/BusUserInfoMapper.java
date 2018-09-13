package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bms.UserRealIntro;
import com.holley.charging.model.bus.BusUserInfo;
import com.holley.charging.model.bus.BusUserInfoExample;

public interface BusUserInfoMapper {

    int countByExample(BusUserInfoExample example);

    int deleteByExample(BusUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusUserInfo record);

    int insertSelective(BusUserInfo record);

    List<BusUserInfo> selectByExample(BusUserInfoExample example);

    BusUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusUserInfo record, @Param("example") BusUserInfoExample example);

    int updateByExample(@Param("record") BusUserInfo record, @Param("example") BusUserInfoExample example);

    int updateByPrimaryKeySelective(BusUserInfo record);

    int updateByPrimaryKey(BusUserInfo record);


}
