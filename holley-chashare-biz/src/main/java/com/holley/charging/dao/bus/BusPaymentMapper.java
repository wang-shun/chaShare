package com.holley.charging.dao.bus;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.charging.model.bus.BusPayment;
import com.holley.charging.model.bus.BusPaymentExample;
import com.holley.charging.model.def.BusPaymentVo;

public interface BusPaymentMapper {

    int countByExample(BusPaymentExample example);

    int deleteByExample(BusPaymentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BusPayment record);

    int insertSelective(BusPayment record);

    List<BusPayment> selectByExample(BusPaymentExample example);

    BusPayment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BusPayment record, @Param("example") BusPaymentExample example);

    int updateByExample(@Param("record") BusPayment record, @Param("example") BusPaymentExample example);

    int updateByPrimaryKeySelective(BusPayment record);

    int updateByPrimaryKey(BusPayment record);

    // ADD
    // public String sumChargePowerByPileId(Integer pileId);

    /**
     * e充网推送账单
     * 
     * @param param
     * @return
     */
    List<BusPaymentVo> queryEchongPushPayment(Map<String, Object> param);

    List<String> queryCheckCheckTrade();
}
