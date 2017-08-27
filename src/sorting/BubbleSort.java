package sorting;

import java.util.Arrays;

import utils.RandomArray;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = RandomArray.randomCommon(0, 100, 20);
		System.out.println("排序前：");
		RandomArray.print(arr);

		bubbleSort(arr);
		System.out.println("\n" + "排序后：");
		// RandomArray.print(arr);
		System.out.println(Arrays.toString(arr));// 用Arrays.toString()方法打印

		int[] a = { 1, 2, 32, 11, 22, 12 };

		// betterBubbleSort(a);
		// System.out.println(Arrays.toString(a));

		// System.out.println(Arrays.toString(a));
		// bubbleSort(a);
		// System.out.println(Arrays.toString(a));

	}

	private static void bubbleSort(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) { // 外层循环：每一个数最多的比较次数，递减（相当于光标的移动）
			for (int j = 0; j < arr.length - 1 - i; j++) {// 内层循环：这个数在比较的过程中，所需的交换
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					count++;
				}
			}
		}
		System.out.println("交换了" + count + "次");
	}

	/**
	 * 优化后的冒泡排序
	 * 设立flag判断某一遍排序过程是否完成
	 * @param arr
	 * @return
	 */
	private static int[] betterBubbleSort(int[] arr) {
		int[] result = arr; // 数组是引用对象传入，这里测试是否改变原数组，证明会改变
		int n = result.length;
		int temp = 0;
		boolean flag = true;
		int count = 0;

		do {

			flag = false;
			for (int i = 0; i < n - 1; i++) {
				if (result[i] > result[i + 1]) {
					temp = result[i];
					result[i] = result[i + 1];
					result[i + 1] = temp;
					flag = true;// 如果发生了交换，flag变为true
					count++;
				}
			}

		} while (flag);

		System.out.println("优化后交换了" + count + "次");

		return result;
	}

}
