package bili;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.Person;

public class StringDemo {

	public static void main(String[] args) {

		// demo1();
		// demo2();
		// count("ABCDEabcd123456!@#$%^");
		// char2String();
		// obj2String();
		// compare2Str();

		/*		// test:首字母大写，其余小写
				 String s = "sdfwWEFWIOEFfwe";
				 System.out.println(transCase(s));
				 System.out.println(newTransCase(s));
		*/

		/*		// test:整型数组转化为某种格式的String类型输出
				int arr[] = { 12, 1, 3, 44, 32 };
				// 1.数组遍历法
				 String s = intArr2String(arr);
				 System.out.println(s);
		
				// 2.StringBuffer拼接法
				String s1 = newIntArr2String(arr);
				System.out.println(s1);
		*/

		/*		// test:字符串反转
				// 1.字符数组逐个交换
				String string = reverseStr("asdf1234");
				// 2.字符数组逆序遍历
				String string2 = newReverseStr("fwef1123");
				// 3.StringBuffer自带的reverse方法
				String string3 = bufferReverseStr("uoyevoli");
				System.out.println(string);
				System.out.println(string2);
				System.out.println(string3);
		*/

		/*		// test：寻找大串中小串出现的次数
				String longString = "1123qqisalwaysgoodqqhahaqq";
				String shortString = "qq";
				// 第一种实现：
				int count1 = strCount(longString, shortString);
				System.out.println(count1);
		
				// 第二种实现：
				int count2 = newStrCount(longString, shortString);
				System.out.println(count2);
		
				// 第三种实现：
				System.out.println(findStr(longString, shortString));
		*/

	}

	private static void demo2() {
		/**
		 * int转String：
		 * 		1.+
		 * 		2.String.valueOf(int a);
		 * 		3.Integer.toString(int a);  静态方法
		 * 		4.Integer对象的toString方法   动态方法
		 * String转int:
		 * 		parseInt(String s)
		 */
		String s1 = 1 + "";
		String s2 = String.valueOf(1);
		Integer i = new Integer(1);
		String s3 = i.toString();
		String s4 = Integer.toString(1);

		System.out.print(s1 + s2 + s3 + s4);

		int value = Integer.parseInt("1234");
	}

	/**
	 * 寻找大串中小串出现的次数，使用String自带的indexOf方法，返回所在索引值，为正，计数器++，截取字符串，再循环。为负，退出循环，查找结束
	 * @param originStr
	 * @param check
	 * @return
	 */
	private static int newStrCount(String originStr, String check) {

		int count = 0;
		int index = originStr.indexOf(check);

		while (originStr.indexOf(check) != -1) {// originStr.length() >= check.length()
												// 我自己是通过判断长度的方法来作条件的，属于自己去实现底层功能的行为，没有面向对象，不好
			count++;
			originStr = originStr.substring(index + check.length());

		}
		return count;

	}

	/**
	 * 没有想到用indexOf去找，而是选择自己去底层实现
	 * @param originStr
	 * @param check
	 * @return
	 */
	private static int strCount(String originStr, String check) {

		int count = 0;
		int checkLen = check.length();
		char checkChar = check.charAt(0);

		for (int i = 0; i < originStr.length() - checkLen + 1; i++) {
			if (checkChar == originStr.charAt(i)) {
				if (check.equals(originStr.substring(i, i + checkLen))) {// 在这里卡了很久，因为用了“==”没有用equals()方法，记住比较内容，永远用equals()方法
					count++;
					i += checkLen;// 加速比较进程
				}
			}
		}

		return count;
	}

	/**
	 * 正则表达式找答案
	 * @param srcText
	 * @param keyword
	 * @return
	 */
	public static int findStr(String srcText, String keyword) {
		int count = 0;
		Pattern p = Pattern.compile(keyword);
		Matcher m = p.matcher(srcText);
		while (m.find()) {
			count++;
		}
		return count;
	}

	/**
	 * 字符串反转
	 * 我的思路：1.将字符串转成字符数组
	 * 			2.将字符数组收尾元素逐个颠倒
	 * 			3.将字符数组转回成字符串
	 */
	private static String reverseStr(String str) {

		char[] result = str.toCharArray();
		for (int i = 0; i < str.length() / 2; i++) {

			// 建立首尾变量，循环交换
			char c1 = result[i];
			char c2 = result[str.length() - 1 - i];
			c1 = str.charAt(i);
			c2 = str.charAt(str.length() - 1 - i);
			char temp = c1;
			c1 = c2;
			c2 = temp;

			// 交换后的变量重新赋值给首尾
			result[i] = c1;
			result[str.length() - 1 - i] = c2;

		}

		String s = "";
		for (char c : result) {
			s += c;
		}
		return s;
	}

