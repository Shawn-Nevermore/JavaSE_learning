package bili;

public class ArrayDemo6 {

	public static void main(String[] args) {

		/*
		 * ����ľ�̬��ʼ��
		 */
		// int[] arr1 = new int[] { 22, 33, 11 }; // ����Ҳ����������ϣ��������ٸ�ֵ
		// int[] arr2 = { 1, 2, 3, 4, 5 }; // �����͸�ֵ��ͬһ��

		/*
		 * ��ά����
		 */
		int[][] arr = { { 1, 2 }, { 3, 2 }, { 3, 4, 5 } };
		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
		}

		/*
		 * �ҵķ���ʵ�����鷴ת
		 */
		// int[] reversedArr = reverseArray(arr2);
		// printArray(reversedArr);

		/*
		 * �Ż������鷴תʵ��
		 */
		// reverseArrayNew(arr2);
		// printArray(arr2);

		/*
		 * �����������еĺ�������������鲢��ת
		 */
		// System.out.println("-----------------------------------------------");
		// // ����utils���������������ķ���
		// int[] randArr = RandomArray.randomCommon(0, 50, 15);
		// System.out.println("��תǰ���������");
		// printArray(randArr);
		// System.out.println("************************************************");
		// System.out.println("��ת����������");
		// reverseArray(randArr);
		// printArray(randArr);
	}

	/**
	 * ����ı���
	 */
	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}

	/**
	 * ����Ԫ�ط�ת(���Լ���д��) ȱ�㣺˫��ѭ��������ʱ�临�Ӷȣ��Ҳ���Ҫ����ֵ
	 */
	public static int[] reverseArray(int[] arr) {
		int[] curr = arr;
		for (int i = 0, j = curr.length - 1; i < j; i++, j--) {
			int temp = curr[i];
			curr[i] = curr[j];
			curr[j] = temp;
		}
		return curr;
	}

	/**
	 * ����ټ����ҵ����ɣ�����˫��ѭ��
	 * 
	 * @param arr
	 */
	public static void reverseArrayNew(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}
}
