package bili;

/**
 * 跟内存相关的字符串一系列练习题
 * @author 先生
 *
 */
public class Demo1205 {

	public static void main(String[] args) {

		// demo1();
		// demo2();
		// demo3();
		// demo4();
		// demo5();
		demo6();
	}

	private static void demo6() {
		String s = "Helloworld";
		s.substring(5);
		System.out.println(s); // 输出Helloworld，因为s.substring()并没有赋值给s，s并没有指向改变后子串。
	}

	private static void demo5() {
		String s1 = "ab";
		String s2 = "abc";
		String s3 = s1 + "c";
		System.out.println(s3 == s2);// false,从底层实现来看，java在用+连接字符串时，会先将结果缓存到StringBuffer或者StringBuilder对象中，
										// 然后用toString()方法再转换为String对象，从始至终都存放在堆内存中
		System.out.println(s3.equals(s2));// true
	}

	private static void demo4() {
		String s1 = "a" + "b" + "c";// 在编译时就变成了"abc"
		String s2 = "abc";
		System.out.println(s1 == s2);// true,java中有常量优化机制。s1在常量池中创建了"abc"，s2找到了直接赋值
		System.out.println(s1.equals(s2));// true
	}

	private static void demo3() {
		String s1 = new String("abc");// 在堆中
		String s2 = "abc";// 在常量池中
		System.out.println(s1 == s2);// false，位置不同，地址值不同
		System.out.println(s1.equals(s2));// true，内容相同
	}

	private static void demo2() {
		String s3 = new String("bcd");// 创建了几个对象？答案：2。先在常量池里创建了一个，然后因为有new
										// String()，需要在堆内存里也创建一个String对象，然后将常量池里字符串拷贝一个副本到堆内存里，再将该对象的地址值赋值给s3
	}

	private static void demo1() {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2); // true,因为“abc”存在在常量池中，如果没有就创建，有就直接赋值，不会产生新对象
		System.out.println(s1.equals(s2));// true
	}

}
