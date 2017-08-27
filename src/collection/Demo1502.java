package collection;

import java.util.ArrayList;
import java.util.Collection;

import dao.Person;

/**
 * A.集合的由来
 * B.数组和集合的区别：
 * 		1.类型：数组既能存基本数据类型，也能存引用数据类型（地址值）
 * 		2.长度：数组长度恒定，集合长度可变
 * C.什么时候用？
 * 		元素个数固定用数组（连续空间，效率更高），不固定用集合（底层实现会不断扩容，原来的对象变成了垃圾，较占内存）
 * Collection
 * 		List:有序，有索引，可重复
 * 			ArrayList：数组实现
 * 			LinkedList：链表实现
 * 			Vector：数组实现
 * 		Set：无序，无索引，不能重复
 * 			HashSet：哈希		
 * 			TreeSet：二叉树
 * 	
 * 	
 * 
 * @author 先生
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Demo1502 {

	public static void main(String[] args) {
		// addDemo();

		// demo1();

		// demo2(c);

		// demo3();

		Collection c1 = new ArrayList();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");

		Collection c2 = new ArrayList();
		c2.add("a");
		c2.add("c");
		c2.add("z");

		c1.addAll(c2);
		// c1.add(c2);// 将c2当作一个元素添加到c1
		System.out.println(c1);

		c1.removeAll(c2);
		System.out.println(c1);// 删除的是交集，没有交集返回false，c1值不变

		boolean b1 = c1.containsAll(c2);
		System.out.println(b1);

		boolean b2 = c1.retainAll(c2);
		System.out.println(b2);// true，没交集（只要c1改变就返回true，）
		System.out.println(c1);

	}

	private static void demo3() {
		Collection c = new ArrayList();
		c.add(new Person("Tom", 11));
		c.add(new Person("Tommy", 12));
		c.add(new Person("Jim", 15));
		c.add(new Person("John", 1));

		Object[] arr = c.toArray();// Person向上转型成Object，多态的弊端：无法调用子类特有的方法
		/*for (Object i : arr) {
			System.out.println(i);
		}*/
		for (int S = 0; S < arr.length; S++) {
			Person p = (Person) arr[S];// 向下转型，才能访问Person中的方法，能完成更多的诸如赋值传参等操作，更灵活
			System.out.println(p.getName() + "..." + p.getAge());
		}
	}

	private static void demo2(Collection c) {
		Object[] arr = c.toArray();
		for (Object i : arr) {
			System.out.println(i);
		}
	}

	private static void demo1(Collection c) {

		// c.remove(100);
		// c.clear();
		System.out.println(c.contains(100));
		System.out.println(c.isEmpty());
		System.out.println(c.size());
	}

	// add方法如果是List会一直返回true，因为任意类型可重复；如果是set，重复添加元素会返回false
	private static void addDemo() {
		Collection c = new ArrayList();
		boolean b1 = c.add("abc");
		boolean b2 = c.add(false);// 自动装箱new Boolean(false)
		boolean b3 = c.add(100);// new Integer(100)
		boolean b4 = c.add(new Person("Tom", 12));
		System.out.println(b1);// true,作为顶层类，Collection的add方法永远返回true
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(c);// [abc, false, 100, Person [name=Tom, age=12]]，说明ArrayList的父类中有重写toString 方法
	}

}
