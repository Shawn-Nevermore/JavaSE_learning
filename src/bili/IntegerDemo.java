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
		Double.valueOf(19);// ��Integer��ͬ���ǣ�Double��valueOf()������autoboxing�����У���û��һ������Ҫnew�¶���ĳ�������
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
		System.out.println(c == (a + b));// �� "=="��������������������ǰ�װ�����͵����ã����ǱȽ�ָ����Ƿ���ͬһ������;
											// �����������һ���������Ǳ��ʽ���������������㣩��Ƚϵ�����ֵ�����ᴥ���Զ�����Ĺ��̣���
		System.out.println(c.equals(a + b));
		System.out.println(g == (a + b));
		System.out.println(g.equals(a + b));// false,equals()���������������ת��
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
		System.out.println(i1 == i2);// false,new�����Ĳ�ͬ�Ķ���
		System.out.println(i11 == i12);// true��autoboxing���õĵײ㺯��intValue�������䷶Χ[-128,127]����byte��ȡֵ��Χ�����������Χ��new�µĶ���
		System.out.println(i21 == i22);// false
		System.out.println(i1.equals(i2));// true��������ͬ
		System.out.println("---------------");
	}

}
