package bili;

import java.util.Scanner;

/**
 * ģ���û���¼�����λ��ᣬ����ʾ��ʣ���Ρ��û��������붼��admin
 * @author ����
 *
 */
public class Demo1207 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// int count = 3;//����ֱ����i���ܱ�ʾ�ˣ�����Ҫ���ⲿcount����
		for (int i = 0; i < 3; i++) {
			System.out.println("Please enter your account:");
			String name = sc.nextLine();
			System.out.println("Please enter your password:");
			String pwd = sc.nextLine();
			if ("admin".equals(name) && "admin".equals(pwd)) {// ���ַ�����������equal�������ַ����������������룬�Ų�����ֿ�ָ���쳣
				System.out.println("Login successfully!");

				break;
			} else {
				// count--;
				if (i == 2) {
					System.out.println("You are blocked. Please come 1 hour later.");
				} else {
					System.out.println("Wrong account or password. You have " + (2 - i) + " chances left. ");
				}

			}
		}
	}
}
