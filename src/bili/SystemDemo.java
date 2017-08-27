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

		// Calendar c = Calendar.getInstance();// 父类引用指向子类对象
		System.out.println(leapYear("2000"));
	}

	/**
	 * 判断是闰年还是平年（不用能被4或400不能被100整除的理论）
	 * 1.创建Calendar对象
	 * 2.通过set方法将日期设置为那一年的3月1日
	 * 3.将日期减一
	 * 4.判断日期是否为29
	 */
	public static boolean leapYear(String year) {

		int y = Integer.parseInt(year);
		Calendar c = Calendar.getInstance();
		// 通过set方法将日期设置为那一年的3月1日
		c.set(y, 2, 1);
		// 将日期减一
		c.add(Calendar.DAY_OF_MONTH, -1);
		// 判断日期是否为29
		return c.get(Calendar.DAY_OF_MONTH) == 29;
	}

	/**
	 * 计算你来到世界多少天
	 * 1.将生日字符串和今天字符串存储在String变量中
	 * 2.定义日期格式化对象
	 * 3.将日期字符串转化为日期对象
	 * 4.通过日期对象getTime()方法获得毫秒值
	 * 5.求差，再转化为天为单位
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

		// 将时间字符串转换为日期对象
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

		// 第一种方式，传字符串，（不要传double，不精确）
		BigDecimal bd1 = new BigDecimal("3.0");
		BigDecimal bd2 = new BigDecimal("2.1");
		System.out.println(bd1.subtract(bd2));

		// 第二种方式，调用valueOf方法
		BigDecimal bd3 = BigDecimal.valueOf(3.4);// 底层也是new对象的方式来实现的
		BigDecimal db4 = BigDecimal.valueOf(1.2);
		System.out.println(bd3.subtract(db4));
	}

	private static void arrayDemo() {
		int[] src = { 11, 22, 33, 44, 55, 66 };
		int[] dest = new int[8];
		System.arraycopy(src, 0, dest, 0, src.length);// [11, 22, 33, 44, 55, 66, 0, 0]，真正将原数组数据全部复制到新数组
		System.out.println(Arrays.toString(dest));

		int[] newArr = src.clone();// clone的效率比new一个数组再逐个赋值要高
		int[] arr = src;// [11, 22, 33, 44, 55, 66],改变指针，原来new的数组成了垃圾
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
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");// 虚拟机已退出，这句话不执行
	}

	private static void gcDemo() {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			new Demo();
			// 运行垃圾回收器。
			// 调用 gc 方法暗示着 Java虚拟机做了一些努力来回收未用对象，以便能够快速地重用这些对象当前占用的内存。
			// 当控制权从方法调用中返回时，虚拟机已经尽最大努力从所有丢弃的对象中回收了空间。
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
