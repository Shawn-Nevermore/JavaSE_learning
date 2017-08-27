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
		// 需求：把一个字符串中的手机号获取出来
		String s = "My Singapore phone number is 06598765432, email address is johnxu@gmail.com. I've also used the phone number 18788888888 in China.";

		String regex = "[01][35678]\\d{9}";// 获取手机号的正则表达式
		Pattern p = Pattern.compile(regex);// 获取正则表达式
		Matcher m = p.matcher(s);// 获取匹配器
		while (m.find()) {// find()判断是否获取到
			System.out.println(m.group());// group()提取获取到的信息，内置指针，获取一个读一个
		}
	}

	private static void demo6() {
		// 替换-需求："我我..我...我我....我.要...要..要要要..要...学.学.编.编...编..编.程.程....程程"替换为"我要学编程"
		String regex = "\\.+";
		String str = "我我..我...我我....我.要...要..要要要..要...学.学.编.编...编..编.程.程....程程";
		String s1 = str.replaceAll(regex, "");
		System.out.println(s1);

		String s2 = s1.replaceAll("(.)\\1+", "$1");// $1代表第一组中的内容
		System.out.println(s2);
	}

	private static void demo5() {
		// 切割-需求：请按叠词切割："sdqqfgkkkhjppppkl"
		String regex = "(.)\\1+";// 第一组出现一次或多次
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
		// ex1.叠词："快快乐乐，高高兴兴"
		String regex = "(.)\\1(.)\\2"; // \\1代表第一组又出现一次
		String s = "快快乐乐";
		System.out.println(s.matches(regex));

		// ex2.叠词："要死要死"
		String regex1 = "(..)\\1";
		String s1 = "要死要死";
		System.out.println(s1.matches(regex1));
		System.out.println(s.matches(regex1));
		System.out.println("哈哈哈哈".matches(regex1));// true
		System.out.println("哈哈哈哈".matches(regex));// true
	}

	/**
	 * 正则表达式的替换功能
	 * 		public static String replaceAll(String regex, String replacement)
	 */
	private static void replaceDemo() {
		String regex = "\\d";
		String regex2 = "\\D";
		String s = "I1love23you";
		String s2 = s.replaceAll(regex, "");// 去掉字符串中的所有数字
		System.out.println(s2);
		String s3 = s.replaceAll(regex2, "");// 去掉字符串中的所有字母
		System.out.println(s3);
	}

	/**
	 * 有字符串“91 27 46 38 50”，请输出得到“27 38 46 50 91”
	 */
	public static String sortStr(String string) {
		String[] arr = string.split(" ");
		StringBuilder result = new StringBuilder("");

		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			intArr[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(intArr);// 不能直接用Arrays.sort()对String数组排序，"91 27 46 38 50 100 22 12 98 55"中100会出现的序列开头
		for (int i = 0; i < intArr.length; i++) {
			if (i == intArr.length - 1) {
				result.append("");
			}
			result.append(intArr[i]).append(" ");// 这里不要用append(s + " ")，因为俩字符串相加时，底层实现是先new一个StringBuffer对象，
			// 然后将结果赋值给该对象，最后用toString()方法转换回来。不如直接调用append()更好
		}

		return result.toString();
	}

	private static void splitDemo() {
		String addr = "johnxu2010cd@gmail.com";
		String[] arr = addr.split("[@\\.]");// 得到johnxu2010cd gmail com，然后分别赋值存储用户数据，按邮箱分类etc.
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
		System.out.println(" ".matches(regex2));// false，空格字符不是空字符
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

		System.out.println("通配符..:");
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
		System.out.println("4个空格和1个tab检验水平空格符");
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
		System.out.println("ab".matches(regex1));// false，[]代表单个字符
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
