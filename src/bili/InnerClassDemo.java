package bili;

public class InnerClassDemo {
	public static void main(String[] args) {
		// 1.���ʳ�Ա����
		// new Outer().new Inner().print();
		new Outer().new Inner().show();

		// The type Outer.InnerPrivate is not visible
		// ����˽���ڲ���ķ������������ַ�ʽֱ�ӵ���
		// new Outer().new InnerPrivate().method();

		// 2.����˽���ڲ���ķ�����ֻ�������ⲿ���д�������ʵ�����ڲ���
		new Outer().method();

		// 3.���þ�̬�ڲ���ĳ�Ա����(�����new����Ծ�̬�ڲ����)
		new Outer.InnerStatic().method();

		// 4.���þ�̬�ڲ���ľ�̬����
		Outer.InnerStatic.methodStatic();

		// 5.���þֲ��ڲ����еķ���
		new Outer().show();

		// 6.���ú������ڲ���ķ���
		new Outer().showInner();
	}
}

/**
 * �ڲ���
 * 1�������ص㣺a���ڲ����ֱ�ӷ����ⲿ�����г�Ա������˽��
 *             b���ⲿ��Ҫ�����ڲ���ĳ�Ա�����봴������
 * @author ����
 *
 */
class Outer {

	private int num = 30;

	class Inner {

		public int num = 20;

		public void print() {
			System.out.println("print method in Inner...");
		}

		// �ڲ���֮�����ܻ�ȡ���ⲿ��ĳ�Ա������Ϊ���ܻ���ⲿ������ã���Outer.this
		public void show() {
			int num = 10;
			System.out.println(num);
			System.out.println(this.num);
			System.out.println(Outer.this.num);
		}

		// public static void method() {}//The method method cannot be declared static;
		// static methods can only be declared in a static or top level type
		// ���Ҫ�����ڲ��ྲ̬����������ڲ������Ҳ�Ǿ�̬��
	}

	// ˽���ڲ���
	private class InnerPrivate {
		public void method() {
			System.out.println(num);
		}
	}

	// �����ⲿ������ʵ�����ڲ��࣬����˽���ڲ���ķ���
	public void method() {
		InnerPrivate ni = new InnerPrivate();
		ni.method();
	}

	// ��̬�ڲ���
	static class InnerStatic {
		// ��̬�ڲ���ĳ�Ա����
		public void method() {
			System.out.println("method in InnerStatic");
		}

		// ��̬�ڲ���ľ�̬����
		public static void methodStatic() {
			System.out.println("static method in InnerStatic");
		}
	}

	public void show() {

		int num = 50;
		// �ֲ��ڲ��ֻࣨ���ڷ����б����ʣ�
		class InnerClazz {
			public void print() {
				System.out.println(num);
			}
		}

		InnerClazz ic = new InnerClazz();
		ic.print();

	}

	// �����ڲ���
	public void showInner() {
		new InterfaceAnonym() {

			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("�����ڲ���...");
			}

		}.show();
	}

}

interface InterfaceAnonym {
	void show();
}