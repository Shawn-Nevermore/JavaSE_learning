package abstractDemo;

public class Test {

	public static void main(String[] args) {
		new InterfaceB() {
		}.hello();
		new InterfaceC() {
		}.hello();
		new InterfaceD() {

			@Override
			public void hello() {
				System.out.println("Hello world from D");
			}
		}.hello();

		// lambda表达式
		((InterfaceD) () -> System.out.println("Hello world from D")).hello();

		new TestClazz().hello();
	}
}

class TestClazz implements InterfaceA, InterfaceE {
	public void hello() {
		// InterfaceA.hello();//Cannot make a static reference to the non-static method
		// hello() from the type InterfaceA
		InterfaceA.super.hello(); // 新语法：这句话要生效，所实现的俩接口不能有继承关系
	}
}

interface InterfaceA {
	default void hello() {
		System.out.println("Hello world from A");
	}
}

interface InterfaceB extends InterfaceA {

}

interface InterfaceC extends InterfaceB {
	default void hello() {
		System.out.println("Hello world from C");
	}
}

interface InterfaceD extends InterfaceC {

	@Override
	void hello();

}

interface InterfaceE {
	default void hello() {
		System.out.println("Hello world from E");
	}
}