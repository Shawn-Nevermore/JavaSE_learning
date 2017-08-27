package bili;

/**
 * ��̬(polymorphism) 
 * 1��ǰ�᣺a��Ҫ�м̳й�ϵ b��Ҫ�з�����д(Override) c��Ҫ�и�������ָ���������
 * 
 * ��Ա���������뿴��ߣ����п����
 * ��Ա���������뿴��ߣ����п��ұߣ���̬�� run time type identification i.e. RTTI��
 * ��̬���������뿴��ߣ����п���ߣ���̬���ࣩ
 * 
 * ��̬�ĺô��ͱ׶ˣ�
 * �ô���a����ߴ����ά���ԣ��ɼ̳б�֤�� b������˴������չ�ԣ��ɶ�̬��֤��
 * �׶ˣ�����ʹ���������е����Ժ���Ϊ
 * @author ����
 * @version v1.0
 */
public class Demo0901 {

	public static void main(String[] args) {

		/*
		 * Animal & Cat & Dog ������
		 */
		Animal a = new Cat(); // �����˶�̬������ǰ�ᣨ������ʱ������ڴ�����ʱ���ø�������ָ���������ֱ�Ӵ�����������룬����ʹ���������ض������Ժ���Ϊ��
		a.eat(); // ����������������󣬱���ʱ�ȿ��������Ƿ���eat()��֤�����ܹ�ͨ���������е��õ������෽��
		System.out.println(a.legs); // ����a�Ǹ�������ã����ʵ���Ȼ�Ǹ��������
		a.method();// �൱��Animal.method()

		show(new Cat());// ����������ʱ�������
		show(new Dog()); // �����˶�̬���븴���Ըߵ��ص㡣����д�����������show()������

		System.out.println("--------------------------");

		/*
		 * ���˺���ͨ�˵�����
		 */
		Person p = new Superman();// ��⣺�ں���superman���Զ�����������ƽʱαװ����ͨ��
		p.bussiness();// ��Ϊ������ʵ��superman������������������̸�����������
		((Superman) p).fly();// �����Ҫչʾ�����ܷɵ���������Ҫ����ת�ͣ��ڿ��⴩��ǿ��ת��
	}

	public static void show(Animal a) {
		a.eat();

		// ������һ�㲻��ô�ã�����ʱһ��ֻ���ø�����������������д�ķ�����
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
		System.out.println("����Զ���");
	}

	public static void method() {
		System.out.println("Father...");
	}
}

class Cat extends Animal {

	int legs = 4;

	public void eat() {
		System.out.println("è����");

	}

	public void catchMouse() {
		System.out.println("ץ����");
	}

	public static void method() {
		System.out.println("Son...");
	}
}

class Dog extends Animal {
	int legs = 4;

	public void eat() {
		System.out.println("������");
	}

	public void housesitting() {
		System.out.println("����");
	}
}

class Person {
	String name = "Shawn";

	public void bussiness() {
		System.out.println("̸����...");
	}
}

class Superman extends Person {
	String name = "Superman";

	public void bussiness() {
		System.out.println("̸�����ڵĴ�����...");
	}

	public void fly() {
		System.out.println("�����ˣ��ɳ�ȥ����...");
	}
}
