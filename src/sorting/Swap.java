package sorting;

public class Swap {

	// 交换数组中的两个元素（基本元素交换不变，必须带数组）
	public static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
