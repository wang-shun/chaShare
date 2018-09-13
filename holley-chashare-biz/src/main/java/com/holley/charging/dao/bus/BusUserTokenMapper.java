package com.holley.charging.dao.bus;

import com.holley.charging.model.bus.BusUserToken;
import com.holley.charging.model.bus.BusUserTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusUserTokenMapper {
    int countByExample(BusUserTokenExample example);

    int deleteByExample(BusUserTokenExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(BusUserToken record);

    int insertSelective(BusUserToken record);

    List<BusUserToken> selectByExample(BusUserTokenExample example);

    BusUserToken selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") BusUserToken record, @Param("example") BusUserTokenExample example);

    int updateByExample(@Param("record") BusUserToken record, @Param("example") BusUserTokenExample example);

    int updateByPrimaryKeySelective(BusUserToken record);

    int updateByPrimaryKey(BusUserToken record);
}