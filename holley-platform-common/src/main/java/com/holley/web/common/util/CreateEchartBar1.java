package com.holley.web.common.util;

import java.util.Iterator;
import java.util.Set;

public class CreateEchartBar1 implements CreateEchart {

    public EchartData createOptingByYear(double[][] chargingMoney, double[] totalMoney, String[] pieData, Set yearData) {

        EchartData eData = new EchartData();
        eData.setLegendData(CreateEchart.legendData);
        eData.setTitleText("年各项费用统计（元）");
        eData.setTitleX("left");
        eData.setTitleSubtext("按年份份统计各项费用");
        if (yearData != null) {
            String[] years = new String[yearData.size()];
            Iterator it = yearData.iterator();
            int x = 0;
            while (it.hasNext()) {
                String year = it.next().toString();
                years[x] = year;
                x++;
            }
            eData.setxAxisData(years);
        }
        eData.setChargingMoney(chargingMoney);
        eData.setPieData(pieData);
        return eData;
    }

    public EchartData createOptingByMonth(double[][] chargingMoney, double[] totalMoney, String[] pieData) {
        EchartData eData = new EchartData();
        eData.setLegendData(CreateEchart.legendData);
        eData.setTitleText("月各项费用统计（元）");
        eData.setTitleX("left");
        eData.setTitleSubtext("按月份统计各项费用");
        eData.setxAxisData(CreateEchart.MonthData);
        eData.setChargingMoney(chargingMoney);
        eData.setPieData(pieData);
        return eData;
    }

    public EchartData createOptingByQuarter(double[][] chargingMoney, double[] totalMoney, String[] pieData) {
        EchartData eData = new EchartData();
        eData.setLegendData(CreateEchart.legendData);
        eData.setTitleText("季度各项费用统计（元）");
        eData.setTitleX("left");
        eData.setTitleSubtext("按季度统计各项费用");
        eData.setxAxisData(CreateEchart.QuarterData);
        eData.setChargingMoney(chargingMoney);
        eData.setPieData(pieData);
        return eData;
    }
}
