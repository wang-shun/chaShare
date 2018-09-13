package com.holley.charging.service.shareImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.holley.charging.dao.bus.BusChargeRuleMapper;
import com.holley.charging.dao.bus.BusPaymentMapper;
import com.holley.charging.dao.bus.BusPileModelMapper;
import com.holley.charging.dao.dcs.DcsChargerecordMapper;
import com.holley.charging.dao.pob.PobChargingPileMapper;
import com.holley.charging.dao.pob.PobChargingStationMapper;
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
import com.holley.charging.service.share.CommonService;
import com.holley.common.constants.charge.ChargePayStatusEnum;
import com.holley.common.constants.charge.PayWayEnum;
import com.holley.platform.dao.sys.SysSecretKeyMapper;
import com.holley.platform.model.sys.SysSecretKey;
import com.holley.platform.model.sys.SysSecretKeyExample;

/**
 * common公共对象服务
 *
 * @author sc
 */
public class CommonServiceImpl implements CommonService {

    private final static Logger      logger = Logger.getLogger(CommonServiceImpl.class);
    @Resource
    private PobChargingStationMapper pobChargingStationMapper;
    @Resource
    private PobChargingPileMapper    pobChargingPileMapper;
    @Resource
    private BusPileModelMapper       busPileModelMapper;
    @Resource
    private BusPaymentMapper         busPaymentMapper;
    @Resource
    private SysSecretKeyMapper       sysSecretKeyMapper;
    @Resource
    private BusChargeRuleMapper      busChargeRuleMapper;
    @Resource
    private DcsChargerecordMapper    dcsChargerecordMapper;

    @Override
    public List<PobChargingStation> queryStationInfoByPage(Map<String, Object> param) {
        return pobChargingStationMapper.queryStationInfoByPage(param);
    }

    @Override
    public List<PobChargingPile> queryEquipmentInfoByStationId(Integer stationId) {
        return pobChargingPileMapper.queryEquipmentInfoByStationId(stationId);
    }

    @Override
    public List<PobChargingPile> queryConnectorInfoByComAddr(String comAddr) {
        PobChargingPileExample emp = new PobChargingPileExample();
        PobChargingPileExample.Criteria cr = emp.createCriteria();
        cr.andComAddrEqualTo(comAddr);
        List<PobChargingPile> list = pobChargingPileMapper.selectByExample(emp);
        return list;
    }

    @Override
    public List<BusPileModel> queryChargeModelByExample(BusPileModelExample example) {
        return busPileModelMapper.selectByExample(example);
    }

    @Override
    public List<PobChargingStation> queryStationByExample(PobChargingStationExample example) {
        return pobChargingStationMapper.selectByExample(example);
    }

    @Override
    public List<PobChargingPile> queryPileByExample(PobChargingPileExample example) {
        return pobChargingPileMapper.selectByExample(example);
    }

    @Override
    public List<BusPayment> queryPaymentByExample(BusPaymentExample example) {
        return busPaymentMapper.selectByExample(example);
    }

    @Override
    public List<SysSecretKey> querySysSecretKeyByExample(SysSecretKeyExample example) {
        return sysSecretKeyMapper.selectByExample(example);
    }

    @Override
    public List<BusChargeRule> queryChargeRuleByExample(BusChargeRuleExample example) {
        return busChargeRuleMapper.selectByExample(example);
    }

    @Override
    public int updatePaymentByPrimaryKeySelective(BusPayment record) {
        return busPaymentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<BusPaymentVo> queryEchongPushPayment(Map<String, Object> param) {
        return busPaymentMapper.queryEchongPushPayment(param);
    }

    @Override
    public int updatePaymentByExampleSelective(BusPayment record, BusPaymentExample example) {
        return busPaymentMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updatePaymentstatus(String out_trade_no, BigDecimal operateMoney, ChargePayStatusEnum payStatus, PayWayEnum payWay) {
        // 更新充电缴费记录的支付状态
        int result = 0;
        String tradeNo = out_trade_no != null ? out_trade_no : "";
        BusPaymentExample emp = new BusPaymentExample();
        BusPaymentExample.Criteria cr = emp.createCriteria();
        cr.andTradeNoEqualTo(tradeNo);
        List<BusPayment> list = queryPaymentByExample(emp);
        if (list == null || list.size() == 0) {
            logger.info("tradeNo:" + tradeNo + ",充电记录不存在!不处理...");
            return 0;
        }
        BusPayment record = list.get(0);
        if (ChargePayStatusEnum.SUCCESS.getShortValue().equals(record.getPayStatus())) {
            logger.info("tradeNo:" + tradeNo + ",充电记录的支付状态已经为成功!不处理...");
            return 0;
        }

        if (!payStatus.getShortValue().equals(record.getPayStatus())) {
            BusPayment item = new BusPayment();
            item.setId(record.getId());
            item.setPayStatus(payStatus.getShortValue());
            if (operateMoney != null) {
                item.setActualMoney(operateMoney);
            }
            item.setAccountInfo("echong网");
            item.setUpdateTime(new Date());
            item.setPayWay(payWay.getShortValue());
            result += updatePaymentByPrimaryKeySelective(item);
        }
        return result;
    }

    @Override
    public List<DcsChargerecord> queryDcsChargerecordByExample(DcsChargerecordExample example) {
        return dcsChargerecordMapper.selectByExample(example);
    }

    @Override
    public List<String> queryCheckCheckTrade() {
        return busPaymentMapper.queryCheckCheckTrade();
    }

}
