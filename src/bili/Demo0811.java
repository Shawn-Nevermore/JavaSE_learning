package bili;

public class Demo0811 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zi z = new Zi(); // 解释这一步发生了什么？

		// 1.main进栈：jvm调用了main方法
		// 2.加载类：遇到Zi z = new Zi();会先将Fu.class和Zi.class加载进内存，再创建对象。
		// 父类和子类的静态代码块分别随着类加载而加载，先输出父类静态代码块，后子类。即“静态代码块Fu”，后“静态代码块Zi”
		// 3.调用构造方法：因为子类构造方法中隐含super()，所以先调用父类构造方法，发现有父类构造代码块，其优先于构造方法执行，
		// 故先执行之，再调用Fu()，父类调用完毕；接着调用子类，顺序同父类。

		// 最终顺序：
		// 静态代码块Fu
		// 静态代码块Zi
		// 构造代码块Fu
		// 构造方法Fu
		// 构造代码块Zi
		// 构造方法Zi

	}

}

class Fu {
	static {
		System.out.println("静态代码块Fu");
	}
	{
		System.out.println("构造代码块Fu");
	}

	public Fu() {
		System.out.println("构造方法Fu");
	}
}

class Zi extends Fu {
	static {
		System.out.println("静态代码块Zi");
	}
	{
		System.out.println("构造代码块Zi");
	}

	public Zi() {
		System.out.println("构造方法Zi");
	}
}