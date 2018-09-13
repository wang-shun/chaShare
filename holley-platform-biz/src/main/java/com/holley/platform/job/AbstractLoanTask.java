package com.holley.platform.job;

import org.apache.log4j.Logger;

public class AbstractLoanTask implements LoanTask {
	private Logger logger = Logger.getLogger(AbstractLoanTask.class);
	private boolean isRun = true;
	public Thread task = new Thread("task"){
		public void run(){
			logger.info(this.getName()+"任务启动。。。");
			while(isRun){
				doLoan();
				doWait();
			}

		}
	};
	public AbstractLoanTask(){
		task.start();
	}
	@Override
	public void doLoan() {
		logger.info("doloan...");

	}

	@Override
	public void doWait() {
		Object lock = this.getLock();
		logger.info("task.doWait");
		//logger.info("lock:"+lock.toString());
		synchronized(lock){
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void stop() {
		this.isRun = false;

	}

	@Override
	public Object getLock() {
		return this.BASE_LOCK;
	}

	@Override
	public void execute() {
		Object lock = this.getLock();
		logger.info("task.execute");
	//	logger.info("lock:"+lock.toString());
		synchronized(lock){
			lock.notifyAll();
		}
	}

}
