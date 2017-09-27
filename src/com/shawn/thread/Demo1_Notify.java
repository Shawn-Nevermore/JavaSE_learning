package com.shawn.thread;

public class Demo1_Notify {

	/**
	 * �ȴ����ѻ��ƣ������̼߳��ͨ�ţ�
	 * 
	 * �������γɼ�����
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

	// �Ǿ�̬ͬ����������������thisָ��
	public synchronized void print1() throws InterruptedException {
		if (flag != 1) {
			this.wait();
		}
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("ӭ");
		System.out.print("��");
		System.out.print("\r\n");
		flag = 2;
		this.notify();
	}

	public synchronized void print2() throws InterruptedException {
		if (flag != 2) {
			this.wait();
		}
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("��");
		System.out.print("\r\n");
		flag = 1;
		this.notify();
	}

}