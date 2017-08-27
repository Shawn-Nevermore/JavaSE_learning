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
			if (!arrayList.contains(obj)) {// contains �ж��Ƿ�������ײ��õ���Person�е�equals������remove����Ҳ������equals����
				arrayList.add(obj);
			}
		}

		return arrayList;
	}

	/**
	 * ȥ��ArrayList�е��ظ�Ԫ��
	 * ˼·������һ���¼��ϣ�ͨ���ж�ȥ��
	 * ���Լ���ʵ�ַ�ʽ��û���õ�����
	 * @param list
	 * @return
	 */
	private static ArrayList deleteDuplicatedEle(List list) {
		ArrayList li = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			if (li.contains(list.get(i))) {// ֱ��if(! li.contains(list.get(i))){li.add(list.get(i))}����
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

	// �Ĳ�
	private static void demo2() {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		// ����1��
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

		System.out.println("-------------");
		// ����2��
		for (Object i : list) {
			System.out.print(i + " ");
		}

		System.out.println("-------------");
		list.set(3, 100);
		System.out.println(list);
	}

	// ��ɾ
	private static void demo1() {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add(2, "e");
		list.add(100);// �Զ�װ�� new Integer(100)
		System.out.println(list.get(5) instanceof Integer);
		// list.add(5, "e");// index����size�������±�Խ���쳣
		System.out.println(list);

		// list.remove(100);// 100���±꣬ɾ����ʱ�򲻻��Զ�װ�䣬���Ǳ���������ֵ
		Object obj = list.remove(2);
		System.out.println("��ɾ�����ǣ�" + obj);
		System.out.println(list);
	}

}
