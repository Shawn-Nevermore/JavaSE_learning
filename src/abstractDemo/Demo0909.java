package abstractDemo;

public class Demo0909 {
	public static void main(String[] args) {
		Animal a = new Cat();
		a.eat();
		a.show();
	}
}

/**
 * 抽象类
 * 抽象类的特点：
 *       a、抽象类和抽象方法必须由abstract关键字修饰
 *       abstract class Something {}
 *       public abstract void something();
 *       b、抽象类不一定有抽象方法，有抽象方法的一定是抽象类或接口
 *       c、抽象类不能实例化（由具体的子类去实例化。多态的一种，记为抽象类多态）
 *       d、抽象类的子类要么是抽象类，要么重写抽象类中所有的抽象方法
 *
 *抽象类的成员特点：
 *       a、成员变量：既可以是变量，也可以是常量。abstract不能修饰成员变量
 *       b、构造方法：有。用于子类访问父类数据的初始化
 *       c、成员方法：既可以是抽象的，也可以是非抽象的
 *       成员方法特性：抽象方法是强制要求子类做的事情；非抽象方法是子类继承的事情，为了提高代码的复用性
 *       
 * abstract 和哪些关键字不能共存？
 * 	     abstract和static：被abstract修饰的方法没有方法体，但是静态方法可以直接由类调用，而调用抽象方法没有意义
 *       abstract和final：被abstract修饰的方法强制子类重写，被final修饰的方法不让子类重写，互相矛盾
 *       abstract和private：被abstract修饰的方法是为了让子类访问并强制重写，别private修饰的方法不让子类访问，互相矛盾
 *       
 */
abstract class Animal {

	String genre = "Animal";
	final int ID = 0;

	public Animal() {
		System.out.println("父类空参构造");

	}

	public abstract void eat();// 抽象方法

	public void show() {// 非抽象方法
		System.out.println(genre + "..." + ID);
	}
}

class Cat extends Animal {

	public Cat() {
		super();
	}

	public void eat() {
		System.out.println("猫吃鱼");
	}
}