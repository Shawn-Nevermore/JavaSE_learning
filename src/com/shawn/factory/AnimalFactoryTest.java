package com.shawn.factory;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A.简单工厂模式：
 * 	又叫静态工厂方法模式，它定义一个具体的类创建方法的实例
 * B.优点：
 * 	客户端不需要再负责对象的创建，从而明确了各个类的职责
 * C.缺点：
 * 	因为该工厂负责所有对象的创建，如果有新的类增加，或者某些对象的创建方式不同，就需要不断的修改工厂类，不利于后期的维护
 * 
 * @author user
 *
 */
public class AnimalFactoryTest {

	@Test
	public void test1() {
		Dog d = (Dog) AnimalFactory.createAnimal("dog");
		d.eat();
		
		Cat c = (Cat) AnimalFactory.createAnimal("cat");
		c.eat();
		
//		空指针
		Dog p = (Dog) AnimalFactory.createAnimal("pig");
		p.eat();
		
	}

}
