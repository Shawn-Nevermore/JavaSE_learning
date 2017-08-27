package sorting;

import java.util.Arrays;

import utils.RandomArray;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = RandomArray.randomCommon(0, 100, 20);
		System.out.println("����ǰ��");
		RandomArray.print(arr);

		bubbleSort(arr);
		System.out.println("\n" + "�����");
		// RandomArray.print(arr);
		System.out.println(Arrays.toString(arr));// ��Arrays.toString()������ӡ

		int[] a = { 1, 2, 32, 11, 22, 12 };

		// betterBubbleSort(a);
		// System.out.println(Arrays.toString(a));

		// System.out.println(Arrays.toString(a));
		// bubbleSort(a);
		// System.out.println(Arrays.toString(a));

	}

	private static void bubbleSort(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) { // ���ѭ����ÿһ�������ıȽϴ������ݼ����൱�ڹ����ƶ���
			for (int j = 0; j < arr.length - 1 - i; j++) {// �ڲ�ѭ����������ڱȽϵĹ����У�����Ľ���
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					count++;
				}
			}
		}
		System.out.println("������" + count + "��");
	}

	/**
	 * �Ż����ð������
	 * ����flag�ж�ĳһ����������Ƿ����
	 * @param arr
	 * @return
	 */
	private static int[] betterBubbleSort(int[] arr) {
		int[] result = arr; // ���������ö����룬��������Ƿ�ı�ԭ���飬֤����ı�
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
					flag = true;// ��������˽�����flag��Ϊtrue
					count++;
				}
			}

		} while (flag);

		System.out.println("�Ż��󽻻���" + count + "��");

		return result;
	}

}
