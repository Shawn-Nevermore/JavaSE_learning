package com.shawn.factory;

public class AnimalFactory {
	/*
	 * public static Dog createDog() { return new Dog(); }
	 * 
	 * public static Cat createCat() { return new Cat(); }
	 */

	// ������������̫���࣬������̫��Ľ�����

	public static Animal createAnimal(String name) {
		if ("dog".equals(name)) {
			return new Dog();
		} else if ("cat".equals(name)) {
			return new Cat();
		} else {
			return null;
		}
	}
}
