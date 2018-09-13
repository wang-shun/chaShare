package com.holley.charging.service.share;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.holley.charging.model.bus.BusChargeRule;
import com.holley.charging.model.bus.BusChargeRuleExample;
import com.holley.charging.model.bus.BusPayment;
import com.holley.charging.model.bus.BusPaymentExample;
import com.holley.charging.model.bus.BusPileModel;
import com.holley.charging.model.bus.BusPileModelExample;
import com.holley.charging.model.dcs.DcsChargerecord;
import com.holley.charging.model.dcs.DcsChargerecordExample;
import com.holley.charging.model.def.BusPaymentVo;
import com.holley.charging.model.pob.PobChargingPile;
import com.holley.charging.model.pob.PobChargingPileExample;
import com.holley.charging.model.pob.PobChargingStation;
import com.holley.charging.model.pob.PobChargingStationExample;
import com.holley.common.constants.charge.ChargePayStatusEnum;
import com.holley.common.constants.charge.PayWayEnum;
import com.holley.platform.model.sys.SysSecretKey;
import com.holley.platform.model.sys.SysSecretKeyExample;

/**
 * common公共对象服务
 *
 * @author sc
 */
public interface CommonService {

    /**
     * 查询充电站信息列表
     * 
     * @return
     */
    List<PobChargingStation> queryStationInfoByPage(Map<String, Object> param);

    List<PobChargingPile> queryEquipmentInfoByStationId(Integer stationId);

    List<PobChargingPile> queryConnectorInfoByComAddr(String comAddr);

    List<BusPileModel> queryChargeModelByExample(BusPileModelExample example);

    List<PobChargingStation> queryStationByExample(PobChargingStationExample example);

    List<PobChargingPile> queryPileByExample(PobChargingPileExample example);

    List<BusPayment> queryPaymentByExample(BusPaymentExample example);

    List<SysSecretKey> querySysSecretKeyByExample(SysSecretKeyExample example);

    List<BusChargeRule> queryChargeRuleByExample(BusChargeRuleExample example);

    int updatePaymentByPrimaryKeySelective(BusPayment record);

    List<BusPaymentVo> queryEchongPushPayment(Map<String, Object> param);

    int updatePaymentByExampleSelective(BusPayment record, BusPaymentExample example);

    int updatePaymentstatus(String out_trade_no, BigDecimal operateMoney, ChargePayStatusEnum payStatus, PayWayEnum payWay);

    List<DcsChargerecord> queryDcsChargerecordByExample(DcsChargerecordExample example);

    List<String> queryCheckCheckTrade();
}
