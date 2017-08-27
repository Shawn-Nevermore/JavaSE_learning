package bili;

public class StringBufferDemo {
	public static void main(String[] args) {
		// appendDemo();

		// insertDemo();

		// delDemo();

		// replaceDemo();

		// subStrDemo();

		// transStrStrBuffer();

		testStrSB();
	}

	private static void testStrSB() {
		String s = "heima";
		System.out.println(s);
		change(s);// 字符串虽然是引用数据类型，但作为参数传递时，不改变其值
		System.out.println(s);

		System.out.println("---------------");

		StringBuilder sb = new StringBuilder("heima");
		System.out.println(sb);
		change(sb);// StringBuilder是引用类型，作为参数传递指向同一个对象，会改变原值
		System.out.println(sb);
	}

	private static void change(StringBuilder sb) {

		sb.append("itcast");
	}

	private static void change(String s) {

		s += "itcast";
	}

	/**
	 * String转StringBuffer
	 * 		a.通过构造方法 
	 * 		b.通过append()方法
	 * StringBuffer转String
	 * 		a.通过构造方法
	 * 		b.通过toString()方法
	 * 		c.通过subString(0,length)
	 */
	private static void transStrStrBuffer() {

		// 1.a
		StringBuffer sb1 = new StringBuffer("salanghei");

		// 1.b
		StringBuffer sb2 = new StringBuffer();
		sb2.append("ohaiyo");

		// 2.a
		String s1 = new String(sb1);
		System.out.println(s1);

		// 2.b
		String s2 = sb1.toString();
		System.out.println(s2);

		// 3.c
		String s3 = sb1.substring(0, sb1.length());
		System.out.println(s3);
	}

	private static void subStrDemo() {
		StringBuffer sb = new StringBuffer("Aslongasyoulovemebaby...");
		String s = sb.substring(8, 15);// 返回值是String，不是StringBuffer
		System.out.println(s);
	}

	private static void replaceDemo() {
		StringBuffer sb = new StringBuffer("iloveyou");
		sb.replace(1, 5, "hate");
		System.out.println(sb);
	}

	private static void delDemo() {
		StringBuffer sb = new StringBuffer("Aslongasyoulovemebaby...");
		sb.delete(2, 6);
		System.out.println(sb);
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}

	private static void insertDemo() {
		StringBuffer sb = new StringBuffer("12345");
		sb.insert(3, false);
		sb.insert(3, 100);
		System.out.println(sb);
	}

	private static void appendDemo() {
		// 对比StringBuffer和String
		StringBuffer sb = new StringBuffer();// sb,sb1,sb2均指向同一个对象
		StringBuffer sb1 = sb.append("Hello");
		StringBuffer sb2 = sb.append("world");

		System.out.println(sb);
		System.out.println(sb1);
		System.out.println(sb2);

		String s = "";
		String s1 = s.concat("Hello");
		String s2 = s.concat("world");
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
	}
}