	/**
	 * 字符串反转：
	 * 新思路：1.将字符串转成字符数组
	 * 		  2.倒着遍历字符数组
	 * 		  3.拼接成串
	 */
	private static String newReverseStr(String s) {
		char[] arr = s.toCharArray();
		String result = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			result += arr[i];
		}
		return result;
	}

	/**
	 * 字符串反转：
	 * 新思路：1.将字符串转成StringBuffer对象
	 * 			2.用自带的reverse()方法
	 * 			3.toString()转回字符串
	 */
	private static String bufferReverseStr(String s) {

		StringBuffer sb = new StringBuffer(s);
		sb.reverse();
		return sb.toString();
	}

	private static void compare2Str() {
		String s1 = "a";
		String s2 = "abca";
		System.out.println(s1.compareTo(s2)); // 首字母相同长度不同的字符串，比较长度差，返回-3

		String s3 = "abcd";
		String s4 = "abde";
		System.out.println(s3.compareTo(s4));// 长度相同，按字典顺序比较出现差异的第一个字母的ascii码差值，返回-1
	}

	/**
	 * 整型数组转化为某种格式的String类型输出
	 * 例如：输入{1,2,3} 输出"[1, 2, 3]"
	 * 
	 * 思路：数组倒序遍历
	 * @param arr
	 * @return
	 */
	private static String intArr2String(int[] arr) {
		String result = "[";
		for (int i = 0; i < arr.length; i++) {
			result += arr[i] + ", ";
		}

		return result.substring(0, result.length() - 2) + "]";
	}

	/**
	 * 整型数组转化为某种格式的String类型输出
	 * 例如：输入{1,2,3} 输出"[1, 2, 3]"
	 * 
	 * 思路：用StringBuffer拼接字符串（更推荐，只会创建一个StringBuffer对象）
	 * @param arr
	 * @return
	 */
	private static String newIntArr2String(int[] arr) {
		StringBuffer sb = new StringBuffer("[");
		for (int i : arr) {
			sb.append(i).append(", ");// 这里不要用append(i + ", ")，因为俩字符串相加时，底层实现是先new一个StringBuffer对象，
										// 然后将结果赋值给该对象，最后用toString()方法转换回来。不如直接调用append()更好
		}
		return sb.substring(0, sb.length() - 2) + "]";
	}

	/**
	 * 首字母大写，其余全小写的
	 * @param s
	 * @return
	 */
	private static String transCase(String s) {
		String s1 = s.toUpperCase();
		char start = s1.charAt(0);
		s1 = s1.substring(1);
		s1 = s1.toLowerCase();
		return start + s1;
	}

	/**
	 * 链式编程实现大小写转换
	 * @param s
	 * @return 首字母大写，其余全小写的s
	 */
	private static String newTransCase(String s) {
		return s.substring(0, 1).toUpperCase().concat(s.substring(1).toLowerCase());
	}

	private static void obj2String() {
		Person p1 = new Person("Tom", 12);
		System.out.println(p1.toString());
		System.out.println(String.valueOf(p1)); // return (obj == null) ? "null" : obj.toString();
												// 底层的实现还是用toString()，如果不重写，返回Person的地址
	}

	private static void char2String() {
		char[] arr = { 'a', 'f', 'k' };
		String s = new String(arr);
		String s1 = String.valueOf(arr);// 这里valueOf()的底层实现就是String的构造
		System.out.println(s);
		System.out.println(s1);
	}

	/**
	 * 字符串的遍历
	 */
	private static void demo1() {
		String s = "Hello world!";

		// 第一种，调用charAt()方法
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i) + ",");
		}

		// 第二种，转化成char[]
		char[] arr = s.toCharArray();
		for (char c : arr) {
			System.out.print(c + ",");
		}
	}

	/**
	 * 统计字符串中各种类型字符出现的次数：
	 * ABCDEabcd123456!@#$%^
	 * 
	 */
	private static void count(String s) {
		int countUpper = 0;
		int countLower = 0;
		int countNumber = 0;
		int countOther = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'A' && c <= 'Z') {
				countUpper++;
			} else if (c >= 'a' && c <= 'z') {
				countLower++;
			} else if (c >= '0' && c <= '9') {
				countNumber++;
			} else {
				countOther++;
			}
		}

		System.out.println(s + " contains Uppercase:" + countUpper + " Lowercase:" + countLower + " Number:"
				+ countNumber + " Others:" + countOther);

	}

}
