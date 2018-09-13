package com.holley.web.common.util;

import java.util.Set;

public interface CreateEchart {

    public static final int      year        = 1;                                                                                       // 按年统计
    public static final int      month       = 2;                                                                                       // 按月统计
    public static final int      quarter     = 3;                                                                                       // 按季度统计
    public static final String[] QuarterData = { "第一季度", "第二季度", "第三季度", "第四季度" };
    public static final String[] MonthData   = { "第一月", "第二月", "第三月", "第四月", "第五月", "第六月", "第七月", "第八月", "第九月", "第十月", "第十一月", "第十二月" };
    public static final String[] legendData  = { "充电费", "停车费", "服务费", "预约费" };
    public static final String[] legendData2 = { "收益" };

    /**
     * 按年统计
     * 
     * @return
     */
    EchartData createOptingByYear(double[][] chargingMoney, double[] totalMoney, String[] pieData, Set yearData);

    /**
     * 按月统计
     * 
     * @return
     */
    EchartData createOptingByMonth(double[][] chargingMoney, double[] totalMoney, String[] pieData);

    /**
     * 按季度统计
     * 
     * @return
     */
    EchartData createOptingByQuarter(double[][] chargingMoney, double[] totalMoney, String[] pieData);
}
