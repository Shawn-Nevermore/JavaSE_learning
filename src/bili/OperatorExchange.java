package bili;

import java.util.Scanner;

/**
 * @category ʵ�����������Ľ��������¶�������������� ֪ʶ�㣺һ�����ݶ���һ�����ݰ�λ������Σ����������
 * @author ����
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
		x = x + y; // �˴���ȱ�ݣ�x����Խ��
		y = x - y;
		x = x - y;
		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}
}
