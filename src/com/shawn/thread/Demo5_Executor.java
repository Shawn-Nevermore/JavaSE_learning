package com.shawn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo5_Executor {
	/**
	 * public static ExecutorService newFixedThreadPool(int nThreads)
	 * public static ExecutorService newSingleThreadExecutor()
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
//		将线程放入线程池
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());
		
//		关闭线程池
		pool.shutdown();
		
	}
}
