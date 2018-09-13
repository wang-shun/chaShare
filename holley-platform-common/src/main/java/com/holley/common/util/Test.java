package com.holley.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Test {

    public String                  name    = "sc";

    private static long            timeOut = 2;                              // 秒

    private static ExecutorService service = Executors.newCachedThreadPool();

    public static void executor(Runnable task) {
        service.execute(task);
    }

    public static String call(Callable<String> task) {
        Future<String> f = service.submit(task);
        try {
            // System.out.println(f.isDone());
            if (f.isDone()) {
                return f.get(timeOut, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static void stopExecutor() {
        service.shutdown();
    }

    /**
     * 返回文件夹下所有文件
     * 
     * @param path
     * @return
     */
    public static List<File> getFiles(String path) {
        File root = new File("d:\\logs");
        File[] files = root.listFiles();
        List<File> fileList = new ArrayList<File>();
        if (!root.isDirectory()) {
            fileList.add(root);
        } else {
            for (File f : files) {
                fileList.add(f);
            }
        }
        return fileList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Exception {
        Class c = Class.forName("com.holley.common.util.Test");
        Test cc = null;
        long start = System.currentTimeMillis();
        System.out.println(start);
        for (int x = 0; x < Integer.MAX_VALUE; x++) {
            cc = new Test();
            cc.setName("sss");
        }
        long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println((end - start) / 1000);
    }
}

class ThreadTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "hello";
    }

}

class GZIPUtil {

    public static File pack(List<File> sources, File target) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TarArchiveOutputStream os = new TarArchiveOutputStream(out);
        return null;
    }
}

class Dog {

    String name;

    public Dog() {
    };

    private static ExecutorService executor = Executors.newCachedThreadPool(new ThreadFactory() {

                                                @Override
                                                public Thread newThread(Runnable r) {
                                                    Thread thread = new Thread(r);
                                                    thread.setName("test");
                                                    thread.setDaemon(true);
                                                    return thread;
                                                }

                                            });

    // 有返回
    public static <T> T call(Callable<?> task, TimeUnit unit, long time) {
        Future<?> fu = executor.submit(task);
        Object callBean = null;
        try {
            callBean = fu.get(time, unit);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (T) callBean;
    }

    // 无返回
    public static void call(Runnable task, TimeUnit unit, long time) {
        Future<?> fu = executor.submit(task);
        try {
            fu.get(time, unit);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Bussiness {

    static boolean isThreadSub = true;

    public synchronized void sub(int i) {

        while (!isThreadSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 1; j <= 5; j++) {
            System.out.println("sub: " + j + " of loop " + i);
        }

        isThreadSub = false;
        this.notify();

    }

    public synchronized void main(int i) {

        while (isThreadSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 1; j <= 5; j++) {
            System.out.println("main: " + j + " of loop " + i);
        }

        isThreadSub = true;
        this.notify();

    }

}
