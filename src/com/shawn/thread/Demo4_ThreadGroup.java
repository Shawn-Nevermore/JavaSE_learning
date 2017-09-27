package com.shawn.thread;

public class Demo4_ThreadGroup {
	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("�߳���1");
		MyRunnable mr = new MyRunnable();
		
		Thread t1 = new Thread(tg, mr, "����");
		Thread t2 = new Thread(tg, mr, "����");
		
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