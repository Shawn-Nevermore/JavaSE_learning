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
	
	//�Ǿ�̬ͬ����������������thisָ��
	public synchronized void print1() {
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("ӭ");
		System.out.print("��");
		System.out.print("\r\n");
	}

	public synchronized void print2() {
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("\r\n");
	}
	
	
}

class Printer2 {
	//��̬ͬ���������������Ǹ�����ֽ������
	public static synchronized void print1() {
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("\r\n");	
	}
	
	public static void print2() {
		synchronized (Printer2.class) {
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("\r\n");	
		}
	}
	
	
}
