package collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import dao.Student;

/**
 * A.Map集合的功能概述(Set的底层实现是用Map来实现，查看Set的添加方法源码。Map中所有的算法针对的是键，不是值，比如hash算法针对的是键)
 * 	a.添加功能
 * 		V put(K key, V value)：添加元素
 * 			如果键是第一次存储，就直接存储元素，返回null
 * 			如果键不是第一次存储，就用值把以前的值替换掉，返回以前的值
 * 	b.删除功能
 * 		void clear()：清空所有元素
 * 		V remove(Object key)：根据键去删除键值对元素，并把值返回
 * 	c.判断功能
 * 		boolean containsKey(key)
 * 		boolean containsValue(value)
 * 		boolean isEmpty()
 * 	d.获取功能
 * 		Set<Map.Entry<K,V>> entrySet():
 * 		V get(Object key)
 * 		Set<K> keySet()
 * 		Collection<V> values()
 * 	e.长度功能
 * 		int size()
 * @author 先生
 *
 */
public class MapDemo {
	public static void main(String[] args) {
		// putRemoveDemo();

		// demo1();

		// Map<String, Integer> map = keySetDemo();

		// entrySetDemo();

		// demo2();

		// demo3();

		// treeMapDemo();

		// String s = "aaaaabbbeeededddfcc";
		// count(s);

		demo4();
	}

	/**
	 * HashMap的嵌套
	 */
	private static void demo4() {

		HashMap<String, Integer> hm1 = new HashMap<>();
		hm1.put("iG", 2);
		hm1.put("Navi", 1);
		hm1.put("Alliance", 3);
		hm1.put("Newbee", 4);
		hm1.put("EG", 5);

		HashMap<String, Integer> hm2 = new HashMap<>();
		hm2.put("Wings", 6);
		hm2.put("Liquid", 7);
		hm2.put("LGD", 8);

		HashMap<HashMap<String, Integer>, String> hm = new HashMap<>();
		hm.put(hm1, "1");
		hm.put(hm2, "2");

		for (HashMap<String, Integer> map : hm.keySet()) {
			for (String s : map.keySet()) {
				System.out.println(s + " wins Aiges in Ti" + map.get(s));
			}

		}

	}

	/**
	 * 案例：统计字符串中每个字符出现的次数
	 * 
	 * 思路：
	 * 	1.转换成字符数组
	 * 	2.建立HashMap，字符为键，次数为值。若某字符第一次存入，则值为1，再次尝试存入同一字符，则值++
	 * 	3.遍历输出结果
	 * @param string
	 * 
	 */
	public static void count(String string) {

		char[] cArr = string.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();

		for (char c : cArr) {
			// 如果hm的keySet中包含c，则c对应的次数+1
			hm.put(c, hm.containsKey(c) ? hm.get(c) + 1 : 1);
		}

		System.out.println(hm);
	}

	public static void treeMapDemo() {
		// TreeMap的自然排序
		TreeMap<Student, String> thm1 = new TreeMap<>();

		thm1.put(new Student("张三", 18), "四川");
		thm1.put(new Student("张三", 18), "北京");
		thm1.put(new Student("李四", 28), "北京");
		thm1.put(new Student("王五", 20), "上海");
		// System.out.println(thm); // Student类需实现Comparable接口，重写Compare方法（按年龄比较）

		// TreeMap的比较器排序
		TreeMap<Student, String> thm2 = new TreeMap<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				int num = o1.getName().compareTo(o2.getName()); // 主要按姓名比较
				return num == 0 ? o1.getAge() - o2.getAge() : num;
			}
		});
		thm2.put(new Student("张三", 18), "四川");
		thm2.put(new Student("张三", 18), "北京");
		thm2.put(new Student("李四", 28), "北京");
		thm2.put(new Student("王五", 20), "上海");
		System.out.println(thm2);
	}

	public static void demo3() {
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		lhm.put("iG", 2);
		lhm.put("Navi", 1);
		lhm.put("Alliance", 3);
		lhm.put("Newbee", 4);
		lhm.put("EG", 5);
		lhm.put("Wings", 6);
		System.out.println(lhm);
	}

	/**
	 * HashMap键是自定义类的案例（看如何保证唯一性）
	 * 	键：Student对象，代表每一个学生
	 *	值：字符串对象，代表学生的归属地
	 */
	public static void demo2() {
		HashMap<Student, String> hm = new HashMap<>();
		hm.put(new Student("张三", 18), "四川");
		hm.put(new Student("张三", 18), "北京");
		hm.put(new Student("李四", 28), "北京");
		hm.put(new Student("王五", 20), "上海");
		/*		
				for (Map.Entry<Student, String> entry : hm.entrySet()) {
					System.out.println(entry.getKey() + "属于..." + entry.getValue());
				}
		*/
		System.out.println(hm);// Student类需要重写equals()和hashCode()方法才能保证键的唯一性
	}

	public static void entrySetDemo() {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("iG", 2);
		hm.put("Navi", 1);
		hm.put("Alliance", 3);
		hm.put("Newbee", 4);
		hm.put("EG", 5);
		hm.put("Wings", 6);

		// 2.通过键值对对象获取键和值
		// Map.Entry说明Entry是Map的内部接口，将键和值封装成了Entry对象，并存储在Set中
		/*		System.out.println("------------Map.Entry 迭代器--------------");
				Set<Map.Entry<String, Integer>> entrySet = hm.entrySet();
				// 获取每一个对象
				Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
				while (iterator.hasNext()) {
					// 获取每一个Entry对象
					Map.Entry<String, Integer> entry = iterator.next();// 父类引用指向子类对象
					String key = entry.getKey();
					int value = entry.getValue();
					System.out.println(key + "=" + value);
				}
		*/
		// 增强for
		System.out.println("------------Map.Entry 增强for--------------");
		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}

	public static Map<String, Integer> keySetDemo() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Tom", 18);
		map.put("Tim", 28);
		map.put("Shawn", 18);
		map.put("Sara", 8);
		map.put("Henry", 10);

		// 1.通过KeySet来遍历
		// 迭代器遍历
		System.out.println("------------KeySet迭代器--------------");
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();// 获取键
			int value = map.get(key);// 获取值
			System.out.println(key + "=" + value);
		}

		// 增强for
		System.out.println("------------KeySet 增强for--------------");
		for (String key : map.keySet()) {
			System.out.println(key + "=" + map.get(key));
		}
		return map;
	}

	/**
	 * Collection<Integer> -- map.values()
	 * map.size()
	 */
	private static void demo1() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Tom", 18);
		map.put("Tim", 28);
		map.put("Shawn", 18);
		map.put("Sara", 8);
		map.put("Henry", 10);

		Collection<Integer> c = map.values();
		System.out.println(c);
		System.out.println(map.size());
	}

	/**
	 * 增删
	 */
	private static void putRemoveDemo() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Tom", 18);
		map.put("Tim", 28);
		map.put("Shawn", 38);
		map.put("Sara", 8);
		map.put("Henry", 10);
		Integer i = map.put("Tom", 20);// "Tom"已存在，覆盖原值 ，并返回18
		System.out.println(i);

		Integer val1 = map.remove("Henry");
		System.out.println(val1);// 10
		System.out.println(map);
	}
}
