package bili;

public class Demo0821 {
	public static void main(String[] args) {
		finalDemo fd = new finalDemo();
		fd.print();
	}
}

class finalDemo {
	final int num;// �������ʼ��finalֵ����������´���The blank final field num may not have been initialized

	public finalDemo() {
		num = 10;// �������ڶ��������ǰ��ֵ��ʼ��
	}

	public void print() {
		System.out.println(num);
	}
}
