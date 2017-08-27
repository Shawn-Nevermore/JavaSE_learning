package dao;

import exception.AgeOutOfBoundsException;

public class Person implements Comparable {

	private String name;
	private int age;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws AgeOutOfBoundsException {
		if (age > 0 && age <= 150) {
			this.age = age;
		} else {
			throw new AgeOutOfBoundsException("invalid age input...");
		}
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {// 为了少调用hashCode方法
		/*
			为什么是31？
			1.31是质数
			2.31大小适中
			3.31=2<<5-1
		*/
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)// 调用对象和传入对象是同一个
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())// 不是同一个类
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		Person p = (Person) o;
		int num = this.age - p.age;
		return num == 0 ? this.name.compareTo(p.name) : num;// 比较年龄是主要的，姓名的compareTo是比较字符串，相同返回0，不同就按字符串的比较规则去比较
	}

}
