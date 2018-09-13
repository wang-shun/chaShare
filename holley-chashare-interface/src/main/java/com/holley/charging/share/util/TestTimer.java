package com.holley.charging.share.util;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;

public class TestTimer {

    public static void main(String[] args) throws ParseException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        threadPool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("ok1");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        threadPool.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("ok2");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Scheduled(cron = "*/2 * * * * ?")
    public void test1() throws InterruptedException {
        for (int x = 0; x < 5; x++) {
            System.out.println("test1:" + x);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void test2() {
        System.out.println("test2:");
    }
}
