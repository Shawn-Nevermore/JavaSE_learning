package bili;

/**
 * 找到水仙花数。ex.153=1^3+5^3+3^3
 * 
 * @author 先生
 *
 */
public class LoopPractice {
	public static void main(String[] args) {

		int[] arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		System.out.println(arr[2]);

		// shuiXianHua();
		new_shuiXianHua(1000);
		// Console cons = System.console();
		// String name = cons.readLine("User name: ");
		// char[] password = cons.readPassword("Password: ");
	}

	public static void shuiXianHua() {

		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int z = 0; z < 10; z++) {
					if (100 * i + 10 * j + z == i * i * i + j * j * j + z * z * z) {
						System.out.println(100 * i + 10 * j + z);
					}
				}
			}
		}
	}

	/*
	 * 
	 */
	public static void new_shuiXianHua(int n) {
		for (int i = 100; i < n; i++) {
			int g = i % 10;
			int s = i / 10 % 10;
			int b = i / 100 % 10;
			if (b * b * b + s * s * s + g * g * g == i) {
				System.out.println(i);
			}
		}
	}
}
