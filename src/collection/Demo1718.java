package collection;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 需求：程序启动后，可以从键盘输入接收多个整数，直到输入quit时结束输入，把所有输入的整数倒序排列打印
 * @author 先生
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
			if (line.matches("\\d*")) {// 判断输入的全是整数才满足目标
				Integer i = Integer.parseInt(line);
				ts.add(i);
			}
			continue;// 既没有遇到退出指令，也参杂了其他字符，就继续
		}

		System.out.println(ts);
	}

	/**
	 * 我之前错误的理解：将输入的整数反序输出，不排序
	 * 
	 * 思路：考虑到不要去重，且要反序，就用LinkedList。在添加元素的时候用addFirst方法就行
	 */
	public static void reverseInput(Scanner sc) {

		LinkedList<Integer> list = new LinkedList<>();

		while (true) {
			String line = sc.nextLine();
			if ("quit".equals(line)) {
				break;
			}
			if (line.matches("\\d*")) {// 判断输入的全是整数才满足目标
				Integer i = Integer.parseInt(line);
				list.addFirst(i);
			}
			continue;
		}
		System.out.println(list);

	}
}
