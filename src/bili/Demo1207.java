package bili;

import java.util.Scanner;

/**
 * 模拟用户登录，三次机会，并提示还剩几次。用户名和密码都是admin
 * @author 先生
 *
 */
public class Demo1207 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// int count = 3;//这里直接用i就能表示了，不需要用外部count变量
		for (int i = 0; i < 3; i++) {
			System.out.println("Please enter your account:");
			String name = sc.nextLine();
			System.out.println("Please enter your password:");
			String pwd = sc.nextLine();
			if ("admin".equals(name) && "admin".equals(pwd)) {// 用字符串常量调用equal方法，字符串变量做参数传入，才不会出现空指针异常
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
