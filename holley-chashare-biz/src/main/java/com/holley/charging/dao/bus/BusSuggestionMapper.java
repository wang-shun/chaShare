package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusSuggestion;
import com.holley.charging.model.bus.BusSuggestionExample;
import com.holley.charging.model.bus.BusSuggestionKey;

public interface BusSuggestionMapper {

    int countByExample(BusSuggestionExample example);

    int deleteByExample(BusSuggestionExample example);

    int deleteByPrimaryKey(BusSuggestionKey key);

    int insert(BusSuggestion record);

    int insertSelective(BusSuggestion record);

    List<BusSuggestion> selectByExample(BusSuggestionExample example);

    BusSuggestion selectByPrimaryKey(BusSuggestionKey key);

    int updateByExampleSelective(@Param("record") BusSuggestion record, @Param("example") BusSuggestionExample example);

    int updateByExample(@Param("record") BusSuggestion record, @Param("example") BusSuggestionExample example);

    int updateByPrimaryKeySelective(BusSuggestion record);

    int updateByPrimaryKey(BusSuggestion record);

}
