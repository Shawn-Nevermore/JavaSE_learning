package collection;

import java.util.ArrayList;
import java.util.Collection;

import dao.Person;

/**
 * A.���ϵ�����
 * B.����ͼ��ϵ�����
 * 		1.���ͣ�������ܴ�����������ͣ�Ҳ�ܴ������������ͣ���ֵַ��
 * 		2.���ȣ����鳤�Ⱥ㶨�����ϳ��ȿɱ�
 * C.ʲôʱ���ã�
 * 		Ԫ�ظ����̶������飨�����ռ䣬Ч�ʸ��ߣ������̶��ü��ϣ��ײ�ʵ�ֻ᲻�����ݣ�ԭ���Ķ���������������ռ�ڴ棩
 * Collection
 * 		List:���������������ظ�
 * 			ArrayList������ʵ��
 * 			LinkedList������ʵ��
 * 			Vector������ʵ��
 * 		Set�������������������ظ�
 * 			HashSet����ϣ		
 * 			TreeSet��������
 * 	
 * 	
 * 
 * @author ����
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Demo1502 {

	public static void main(String[] args) {
		// addDemo();

		// demo1();

		// demo2(c);

		// demo3();

		Collection c1 = new ArrayList();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");

		Collection c2 = new ArrayList();
		c2.add("a");
		c2.add("c");
		c2.add("z");

		c1.addAll(c2);
		// c1.add(c2);// ��c2����һ��Ԫ����ӵ�c1
		System.out.println(c1);

		c1.removeAll(c2);
		System.out.println(c1);// ɾ�����ǽ�����û�н�������false��c1ֵ����

		boolean b1 = c1.containsAll(c2);
		System.out.println(b1);

		boolean b2 = c1.retainAll(c2);
		System.out.println(b2);// true��û������ֻҪc1�ı�ͷ���true����
		System.out.println(c1);

	}

	private static void demo3() {
		Collection c = new ArrayList();
		c.add(new Person("Tom", 11));
		c.add(new Person("Tommy", 12));
		c.add(new Person("Jim", 15));
		c.add(new Person("John", 1));

		Object[] arr = c.toArray();// Person����ת�ͳ�Object����̬�ı׶ˣ��޷������������еķ���
		/*for (Object i : arr) {
			System.out.println(i);
		}*/
		for (int S = 0; S < arr.length; S++) {
			Person p = (Person) arr[S];// ����ת�ͣ����ܷ���Person�еķ���������ɸ�������縳ֵ���εȲ����������
			System.out.println(p.getName() + "..." + p.getAge());
		}
	}

	private static void demo2(Collection c) {
		Object[] arr = c.toArray();
		for (Object i : arr) {
			System.out.println(i);
		}
	}

	private static void demo1(Collection c) {

		// c.remove(100);
		// c.clear();
		System.out.println(c.contains(100));
		System.out.println(c.isEmpty());
		System.out.println(c.size());
	}

	// add���������List��һֱ����true����Ϊ�������Ϳ��ظ��������set���ظ����Ԫ�ػ᷵��false
	private static void addDemo() {
		Collection c = new ArrayList();
		boolean b1 = c.add("abc");
		boolean b2 = c.add(false);// �Զ�װ��new Boolean(false)
		boolean b3 = c.add(100);// new Integer(100)
		boolean b4 = c.add(new Person("Tom", 12));
		System.out.println(b1);// true,��Ϊ�����࣬Collection��add������Զ����true
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b4);
		System.out.println(c);// [abc, false, 100, Person [name=Tom, age=12]]��˵��ArrayList�ĸ���������дtoString ����
	}

}
