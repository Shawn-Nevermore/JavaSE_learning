package bili;

public class InnerClassDemo {
	public static void main(String[] args) {
		// 1.访问成员方法
		// new Outer().new Inner().print();
		new Outer().new Inner().show();

		// The type Outer.InnerPrivate is not visible
		// 调用私有内部类的方法不能用这种方式直接调用
		// new Outer().new InnerPrivate().method();

		// 2.调用私有内部类的方法，只能先在外部类中创建方法实例化内部类
		new Outer().method();

		// 3.调用静态内部类的成员方法(这里的new是针对静态内部类的)
		new Outer.InnerStatic().method();

		// 4.调用静态内部类的静态方法
		Outer.InnerStatic.methodStatic();

		// 5.调用局部内部类中的方法
		new Outer().show();

		// 6.调用含匿名内部类的方法
		new Outer().showInner();
	}
}

/**
 * 内部类
 * 1、访问特点：a、内部类可直接访问外部类所有成员，包括私有
 *             b、外部类要访问内部类的成员，必须创建对象
 * @author 先生
 *
 */
class Outer {

	private int num = 30;

	class Inner {

		public int num = 20;

		public void print() {
			System.out.println("print method in Inner...");
		}

		// 内部类之所以能获取到外部类的成员，是因为他能获得外部类的引用，即Outer.this
		public void show() {
			int num = 10;
			System.out.println(num);
			System.out.println(this.num);
			System.out.println(Outer.this.num);
		}

		// public static void method() {}//The method method cannot be declared static;
		// static methods can only be declared in a static or top level type
		// 如果要创建内部类静态方法，则该内部类必须也是静态的
	}

	// 私有内部类
	private class InnerPrivate {
		public void method() {
			System.out.println(num);
		}
	}

	// 创建外部方法，实例化内部类，调用私有内部类的方法
	public void method() {
		InnerPrivate ni = new InnerPrivate();
		ni.method();
	}

	// 静态内部类
	static class InnerStatic {
		// 静态内部类的成员方法
		public void method() {
			System.out.println("method in InnerStatic");
		}

		// 静态内部类的静态方法
		public static void methodStatic() {
			System.out.println("static method in InnerStatic");
		}
	}

	public void show() {

		int num = 50;
		// 局部内部类（只能在方法中被访问）
		class InnerClazz {
			public void print() {
				System.out.println(num);
			}
		}

		InnerClazz ic = new InnerClazz();
		ic.print();

	}

	// 匿名内部类
	public void showInner() {
		new InterfaceAnonym() {

			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("匿名内部类...");
			}

		}.show();
	}

}

interface InterfaceAnonym {
	void show();
}