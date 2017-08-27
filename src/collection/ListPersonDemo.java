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
	 * hasPrevious() �� previous()�����ǰ������
	 * @param list
	 */
	private static void demo2(List list) {
		ListIterator li = list.listIterator();
		while (li.hasNext()) {
			System.out.println(li.next());
		}
		while (li.hasPrevious()) {// �Ѿ��ڶ�����ǰ
			System.out.println(li.previous());// û���κ����
		}
		System.out.println(list);

	}

	/**
	 * һ�����ϣ����������"world"Ԫ�أ������һ��"javaee"Ԫ��
	 */
	private static void listIteratorDemo(List list) {
		/*
				Iterator it = list.iterator();
				while (it.hasNext()) {
					String str = (String) it.next();
					if ("world".equals(str)) {// ȷ�����ڵ��ַ���дǰ��
						list.add("javaee");// ConcurrentModificationException:�����Ĺ������޸ģ�����������ͻ
					}
				}
		*/
		// List���еĵ����������Ա��Ⲣ����ͻ
		ListIterator li = list.listIterator();
		while (li.hasNext()) {
			String str = (String) li.next();
			if ("world".equals(str)) {
				// list.add("javaee");// ConcurrentModificationException:�����Ĺ������޸ģ�����������ͻ
				li.add("javaee");
			}
		}
		System.out.println(list);
	}

	/**
	 * �����������ݵı���
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
