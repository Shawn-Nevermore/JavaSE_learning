package collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 工具类Collections的常见方法
 * @author 先生
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
				// 排序
				Collections.sort(list);
				System.out.println(list);
		*/

		// 二分查找
		int index = Collections.binarySearch(list, "ig");
		int index1 = Collections.binarySearch(list, "wings");
		System.out.println(index1);

		// 求最大最小值
		System.out.println("max=" + Collections.max(list));
		System.out.println("min=" + Collections.min(list));

		// 反序
		Collections.reverse(list);
		System.out.println(list);

		// 洗牌
		Collections.shuffle(list);
		System.out.println(list);

	}
}
