package abstractDemo;

public class TestStaticMethod {
	public static void main(String[] args) {
		TestClazzA a = new TestClazzB();
		a.printOrigin();

		TestInterfaceA.print();// static method in interface A.

		TestClazzB b = new TestClazzB();
		b.method();
		// b.print();//接口中的静态方法不能调用：The method print() is undefined for the type
		// TestClazzB
	}
}

class TestClazzA {
	public static void printOrigin() {
		System.out.println("static method in TestClazzA.");
	}
}

interface TestInterfaceA {
	public static void print() {
		System.out.println("static method in interface A.");
	}

	public default void method() {
		System.out.println("default method in interface A.");
	}
}

class TestClazzB extends TestClazzA implements TestInterfaceA {

}