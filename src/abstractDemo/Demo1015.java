package abstractDemo;

public class Demo1015 {
	public static void main(String[] args) {
		PersonDemo pd = new PersonDemo();
		pd.method(new Person() {
			public void show() {
				System.out.println("show something");
			}
		});
	}
}

abstract class Person {
	public abstract void show();
}

class PersonDemo {
	public void method(Person p) {
		p.show();
	}
}