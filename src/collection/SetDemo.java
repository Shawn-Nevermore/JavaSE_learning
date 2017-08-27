package collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import dao.Person;

public class SetDemo {

	public static void main(String[] args) {
		// demo1();

		// hashSetDemo();

		// linkedHashSetDemo();

		// getRandomNum(1, 20, 10);

		/*//test��ȥ���ַ����е��ظ��ַ�		
				String s = deDupString("aafweeeabvvvvbb");
				System.out.println(s);
		
		*/

		/*
				List<String> list = new ArrayList<String>();
				list.add("a");
				list.add("b");
				list.add("b");
				list.add("a");
				list.add("c");
				list.add("e");
				
				System.out.println(deDupEle(list));
		*/

		// treeSetDemo();

		// treeSetComparatorDemo();

		/*
				List<String> list = new ArrayList<>();
				list.add("adbe");
				list.add("be");
				list.add("bee");
				list.add("be");
				list.add("efwefwe");
				list.add("e");
				list.add("ccc");
				list.add("cc");
		
				sortDupString(list);
				System.out.println(list);
		*/

		String s1 = sortString("woyaocaonima");
		System.out.println(s1);

	}

	/**
	 * ���󣺽����ַ�������������ֵ仯����
	 * 
	 * ˼·��
	 * 	1.��TreeSet����String
	 * 	2.ת��Ϊchar[]����
	 * 	2.����һ��Comparator������������
	 * 	4.ƴ�ӳ��ַ������أ���StringBuilder
	 * @param string
	 * @return
	 */
	public static String sortString(String string) {

		StringBuilder sb = new StringBuilder();
		char[] cArr = string.toCharArray();

		TreeSet<Character> ts = new TreeSet<>(new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				int num = o1 - o2;// �Զ�����
				// int num1 = o1.compareTo(o2);//�ײ�ʵ�ֺ�o1-o2һ��
				return num == 0 ? 1 : num;
			}
		});

		for (char c : cArr) {// �Զ�װ��
			ts.add(c);
		}
		for (Character character : ts) {
			sb.append(character);
		}

		return sb.toString();
	}

	/**
	 * �����ڼ����д洢���������ظ����ַ���������һ�����������������ֵ�˳�򣩣����Ҳ���ȥ�ظ�
	 * 
	 * ˼·��
	 * 	1.��TreeSet����List�е������ַ���
	 * 	2.����һ��Comparator������compare�����㶨��Ϊ0
	 * 	3.ԭlist��գ�����addAll�����ַ���
	 * @param list
	 * @return
	 */
	public static void sortDupString(List<String> list) {
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {// �����ڲ���

			@Override
			public int compare(String o1, String o2) {
				int num = o1.compareTo(o2);
				return num == 0 ? 1 : num;

			}
		});
		ts.addAll(list);
		list.clear();
		list.addAll(ts);
	}

	/**
	 * TreeSet�ıȽ�������
	 * ���ַ������ȴ洢
	 * 		TreeSet<String> tSet = new TreeSet<String>(new CompareByLen());
	 * 		
	 */
	private static void treeSetComparatorDemo() {
		// ����Comparator�����������TreeSet�Ͱ��ձȽ�������
		// add()�����ڲ����Զ�����Comparator�ӿڵ�compare()������������
		TreeSet<String> tSet = new TreeSet<String>(new CompareByLen());
		tSet.add("aaaaaaaaaa");
		tSet.add("asdf");
		tSet.add("asde");
		tSet.add("bb");
		tSet.add("e");
		System.out.println(tSet);

	}

	/**
	 * TreeSet
	 * 		������������Ԫ�ؽ��������
	 * 		�ײ��ö�����ʵ�֣�����������������������������������ȾͲ��棨0��
	 * 		��������δ洢ȡ����compareTo�����ķ���ֵ
	 * ��compareTo����0��ʱ�򣬼�����ֻ��һ��Ԫ��
	 * ��compareTo����������ʱ�򣬼����д�ȡ˳��һ��
	 * ��compareTo����������ʱ�򣬼����д�ȡ˳���෴
	 */
	private static void treeSetDemo() {
		// ��Ȼ˳��Comparable��:add()������Ѵ���Ķ�������ΪComparable���͡�
		// ��ˣ��ڴ洢Person�����ʱ����ҪPersonʵ��Comparable�ӿڣ���дcompareTo������
		// ����ľ��������ǣ���Ҫ��������������������ͬ���Ƚ������ַ�����
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("Tom", 12));
		ts.add(new Person("Shawn", 22));
		ts.add(new Person("Dick", 11));
		ts.add(new Person("Vivi", 11));//
		ts.add(new Person("Penis", 13));
		System.out.println(ts);
	}

	/**
	 * ȥ���������ظ���Ԫ�أ�Ҳ��������һ��Listͨ���������ʵ�֣�
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> List<T> deDupEle(List<T> list) {// ��һ��<T>�Ǿ�̬��������ģ���������List�Լ���

		LinkedHashSet<T> set = new LinkedHashSet<>();// ԭ��������������򷵻�
		set.addAll(list);
		list.clear();
		list.addAll(set);

		return list;
	}

	/**
	 * ȥ���ַ����е��ظ��ַ�
	 * @param str
	 * @return
	 */
	public static String deDupString(String str) {
		StringBuilder sb = new StringBuilder();
		// 1.���ַ���ת��Ϊ�ַ�����
		char[] cArr = str.toCharArray();
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		// 2.���ַ������е�Ԫ���������LinkedHashSet��
		for (char c : cArr) {
			set.add(c);
		}
		// 3.��HashSet�е�ֵƴ�ӵ�StringBuilder��
		for (Character character : set) {
			sb.append(character);
		}

		// 4.ת��ΪString���
		return sb.toString();
	}

	/**
	 * ���󣺱�дһ�����򣬻�ȡ10��1~20���������Ҫ����������ظ�
	 * 
	 * ������
	 * 		1.Random�ഴ�����������
	 * 		2.��hashSet�洢
	 * 		3.���hashSet��sizeС��10�Ͳ��ϴ洢��>=10��ֹͣ�洢
	 * 		4.ͨ��Random���е�nextInt()�������������������ӵ�HashSet��
	 * 		5.���� HashSet
	 */
	public static void getRandomNum(int min, int max, int n) {
		if (n > max - min + 1 || min > max) {
			return;
		}

		// 1.Random�ഴ�����������
		Random r = new Random();
		// 2.��hashSet�洢
		HashSet<Integer> hs = new HashSet<>();
		// 3.���hashSet��sizeС��10�Ͳ��ϴ洢��>=10��ֹͣ�洢
		while (hs.size() < n) {
			// 4.ͨ��Random���е�nextInt()�������������������ӵ�HashSet��
			hs.add(r.nextInt(max) + min);

			// ��һ�ֲ���������ķ���
			// int i = (int) Math.round(Math.random() * (max - min) + min);
			// hs.add(i);
		}
		// 5.���� HashSet
		for (Integer integer : hs) {
			System.out.println(integer);
		}
	}

	/**
	 * LinkedHashSet
	 * 		�ײ�������ʵ�֣���set��Ψһ�ܱ�֤��ȡһ�µ�
	 * 		�������Ժ�HashSetһ��
	 */
	private static void linkedHashSetDemo() {

		LinkedHashSet<String> lhs = new LinkedHashSet<>();
		lhs.add("a");
		lhs.add("a");
		lhs.add("b");
		lhs.add("b");
		lhs.add("c");
		lhs.add("c");
		lhs.add("c");
		System.out.println(lhs);
	}

	/**
	 * HashSet
	 * 		�����������ظ�������(��ȡ��һ��)
	 * ԭ��
	 * 		����ʹ��Set���϶���Ҫȥ�ظ�������ڴ洢��ʱ�����equals�Ƚϣ�Ч�ʽϵͣ���ϣ�㷨�����ȥ�ظ���Ч�ʣ�������ʹ��equals()�����Ĵ���
	 * 		��HashSet����add����ʱ����ʵ���ȵ��ö����hashCode()�����õ�һ����ϣֵ��Ȼ���ڼ��������Ƿ�����ͬ��ϣֵ�Ķ���
	 * ���Զ�����Ķ������HashCodeȥ�ظ�
	 * 		���б�����дhashCode()��equals()����
	 * 		hashCode():������ͬ����ֵһ����ͬ�����Բ�ͬ������ͬ
	 * 		equals():������ȫ��ͬ����true
	 * @author ����
	 *
	 */
	private static void hashSetDemo() {
		HashSet<Person> hs = new HashSet<>();
		hs.add(new Person("Tom", 12));
		hs.add(new Person("Tom", 12));
		hs.add(new Person("Tim", 22));
		hs.add(new Person("Tim", 22));
		hs.add(new Person("Tim", 22));
		hs.add(new Person("Shawn", 32));

		for (Person person : hs) {// ��Ҫ��дPerson��hashCode��equals��������Ȼ������ظ�Ԫ��
			System.out.println(person.getName() + "..." + person.getAge());
		}

		System.out.println((2 << 4) - 1);
	}

	/**
	 * HashSet��add()������ӻ������������Լ�String����
	 */
	private static void demo1() {
		HashSet<String> hs = new HashSet<>();
		boolean b1 = hs.add("b");
		boolean b2 = hs.add("b");
		hs.add("d");
		hs.add("a");
		hs.add("f");
		hs.add("e");
		System.out.println(b1);
		System.out.println(b2);// false

		System.out.println(hs);// HashSet�ļ̳���ϵ������дtoString����

		for (String string : hs) {
			System.out.println(string);
		}
	}
}

class CompareByLen implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int num = o1.length() - o2.length();

		return num == 0 ? o1.compareTo(o2) : num;
	}

}
