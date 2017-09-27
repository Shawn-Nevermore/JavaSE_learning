package com.shawn.thread;

public class Demo2_NotifyAll {
	
	/**
	 * 三个进程之间的等待唤醒机制
	 * 
	 * 知识点：while每次进判断，notifyAll一次唤醒所有等待
	 * @param args
	 */
	public static void main(String[] args) {
		Printer2 p = new Printer2();

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
 * 1.在同步代码块中，用哪个锁对象，就用哪个对象调用wait方法
 * 2.为什么wait()和notify()需要定义在Object类中？
 * 		因为锁对象可以是任意对象，Object类是所有类的基类，故...
 * 3.sleep()和wait()区别：
 * 		a.sleep()必须传入参数，即为睡眠时间，时间到了自动醒来
 * 		  wait()可以传入参数也可以不传，传入参数就是在参数结束的时间后等待，不传就是直接等待
 * 		b.sleep()在同步函数或者同步代码块中不释放锁，wait()相反
 * @author user
 *
 */
class Printer2 {

	private int flag = 1;

	// 非静态同步方法的锁对象是this指针
	public void print1() throws InterruptedException {
		synchronized (this) {
			while (flag != 1) {
				this.wait();
			}
			System.out.print("北");
			System.out.print("京");
			System.out.print("欢");
			System.out.print("迎");
			System.out.print("你");
			System.out.print("\r\n");
			flag = 2;
			this.notifyAll();
		}
	}

	public void print2() throws InterruptedException {
		synchronized (this) {
			while (flag != 2) {
				this.wait();
			}
			System.out.print("大");
			System.out.print("吉");
			System.out.print("大");
			System.out.print("利");
			System.out.print("\r\n");
			flag = 3;
			this.notifyAll();
		}
	}

	public void print3() throws InterruptedException {
		synchronized (this) {
			while (flag != 3) {
				this.wait();
			}
			System.out.print("今");
			System.out.print("晚");
			System.out.print("吃");
			System.out.print("鸡");
			System.out.print("\r\n");
			flag = 1;
			this.notifyAll();
		}
	}

}