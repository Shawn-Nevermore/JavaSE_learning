package com.shawn.thread;

public class Demo2_NotifyAll {
	
	/**
	 * ��������֮��ĵȴ����ѻ���
	 * 
	 * ֪ʶ�㣺whileÿ�ν��жϣ�notifyAllһ�λ������еȴ�
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
 * 1.��ͬ��������У����ĸ������󣬾����ĸ��������wait����
 * 2.Ϊʲôwait()��notify()��Ҫ������Object���У�
 * 		��Ϊ������������������Object����������Ļ��࣬��...
 * 3.sleep()��wait()����
 * 		a.sleep()���봫���������Ϊ˯��ʱ�䣬ʱ�䵽���Զ�����
 * 		  wait()���Դ������Ҳ���Բ�����������������ڲ���������ʱ���ȴ�����������ֱ�ӵȴ�
 * 		b.sleep()��ͬ����������ͬ��������в��ͷ�����wait()�෴
 * @author user
 *
 */
class Printer2 {

	private int flag = 1;

	// �Ǿ�̬ͬ����������������thisָ��
	public void print1() throws InterruptedException {
		synchronized (this) {
			while (flag != 1) {
				this.wait();
			}
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("ӭ");
			System.out.print("��");
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
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
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
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("��");
			System.out.print("\r\n");
			flag = 1;
			this.notifyAll();
		}
	}

}