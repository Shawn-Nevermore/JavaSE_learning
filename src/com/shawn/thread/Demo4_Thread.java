package com.shawn.thread;

public class Demo4_Thread {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				this.setName("С��");
				for (int i = 0; i < 1000; i++) {
					System.out.println(this.getName() + "...aaaaaaaaaaaa");
				}
			}
		}.start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread().getName() + "...bbb");
				}
			}

		}, "СС").start();

		new Thread("����Ħ��") {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println(this.getName() + ".............");
				}
			}
		}.start();

	}
}
