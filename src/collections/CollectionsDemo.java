package collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ������Collections�ĳ�������
 * @author ����
 *
 */
public class CollectionsDemo {
	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<>();
		list.add("aa");
		list.add("ig");
		list.add("navi");
		list.add("good");
		list.add("alliance");
		list.add("evil");

		System.out.println(list);
		/*		
				// ����
				Collections.sort(list);
				System.out.println(list);
		*/

		// ���ֲ���
		int index = Collections.binarySearch(list, "ig");
		int index1 = Collections.binarySearch(list, "wings");
		System.out.println(index1);

		// �������Сֵ
		System.out.println("max=" + Collections.max(list));
		System.out.println("min=" + Collections.min(list));

		// ����
		Collections.reverse(list);
		System.out.println(list);

		// ϴ��
		Collections.shuffle(list);
		System.out.println(list);

	}
}
