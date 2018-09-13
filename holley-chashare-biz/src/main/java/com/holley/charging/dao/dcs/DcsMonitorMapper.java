package com.holley.charging.dao.dcs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.dcs.DcsMonitorExample;
import com.holley.common.dataobject.charging.dcs.DcsMonitor;

public interface DcsMonitorMapper {

    int countByExample(DcsMonitorExample example);

    int deleteByExample(DcsMonitorExample example);

    int deleteByPrimaryKey(Integer pileId);

    int insert(DcsMonitor record);

    int insertSelective(DcsMonitor record);

    List<DcsMonitor> selectByExample(DcsMonitorExample example);

    DcsMonitor selectByPrimaryKey(Integer pileId);

    int updateByExampleSelective(@Param("record") DcsMonitor record, @Param("example") DcsMonitorExample example);

    int updateByExample(@Param("record") DcsMonitor record, @Param("example") DcsMonitorExample example);

    int updateByPrimaryKeySelective(DcsMonitor record);

    int updateByPrimaryKey(DcsMonitor record);
}
