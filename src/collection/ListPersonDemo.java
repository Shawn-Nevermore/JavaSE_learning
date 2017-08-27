package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import dao.Person;

@SuppressWarnings({ "rawtypes" })
public class ListPersonDemo {
	public static void main(String[] args) {

		List list = new ArrayList();
		list.add("a");// Object obj = new String("a");
		list.add("b");
		list.add("c");
		list.add("world");
		list.add("e");
		list.add("world");

		// demo1();

		// listIteratorDemo(list);

		demo2(list);
	}

	/**
	 * hasPrevious() 和 previous()配合向前遍历。
	 * @param list
	 */
	private static void demo2(List list) {
		ListIterator li = list.listIterator();
		while (li.hasNext()) {
			System.out.println(li.next());
		}
		while (li.hasPrevious()) {// 已经在队列最前
			System.out.println(li.previous());// 没有任何输出
		}
		System.out.println(list);

	}

	/**
	 * 一个集合，如果里面有"world"元素，就添加一个"javaee"元素
	 */
	private static void listIteratorDemo(List list) {
		/*
				Iterator it = list.iterator();
				while (it.hasNext()) {
					String str = (String) it.next();
					if ("world".equals(str)) {// 确定存在的字符串写前面
						list.add("javaee");// ConcurrentModificationException:遍历的过程中修改，产生并发冲突
					}
				}
		*/
		// List特有的迭代器，可以避免并发冲突
		ListIterator li = list.listIterator();
		while (li.hasNext()) {
			String str = (String) li.next();
			if ("world".equals(str)) {
				// list.add("javaee");// ConcurrentModificationException:遍历的过程中修改，产生并发冲突
				li.add("javaee");
			}
		}
		System.out.println(list);
	}

	/**
	 * 引用类型数据的遍历
	 */
	private static void demo1() {
		List list = new ArrayList();

		list.add(new Person("Hell", 12));// Object o = new Person();
		list.add(new Person("Tom", 22));
		list.add(new Person("Linda", 17));
		list.add(new Person("Hehe", 14));

		for (int i = 0; i < list.size(); i++) {
			Person p = (Person) list.get(i);
			System.out.println(p.getName() + "..." + p.getAge());
		}
	}
}
