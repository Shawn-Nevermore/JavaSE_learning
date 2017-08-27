package bili;

public class Demo0916 {
	public static void main(String[] args) {
		// Inter i = new Inter();//�ӿڲ���ʵ����
		Inter i = new interDemo();
		i.print();
		Inter.test1();
		i.test();
	}
}

/**
 * �ӿڸ����������ṩ����Ķ��ǽӿڣ����壩
 * �ӿ��ص㣺
 *         a���ؼ���interface
 *         b����ʵ�ֽӿ���implements
 *         c���ӿڲ���ʵ�������ö�̬�ķ�ʽʵ������
 *         d���ӿڵ����ࣺ�����ǳ����࣬�����岻��
 *                       �����Ǿ����࣬�ұ�����д�ӿ��е����г��󷽷�
 * �ӿڵĳ�Ա�ص㣺
 *         ��Ա������Ĭ�����η� public static final
 *         ���췽�����ӿ���û�й��췽��
 *         ��Ա������Ĭ�����η� public abstract
 *         
 *                       
 * �ӿںͳ����������
 * ��ͬ��:	
		1.���ǳ������ͣ�
		2.��������ʵ�ַ�������ǰ�ӿڲ��У���
		3.�����Բ���Ҫʵ������߼̳���ȥʵ�����з���������ǰ���У����ڽӿ���Ĭ�Ϸ�������Ҫʵ����ʵ�֣�
      ��ͬ�㣺
		1.�����಻���Զ��ؼ̳У��ӿڿ��ԣ������Ƕ������ͼ̳л��Ƕ�����Ϊ�̳У���
		2.������ͽӿ�����ӳ����������ͬ����ʵ�������ʾ����"is-a"��ϵ���ӿڱ�ʾ����"like-a"��ϵ��
		3.�ӿ��ж���ı���Ĭ����public static final �ͣ��ұ�������ֵ������ʵ�����в��ܸı���ֵ��
		    �������еı���Ĭ���� friendly �ͣ���ֵ���������������¶��壬Ҳ�������¸�ֵ�� 
 * 
 * @author ����
 *
 */
interface Inter {
	// private int num = 10;//Illegal modifier for the interface field
	// Inter.num; only public, static & final are permitted
	public static final int num = 10; // �����ؼ��ֿ��Խ���˳��

	// public Inter() {}// Interfaces cannot have constructors

	public abstract void print();

	// ΪʲôҪ��������ԣ����ȣ�֮ǰ�Ľӿ��Ǹ�˫�н����ô�����������������������̣�ȱ���ǣ�����Ҫ�޸Ľӿ�ʱ����Ҫ�޸�ȫ��ʵ�ָýӿڵ��࣬
	// Ŀǰ��java8֮ǰ�ļ��Ͽ��û��foreach������ͨ�����뵽�Ľ���취����JDK�����صĽӿ�����µķ�����ʵ�֡�Ȼ���������Ѿ������İ汾��
	// ��û���ڸ��ӿ�����·�����ͬʱ��Ӱ�����е�ʵ�֡�����������Ĭ�Ϸ��������ǵ�Ŀ����Ϊ�˽���ӿڵ��޸������е�ʵ�ֲ����ݵ����⡣
	public default void test() {
		System.out.println("Inter�е�Ĭ�Ϸ���");
	}

	public static void test1() {
		System.out.println("Inter�еľ�̬����");
	}
}

class interDemo implements Inter {

	@Override
	public void print() {
		// num = 20;// The final field Inter.num cannot be assigned
		System.out.println("printing...");
	}

}
