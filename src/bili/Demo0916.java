package bili;

public class Demo0916 {
	public static void main(String[] args) {
		// Inter i = new Inter();//接口不能实例化
		Inter i = new interDemo();
		i.print();
		Inter.test1();
		i.test();
	}
}

/**
 * 接口概述：对外提供规则的都是接口（广义）
 * 接口特点：
 *         a、关键字interface
 *         b、类实现接口用implements
 *         c、接口不能实例化（用多态的方式实例化）
 *         d、接口的子类：可以是抽象类，但意义不大；
 *                       可以是具体类，且必须重写接口中的所有抽象方法
 * 接口的成员特点：
 *         成员变量：默认修饰符 public static final
 *         构造方法：接口中没有构造方法
 *         成员方法：默认修饰符 public abstract
 *         
 *                       
 * 接口和抽象类的区别：
 * 相同点:	
		1.都是抽象类型；
		2.都可以有实现方法（以前接口不行）；
		3.都可以不需要实现类或者继承者去实现所有方法，（以前不行，现在接口中默认方法不需要实现者实现）
      不同点：
		1.抽象类不可以多重继承，接口可以（无论是多重类型继承还是多重行为继承）；
		2.抽象类和接口所反映出的设计理念不同。其实抽象类表示的是"is-a"关系，接口表示的是"like-a"关系；
		3.接口中定义的变量默认是public static final 型，且必须给其初值，所以实现类中不能改变其值；
		    抽象类中的变量默认是 friendly 型，其值可以在子类中重新定义，也可以重新赋值。 
 * 
 * @author 先生
 *
 */
interface Inter {
	// private int num = 10;//Illegal modifier for the interface field
	// Inter.num; only public, static & final are permitted
	public static final int num = 10; // 三个关键字可以交换顺序

	// public Inter() {}// Interfaces cannot have constructors

	public abstract void print();

	// 为什么要有这个特性？首先，之前的接口是个双刃剑，好处是面向抽象而不是面向具体编程，缺陷是，当需要修改接口时候，需要修改全部实现该接口的类，
	// 目前的java8之前的集合框架没有foreach方法，通常能想到的解决办法是在JDK里给相关的接口添加新的方法及实现。然而，对于已经发布的版本，
	// 是没法在给接口添加新方法的同时不影响已有的实现。所以引进的默认方法。他们的目的是为了解决接口的修改与现有的实现不兼容的问题。
	public default void test() {
		System.out.println("Inter中的默认方法");
	}

	public static void test1() {
		System.out.println("Inter中的静态方法");
	}
}

class interDemo implements Inter {

	@Override
	public void print() {
		// num = 20;// The final field Inter.num cannot be assigned
		System.out.println("printing...");
	}

}
