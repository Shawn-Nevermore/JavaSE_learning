package abstractDemo;

public class Demo1016 {
	public static void main(String[] args) {
		Outer.method().show(); // ��ʽ���
	}

}

interface Inter {
	void show();
}

// Ҫ�����helloworld������Outer�������
class Outer {

	public static Inter method() {
		return new Inter() {
			public void show() {
				System.out.println("Helloworld");
			}
		};
	}
}