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
				// 1.��ͨforɾ��������Ҫ--
				for (int i = 0; i < arrayList.size(); i++) {
					if ("b".equals(arrayList.get(i))) {
						arrayList.remove(i--); // i�������--�����ظ�Ԫ�أ������ظ�Ԫ�ػ�����
					}
				}
		
		*/
		/*
				// 2.������ɾ��
				Iterator<String> it = arrayList.iterator();
				while (it.hasNext()) {
					if ("b".equals(it.next())) {
						// list.remove("b");//����ֲ����޸��쳣
						it.remove();
					}
				}
				
				for (Iterator<String> iterator = arrayList.iterator(); iterator.hasNext();) {
					if ("b".equals(it.next())) {
						// list.remove("b");//����ֲ����޸��쳣
						it.remove();
				}
		
		*/

		// 3.��ǿforѭ��������ɾ����ֻ�ܱ����������޸��쳣��

	}

	/**
	 * A.����ͨ���<?>��
	 * 		�������ͣ����û����ȷ����ô����Object�Լ��������͵�Java����
	 * B.? extends E
	 * 		�����޶���E��������
	 * C.? super E
	 * 		�����޶���E���丸��
	 * 		
	 */
	private static void demo2() {
		// List<?> list = new ArrayList<String>();//���ұ����Ͳ�ȷ��ʱ����߿���ָ��Ϊ��
		ArrayList<Person> list1 = new ArrayList<>();
		list1.add(new Person("Tom", 12));
		list1.add(new Person("Shawn", 22));
		list1.add(new Person("Geek", 32));
		list1.add(new Person("Steam", 42));
		list1.add(new Person("Lol", 52));

		ArrayList<Student> list2 = new ArrayList<>();
		list2.add(new Student("����", 19));
		list2.add(new Student("����", 19));

		list1.addAll(list2);// addAll(Collection<? extends E> c)
							// ����list2�ķ��ͼ̳���list1�ķ���
		System.out.println(list1);
	}

	private static void demo1() {
		Tool<String> t = new Tool<>(); // 1.7�����ԣ�������Բ�д�����η���
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
