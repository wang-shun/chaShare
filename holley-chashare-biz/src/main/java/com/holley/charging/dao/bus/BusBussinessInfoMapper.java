package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusBussinessInfo;
import com.holley.charging.model.bus.BusBussinessInfoExample;

public interface BusBussinessInfoMapper {

    int countByExample(BusBussinessInfoExample example);

    int deleteByExample(BusBussinessInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusBussinessInfo record);

    int insertSelective(BusBussinessInfo record);

    List<BusBussinessInfo> selectByExample(BusBussinessInfoExample example);

    BusBussinessInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusBussinessInfo record, @Param("example") BusBussinessInfoExample example);

    int updateByExample(@Param("record") BusBussinessInfo record, @Param("example") BusBussinessInfoExample example);

    int updateByPrimaryKeySelective(BusBussinessInfo record);

    int updateByPrimaryKey(BusBussinessInfo record);

}
