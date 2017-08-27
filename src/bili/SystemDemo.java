package bili;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class SystemDemo {
	public static void main(String[] args) {

		// gcDemo();
		// exitDemo();
		// demo1();
		// arrayDemo();
		// bidDemo();

		// dateDemo();
		/*int d = birthComputing("1991/12/11", "2017/08/23");
		System.out.println(d / 365);*/

		// Calendar c = Calendar.getInstance();// ��������ָ���������
		System.out.println(leapYear("2000"));
	}

	/**
	 * �ж������껹��ƽ�꣨�����ܱ�4��400���ܱ�100���������ۣ�
	 * 1.����Calendar����
	 * 2.ͨ��set��������������Ϊ��һ���3��1��
	 * 3.�����ڼ�һ
	 * 4.�ж������Ƿ�Ϊ29
	 */
	public static boolean leapYear(String year) {

		int y = Integer.parseInt(year);
		Calendar c = Calendar.getInstance();
		// ͨ��set��������������Ϊ��һ���3��1��
		c.set(y, 2, 1);
		// �����ڼ�һ
		c.add(Calendar.DAY_OF_MONTH, -1);
		// �ж������Ƿ�Ϊ29
		return c.get(Calendar.DAY_OF_MONTH) == 29;
	}

	/**
	 * �������������������
	 * 1.�������ַ����ͽ����ַ����洢��String������
	 * 2.�������ڸ�ʽ������
	 * 3.�������ַ���ת��Ϊ���ڶ���
	 * 4.ͨ�����ڶ���getTime()������ú���ֵ
	 * 5.����ת��Ϊ��Ϊ��λ
	 * @param birth
	 * @param today
	 * @return
	 * @throws ParseException 
	 */
	public static int birthComputing(String birth, String today) throws ParseException {

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		Date birthday = sdf1.parse(birth);
		Date todayDate = sdf1.parse(today);

		long mills = todayDate.getTime() - birthday.getTime();
		return (int) (mills / 1000 / 3600 / 24);
	}

	private static void dateDemo() throws ParseException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(sdf.format(date));

		// ��ʱ���ַ���ת��Ϊ���ڶ���
		String string = "2000/08/08 08:08:00";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d = sdf1.parse(string);
		System.out.println(d);
	}

	private static void bidDemo() {
		BigInteger b1 = new BigInteger("100");
		BigInteger b2 = new BigInteger("2");
		BigInteger[] arr = b1.divideAndRemainder(b2);
		System.out.println(Arrays.toString(arr));

		// ��һ�ַ�ʽ�����ַ���������Ҫ��double������ȷ��
		BigDecimal bd1 = new BigDecimal("3.0");
		BigDecimal bd2 = new BigDecimal("2.1");
		System.out.println(bd1.subtract(bd2));

		// �ڶ��ַ�ʽ������valueOf����
		BigDecimal bd3 = BigDecimal.valueOf(3.4);// �ײ�Ҳ��new����ķ�ʽ��ʵ�ֵ�
		BigDecimal db4 = BigDecimal.valueOf(1.2);
		System.out.println(bd3.subtract(db4));
	}

	private static void arrayDemo() {
		int[] src = { 11, 22, 33, 44, 55, 66 };
		int[] dest = new int[8];
		System.arraycopy(src, 0, dest, 0, src.length);// [11, 22, 33, 44, 55, 66, 0, 0]��������ԭ��������ȫ�����Ƶ�������
		System.out.println(Arrays.toString(dest));

		int[] newArr = src.clone();// clone��Ч�ʱ�newһ�������������ֵҪ��
		int[] arr = src;// [11, 22, 33, 44, 55, 66],�ı�ָ�룬ԭ��new�������������
		System.out.println(src != newArr);// true
		System.out.println(arr != src);// false
		System.out.println(newArr.equals(src));// false
		System.out.println(arr.equals(src));// true
		System.out.println(Arrays.toString(newArr));
	}

	private static void demo1() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			System.out.println("*");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	private static void exitDemo() {
		System.exit(0);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");// ��������˳�����仰��ִ��
	}

	private static void gcDemo() {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			new Demo();
			// ����������������
			// ���� gc ������ʾ�� Java���������һЩŬ��������δ�ö����Ա��ܹ����ٵ�������Щ����ǰռ�õ��ڴ档
			// ������Ȩ�ӷ��������з���ʱ��������Ѿ������Ŭ�������ж����Ķ����л����˿ռ䡣
			System.gc();
			count++;
		}
		System.out.println(count);
	}
}

class Demo {

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("cleaning...");
	}

}
