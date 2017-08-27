package bili;

public class Demo0821 {
	public static void main(String[] args) {
		finalDemo fd = new finalDemo();
		fd.print();
	}
}

class finalDemo {
	final int num;// 如果不初始化final值，会出现以下错误：The blank final field num may not have been initialized

	public finalDemo() {
		num = 10;// 但可以在对象构造完成前赋值初始化
	}

	public void print() {
		System.out.println(num);
	}
}
