package exception;

/**
 * �쳣��
 * 	���������й����г��ֵĴ���
 * �쳣�ļ̳���ϵ��
 * 	Throwalble
 * 		Error
 * 		Exception
 * 			RuntimeException
 * JVMĬ������δ����쳣��
 * 	���ִ���ʽ��
 * 		a.�Լ��������⴦��Ȼ���������
 * 		b.�Լ�û����ԵĴ���ʽ��ֻ�н���main��jvm������
 * 	jvm��һ��Ĭ�ϵ��쳣������ƣ��ͽ����쳣��������ӡ�����Ϣ������̨��ͬʱ��ֹ����
 * 	
 * @author ����
 *
 */
public class ExceptionDemo {
	public static void main(String[] args) {
		Demo d = new Demo();
		try {
			int x = d.divide(10, 0);
			System.out.println(x);
		} catch (ArithmeticException e) {
			System.out.println("����Ϊ�㣬gg");
			// e.printStackTrace();
		}
	}

}

class Demo {
	public int divide(int a, int b) {
		return a / b;// new ArithmeticException()
	}
}