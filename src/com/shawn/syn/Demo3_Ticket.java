package com.shawn.syn;

public class Demo3_Ticket {

	/**
	 * 模拟铁路售票，100张，通过4个窗口卖完
	 * 
	 * 知识点：访问同一资源，考虑线程安全
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// demo1();

		// 就创建了一次对象
		Ticket1 t = new Ticket1();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}

	private static void demo1() {
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
		new Ticket().start();
	}
}

class Ticket extends Thread {

	// 四个线程共享同一资源，用静态成员
	private static int ticket = 100;

	@Override
	public void run() {

		while (true) {
			synchronized (Ticket.class) {
				if (ticket <= 0) {
					break;
				}
				try {
					sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(getName() + "...窗口卖出的第" + ticket-- + "号票");
			}
		}
	}

}

class Ticket1 implements Runnable {

	private int ticket = 100;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (Ticket.class) {
				if (ticket <= 0) {
					break;
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "...窗口卖出的第" + ticket-- + "号票");
			}
		}
	}

}
