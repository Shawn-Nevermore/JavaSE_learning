package bili;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dao.Person;

public class Demo1618 {

	public static void main(String[] args) {

		/**
		 * ����ת���ɼ���
		 * ������ɾ Ԫ�أ�����ʹ�ü��ϵ���������
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
		System.out.println(list);// �����[[I@15db9742]��������������ת��Ϊ���ϣ��Ὣ�������鿴��һ����������������ǵ�ֵַ

		// ����ת���ɼ��ϣ���������������
		Integer[] arr1 = { 11, 22, 33 };
		List<Integer> list1 = Arrays.asList(arr1);
		System.out.println(list1);
	}

	/**
	 * ����ת���飨�����ͣ�
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
		// list.add("d");//�������Ԫ��
		list.set(1, "e");
		System.out.println(list);// ���Ը�
	}
}
