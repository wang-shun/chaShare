package com.holley.charging.dao.pob;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.pob.PobNews;
import com.holley.charging.model.pob.PobNewsExample;

public interface PobNewsMapper {

    int countByExample(PobNewsExample example);

    int deleteByExample(PobNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PobNews record);

    int insertSelective(PobNews record);

    List<PobNews> selectByExampleWithBLOBs(PobNewsExample example);

    List<PobNews> selectByExample(PobNewsExample example);

    PobNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PobNews record, @Param("example") PobNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") PobNews record, @Param("example") PobNewsExample example);

    int updateByExample(@Param("record") PobNews record, @Param("example") PobNewsExample example);

    int updateByPrimaryKeySelective(PobNews record);

    int updateByPrimaryKeyWithBLOBs(PobNews record);

    int updateByPrimaryKey(PobNews record);

}
