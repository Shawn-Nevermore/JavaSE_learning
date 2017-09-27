package com.shawn.thread;

import java.io.IOException;

public class Demo1_Singleton {

	/**
	 * �������ģʽ����֤�����ڴ���ֻ��һ������
	 * 
	 * ����ʽ && ����ʽ�� 1.����ʽ�ǿռ任ʱ�䣬����ʽ��ʱ�任�ռ䡣�����Ƽ�����ʽ��
	 * 2.�ڶ��̷߳���ʱ������ʽ���ᴴ��������󣬶�����ʽ����ܴ����������
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// demo1();
		// demo2();
		
		Runtime rt = Runtime.getRuntime();
//		rt.exec("shutdown -s -t 300");
		rt.exec("shutdown -a");
	}

	private static void demo2() {
		Singleton_x s1 = Singleton_x.s;
		Singleton_x s2 = Singleton_x.s;
		System.out.println(s1 == s2);
	}

	private static void demo1() {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println(s1 == s2);
	}
}

/**
 * ����ʽ
 * 
 * @author user
 *
 */
class Singleton {
	// 1.˽�й��췽��
	private Singleton() {

	}

	// 2.�����������
	// (Ҫ����s����Ҫ���󣬵���û���������󣬹���Ҫ������ֱ�ӵ��ã�����Ϊ��̬)
	// (Ϊ�˷�ֹs��ֵ������۸ģ���ΪNull��������Ϊ˽��)
	private static Singleton s = new Singleton();

	// 3.�����ṩ�����ķ��ʷ���
	public static Singleton getInstance() {
		return s;
	}

}

/**
 * ����ʽ���������ӳټ���ģʽ���ڶ��߳�����£��п��ܴ�������������
 * 
 * @author user
 *
 */
class Singleton1 {
	private Singleton1() {
	}

	private static Singleton1 s;

	public static Singleton1 getInstance() {
		if (s == null) {
			s = new Singleton1();
		}
		return s;

	}
}

class Singleton_x {
	private Singleton_x() {
	}

	public static final Singleton_x s = new Singleton_x();
}