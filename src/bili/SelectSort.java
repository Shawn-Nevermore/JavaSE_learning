package bili;

import java.util.Arrays;

import sorting.Swap;

/**
 * 选择排序的主要优点与数据移动有关。如果某个元素位于正确的最终位置上，则它不会被移动。
 * 选择排序每次交换一对元素，它们当中至少有一个将被移到其最终位置上，因此对n个元素的序列进行排序总共进行至多n-1次交换。
 * 在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
 * 
 * 由于在直接选择排序中存在着不相邻元素之间的互换，因此，直接选择排序是一种不稳定的排序方法。
 * @author 先生
 *
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] arr = { 23, 65, 21, 77, 33, 2, 37 };
		System.out.println(Arrays.toString(arr));
		// selectSort(arr);
		// System.out.println(Arrays.toString(arr));
		biSelectSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));

	}

	/**
	 * 直接选择排序算法的Java实现。<br/>
	 *   1：从a[0]-a[N-1]中选出最小的数据，然后与a[0]交换位置<br/>
	 *   2：从a[1]-a[N-1]中选出最小的数据，然后与a[1]交换位置（第1步结束后a[0]就是N个数的最小值）<br/>
	 *   3：从a[2]-a[N-1]中选出最小的数据，然后与a[2]交换位置（第2步结束后a[1]就是N-1个数的最小值）<br/>
	 *   以此类推，N-1次排序后，待排数据就已经按照从小到大的顺序排列了。
	 */
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {

			int minIndex = i;// 最小数的索引，该索引每次都根据外层循环的计数器来觉得初始值。
			for (int j = i + 1; j < array.length; j++) {
				// 根据最小数的索引，判断当前这个数是否小于最小数。
				// 如果小于，则把当前数的索引作为最小数的索引。
				// 否则不处理。
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
				// 直到循环完成的时候，minIndex肯定就是当前这轮循环中，最小的那个。
			}

			Swap.swap(i, minIndex, array);
			System.out.println(String.format("%2s", (i + 1)) + "轮排序后：" + Arrays.toString(array));
		}
	}

	/**
	 * 二元选择排序：考虑改进为每趟循环确定两个元素（当前趟最大和最小记录）的位置,
	 * 从而减少排序所需的循环次数。改进后对n个数据进行排序，最多只需进行[n/2]趟循环即可。
	 */
	public static void biSelectSort(int[] array, int length) {

		/*		for (int i = 0; i < arr.length / 2; i++) {
					int minIndex = i;
					int maxIndex = i;
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[minIndex] > arr[j]) {
							minIndex = j;
							// continue;
						}
						if (arr[maxIndex] < arr[j]) {
							maxIndex = j;
						}
					}
					Swap.swap(i, minIndex, arr);
					Swap.swap(arr.length - i-1, maxIndex, arr);
					System.out.println(String.format("%2s", (i + 1)) + "轮排序后：" + Arrays.toString(arr));
		*/

		int i, j, min, max;
		for (i = 0; i < length / 2; i++) { // i 跑 n / 2 趟排序就会排序完成
			min = max = i; // 先将 min 和 max 都指向待排序的第一个元素
			for (j = i; j < length - i; j++) {
				if (array[j] < array[min]) {
					min = j;
					continue;
				}
				if (array[j] > array[max]) {
					max = j;
				}
			}

			// 将最小值放在第i处，将最大值放在第length-i-1处
			// 注意:这里不能把 array[max]、array[min] 直接和 array[i] 和 array[length-i-1]调换
			int maxtemp = array[max];
			int mintemp = array[min];
			array[max] = array[length - i - 1];
			array[min] = array[i];
			array[i] = mintemp;
			array[length - i - 1] = maxtemp;

		}
	}
}
