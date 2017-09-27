package com.shawn.syn;

public class Demo1_Synchronized {
	public static void main(String[] args) {
//		demo1();

		new Thread() {
			public void run() {
				while(true) {
					Printer2.print1();
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while(true) {
					Printer2.print2();
				}
			}
		}.start();
		
	}

	private static void demo1() {
		Printer p = new Printer();

		new Thread() {
			public void run() {
				while (true) {
					p.print1();
				}
			}
		}.start();
		
		new Thread() {
			public void run() {
				while (true) {
					p.print2();
				}
			}
		}.start();
	}
}

class Printer {
	
	//非静态同步方法的锁对象是this指针
	public synchronized void print1() {
		System.out.print("北");
		System.out.print("京");
		System.out.print("欢");
		System.out.print("迎");
		System.out.print("你");
		System.out.print("\r\n");
	}

	public synchronized void print2() {
		System.out.print("大");
		System.out.print("吉");
		System.out.print("大");
		System.out.print("利");
		System.out.print("\r\n");
	}
	
	
}

class Printer2 {
	//静态同步方法的锁对象是该类的字节码对象
	public static synchronized void print1() {
			System.out.print("今");
			System.out.print("晚");
			System.out.print("吃");
			System.out.print("鸡");
			System.out.print("\r\n");	
	}
	
	public static void print2() {
		synchronized (Printer2.class) {
			System.out.print("天");
			System.out.print("天");
			System.out.print("向");
			System.out.print("上");
			System.out.print("\r\n");	
		}
	}
	
	
}
