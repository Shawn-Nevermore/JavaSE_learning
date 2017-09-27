package com.shawn.thread;

public class Demo1_Notify {

	/**
	 * 等待唤醒机制（两个线程间的通信）
	 * 
	 * 本例会形成间隔输出
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Printer p = new Printer();

		new Thread() {
			public void run() {
				while (true) {
					try {
						p.print1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();

		new Thread() {
			public void run() {
				while (true) {
					try {
						p.print2();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();

	}
}

class Printer {

	private int flag = 1;

	// 非静态同步方法的锁对象是this指针
	public synchronized void print1() throws InterruptedException {
		if (flag != 1) {
			this.wait();
		}
		System.out.print("北");
		System.out.print("京");
		System.out.print("欢");
		System.out.print("迎");
		System.out.print("你");
		System.out.print("\r\n");
		flag = 2;
		this.notify();
	}

	public synchronized void print2() throws InterruptedException {
		if (flag != 2) {
			this.wait();
		}
		System.out.print("大");
		System.out.print("吉");
		System.out.print("大");
		System.out.print("利");
		System.out.print("\r\n");
		flag = 1;
		this.notify();
	}

}