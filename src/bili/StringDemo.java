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

		/*		// test:����ĸ��д������Сд
				 String s = "sdfwWEFWIOEFfwe";
				 System.out.println(transCase(s));
				 System.out.println(newTransCase(s));
		*/

		/*		// test:��������ת��Ϊĳ�ָ�ʽ��String�������
				int arr[] = { 12, 1, 3, 44, 32 };
				// 1.���������
				 String s = intArr2String(arr);
				 System.out.println(s);
		
				// 2.StringBufferƴ�ӷ�
				String s1 = newIntArr2String(arr);
				System.out.println(s1);
		*/

		/*		// test:�ַ�����ת
				// 1.�ַ������������
				String string = reverseStr("asdf1234");
				// 2.�ַ������������
				String string2 = newReverseStr("fwef1123");
				// 3.StringBuffer�Դ���reverse����
				String string3 = bufferReverseStr("uoyevoli");
				System.out.println(string);
				System.out.println(string2);
				System.out.println(string3);
		*/

		/*		// test��Ѱ�Ҵ���С�����ֵĴ���
				String longString = "1123qqisalwaysgoodqqhahaqq";
				String shortString = "qq";
				// ��һ��ʵ�֣�
				int count1 = strCount(longString, shortString);
				System.out.println(count1);
		
				// �ڶ���ʵ�֣�
				int count2 = newStrCount(longString, shortString);
				System.out.println(count2);
		
				// ������ʵ�֣�
				System.out.println(findStr(longString, shortString));
		*/

	}

	private static void demo2() {
		/**
		 * intתString��
		 * 		1.+
		 * 		2.String.valueOf(int a);
		 * 		3.Integer.toString(int a);  ��̬����
		 * 		4.Integer�����toString����   ��̬����
		 * Stringתint:
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
	 * Ѱ�Ҵ���С�����ֵĴ�����ʹ��String�Դ���indexOf������������������ֵ��Ϊ����������++����ȡ�ַ�������ѭ����Ϊ�����˳�ѭ�������ҽ���
	 * @param originStr
	 * @param check
	 * @return
	 */
	private static int newStrCount(String originStr, String check) {

		int count = 0;
		int index = originStr.indexOf(check);

		while (originStr.indexOf(check) != -1) {// originStr.length() >= check.length()
												// ���Լ���ͨ���жϳ��ȵķ������������ģ������Լ�ȥʵ�ֵײ㹦�ܵ���Ϊ��û��������󣬲���
			count++;
			originStr = originStr.substring(index + check.length());

		}
		return count;

	}

	/**
	 * û���뵽��indexOfȥ�ң�����ѡ���Լ�ȥ�ײ�ʵ��
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
				if (check.equals(originStr.substring(i, i + checkLen))) {// �����￨�˺ܾã���Ϊ���ˡ�==��û����equals()��������ס�Ƚ����ݣ���Զ��equals()����
					count++;
					i += checkLen;// ���ٱȽϽ���
				}
			}
		}

		return count;
	}

	/**
	 * ������ʽ�Ҵ�
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
	 * �ַ�����ת
	 * �ҵ�˼·��1.���ַ���ת���ַ�����
	 * 			2.���ַ�������βԪ������ߵ�
	 * 			3.���ַ�����ת�س��ַ���
	 */
	private static String reverseStr(String str) {

		char[] result = str.toCharArray();
		for (int i = 0; i < str.length() / 2; i++) {

			// ������β������ѭ������
			char c1 = result[i];
			char c2 = result[str.length() - 1 - i];
			c1 = str.charAt(i);
			c2 = str.charAt(str.length() - 1 - i);
			char temp = c1;
			c1 = c2;
			c2 = temp;

			// ������ı������¸�ֵ����β
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
	 * �ַ�����ת��
	 * ��˼·��1.���ַ���ת���ַ�����
	 * 		  2.���ű����ַ�����
	 * 		  3.ƴ�ӳɴ�
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
	 * �ַ�����ת��
	 * ��˼·��1.���ַ���ת��StringBuffer����
	 * 			2.���Դ���reverse()����
	 * 			3.toString()ת���ַ���
	 */
	private static String bufferReverseStr(String s) {

		StringBuffer sb = new StringBuffer(s);
		sb.reverse();
		return sb.toString();
	}

	private static void compare2Str() {
		String s1 = "a";
		String s2 = "abca";
		System.out.println(s1.compareTo(s2)); // ����ĸ��ͬ���Ȳ�ͬ���ַ������Ƚϳ��Ȳ����-3

		String s3 = "abcd";
		String s4 = "abde";
		System.out.println(s3.compareTo(s4));// ������ͬ�����ֵ�˳��Ƚϳ��ֲ���ĵ�һ����ĸ��ascii���ֵ������-1
	}

	/**
	 * ��������ת��Ϊĳ�ָ�ʽ��String�������
	 * ���磺����{1,2,3} ���"[1, 2, 3]"
	 * 
	 * ˼·�����鵹�����
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
	 * ��������ת��Ϊĳ�ָ�ʽ��String�������
	 * ���磺����{1,2,3} ���"[1, 2, 3]"
	 * 
	 * ˼·����StringBufferƴ���ַ��������Ƽ���ֻ�ᴴ��һ��StringBuffer����
	 * @param arr
	 * @return
	 */
	private static String newIntArr2String(int[] arr) {
		StringBuffer sb = new StringBuffer("[");
		for (int i : arr) {
			sb.append(i).append(", ");// ���ﲻҪ��append(i + ", ")����Ϊ���ַ������ʱ���ײ�ʵ������newһ��StringBuffer����
										// Ȼ�󽫽����ֵ���ö��������toString()����ת������������ֱ�ӵ���append()����
		}
		return sb.substring(0, sb.length() - 2) + "]";
	}

	/**
	 * ����ĸ��д������ȫСд��
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
	 * ��ʽ���ʵ�ִ�Сдת��
	 * @param s
	 * @return ����ĸ��д������ȫСд��s
	 */
	private static String newTransCase(String s) {
		return s.substring(0, 1).toUpperCase().concat(s.substring(1).toLowerCase());
	}

	private static void obj2String() {
		Person p1 = new Person("Tom", 12);
		System.out.println(p1.toString());
		System.out.println(String.valueOf(p1)); // return (obj == null) ? "null" : obj.toString();
												// �ײ��ʵ�ֻ�����toString()���������д������Person�ĵ�ַ
	}

	private static void char2String() {
		char[] arr = { 'a', 'f', 'k' };
		String s = new String(arr);
		String s1 = String.valueOf(arr);// ����valueOf()�ĵײ�ʵ�־���String�Ĺ���
		System.out.println(s);
		System.out.println(s1);
	}

	/**
	 * �ַ����ı���
	 */
	private static void demo1() {
		String s = "Hello world!";

		// ��һ�֣�����charAt()����
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i) + ",");
		}

		// �ڶ��֣�ת����char[]
		char[] arr = s.toCharArray();
		for (char c : arr) {
			System.out.print(c + ",");
		}
	}

	/**
	 * ͳ���ַ����и��������ַ����ֵĴ�����
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
