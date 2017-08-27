package regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {

		// demo1();

		// demo2();

		// demo3();

		// splitDemo();

		/*System.out.println("100".compareTo("99"));// -8
		String s = sortStr("91 27 46 38 50 100 22 12 98 55");
		System.out.println(s);*/

		// replaceDemo();

		// demo4();

		// demo5();

		// demo6();

		/*		public static Pattern compile(String regex)
				Compiles the given regular expression into a pattern.
		*/

		demo7();
	}

	private static void demo7() {
		// ���󣺰�һ���ַ����е��ֻ��Ż�ȡ����
		String s = "My Singapore phone number is 06598765432, email address is johnxu@gmail.com. I've also used the phone number 18788888888 in China.";

		String regex = "[01][35678]\\d{9}";// ��ȡ�ֻ��ŵ�������ʽ
		Pattern p = Pattern.compile(regex);// ��ȡ������ʽ
		Matcher m = p.matcher(s);// ��ȡƥ����
		while (m.find()) {// find()�ж��Ƿ��ȡ��
			System.out.println(m.group());// group()��ȡ��ȡ������Ϣ������ָ�룬��ȡһ����һ��
		}
	}

	private static void demo6() {
		// �滻-����"����..��...����....��.Ҫ...Ҫ..ҪҪҪ..Ҫ...ѧ.ѧ.��.��...��..��.��.��....�̳�"�滻Ϊ"��Ҫѧ���"
		String regex = "\\.+";
		String str = "����..��...����....��.Ҫ...Ҫ..ҪҪҪ..Ҫ...ѧ.ѧ.��.��...��..��.��.��....�̳�";
		String s1 = str.replaceAll(regex, "");
		System.out.println(s1);

		String s2 = s1.replaceAll("(.)\\1+", "$1");// $1�����һ���е�����
		System.out.println(s2);
	}

	private static void demo5() {
		// �и�-�����밴�����и"sdqqfgkkkhjppppkl"
		String regex = "(.)\\1+";// ��һ�����һ�λ���
		String s = "sdqqfgkkkhjppppkl";
		String[] sArr = s.split(regex);
		for (String str : sArr) {
			System.out.print(str + " ");
		}
	}

	/**
	 * Group number
	
	Capturing groups are numbered by counting their opening parentheses from left to right. 
	In the expression ((A)(B(C))), for example, there are four such groups:
	
	1    	((A)(B(C)))
	2    	(A)
	3    	(B(C))
	4    	(C)
	Group zero always stands for the entire expression.
	 */
	private static void demo4() {
		// ex1.���ʣ�"������֣��߸�����"
		String regex = "(.)\\1(.)\\2"; // \\1�����һ���ֳ���һ��
		String s = "�������";
		System.out.println(s.matches(regex));

		// ex2.���ʣ�"Ҫ��Ҫ��"
		String regex1 = "(..)\\1";
		String s1 = "Ҫ��Ҫ��";
		System.out.println(s1.matches(regex1));
		System.out.println(s.matches(regex1));
		System.out.println("��������".matches(regex1));// true
		System.out.println("��������".matches(regex));// true
	}

	/**
	 * ������ʽ���滻����
	 * 		public static String replaceAll(String regex, String replacement)
	 */
	private static void replaceDemo() {
		String regex = "\\d";
		String regex2 = "\\D";
		String s = "I1love23you";
		String s2 = s.replaceAll(regex, "");// ȥ���ַ����е���������
		System.out.println(s2);
		String s3 = s.replaceAll(regex2, "");// ȥ���ַ����е�������ĸ
		System.out.println(s3);
	}

	/**
	 * ���ַ�����91 27 46 38 50����������õ���27 38 46 50 91��
	 */
	public static String sortStr(String string) {
		String[] arr = string.split(" ");
		StringBuilder result = new StringBuilder("");

		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(intArr);// ����ֱ����Arrays.sort()��String��������"91 27 46 38 50 100 22 12 98 55"��100����ֵ����п�ͷ
		for (int i = 0; i < intArr.length; i++) {
			if (i == intArr.length - 1) {
				result.append("");
			}
			result.append(intArr[i]).append(" ");// ���ﲻҪ��append(s + " ")����Ϊ���ַ������ʱ���ײ�ʵ������newһ��StringBuffer����
			// Ȼ�󽫽����ֵ���ö��������toString()����ת������������ֱ�ӵ���append()����
		}

		return result.toString();
	}

	private static void splitDemo() {
		String addr = "johnxu2010cd@gmail.com";
		String[] arr = addr.split("[@\\.]");// �õ�johnxu2010cd gmail com��Ȼ��ֱ�ֵ�洢�û����ݣ����������etc.
		for (String i : arr) {
			System.out.println(i);
		}
	}

	/**
	 * Greedy quantifiers
	X?	X, once or not at all
	X*	X, zero or more times
	X+	X, one or more times
	X{n}	X, exactly n times
	X{n,}	X, at least n times
	X{n,m}	X, at least n but not more than m times
	 */
	private static void demo3() {
		String regex1 = "[abc]?";
		String regex2 = "[abc]*";
		String regex3 = "[abc]+";
		String regex4 = "[abcd]{4}";
		String regex5 = "[abcd]{4,}";
		String regex6 = "[abcd]{4,6}";

		System.out.println("d".matches(regex1));
		System.out.println("ab".matches(regex2));
		System.out.println(" ".matches(regex2));// false���ո��ַ����ǿ��ַ�
		System.out.println("".matches(regex3));// false
		System.out.println("abcde".matches(regex4));
		System.out.println("abc".matches(regex5));
		System.out.println("abcdefg".matches(regex6));
	}

	/**
	 * Predefined character classes
	.	Any character (may or may not match line terminators)
	\d	A digit: [0-9]
	\D	A non-digit: [^0-9]
	\h	A horizontal whitespace character: [ \t\xA0\u1680\u180e\u2000-\u200a\u202f\u205f\u3000]
	\H	A non-horizontal whitespace character: [^\h]
	\s	A whitespace character: [ \t\n\x0B\f\r]
	\S	A non-whitespace character: [^\s]
	\v	A vertical whitespace character: [\n\x0B\f\r\x85\u2028\u2029]
	\V	A non-vertical whitespace character: [^\v]
	\w	A word character: [a-zA-Z_0-9]
	\W	A non-word character: [^\w]
	 */
	private static void demo2() {

		System.out.println("ͨ���..:");
		String regex1 = "..";
		System.out.println("ab".matches(regex1));
		System.out.println("a".matches(regex1));

		System.out.println("-------------------------");
		String regex2 = "\\d";
		System.out.println("9".matches(regex2));

		System.out.println("-------------------------");

		String regex3 = "\\h";
		String regex4 = "\\s";
		System.out.println(" ".matches(regex3));
		System.out.println(" ".matches(regex4));
		System.out.println("-------------------------");
		System.out.println("4���ո��1��tab����ˮƽ�ո��");
		System.out.println("    ".matches(regex3));
		System.out.println("	".matches(regex3));
		System.out.println("-------------------------");
		System.out.println("\n".matches(regex3));
		System.out.println("\n".matches(regex4));
		System.out.println("-------------------------");

		String regex5 = "\\w";
		System.out.println("@".matches(regex5));
		System.out.println("_".matches(regex5));
	}

	/**
	 * Character classes
	[abc]			a, b, or c (simple class)
	[^abc]			Any character except a, b, or c (negation)
	[a-zA-Z]		a through z or A through Z, inclusive (range)
	[a-d[m-p]]		a through d, or m through p: [a-dm-p] (union)
	[a-z&&[def]]	d, e, or f (intersection)
	[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
	[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)
	 */
	private static void demo1() {
		// [abc] a, b, or c (simple class)
		String regex1 = "[abc]";
		String regex2 = "[^abc]";
		System.out.println("ab".matches(regex1));// false��[]�������ַ�
		System.out.println("d".matches(regex1));
		System.out.println("d".matches(regex2));
		System.out.println("\t".matches(regex2));

		String regex3 = "[a-dm-p]";
		System.out.println("m".matches(regex3));
		System.out.println("e".matches(regex3));

		String regex4 = "[a-z&&[^b-f]]";
		System.out.println("f".matches(regex4));
		System.out.println("x".matches(regex4));
	}
}
