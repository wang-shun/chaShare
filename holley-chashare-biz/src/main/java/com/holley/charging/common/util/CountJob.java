package com.holley.charging.common.util;

import java.util.concurrent.TimeUnit;

import com.holley.common.constants.Globals;

/**
 * Description: 用于1秒内计数
 *
 * @author shen.cheng@holley.cn
 */
public class CountJob implements Runnable {

    private boolean isRun = true;

    @Override
    public void run() {

        while (isRun) {
            try {
                if (Globals.TIME_STTEMP > 0) {
                    if ((System.currentTimeMillis() - Globals.TIME_STTEMP) > 999) {
                        Globals.TIME_STTEMP = 0;
                        Globals.COUNT_TIME = 0;
                    }
                }
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
