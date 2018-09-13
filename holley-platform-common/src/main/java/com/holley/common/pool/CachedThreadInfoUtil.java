package com.holley.common.pool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachedThreadInfoUtil {

    public static final Map<String, ThreadInfo> THREADINFO = new ConcurrentHashMap<String, ThreadInfo>(); // 线程运行信息

    public static ThreadInfo get(String jobName) {
        return THREADINFO.get(jobName);
    }

    public static void put(String jobName, ThreadInfo threadInfo) {
        THREADINFO.put(jobName, threadInfo);
    }

    public static void remove(String jobName) {
        THREADINFO.remove(jobName);
    }

    public static boolean isExist(String jobName) {
        return THREADINFO.containsKey(jobName);
    }
}
