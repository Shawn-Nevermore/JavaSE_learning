package com.shawn.factoryMethod;

import static org.junit.Assert.*;

/**
 * A.��������ģʽ���� 
 * 	�ֽо�̬��������ģʽ��������һ��������ഴ��������ʵ�� 
 * 
 * B.�ŵ㣺
 * 	�ͻ��˲���Ҫ�ٸ������Ĵ������Ӷ���ȷ�˸������ְ��������µĶ������ӣ�ֻ��Ҫ����һ����������һ������Ĺ����࣬��Ӱ�����еĴ��룬����ά�������ף���ǿ��ϵͳ����չ��
 * 
 * C.ȱ�㣺 
 * 	�����˹�����
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
