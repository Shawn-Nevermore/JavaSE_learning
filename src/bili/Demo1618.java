package bili;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.Person;

public class Demo1618 {

	public static void main(String[] args) {

		/**
		 * 数组转换成集合
		 * 不能增删 元素，可以使用集合的其他方法
		 * @param args
		 */
		// demo1();

		// demo2();

		// demo3();

		ArrayList<ArrayList<Person>> list = new ArrayList<>();
		ArrayList<Person> first = new ArrayList<>();

		first.add(new Person("Tom", 12));
	}

	private static void demo2() {
		int[] arr = { 11, 22, 33 };
		List<int[]> list = Arrays.asList(arr);
		System.out.println(list);// 输出：[[I@15db9742]，基本数据类型转换为集合，会将整个数组看成一个对象，所以输出的是地址值

		// 数组转换成集合，必须是引用类型
		Integer[] arr1 = { 11, 22, 33 };
		List<Integer> list1 = Arrays.asList(arr1);
		System.out.println(list1);
	}

	/**
	 * 集合转数组（带泛型）
	 */
	private static void demo3() {
		ArrayList<String> arrList = new ArrayList<>();
		arrList.add("a");
		arrList.add("b");
		arrList.add("c");
		arrList.add("d");
		String[] strArr = arrList.toArray(new String[6]);
		System.out.println(Arrays.toString(strArr));// [a, b, c, d, null, null]
	}

	private static void demo1() {
		String[] arr = { "a", "b", "c" };
		List<String> list = Arrays.asList(arr);
		// list.add("d");//不能添加元素
		list.set(1, "e");
		System.out.println(list);// 可以改
	}
}
