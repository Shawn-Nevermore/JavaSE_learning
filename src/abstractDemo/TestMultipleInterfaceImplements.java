package abstractDemo;

public class TestMultipleInterfaceImplements {

}

interface A {
	default void foo() {
		System.out.println("Calling A.foo()");
	}
}

interface B {
	default void foo() {
		System.out.println("Calling B.foo()");
	}
}

interface C extends A {
	default void foo() {
		System.out.println("Calling C.foo()");
	}
}

class Clazz implements A, B {
	public void foo() {
		A.super.foo();// �ӿ�A,B�����м̳й�ϵ
		// A.super.foo();//���ʵ��Clazzȥʵ��A��C�ӿڣ�Illegal reference to super type A, cannot
		// bypass the more specific direct super type abstractDemo.C
	}
}
