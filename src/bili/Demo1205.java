package bili;

/**
 * ���ڴ���ص��ַ���һϵ����ϰ��
 * @author ����
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
		System.out.println(s); // ���Helloworld����Ϊs.substring()��û�и�ֵ��s��s��û��ָ��ı���Ӵ���
	}

	private static void demo5() {
		String s1 = "ab";
		String s2 = "abc";
		String s3 = s1 + "c";
		System.out.println(s3 == s2);// false,�ӵײ�ʵ��������java����+�����ַ���ʱ�����Ƚ�������浽StringBuffer����StringBuilder�����У�
										// Ȼ����toString()������ת��ΪString���󣬴�ʼ���ն�����ڶ��ڴ���
		System.out.println(s3.equals(s2));// true
	}

	private static void demo4() {
		String s1 = "a" + "b" + "c";// �ڱ���ʱ�ͱ����"abc"
		String s2 = "abc";
		System.out.println(s1 == s2);// true,java���г����Ż����ơ�s1�ڳ������д�����"abc"��s2�ҵ���ֱ�Ӹ�ֵ
		System.out.println(s1.equals(s2));// true
	}

	private static void demo3() {
		String s1 = new String("abc");// �ڶ���
		String s2 = "abc";// �ڳ�������
		System.out.println(s1 == s2);// false��λ�ò�ͬ����ֵַ��ͬ
		System.out.println(s1.equals(s2));// true��������ͬ
	}

	private static void demo2() {
		String s3 = new String("bcd");// �����˼������󣿴𰸣�2�����ڳ������ﴴ����һ����Ȼ����Ϊ��new
										// String()����Ҫ�ڶ��ڴ���Ҳ����һ��String����Ȼ�󽫳��������ַ�������һ�����������ڴ���ٽ��ö���ĵ�ֵַ��ֵ��s3
	}

	private static void demo1() {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2); // true,��Ϊ��abc�������ڳ������У����û�оʹ������о�ֱ�Ӹ�ֵ����������¶���
		System.out.println(s1.equals(s2));// true
	}

}
