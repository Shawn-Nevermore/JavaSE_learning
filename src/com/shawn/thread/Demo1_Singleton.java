package com.shawn.thread;

import java.io.IOException;

public class Demo1_Singleton {

	/**
	 * 单例设计模式：保证类在内存中只有一个对象
	 * 
	 * 饿汉式 && 懒汉式： 1.饿汉式是空间换时间，懒汉式是时间换空间。（更推荐饿汉式）
	 * 2.在多线程访问时，饿汉式不会创建多个对象，而懒汉式则可能创建多个对象
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
 * 饿汉式
 * 
 * @author user
 *
 */
class Singleton {
	// 1.私有构造方法
	private Singleton() {

	}

	// 2.创建本类对象
	// (要调用s，需要对象，但是没法创建对象，故需要用类名直接调用，设置为静态)
	// (为了防止s的值被任意篡改，变为Null，故设置为私有)
	private static Singleton s = new Singleton();

	// 3.对外提供公共的访问方法
	public static Singleton getInstance() {
		return s;
	}

}

/**
 * 懒汉式（单例的延迟加载模式，在多线程情况下，有可能创建出两个对象）
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