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
		A.super.foo();// 接口A,B不能有继承关系
		// A.super.foo();//如果实现Clazz去实现A，C接口：Illegal reference to super type A, cannot
		// bypass the more specific direct super type abstractDemo.C
	}
}
