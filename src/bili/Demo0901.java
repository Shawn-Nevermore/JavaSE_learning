package bili;

/**
 * 多态(polymorphism) 
 * 1、前提：a、要有继承关系 b、要有方法重写(Override) c、要有父类引用指向子类对象
 * 
 * 成员变量：编译看左边，运行看左边
 * 成员方法：编译看左边，运行看右边（动态绑定 run time type identification i.e. RTTI）
 * 静态方法：编译看左边，运行看左边（静态和类）
 * 
 * 多态的好处和弊端：
 * 好处：a、提高代码的维护性（由继承保证） b、提高了代码的扩展性（由多态保证）
 * 弊端：不能使用子类特有的属性和行为
 * @author 先生
 * @version v1.0
 */
public class Demo0901 {

	public static void main(String[] args) {

		/*
		 * Animal & Cat & Dog 调用区
		 */
		Animal a = new Cat(); // 满足了多态的三大前提（开发的时候很少在创建的时候用父类引用指向子类对象，直接创建子类对象传入，可以使用子类中特定的属性和行为）
		a.eat(); // 堆中生成了子类对象，编译时先看父类中是否有eat()保证编译能够通过，再运行调用的是子类方法
		System.out.println(a.legs); // 引用a是父类的引用，访问的仍然是父类的属性
		a.method();// 相当于Animal.method()

		show(new Cat());// 当作参数的时候传入最好
		show(new Dog()); // 体现了多态代码复用性高的特点。不用写多个针对子类的show()方法。

		System.out.println("--------------------------");

		/*
		 * 超人和普通人调用区
		 */
		Person p = new Superman();// 理解：内核是superman，自动类型提升，平时伪装成普通人
		p.bussiness();// 因为本身其实是superman，所以他的能力还是谈大生意的能力
		((Superman) p).fly();// 如果需要展示超人能飞的能力，需要向下转型，内裤外穿，强制转换
	}

	public static void show(Animal a) {
		a.eat();

		// 开发中一般不这么用，开发时一般只调用父类中有且子类已重写的方法。
		if (a instanceof Cat) {
			Cat c = (Cat) a;
			c.catchMouse();
		}
		if (a instanceof Dog) {
			Dog d = (Dog) a;
			d.housesitting();
		}
	}
}

class Animal {
	String name;
	int legs;

	public void eat() {
		System.out.println("动物吃东西");
	}

	public static void method() {
		System.out.println("Father...");
	}
}

class Cat extends Animal {

	int legs = 4;

	public void eat() {
		System.out.println("猫吃鱼");

	}

	public void catchMouse() {
		System.out.println("抓老鼠");
	}

	public static void method() {
		System.out.println("Son...");
	}
}

class Dog extends Animal {
	int legs = 4;

	public void eat() {
		System.out.println("狗吃肉");
	}

	public void housesitting() {
		System.out.println("看家");
	}
}

class Person {
	String name = "Shawn";

	public void bussiness() {
		System.out.println("谈生意...");
	}
}

class Superman extends Person {
	String name = "Superman";

	public void bussiness() {
		System.out.println("谈几个亿的大生意...");
	}

	public void fly() {
		System.out.println("化身超人，飞出去救人...");
	}
}
