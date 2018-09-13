package com.holley.charging.model.def;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 对账基类 Description:
 *
 * @author shen.cheng@holley.cn
 */
public class CheckChargeOrdersBase {

    @JSONField(name = "CheckOrderSeq")
    private String            checkOrderSeq;                                 // 订单对账流水
    @JSONField(name = "StartTime")
    private String            startTime;                                     // 账单开始时间
    @JSONField(name = "EndTime")
    private String            endTime;                                       // 账单结束时间
    @JSONField(name = "OrderCount")
    private int               orderCount;                                    // 订单数量
    @JSONField(name = "TotalOrderPower")
    private BigDecimal        totalOrderPower = BigDecimal.ZERO;             // 总电量
    @JSONField(name = "TotalOrderMoney")
    private BigDecimal        totalOrderMoney = BigDecimal.ZERO;             // 总金额
    @JSONField(name = "ChargeOrders")
    private List<ChargeOrder> cargeOrders     = new ArrayList<ChargeOrder>(); // 具体订单

    public String getCheckOrderSeq() {
        return checkOrderSeq;
    }

    public void setCheckOrderSeq(String checkOrderSeq) {
        this.checkOrderSeq = checkOrderSeq;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(int orderCount) {
        this.orderCount = orderCount;
    }

    public BigDecimal getTotalOrderPower() {
        return totalOrderPower;
    }

    public void setTotalOrderPower(BigDecimal totalOrderPower) {
        this.totalOrderPower = totalOrderPower;
    }

    public BigDecimal getTotalOrderMoney() {
        return totalOrderMoney;
    }

    public void setTotalOrderMoney(BigDecimal totalOrderMoney) {
        this.totalOrderMoney = totalOrderMoney;
    }

    public List<ChargeOrder> getCargeOrders() {
        return cargeOrders;
    }

    public void setCargeOrders(List<ChargeOrder> cargeOrders) {
        this.cargeOrders = cargeOrders;
    }

}
