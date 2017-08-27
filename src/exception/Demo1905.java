package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import dao.Person;

/**
 * 1.编译时异常和运行时异常的区别
 * 		所有的RuntimeException类及其子类的实例被称为运行时异常，其他的异常就是编译时异常
 * 
 * 编译时异常：Java程序必须显示处理，否则程序出错，无法编译通过（未雨绸缪）
 * 运行时异常：无需显示处理，也可以和编译时异常一样处理
 * 
 * 2.throws和throw的区别
 * 	a.throws:定义方法时，需要把问题暴露出来让调用者去处理，那么就用throws标识
 * 	b.throw:在功能方法内部出现某种情况，程序不能继续运行，需要跳转时就用throw把异常对象抛出
 * 	区别：
 * 		throws  用在方法申明后面，跟的是异常类名（可以跟多个），                    表示抛出异常，由该方法的调用者来处理
 * 		throw   用在方法体内，       跟的是异常对象名，只能抛出一个异常对象，  表示抛出异常，由方法体内语句处理 
 * 
 * 3.finally的作用
 * 	用于释放资源，在IO流和数据库操作中常见到
 * 	仅当系统在执行finally之前就已经退出了jvm，finally才不执行
 * 	System.exit(0);
 * 
 * 4.为什么需要自定义异常
 * 	通过名字区分到底是什么异常，好有针对的解决办法
 * 
 * 5.异常的注意事项
 * 	a.子类重写父类的方法时，子类的方法必须抛出相同的异常或者父类异常的子类
 *  b.如果父类抛出了多个异常，子类继承父类时只能抛出相同的异常或者他的子集
 *  c.如果被重写的方法没有抛出异常，那么子类的方法决不可抛出异常，如果子类发生异常，那么子类只能try，不能throws
 * 
 * @author 先生
 *
 */
public class Demo1905 {
	public static void main(String[] args) throws AgeOutOfBoundsException {
		try {
			FileInputStream file = new FileInputStream("xx.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.toString());
		}

		// divide(10, 0);

		// newDivide(10, 0);
		int x = method();
		System.out.println(x);// 30，return 语句先建立返回路径，确认返回值是30，但还是会去执行finally中的语句，最终return 再返回，但是x的值不会变

		System.out.println("------------------");

		Person p = new Person();
		p.setName("张三");
		p.setAge(-1);
		System.out.println(p.getName() + "..." + p.getAge());
	}

	private static int divide(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException();
		}
		return a / b;
	}

	private static int newDivide(int a, int b) throws ArithmeticException {
		return a / b;
	}

	private static int method() {
		int x = 10;
		try {
			x = 20;
			System.out.println(1 / 0);
			return x;

		} catch (Exception e) {
			x = 30;
			return x;
		} finally {
			x = 40;
			System.out.println(x);
		}
	}

}
