package bili;

import java.util.Scanner;

/**
 * @category 实现两个整数的交换（不新定义第三方变量） 知识点：一个数据对另一个数据按位异或两次，这个数不变
 * @author 先生
 *
 */
public class OperatorExchange {

	public static void main(String[] args) {
		// bitwiseOperatorExch(3, 4);
		// plusOperatorExch(10, 1);

		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		System.out.println(x);
		s.close();
	}

	public static void bitwiseOperatorExch(int x, int y) {
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}

	//
	public static void plusOperatorExch(int x, int y) {
		x = x + y; // 此处有缺陷，x可能越界
		y = x - y;
		x = x - y;
		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}
}
