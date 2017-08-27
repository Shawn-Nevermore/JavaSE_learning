package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
public class ListDemo {
	public static void main(String[] args) {
		// demo1();

		// demo2();

		/*
				System.out.println(deleteDuplicatedEle(list));
				ArrayList newList = newDeleteDuplicatedEle(list);
				System.out.println(newList);
		*/
		/*
		List list = new ArrayList();
		list.add(new Person("Tom", 12));
		list.add(new Person("Tom", 12));
		list.add(new Person("Tom", 12));
		list.add(new Person("Harry", 22));
		list.add(new Person("Harry", 22));
		list.add(new Person("Harry", 22));
		
		ArrayList newList = deleteDupObj(list);
		System.out.println(newList);
		*/

		StackDemo stack = new StackDemo();
		stack.in("a");
		stack.in("b");
		stack.in("c");
		stack.in("d");

		System.out.println(stack.out());
		System.out.println(stack.out());
		System.out.println(stack.out());

		System.out.println(stack.isEmpty());
	}

	public static ArrayList deleteDupObj(List list) {
		ArrayList arrayList = new ArrayList();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (!arrayList.contains(obj)) {// contains 判断是否包含，底层用的是Person中的equals方法。remove方法也是依赖equals方法
				arrayList.add(obj);
			}
		}

		return arrayList;
	}

	/**
	 * 去除ArrayList中的重复元素
	 * 思路：创建一个新集合，通过判断去重
	 * 我自己的实现方式，没有用迭代器
	 * @param list
	 * @return
	 */
	private static ArrayList deleteDuplicatedEle(List list) {
		ArrayList li = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			if (li.contains(list.get(i))) {// 直接if(! li.contains(list.get(i))){li.add(list.get(i))}更好
				continue;
			} else {
				li.add(list.get(i));
			}

		}
		return li;
	}

	private static ArrayList newDeleteDuplicatedEle(List list) {
		ArrayList arrayList = new ArrayList();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			if (!arrayList.contains(obj)) {
				arrayList.add(obj);
			}
		}

		return arrayList;
	}

	// 改查
	private static void demo2() {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		// 遍历1：
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

		System.out.println("-------------");
		// 遍历2：
		for (Object i : list) {
			System.out.print(i + " ");
		}

		System.out.println("-------------");
		list.set(3, 100);
		System.out.println(list);
	}

	// 增删
	private static void demo1() {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add(2, "e");
		list.add(100);// 自动装箱 new Integer(100)
		System.out.println(list.get(5) instanceof Integer);
		// list.add(5, "e");// index超过size，会有下标越界异常
		System.out.println(list);

		// list.remove(100);// 100是下标，删除的时候不会自动装箱，而是被当作索引值
		Object obj = list.remove(2);
		System.out.println("被删除的是：" + obj);
		System.out.println(list);
	}

}
