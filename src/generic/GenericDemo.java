package generic;

import java.util.ArrayList;

import dao.Person;
import dao.Student;
import dao.Tool;

public class GenericDemo implements tempInter<String> {

	public static void main(String[] args) {
		// demo1();

		// demo2();

		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("a");
		arrayList.add("b");
		arrayList.add("b");
		arrayList.add("c");
		arrayList.add("d");
		/*
				// 1.普通for删除，索引要--
				for (int i = 0; i < arrayList.size(); i++) {
					if ("b".equals(arrayList.get(i))) {
						arrayList.remove(i--); // i如果不加--遇到重复元素，遇到重复元素会跳过
					}
				}
		
		*/
		/*
				// 2.迭代器删除
				Iterator<String> it = arrayList.iterator();
				while (it.hasNext()) {
					if ("b".equals(it.next())) {
						// list.remove("b");//会出现并发修改异常
						it.remove();
					}
				}
				
				for (Iterator<String> iterator = arrayList.iterator(); iterator.hasNext();) {
					if ("b".equals(it.next())) {
						// list.remove("b");//会出现并发修改异常
						it.remove();
				}
		
		*/

		// 3.增强for循环，不能删除，只能遍历（并发修改异常）

	}

	/**
	 * A.泛型通配符<?>：
	 * 		任意类型，如果没有明确，那么就是Object以及任意类型的Java类了
	 * B.? extends E
	 * 		向下限定，E及其子类
	 * C.? super E
	 * 		向上限定，E及其父类
	 * 		
	 */
	private static void demo2() {
		// List<?> list = new ArrayList<String>();//当右边类型不确定时，左边可以指定为？
		ArrayList<Person> list1 = new ArrayList<>();
		list1.add(new Person("Tom", 12));
		list1.add(new Person("Shawn", 22));
		list1.add(new Person("Geek", 32));
		list1.add(new Person("Steam", 42));
		list1.add(new Person("Lol", 52));

		ArrayList<Student> list2 = new ArrayList<>();
		list2.add(new Student("张三", 19));
		list2.add(new Student("李四", 19));

		list1.addAll(list2);// addAll(Collection<? extends E> c)
							// 必须list2的泛型继承了list1的泛型
		System.out.println(list1);
	}

	private static void demo1() {
		Tool<String> t = new Tool<>(); // 1.7新特性，后面可以不写，菱形泛型
		t.show("String");
		t.show(100);
	}

	@Override
	public void print(String t) {
		// TODO Auto-generated method stub

	}

}

interface tempInter<T> {
	public void print(T t);
}
