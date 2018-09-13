package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusPileModel;
import com.holley.charging.model.bus.BusPileModelExample;

public interface BusPileModelMapper {

    int countByExample(BusPileModelExample example);

    int deleteByExample(BusPileModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusPileModel record);

    int insertSelective(BusPileModel record);

    List<BusPileModel> selectByExample(BusPileModelExample example);

    BusPileModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusPileModel record, @Param("example") BusPileModelExample example);

    int updateByExample(@Param("record") BusPileModel record, @Param("example") BusPileModelExample example);

    int updateByPrimaryKeySelective(BusPileModel record);

    int updateByPrimaryKey(BusPileModel record);

}
