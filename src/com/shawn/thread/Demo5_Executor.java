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
		
//		���̷߳����̳߳�
		pool.submit(new MyRunnable());
		pool.submit(new MyRunnable());
		
//		�ر��̳߳�
		pool.shutdown();
		
	}
}
