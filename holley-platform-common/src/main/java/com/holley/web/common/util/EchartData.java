package com.holley.web.common.util;

public class EchartData {

    private String     titleText;    // 主标题
    private String     titleSubtext; // 副标题
    private String     titleX;       // 标题位置center居中
    private String[]   legendData;   // 项目标题
    private String     legendX;      // 项目标题位置
    private String[]   xAxisData;    // 按月，季度，年
    private double[][] chargingMoney; // 金额0:预约费，1服务费，2停车费，3充电费
    private double[]   totalMoney;   // 总金额
    private String[]   PieData;      // 圆饼数据

    public double[] getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double[] totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double[][] getChargingMoney() {
        return chargingMoney;
    }

    public void setChargingMoney(double[][] chargingMoney) {
        this.chargingMoney = chargingMoney;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getTitleSubtext() {
        return titleSubtext;
    }

    public void setTitleSubtext(String titleSubtext) {
        this.titleSubtext = titleSubtext;
    }

    public String getTitleX() {
        return titleX;
    }

    public void setTitleX(String titleX) {
        this.titleX = titleX;
    }

    public String[] getLegendData() {
        return legendData;
    }

    public void setLegendData(String[] legendData) {
        this.legendData = legendData;
    }

    public String getLegendX() {
        return legendX;
    }

    public void setLegendX(String legendX) {
        this.legendX = legendX;
    }

    public String[] getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(String[] xAxisData) {
        this.xAxisData = xAxisData;
    }

    public String[] getPieData() {
        return PieData;
    }

    public void setPieData(String[] pieData) {
        PieData = pieData;
    }

}
