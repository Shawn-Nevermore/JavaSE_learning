package com.shawn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo6_Callable {
	
	/**
	 * 使用Callable创建多线程
	 * @param args
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Future<Integer> result1 = pool.submit(new MyCallable(100));
		Future<Integer> result2 = pool.submit(new MyCallable(20));
		
		System.out.println(result1.get());
		System.out.println(result2.get());
		
		pool.shutdown();
	}
}

class MyCallable implements Callable<Integer> {

	private int num;

	public MyCallable(int num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum += i;
		}
		return sum;
	}

}