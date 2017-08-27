package abstractDemo;

public class Demo0909 {
	public static void main(String[] args) {
		Animal a = new Cat();
		a.eat();
		a.show();
	}
}

/**
 * ������
 * ��������ص㣺
 *       a��������ͳ��󷽷�������abstract�ؼ�������
 *       abstract class Something {}
 *       public abstract void something();
 *       b�������಻һ���г��󷽷����г��󷽷���һ���ǳ������ӿ�
 *       c�������಻��ʵ�������ɾ��������ȥʵ��������̬��һ�֣���Ϊ�������̬��
 *       d�������������Ҫô�ǳ����࣬Ҫô��д�����������еĳ��󷽷�
 *
 *������ĳ�Ա�ص㣺
 *       a����Ա�������ȿ����Ǳ�����Ҳ�����ǳ�����abstract�������γ�Ա����
 *       b�����췽�����С�����������ʸ������ݵĳ�ʼ��
 *       c����Ա�������ȿ����ǳ���ģ�Ҳ�����Ƿǳ����
 *       ��Ա�������ԣ����󷽷���ǿ��Ҫ�������������飻�ǳ��󷽷�������̳е����飬Ϊ����ߴ���ĸ�����
 *       
 * abstract ����Щ�ؼ��ֲ��ܹ��棿
 * 	     abstract��static����abstract���εķ���û�з����壬���Ǿ�̬��������ֱ��������ã������ó��󷽷�û������
 *       abstract��final����abstract���εķ���ǿ��������д����final���εķ�������������д������ì��
 *       abstract��private����abstract���εķ�����Ϊ����������ʲ�ǿ����д����private���εķ�������������ʣ�����ì��
 *       
 */
abstract class Animal {

	String genre = "Animal";
	final int ID = 0;

	public Animal() {
		System.out.println("����ղι���");

	}

	public abstract void eat();// ���󷽷�

	public void show() {// �ǳ��󷽷�
		System.out.println(genre + "..." + ID);
	}
}

class Cat extends Animal {

	public Cat() {
		super();
	}

	public void eat() {
		System.out.println("è����");
	}
}