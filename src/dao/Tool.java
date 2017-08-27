package dao;

public class Tool<Q> {
	private Q q;

	public Q getQ() {
		return q;
	}

	public Tool() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tool(Q q) {
		super();
		this.q = q;
	}

	public void setQ(Q q) {
		this.q = q;
	}

	public <W> void show(W w) { // ���������������ķ���һ��
		System.out.println(w); // �����һ�£���Ҫ�Լ�������������
	}

	public static <T> void print(T t) { // ��̬�����������Լ��ķ��ͣ�������أ�����Ҫ�����������ֻ���Լ��Դ����ͣ�
		System.out.println(t);
	}
}
