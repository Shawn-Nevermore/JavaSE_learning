package com.shawn.thread;

public class Demo4_ThreadGroup {
	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("线程组1");
		MyRunnable mr = new MyRunnable();
		
		Thread t1 = new Thread(tg, mr, "张三");
		Thread t2 = new Thread(tg, mr, "李四");
		
		System.out.println(t1.getThreadGroup().getName());
		System.out.println(t2.getThreadGroup().getName());
		
		tg.setDaemon(true);
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "..." + i);
		}
	}

}