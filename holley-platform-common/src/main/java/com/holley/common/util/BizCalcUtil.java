package com.holley.common.util;


public class BizCalcUtil {

    /**
     * 计算不平衡率
     * 
     * @param LineType 线路类型
     * @param ValueA A相值
     * @param ValueB B相值
     * @param ValueC C相值
     * @return
     */
    public static double getRat(int LineType, double ValueA, double ValueB, double ValueC) {
        double max = 0.0, ran = 0.0, rat = 0.0;
        if (LineType == 0)// 三相三线
        {
            ran = (ValueA + ValueC) / 2;// 平均
            max = (Math.abs(ValueA - ran) > Math.abs(ValueC - ran)) ? Math.abs(ValueA - ran) : Math.abs(ValueC - ran);// 最大
        } else if (LineType == 1)// 三相四线
        {
            ran = (ValueA + ValueB + ValueC) / 3;
            max = (Math.abs(ValueA - ran) > Math.abs(ValueC - ran)) ? Math.abs(ValueA - ran) : Math.abs(ValueC - ran);// 最大
            max = (max > Math.abs(ValueB - ran)) ? max : Math.abs(ValueB - ran);
        } else if (LineType == 2)// 单相
        {
            max = 0;
            ran = ValueA;
        }

        if (ran != 0.0) {
            rat = 100.0 * max / ran;
        }
        return rat;
    }
    
}
