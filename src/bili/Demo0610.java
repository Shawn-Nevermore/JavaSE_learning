package bili;

public class Demo0610 {
	public static void main(String[] args) {

		Student s = new Student();
		s.showInfo();
		//
		// Student s1 = new Student("Shawn", 12);
		// s1.setName("John");
		// s1.showInfo();

		// Test t = new Test();
		// t.showInfo();

	}

	static { // 优先于主方法执行
		System.out.println("我是主方法中的静态代码块");
	}
}

/**
 * @author 先生
 *
 */
class Student {

	public Student(String name, int num) {
		super();
		this.name = name;
		this.num = num;

		System.out.println("有参构造");
	}

	public Student() {
		// TODO Auto-generated constructor stub
		System.out.println("空参构造");
	}

	private String name;
	private int num;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void showInfo() {
		// int num = 10;
		System.out.println(name + "..." + num);
	}

	public void study() {
		System.out.println("Studying...");
	}

	// 构造代码块，在类中，方法外出现：
	// 多个构造方法中相同的代码存放在一起，每次调用构造都执行，并且在构造前执行
	// 每创建一次对象就会执行一次
	{
		study();
	}

	// 静态代码块，在类中方法外出现
	// 随着类的加载而加载，全程只执行一次
	// 作用：用来给类进行初始化，一般用来加载驱动
	static {
		System.out.println("我是静态代码块");
	}
}

class Test {

	// 显示初始化
	String name = "Hello";
	int id = 1;

	public Test(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Test() {
		System.out.println(name + "..." + id); // 测试是否在创建对象时先执行显示初始化
		name = "Hale"; // 然后再构造初始化
		id = 2;
	}

	public void showInfo() {
		System.out.println(name + "..." + id);
	}

}