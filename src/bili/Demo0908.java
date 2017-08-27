package bili;

public class Demo0908 {

	public static void main(String[] args) {

		A a = new B();
		a.show(); // love

		B b = new C();
		b.show(); // you
	}

}

class A {
	public void show() {
		show2();
	}

	public void show2() {
		System.out.println("I");
	}
}

class B extends A {
	public void show2() {
		System.out.println("love");
	}
}

class C extends B {
	public void show() {
		super.show();
	}

	public void show2() {
		System.out.println("you");
	}
}