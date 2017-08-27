package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import dao.Person;

/**
 * 1.����ʱ�쳣������ʱ�쳣������
 * 		���е�RuntimeException�༰�������ʵ������Ϊ����ʱ�쳣���������쳣���Ǳ���ʱ�쳣
 * 
 * ����ʱ�쳣��Java���������ʾ���������������޷�����ͨ����δ����ѣ�
 * ����ʱ�쳣��������ʾ����Ҳ���Ժͱ���ʱ�쳣һ������
 * 
 * 2.throws��throw������
 * 	a.throws:���巽��ʱ����Ҫ�����Ⱪ¶�����õ�����ȥ������ô����throws��ʶ
 * 	b.throw:�ڹ��ܷ����ڲ�����ĳ������������ܼ������У���Ҫ��תʱ����throw���쳣�����׳�
 * 	����
 * 		throws  ���ڷ����������棬�������쳣���������Ը��������                    ��ʾ�׳��쳣���ɸ÷����ĵ�����������
 * 		throw   ���ڷ������ڣ�       �������쳣��������ֻ���׳�һ���쳣����  ��ʾ�׳��쳣���ɷ���������䴦�� 
 * 
 * 3.finally������
 * 	�����ͷ���Դ����IO�������ݿ�����г�����
 * 	����ϵͳ��ִ��finally֮ǰ���Ѿ��˳���jvm��finally�Ų�ִ��
 * 	System.exit(0);
 * 
 * 4.Ϊʲô��Ҫ�Զ����쳣
 * 	ͨ���������ֵ�����ʲô�쳣��������ԵĽ���취
 * 
 * 5.�쳣��ע������
 * 	a.������д����ķ���ʱ������ķ��������׳���ͬ���쳣���߸����쳣������
 *  b.��������׳��˶���쳣������̳и���ʱֻ���׳���ͬ���쳣���������Ӽ�
 *  c.�������д�ķ���û���׳��쳣����ô����ķ����������׳��쳣��������෢���쳣����ô����ֻ��try������throws
 * 
 * @author ����
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
		System.out.println(x);// 30��return ����Ƚ�������·����ȷ�Ϸ���ֵ��30�������ǻ�ȥִ��finally�е���䣬����return �ٷ��أ�����x��ֵ�����

		System.out.println("------------------");

		Person p = new Person();
		p.setName("����");
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
