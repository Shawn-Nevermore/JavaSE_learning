package bili;

import java.util.Arrays;

import sorting.Swap;

/**
 * ѡ���������Ҫ�ŵ��������ƶ��йء����ĳ��Ԫ��λ����ȷ������λ���ϣ��������ᱻ�ƶ���
 * ѡ������ÿ�ν���һ��Ԫ�أ����ǵ���������һ�������Ƶ�������λ���ϣ���˶�n��Ԫ�ص����н��������ܹ���������n-1�ν�����
 * �����е���ȫ��������ȥ�ƶ�Ԫ�ص����򷽷��У�ѡ���������ڷǳ��õ�һ�֡�
 * 
 * ������ֱ��ѡ�������д����Ų�����Ԫ��֮��Ļ�������ˣ�ֱ��ѡ��������һ�ֲ��ȶ������򷽷���
 * @author ����
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
	 * ֱ��ѡ�������㷨��Javaʵ�֡�<br/>
	 *   1����a[0]-a[N-1]��ѡ����С�����ݣ�Ȼ����a[0]����λ��<br/>
	 *   2����a[1]-a[N-1]��ѡ����С�����ݣ�Ȼ����a[1]����λ�ã���1��������a[0]����N��������Сֵ��<br/>
	 *   3����a[2]-a[N-1]��ѡ����С�����ݣ�Ȼ����a[2]����λ�ã���2��������a[1]����N-1��������Сֵ��<br/>
	 *   �Դ����ƣ�N-1������󣬴������ݾ��Ѿ����մ�С�����˳�������ˡ�
	 */
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {

			int minIndex = i;// ��С����������������ÿ�ζ��������ѭ���ļ����������ó�ʼֵ��
			for (int j = i + 1; j < array.length; j++) {
				// ������С�����������жϵ�ǰ������Ƿ�С����С����
				// ���С�ڣ���ѵ�ǰ����������Ϊ��С����������
				// ���򲻴���
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
				// ֱ��ѭ����ɵ�ʱ��minIndex�϶����ǵ�ǰ����ѭ���У���С���Ǹ���
			}

			Swap.swap(i, minIndex, array);
			System.out.println(String.format("%2s", (i + 1)) + "�������" + Arrays.toString(array));
		}
	}

	/**
	 * ��Ԫѡ�����򣺿��ǸĽ�Ϊÿ��ѭ��ȷ������Ԫ�أ���ǰ��������С��¼����λ��,
	 * �Ӷ��������������ѭ���������Ľ����n�����ݽ����������ֻ�����[n/2]��ѭ�����ɡ�
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
					System.out.println(String.format("%2s", (i + 1)) + "�������" + Arrays.toString(arr));
		*/

		int i, j, min, max;
		for (i = 0; i < length / 2; i++) { // i �� n / 2 ������ͻ��������
			min = max = i; // �Ƚ� min �� max ��ָ�������ĵ�һ��Ԫ��
			for (j = i; j < length - i; j++) {
				if (array[j] < array[min]) {
					min = j;
					continue;
				}
				if (array[j] > array[max]) {
					max = j;
				}
			}

			// ����Сֵ���ڵ�i���������ֵ���ڵ�length-i-1��
			// ע��:���ﲻ�ܰ� array[max]��array[min] ֱ�Ӻ� array[i] �� array[length-i-1]����
			int maxtemp = array[max];
			int mintemp = array[min];
			array[max] = array[length - i - 1];
			array[min] = array[i];
			array[i] = mintemp;
			array[length - i - 1] = maxtemp;

		}
	}
}
