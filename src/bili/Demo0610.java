package bili;

public class Demo0610 {
	public static void main(String[] args) {

		Student s = new Student();
		s.showInfo();
		//
		// Student s1 = new Student("Shawn", 12);
		// s1.setName("John");
		// s1.showInfo();

		// Test t = new Test();
		// t.showInfo();

	}

	static { // ������������ִ��
		System.out.println("�����������еľ�̬�����");
	}
}

/**
 * @author ����
 *
 */
class Student {

	public Student(String name, int num) {
		super();
		this.name = name;
		this.num = num;

		System.out.println("�вι���");
	}

	public Student() {
		// TODO Auto-generated constructor stub
		System.out.println("�ղι���");
	}

	private String name;
	private int num;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void showInfo() {
		// int num = 10;
		System.out.println(name + "..." + num);
	}

	public void study() {
		System.out.println("Studying...");
	}

	// �������飬�����У���������֣�
	// ������췽������ͬ�Ĵ�������һ��ÿ�ε��ù��춼ִ�У������ڹ���ǰִ��
	// ÿ����һ�ζ���ͻ�ִ��һ��
	{
		study();
	}

	// ��̬����飬�����з��������
	// ������ļ��ض����أ�ȫ��ִֻ��һ��
	// ���ã�����������г�ʼ����һ��������������
	static {
		System.out.println("���Ǿ�̬�����");
	}
}

class Test {

	// ��ʾ��ʼ��
	String name = "Hello";
	int id = 1;

	public Test(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Test() {
		System.out.println(name + "..." + id); // �����Ƿ��ڴ�������ʱ��ִ����ʾ��ʼ��
		name = "Hale"; // Ȼ���ٹ����ʼ��
		id = 2;
	}

	public void showInfo() {
		System.out.println(name + "..." + id);
	}

}