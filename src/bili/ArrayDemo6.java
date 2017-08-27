package bili;

public class ArrayDemo6 {

	public static void main(String[] args) {

		/*
		 * 数组的静态初始化
		 */
		// int[] arr1 = new int[] { 22, 33, 11 }; // 现在也不允许动静结合，先声明再赋值
		// int[] arr2 = { 1, 2, 3, 4, 5 }; // 声明和赋值在同一行

		/*
		 * 二维数组
		 */
		int[][] arr = { { 1, 2 }, { 3, 2 }, { 3, 4, 5 } };
		System.out.println(arr.length);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
		}

		/*
		 * 我的方法实现数组反转
		 */
		// int[] reversedArr = reverseArray(arr2);
		// printArray(reversedArr);

		/*
		 * 优化的数组反转实现
		 */
		// reverseArrayNew(arr2);
		// printArray(arr2);

		/*
		 * 调用其他包中的函数生成随机数组并反转
		 */
		// System.out.println("-----------------------------------------------");
		// // 调用utils包中随机生成数组的方法
		// int[] randArr = RandomArray.randomCommon(0, 50, 15);
		// System.out.println("反转前的随机数组");
		// printArray(randArr);
		// System.out.println("************************************************");
		// System.out.println("反转后的随机数组");
		// reverseArray(randArr);
		// printArray(randArr);
	}

	/**
	 * 数组的遍历
	 */
	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.println(i);
		}
	}

	/**
	 * 数组元素反转(我自己的写法) 缺点：双重循环增加了时间复杂度，且不需要返回值
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
	 * 先穷举几个找到规律，避免双重循环
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
