package bili;

public class AngleTower {
	public static void main(String[] args) {
		// paint(20);
		drawAngleTower2(10);
	}

	// 打印正三角形（1，3,5）
	public static void paint(int n) {

		for (int i = 0; i < n; i++) {
			// 打印空格
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}
			// 打印^
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print("^");
			}
			System.out.println();
		}
	}

	// 打印正三角形（1,2,3）
	public static void drawAngleTower2(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
