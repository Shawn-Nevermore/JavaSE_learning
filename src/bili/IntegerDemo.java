package bili;

public class IntegerDemo {
	public static void main(String[] args) {

		// integerDemo();

		// booleanDemo();

		// longDemo();

		// doubleDemo();
	}

	private static void doubleDemo() {
		Double i1 = 100.0;
		Double i2 = 100.0;
		Double i3 = 200.0;
		Double i4 = 200.0;

		System.out.println(i1 == i2);// false
		System.out.println(i1.equals(i2));// true
		System.out.println(i3 == i4);// false

		Integer.valueOf(1);
		Double.valueOf(19);// 和Integer不同的是，Double的valueOf()方法在autoboxing过程中，并没有一个不需要new新对象的常量区间
	}

	private static void longDemo() {
		Long l1 = 127L;
		Long l2 = 127L;

		Long l3 = 128L;
		Long l4 = 128L;

		System.out.println(l1 == l2);// true
		System.out.println(l3 == l4);// false
		System.out.println(l3.equals(l4));// true

		System.out.println("----------------------");
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		Long h = 2L;

		System.out.println(c == d);
		System.out.println(e == f);// false
		System.out.println(c == (a + b));// 当 "=="运算符的两个操作数都是包装器类型的引用，则是比较指向的是否是同一个对象;
											// 而如果其中有一个操作数是表达式（即包含算术运算）则比较的是数值（即会触发自动拆箱的过程）。
		System.out.println(c.equals(a + b));
		System.out.println(g == (a + b));
		System.out.println(g.equals(a + b));// false,equals()方法不会进行类型转换
		System.out.println(g.equals(a + h));// true
	}

	private static void booleanDemo() {
		Boolean b1 = false;
		Boolean b2 = false;
		Boolean b3 = new Boolean(true);
		Boolean b4 = new Boolean(true);
		System.out.println(b1 == b2);// true
		System.out.println(b3 == b4);// false
		System.out.println(b3.equals(b4));// true
	}

	private static void integerDemo() {
		Integer i1 = new Integer(97);
		Integer i2 = new Integer(97);
		Integer i11 = 127;
		Integer i12 = 127;
		Integer i21 = 128;
		Integer i22 = 128;
		System.out.println(i1 == i2);// false,new出来的不同的对象
		System.out.println(i11 == i12);// true，autoboxing调用的底层函数intValue定义了其范围[-128,127]，即byte的取值范围，超过这个范围会new新的对象
		System.out.println(i21 == i22);// false
		System.out.println(i1.equals(i2));// true，内容相同
		System.out.println("---------------");
	}

}
