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

	public <W> void show(W w) { // 方法泛型最好与类的泛型一致
		System.out.println(w); // 如果不一致，需要自己申明方法泛型
	}

	public static <T> void print(T t) { // 静态方法必须有自己的泛型（随类加载，不需要创建对象，因此只有自己自带泛型）
		System.out.println(t);
	}
}
