package bili;

public class Demo0809 {

	public int num = 1;

	public static void main(String[] args) {

		Demo0809 d = new Demo0809();

		int num = 10;
		Son son = new Son();

		System.out.println("---------------------");
		Son son1 = new Son("Tom", 1111);
		son1.showInfo();
		System.out.println("---------------------");
		Father f = new Son();
		f.showInfo();
		System.out.println("---------------------");

		son.testOverride();
		print(d.num);
		System.out.println(d.num);
		print(num);
		System.out.println(num);

	}

	public static void print(int num) {
		num = 20;
		System.out.println(num);
	}

}

class Father {

	String name = "father";
	int id;

	Father() {
		System.out.println("father constructor...");
	}

	public void showInfo() {
		System.out.println(name + "..." + id);
	}

	public void testOverride() {
		System.out.println("father override method...");
	}

	public double salary(int month) {
		return id * month * 1.2;
	}
}

class Son extends Father {

	Son() {
		super(); // 子类中所有的构造方法默认都会访问父类的空参构造方法
		System.out.println("son constructor...");
	}

	Son(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public void showInfo() {
		System.out.println(name + "..." + id);
	}

	public void testOverride() {

		System.out.println("son override method...");
	}

	// 注意下面两个方法， 参数顺序不同可以重载
	public void testOverride(String name, int id) {

		System.out.println("son override method...");
	}

	public void testOverride(int id, String name) {

		System.out.println("son override method...");
	}

	public double salary(int month) {
		return id * month;
	}

}