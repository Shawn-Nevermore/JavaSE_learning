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
 * A.Map���ϵĹ��ܸ���(Set�ĵײ�ʵ������Map��ʵ�֣��鿴Set����ӷ���Դ�롣Map�����е��㷨��Ե��Ǽ�������ֵ������hash�㷨��Ե��Ǽ�)
 * 	a.��ӹ���
 * 		V put(K key, V value)�����Ԫ��
 * 			������ǵ�һ�δ洢����ֱ�Ӵ洢Ԫ�أ�����null
 * 			��������ǵ�һ�δ洢������ֵ����ǰ��ֵ�滻����������ǰ��ֵ
 * 	b.ɾ������
 * 		void clear()���������Ԫ��
 * 		V remove(Object key)�����ݼ�ȥɾ����ֵ��Ԫ�أ�����ֵ����
 * 	c.�жϹ���
 * 		boolean containsKey(key)
 * 		boolean containsValue(value)
 * 		boolean isEmpty()
 * 	d.��ȡ����
 * 		Set<Map.Entry<K,V>> entrySet():
 * 		V get(Object key)
 * 		Set<K> keySet()
 * 		Collection<V> values()
 * 	e.���ȹ���
 * 		int size()
 * @author ����
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
	 * HashMap��Ƕ��
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
	 * ������ͳ���ַ�����ÿ���ַ����ֵĴ���
	 * 
	 * ˼·��
	 * 	1.ת�����ַ�����
	 * 	2.����HashMap���ַ�Ϊ��������Ϊֵ����ĳ�ַ���һ�δ��룬��ֵΪ1���ٴγ��Դ���ͬһ�ַ�����ֵ++
	 * 	3.����������
	 * @param string
	 * 
	 */
	public static void count(String string) {

		char[] cArr = string.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();

		for (char c : cArr) {
			// ���hm��keySet�а���c����c��Ӧ�Ĵ���+1
			hm.put(c, hm.containsKey(c) ? hm.get(c) + 1 : 1);
		}

		System.out.println(hm);
	}

	public static void treeMapDemo() {
		// TreeMap����Ȼ����
		TreeMap<Student, String> thm1 = new TreeMap<>();

		thm1.put(new Student("����", 18), "�Ĵ�");
		thm1.put(new Student("����", 18), "����");
		thm1.put(new Student("����", 28), "����");
		thm1.put(new Student("����", 20), "�Ϻ�");
		// System.out.println(thm); // Student����ʵ��Comparable�ӿڣ���дCompare������������Ƚϣ�

		// TreeMap�ıȽ�������
		TreeMap<Student, String> thm2 = new TreeMap<>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				int num = o1.getName().compareTo(o2.getName()); // ��Ҫ�������Ƚ�
				return num == 0 ? o1.getAge() - o2.getAge() : num;
			}
		});
		thm2.put(new Student("����", 18), "�Ĵ�");
		thm2.put(new Student("����", 18), "����");
		thm2.put(new Student("����", 28), "����");
		thm2.put(new Student("����", 20), "�Ϻ�");
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
	 * HashMap�����Զ�����İ���������α�֤Ψһ�ԣ�
	 * 	����Student���󣬴���ÿһ��ѧ��
	 *	ֵ���ַ������󣬴���ѧ���Ĺ�����
	 */
	public static void demo2() {
		HashMap<Student, String> hm = new HashMap<>();
		hm.put(new Student("����", 18), "�Ĵ�");
		hm.put(new Student("����", 18), "����");
		hm.put(new Student("����", 28), "����");
		hm.put(new Student("����", 20), "�Ϻ�");
		/*		
				for (Map.Entry<Student, String> entry : hm.entrySet()) {
					System.out.println(entry.getKey() + "����..." + entry.getValue());
				}
		*/
		System.out.println(hm);// Student����Ҫ��дequals()��hashCode()�������ܱ�֤����Ψһ��
	}

	public static void entrySetDemo() {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("iG", 2);
		hm.put("Navi", 1);
		hm.put("Alliance", 3);
		hm.put("Newbee", 4);
		hm.put("EG", 5);
		hm.put("Wings", 6);

		// 2.ͨ����ֵ�Զ����ȡ����ֵ
		// Map.Entry˵��Entry��Map���ڲ��ӿڣ�������ֵ��װ����Entry���󣬲��洢��Set��
		/*		System.out.println("------------Map.Entry ������--------------");
				Set<Map.Entry<String, Integer>> entrySet = hm.entrySet();
				// ��ȡÿһ������
				Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
				while (iterator.hasNext()) {
					// ��ȡÿһ��Entry����
					Map.Entry<String, Integer> entry = iterator.next();// ��������ָ���������
					String key = entry.getKey();
					int value = entry.getValue();
					System.out.println(key + "=" + value);
				}
		*/
		// ��ǿfor
		System.out.println("------------Map.Entry ��ǿfor--------------");
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

		// 1.ͨ��KeySet������
		// ����������
		System.out.println("------------KeySet������--------------");
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();// ��ȡ��
			int value = map.get(key);// ��ȡֵ
			System.out.println(key + "=" + value);
		}

		// ��ǿfor
		System.out.println("------------KeySet ��ǿfor--------------");
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
	 * ��ɾ
	 */
	private static void putRemoveDemo() {
		Map<String, Integer> map = new HashMap<>();
		map.put("Tom", 18);
		map.put("Tim", 28);
		map.put("Shawn", 38);
		map.put("Sara", 8);
		map.put("Henry", 10);
		Integer i = map.put("Tom", 20);// "Tom"�Ѵ��ڣ�����ԭֵ ��������18
		System.out.println(i);

		Integer val1 = map.remove("Henry");
		System.out.println(val1);// 10
		System.out.println(map);
	}
}
