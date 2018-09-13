package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bms.UserReceipt;
import com.holley.charging.model.bus.BusUserReceipt;
import com.holley.charging.model.bus.BusUserReceiptExample;

public interface BusUserReceiptMapper {

    int countByExample(BusUserReceiptExample example);

    int deleteByExample(BusUserReceiptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusUserReceipt record);

    int insertSelective(BusUserReceipt record);

    List<BusUserReceipt> selectByExample(BusUserReceiptExample example);

    BusUserReceipt selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusUserReceipt record, @Param("example") BusUserReceiptExample example);

    int updateByExample(@Param("record") BusUserReceipt record, @Param("example") BusUserReceiptExample example);

    int updateByPrimaryKeySelective(BusUserReceipt record);

    int updateByPrimaryKey(BusUserReceipt record);

}
