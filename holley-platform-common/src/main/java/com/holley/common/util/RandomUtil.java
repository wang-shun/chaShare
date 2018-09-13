package com.holley.common.util;

import java.util.Random;

public class RandomUtil {

    /**
     * 得到指定长度的随机字符串
     * 
     * @param length
     * @return
     */
    public static String getRandomStr(int length) {
        Random random = new Random();
        char charValue;
        int i = 0;
        char[] charArray = new char[length];
        while (i < length) {
            charValue = (char) random.nextInt(144);
            if ((charValue >= 65 && charValue < 90) || (charValue >= 97 && charValue < 122)) {
                charArray[i] = charValue;
                i++;
            }
        }
        return new String(charArray);

    }

    /**
     * 得到指定长度的随机数字
     * 
     * @param length
     * @return
     */
    public static String getRandomNumber(int length) {
        Random random = new Random();
        char charValue;
        int i = 0;
        char[] charArray = new char[length];
        while (i < length) {
            charValue = (char) random.nextInt(144);
            if (charValue >= 49 && charValue < 57) {
                charArray[i] = charValue;
                i++;
            }
        }
        return new String(charArray);

    }

    /**
     * 测试函数
     * 
     * @param args
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        // int[] indexArr = getRandomIndexArray(16);
        // for (int i = 0; i < indexArr.length; i++) {
        // System.out.println(indexArr[i]);
        // }
        System.out.println(getRandomNumber(4));
        System.out.println(getRandomStr(4));
        // System.out.println(" Passed Time:" + (System.currentTimeMillis() - startTime));
    }
}
