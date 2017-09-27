package com.shawn.syn;

public class Demo3_Ticket {

	/**
	 * ģ����·��Ʊ��100�ţ�ͨ��4����������
	 * 
	 * ֪ʶ�㣺����ͬһ��Դ�������̰߳�ȫ
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// demo1();

		// �ʹ�����һ�ζ���
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

	// �ĸ��̹߳���ͬһ��Դ���þ�̬��Ա
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
				System.out.println(getName() + "...���������ĵ�" + ticket-- + "��Ʊ");
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
				System.out.println(Thread.currentThread().getName() + "...���������ĵ�" + ticket-- + "��Ʊ");
			}
		}
	}

}
