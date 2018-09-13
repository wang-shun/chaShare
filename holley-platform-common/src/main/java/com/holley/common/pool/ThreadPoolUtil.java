package com.holley.common.pool;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.holley.common.constants.InitParams;
import com.holley.common.constants.TaskStatusEnum;
import com.holley.common.util.DateUtil;


public class ThreadPoolUtil {

	private static ThreadPoolExecutor pool = null;
	private static final String COREPOOLSIZE = "corePoolSize";
	private static final String MAXIMUMPOOLSIZE = "maximumPoolSize";
	private static final String KEEPALIVETIME = "keepAliveTime";
	private static final String QUEUETYPE = "queueType";
	private static final String QUEUESIZE = "queueSize";

	private static ThreadPoolExecutor getPool()
			throws XPathExpressionException, ParserConfigurationException,
			IOException, SAXException {
		if (pool == null) {
			int corePoolSize = Integer.parseInt(InitParams.getThreadPoolParam(
					COREPOOLSIZE).toString());
			int maximumPoolSize = Integer.parseInt(InitParams
					.getThreadPoolParam(MAXIMUMPOOLSIZE).toString());
			int keepAliveTime = Integer.parseInt(InitParams.getThreadPoolParam(
					KEEPALIVETIME).toString());
			String queueType = InitParams.getThreadPoolParam(QUEUETYPE)
					.toString();
			if ("SynchronousQueue".equals(queueType)) {
				pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
						keepAliveTime, TimeUnit.SECONDS,
						new SynchronousQueue<Runnable>());
			} else if ("LinkedBlockingQueue".equals(queueType)) {
				pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
						keepAliveTime, TimeUnit.SECONDS,
						new LinkedBlockingQueue<Runnable>());
			} else if ("ArrayBlockingQueue".equals(queueType)) {
				int queueSize = Integer.parseInt(InitParams.getThreadPoolParam(
						QUEUESIZE).toString());
				pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
						keepAliveTime, TimeUnit.SECONDS,
						new ArrayBlockingQueue<Runnable>(queueSize));

			}
		}
		return pool;
	}

	public static void execute(Runnable command, String jobName) {
		Date now = new Date();
		ThreadInfo threadInfo = new ThreadInfo();
		int index = jobName.indexOf("_");
		if (index >= 0) {
			threadInfo.setModuleName(jobName.substring(0, index));
		} else {
			threadInfo.setModuleName(jobName);
		}
		threadInfo.setStart(now);
		threadInfo.setStatus(TaskStatusEnum.WAITING.getValue());
		threadInfo.setJob(command);

		// clearThreadInfo();
		CachedThreadInfoUtil.put(jobName, threadInfo);

		ThreadPoolExecutor threadPool;
		try {
			threadPool = getPool();
			threadPool.execute(command);
		} catch (Exception e) {
            e.printStackTrace();
		}
	}

	public static List<ThreadInfo> getThreadInfoList(String moduleName) {
		// clearThreadInfo();

		Iterator<String> iterator = CachedThreadInfoUtil.THREADINFO.keySet()
				.iterator();
		List<ThreadInfo> threadInfoList = new LinkedList<ThreadInfo>();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			ThreadInfo value = (ThreadInfo) CachedThreadInfoUtil.get(key);
			if (key.startsWith(moduleName)) {
				threadInfoList.add(value);
			}
		}
		return threadInfoList;
	}

	public static void removeJob(String jobName) {
		ThreadInfo info = CachedThreadInfoUtil.get(jobName);
		if (info != null && info.getJob() != null) {
			try {
				getPool().remove(info.getJob());
				CachedThreadInfoUtil.remove(jobName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void clearThreadInfo() {
		Date twoHourAgo = DateUtil.addHours(new Date(), -2);
		Iterator<String> iterator = CachedThreadInfoUtil.THREADINFO.keySet()
				.iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			ThreadInfo value = (ThreadInfo) CachedThreadInfoUtil.get(key);

			if (value.getStatus() == TaskStatusEnum.FINISH.getValue()
					&& value.getEnd().compareTo(twoHourAgo) < 0) {// 清除
																	// 两小时前的已结束的线程信息
				CachedThreadInfoUtil.remove(key);
				continue;
			}
		}
	}
}
