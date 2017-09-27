package com.shawn.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo3_ReentrantLock {
	public static void main(String[] args) {
		Printer3 p = new Printer3();

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

		new Thread() {
			public void run() {
				while (true) {
					try {
						p.print3();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}

/**
 * 互斥锁
 * 
 * @author user
 *
 */
class Printer3 {

	private ReentrantLock r = new ReentrantLock();
	// 针对每一个互斥锁创建一个监视器
	private Condition c1 = r.newCondition();
	private Condition c2 = r.newCondition();
	private Condition c3 = r.newCondition();

	private int flag = 1;

	public void print1() throws InterruptedException {
		r.lock(); // 获取锁
		if (flag != 1) {
			c1.await();
		}
		System.out.print("北");
		System.out.print("京");
		System.out.print("欢");
		System.out.print("迎");
		System.out.print("你");
		System.out.print("\r\n");
		flag = 2;
		c2.signal();
		r.unlock(); // 释放锁
	}

	public void print2() throws InterruptedException {
		r.lock();
		if (flag != 2) {
			c2.await();
		}
		System.out.print("大");
		System.out.print("吉");
		System.out.print("大");
		System.out.print("利");
		System.out.print("\r\n");
		flag = 3;
		c3.signal();
		r.unlock();
	}

	public void print3() throws InterruptedException {
		r.lock();
		if (flag != 3) {
			c3.await();
		}
		System.out.print("今");
		System.out.print("晚");
		System.out.print("吃");
		System.out.print("鸡");
		System.out.print("\r\n");
		flag = 1;
		c1.signal();
		r.unlock();
	}

}