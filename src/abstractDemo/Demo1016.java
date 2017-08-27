package abstractDemo;

public class Demo1016 {
	public static void main(String[] args) {
		Outer.method().show(); // 链式编程
	}

}

interface Inter {
	void show();
}

// 要求输出helloworld，补齐Outer里的内容
class Outer {

	public static Inter method() {
		return new Inter() {
			public void show() {
				System.out.println("Helloworld");
			}
		};
	}
}