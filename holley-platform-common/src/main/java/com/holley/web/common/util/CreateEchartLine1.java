package com.holley.web.common.util;

import java.util.Iterator;
import java.util.Set;

public class CreateEchartLine1 implements CreateEchart {

    public EchartData createOptingByYear(double[][] chargingMoney, double[] totalMoney, String[] pieData, Set yearData) {

        EchartData eData = new EchartData();
        eData.setLegendData(CreateEchart.legendData2);
        eData.setTitleText("年收益走势统计（元）");
        eData.setTitleX("left");
        eData.setTitleSubtext("按年份统计收益走势");
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
        eData.setTotalMoney(totalMoney);
        eData.setPieData(pieData);
        return eData;
    }

    public EchartData createOptingByMonth(double[][] chargingMoney, double[] totalMoney, String[] pieData) {
        EchartData eData = new EchartData();
        eData.setLegendData(CreateEchart.legendData2);
        eData.setTitleText("月收益走势统计（元）");
        eData.setTitleX("left");
        eData.setTitleSubtext("按月份统计收益走势");
        eData.setxAxisData(CreateEchart.MonthData);
        eData.setTotalMoney(totalMoney);
        eData.setPieData(pieData);
        return eData;
    }

    public EchartData createOptingByQuarter(double[][] chargingMoney, double[] totalMoney, String[] pieData) {
        EchartData eData = new EchartData();
        eData.setLegendData(CreateEchart.legendData2);
        eData.setTitleText("季度收益走势统计（元）");
        eData.setTitleX("left");
        eData.setTitleSubtext("按季度统计收益走势");
        eData.setxAxisData(CreateEchart.QuarterData);
        eData.setTotalMoney(totalMoney);
        eData.setPieData(pieData);
        return eData;
    }

}
