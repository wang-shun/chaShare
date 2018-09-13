package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusFavorites;
import com.holley.charging.model.bus.BusFavoritesExample;

public interface BusFavoritesMapper {

    int countByExample(BusFavoritesExample example);

    int deleteByExample(BusFavoritesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusFavorites record);

    int insertSelective(BusFavorites record);

    List<BusFavorites> selectByExample(BusFavoritesExample example);

    BusFavorites selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusFavorites record, @Param("example") BusFavoritesExample example);

    int updateByExample(@Param("record") BusFavorites record, @Param("example") BusFavoritesExample example);

    int updateByPrimaryKeySelective(BusFavorites record);

    int updateByPrimaryKey(BusFavorites record);

}
