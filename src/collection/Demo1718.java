package collection;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * ���󣺳��������󣬿��ԴӼ���������ն��������ֱ������quitʱ�������룬����������������������д�ӡ
 * @author ����
 *
 */
public class Demo1718 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// reverseOrderInput(sc);
		reverseInput(sc);
	}

	private static void reverseOrderInput(Scanner sc) {
		TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int val = o2 - o1;
				return val == 0 ? 1 : val;
			}
		});

		while (true) {
			String line = sc.nextLine();
			if ("quit".equals(line)) {
				break;
			}
			if (line.matches("\\d*")) {// �ж������ȫ������������Ŀ��
				Integer i = Integer.parseInt(line);
				ts.add(i);
			}
			continue;// ��û�������˳�ָ�Ҳ�����������ַ����ͼ���
		}

		System.out.println(ts);
	}

	/**
	 * ��֮ǰ�������⣺��������������������������
	 * 
	 * ˼·�����ǵ���Ҫȥ�أ���Ҫ���򣬾���LinkedList�������Ԫ�ص�ʱ����addFirst��������
	 */
	public static void reverseInput(Scanner sc) {

		LinkedList<Integer> list = new LinkedList<>();

		while (true) {
			String line = sc.nextLine();
			if ("quit".equals(line)) {
				break;
			}
			if (line.matches("\\d*")) {// �ж������ȫ������������Ŀ��
				Integer i = Integer.parseInt(line);
				list.addFirst(i);
			}
			continue;
		}
		System.out.println(list);

	}
}
