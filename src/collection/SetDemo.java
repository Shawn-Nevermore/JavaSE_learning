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

		/*//test：去掉字符串中的重复字符		
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
	 * 需求：接收字符串，对其进行字典化排序
	 * 
	 * 思路：
	 * 	1.用TreeSet接收String
	 * 	2.转化为char[]数组
	 * 	2.定义一个Comparator，对数组排序
	 * 	4.拼接成字符串返回，用StringBuilder
	 * @param string
	 * @return
	 */
	public static String sortString(String string) {

		StringBuilder sb = new StringBuilder();
		char[] cArr = string.toCharArray();

		TreeSet<Character> ts = new TreeSet<>(new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				int num = o1 - o2;// 自动拆箱
				// int num1 = o1.compareTo(o2);//底层实现和o1-o2一样
				return num == 0 ? 1 : num;
			}
		});

		for (char c : cArr) {// 自动装箱
			ts.add(c);
		}
		for (Character character : ts) {
			sb.append(character);
		}

		return sb.toString();
	}

	/**
	 * 需求：在集合中存储了无序且重复的字符串，定义一个方法，让其有序（字典顺序），并且不能去重复
	 * 
	 * 思路：
	 * 	1.用TreeSet接收List中的所有字符串
	 * 	2.定义一个Comparator，让其compare方法恒定不为0
	 * 	3.原list清空，重新addAll所有字符串
	 * @param list
	 * @return
	 */
	public static void sortDupString(List<String> list) {
		TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {// 匿名内部类

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
	 * TreeSet的比较器排序
	 * 按字符串长度存储
	 * 		TreeSet<String> tSet = new TreeSet<String>(new CompareByLen());
	 * 		
	 */
	private static void treeSetComparatorDemo() {
		// 传入Comparator的子类对象，则TreeSet就按照比较器排序。
		// add()方法内部会自动调用Comparator接口的compare()方法进行排序
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
	 * 		是用来给对象元素进行排序的
	 * 		底层用二叉树实现，负数存在左子树，整数存在右子树，相等就不存（0）
	 * 		集合中如何存储取决于compareTo方法的返回值
	 * 当compareTo返回0的时候，集合中只有一个元素
	 * 当compareTo返回整数的时候，集合中存取顺序一致
	 * 当compareTo返回整数的时候，集合中存取顺序相反
	 */
	private static void treeSetDemo() {
		// 自然顺序（Comparable）:add()方法会把存入的对象提升为Comparable类型。
		// 因此，在存储Person类对象时，需要Person实现Comparable接口，重写compareTo方法。
		// 这里的具体做法是：主要按照年龄排序。若年龄相同，比较姓名字符串。
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person("Tom", 12));
		ts.add(new Person("Shawn", 22));
		ts.add(new Person("Dick", 11));
		ts.add(new Person("Vivi", 11));//
		ts.add(new Person("Penis", 13));
		System.out.println(ts);
	}

	/**
	 * 去掉集合中重复的元素（也可以用另一个List通过判重添加实现）
	 * @param <T>
	 * @param t
	 * @return
	 */
	public static <T> List<T> deDupEle(List<T> list) {// 第一个<T>是静态方法必须的，后两个是List自己的

		LinkedHashSet<T> set = new LinkedHashSet<>();// 原集合有序，最好有序返回
		set.addAll(list);
		list.clear();
		list.addAll(set);

		return list;
	}

	/**
	 * 去掉字符串中的重复字符
	 * @param str
	 * @return
	 */
	public static String deDupString(String str) {
		StringBuilder sb = new StringBuilder();
		// 1.将字符串转化为字符数组
		char[] cArr = str.toCharArray();
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		// 2.将字符数组中的元素逐个存入LinkedHashSet中
		for (char c : cArr) {
			set.add(c);
		}
		// 3.将HashSet中的值拼接到StringBuilder中
		for (Character character : set) {
			sb.append(character);
		}

		// 4.转换为String输出
		return sb.toString();
	}

	/**
	 * 需求：编写一个程序，获取10个1~20的随机数，要求随机数不重复
	 * 
	 * 分析：
	 * 		1.Random类创建随机数对象
	 * 		2.用hashSet存储
	 * 		3.如果hashSet的size小于10就不断存储，>=10就停止存储
	 * 		4.通过Random类中的nextInt()方法，将所得随机数添加到HashSet中
	 * 		5.遍历 HashSet
	 */
	public static void getRandomNum(int min, int max, int n) {
		if (n > max - min + 1 || min > max) {
			return;
		}

		// 1.Random类创建随机数对象
		Random r = new Random();
		// 2.用hashSet存储
		HashSet<Integer> hs = new HashSet<>();
		// 3.如果hashSet的size小于10就不断存储，>=10就停止存储
		while (hs.size() < n) {
			// 4.通过Random类中的nextInt()方法，将所得随机数添加到HashSet中
			hs.add(r.nextInt(max) + min);

			// 另一种产生随机数的方法
			// int i = (int) Math.round(Math.random() * (max - min) + min);
			// hs.add(i);
		}
		// 5.遍历 HashSet
		for (Integer integer : hs) {
			System.out.println(integer);
		}
	}

	/**
	 * LinkedHashSet
	 * 		底层是链表实现，是set中唯一能保证存取一致的
	 * 		其他特性和HashSet一致
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
	 * 		无索引，不重复，无序(存取不一致)
	 * 原理：
	 * 		我们使用Set集合都需要去重复，如果在存储的时候逐个equals比较，效率较低，哈希算法提高了去重复的效率，降低了使用equals()方法的次数
	 * 		当HashSet调用add方法时，其实是先调用对象的hashCode()方法得到一个哈希值，然后在集合中找是否含有相同哈希值的对象
	 * 将自定义类的对象存入HashCode去重复
	 * 		类中必须重写hashCode()和equals()方法
	 * 		hashCode():属性相同返回值一定相同，属性不同尽量不同
	 * 		equals():属性完全相同返回true
	 * @author 先生
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

		for (Person person : hs) {// 需要重写Person的hashCode和equals方法，不然会添加重复元素
			System.out.println(person.getName() + "..." + person.getAge());
		}

		System.out.println((2 << 4) - 1);
	}

	/**
	 * HashSet的add()方法添加基本类型数据以及String对象
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

		System.out.println(hs);// HashSet的继承体系中有重写toString方法

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
