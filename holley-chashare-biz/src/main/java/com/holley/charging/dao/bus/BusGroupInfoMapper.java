package com.holley.charging.dao.bus;

import com.holley.charging.model.bus.BusGroupInfo;
import com.holley.charging.model.bus.BusGroupInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusGroupInfoMapper {
    int countByExample(BusGroupInfoExample example);

    int deleteByExample(BusGroupInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusGroupInfo record);

    int insertSelective(BusGroupInfo record);

    List<BusGroupInfo> selectByExample(BusGroupInfoExample example);

    BusGroupInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusGroupInfo record, @Param("example") BusGroupInfoExample example);

    int updateByExample(@Param("record") BusGroupInfo record, @Param("example") BusGroupInfoExample example);

    int updateByPrimaryKeySelective(BusGroupInfo record);

    int updateByPrimaryKey(BusGroupInfo record);
}