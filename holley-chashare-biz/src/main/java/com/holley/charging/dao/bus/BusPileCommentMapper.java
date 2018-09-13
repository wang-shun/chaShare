package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusPileComment;
import com.holley.charging.model.bus.BusPileCommentExample;

public interface BusPileCommentMapper {

    int countByExample(BusPileCommentExample example);

    int deleteByExample(BusPileCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusPileComment record);

    int insertSelective(BusPileComment record);

    List<BusPileComment> selectByExample(BusPileCommentExample example);

    BusPileComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusPileComment record, @Param("example") BusPileCommentExample example);

    int updateByExample(@Param("record") BusPileComment record, @Param("example") BusPileCommentExample example);

    int updateByPrimaryKeySelective(BusPileComment record);

    int updateByPrimaryKey(BusPileComment record);

}
