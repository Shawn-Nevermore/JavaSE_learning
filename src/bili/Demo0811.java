package bili;

public class Demo0811 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zi z = new Zi(); // ������һ��������ʲô��

		// 1.main��ջ��jvm������main����
		// 2.�����ࣺ����Zi z = new Zi();���Ƚ�Fu.class��Zi.class���ؽ��ڴ棬�ٴ�������
		// ���������ľ�̬�����ֱ���������ض����أ���������ྲ̬����飬�����ࡣ������̬�����Fu�����󡰾�̬�����Zi��
		// 3.���ù��췽������Ϊ���๹�췽��������super()�������ȵ��ø��๹�췽���������и��๹�����飬�������ڹ��췽��ִ�У�
		// ����ִ��֮���ٵ���Fu()�����������ϣ����ŵ������࣬˳��ͬ���ࡣ

		// ����˳��
		// ��̬�����Fu
		// ��̬�����Zi
		// ��������Fu
		// ���췽��Fu
		// ��������Zi
		// ���췽��Zi

	}

}

class Fu {
	static {
		System.out.println("��̬�����Fu");
	}
	{
		System.out.println("��������Fu");
	}

	public Fu() {
		System.out.println("���췽��Fu");
	}
}

class Zi extends Fu {
	static {
		System.out.println("��̬�����Zi");
	}
	{
		System.out.println("��������Zi");
	}

	public Zi() {
		System.out.println("���췽��Zi");
	}
}