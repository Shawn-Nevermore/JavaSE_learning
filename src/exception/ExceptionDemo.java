package exception;

/**
 * 异常：
 * 	程序在运行过程中出现的错误
 * 异常的继承体系：
 * 	Throwalble
 * 		Error
 * 		Exception
 * 			RuntimeException
 * JVM默认是如何处理异常的
 * 	两种处理方式：
 * 		a.自己将该问题处理，然后继续运行
 * 		b.自己没有针对的处理方式，只有交给main的jvm来处理
 * 	jvm有一个默认的异常处理机制，就将该异常处理，并打印相关信息到控制台，同时终止程序
 * 	
 * @author 先生
 *
 */
public class ExceptionDemo {
	public static void main(String[] args) {
		Demo d = new Demo();
		try {
			int x = d.divide(10, 0);
			System.out.println(x);
		} catch (ArithmeticException e) {
			System.out.println("除数为零，gg");
			// e.printStackTrace();
		}
	}

}

class Demo {
	public int divide(int a, int b) {
		return a / b;// new ArithmeticException()
	}
}