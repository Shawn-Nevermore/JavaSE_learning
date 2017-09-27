package com.shawn.factoryMethod;

import static org.junit.Assert.*;

/**
 * A.工厂方法模式概述 
 * 	又叫静态工厂方法模式，它定义一个具体的类创建方法的实例 
 * 
 * B.优点：
 * 	客户端不需要再负责对象的创建，从而明确了各个类的职责，如果有新的对象增加，只需要增加一个具体的类和一个具体的工厂类，不影响已有的代码，后期维护更容易，增强了系统的扩展性
 * 
 * C.缺点： 
 * 	增加了工作量
 * 
 * @author user
 *
 */
public class Test {

	@org.junit.Test
	public void test() {
		DogFactory df = new DogFactory();
		Dog d = (Dog) df.createAnimal();

		d.eat();
	}

}
