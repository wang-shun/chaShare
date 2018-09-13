package com.holley.charging.dao.bus;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusAppointment;
import com.holley.charging.model.bus.BusAppointmentExample;

public interface BusAppointmentMapper {

    int countByExample(BusAppointmentExample example);

    int deleteByExample(BusAppointmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusAppointment record);

    int insertSelective(BusAppointment record);

    List<BusAppointment> selectByExample(BusAppointmentExample example);

    BusAppointment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusAppointment record, @Param("example") BusAppointmentExample example);

    int updateByExample(@Param("record") BusAppointment record, @Param("example") BusAppointmentExample example);

    int updateByPrimaryKeySelective(BusAppointment record);

    int updateByPrimaryKey(BusAppointment record);

}
