package search;

import java.util.Arrays;

import utils.RandomArray;

public class BinarySearch {
	public static void main(String[] args) {
		/*int[] arr = { 11, 22, 33, 44, 55, 66, 77, 88, 99 };
		int i = biSearch(arr, 22);
		// int i = binarySearch(arr, 22);
		System.out.println(i);*/

		int[] arr = RandomArray.randomCommon(0, 100, 15);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.binarySearch(arr, 10));// �鿴ϵͳ�Դ���ʵ�֣�������ҵ�ֵ�����ڣ�����-(index+1)��indexΪӦ�����ڵ��±�
	}

	public static int biSearch(int[] arr, int value) {
		int minIndex = 0;
		int maxIndex = arr.length - 1;

		while (minIndex <= maxIndex && minIndex <= arr.length - 1 && maxIndex <= arr.length - 1) {
			int midIndex = (minIndex + maxIndex) >>> 1; // midIndexÿ��ѭ����Ҫ���¼��㣬Ҫ��ѭ���ڶ���
			if (arr[midIndex] == value) {
				return midIndex;
			} else if (value > arr[midIndex]) {
				minIndex = midIndex + 1;
			} else {
				maxIndex = midIndex - 1;
			}

		}
		return -1;
	}

}
