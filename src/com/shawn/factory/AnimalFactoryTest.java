package com.shawn.factory;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A.�򵥹���ģʽ��
 * 	�ֽо�̬��������ģʽ��������һ��������ഴ��������ʵ��
 * B.�ŵ㣺
 * 	�ͻ��˲���Ҫ�ٸ������Ĵ������Ӷ���ȷ�˸������ְ��
 * C.ȱ�㣺
 * 	��Ϊ�ù����������ж���Ĵ�����������µ������ӣ�����ĳЩ����Ĵ�����ʽ��ͬ������Ҫ���ϵ��޸Ĺ����࣬�����ں��ڵ�ά��
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
		
//		��ָ��
		Dog p = (Dog) AnimalFactory.createAnimal("pig");
		p.eat();
		
	}

}
