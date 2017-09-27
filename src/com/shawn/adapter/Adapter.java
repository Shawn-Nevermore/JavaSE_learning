package com.shawn.adapter;

public class Adapter {
	/**
	 * 适配器设计模式
	 * 
	 * 案例：鲁智深
	 * 	身为一个和尚，不想打坐，念经，只想习武
	 * @param args
	 */
	public static void main(String[] args) {
		LuZhiShen zhiShen = new LuZhiShen();
		zhiShen.fight();
		
		TangSeng tangSeng = new TangSeng();
		tangSeng.chant();
		tangSeng.meditate();
		tangSeng.fight();
	}
}

interface Monk {
	public void meditate();
	public void chant();
	public void fight();
}

/**
 * 适配器类：
 * 声明成抽象的原因是，不想让其他类创建本来对象，全是空方法没有意义
 * @author user
 *
 */
abstract class Fighter implements Monk {

	@Override
	public void meditate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void chant() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		
	}
	
}

/**
 * 鲁智深只需要习武这个方法，因此只重写习武方法
 * @author user
 *
 */
class LuZhiShen extends Fighter {
	public void fight() {
		System.out.println("倒拔垂杨柳，拳打镇关西");
	}
}

class TangSeng extends Fighter {

	@Override
	public void meditate() {
		// TODO Auto-generated method stub
		super.meditate();
		System.out.println("唐僧打坐");
	}

	@Override
	public void chant() {
		// TODO Auto-generated method stub
		super.chant();
		System.out.println("唐僧念经");
	}
}