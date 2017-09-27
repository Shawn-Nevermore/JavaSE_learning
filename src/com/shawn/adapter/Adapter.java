package com.shawn.adapter;

public class Adapter {
	/**
	 * ���������ģʽ
	 * 
	 * ������³����
	 * 	��Ϊһ�����У�������������ֻ��ϰ��
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
 * �������ࣺ
 * �����ɳ����ԭ���ǣ������������ഴ����������ȫ�ǿշ���û������
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
 * ³����ֻ��Ҫϰ��������������ֻ��дϰ�䷽��
 * @author user
 *
 */
class LuZhiShen extends Fighter {
	public void fight() {
		System.out.println("���δ�������ȭ�������");
	}
}

class TangSeng extends Fighter {

	@Override
	public void meditate() {
		// TODO Auto-generated method stub
		super.meditate();
		System.out.println("��ɮ����");
	}

	@Override
	public void chant() {
		// TODO Auto-generated method stub
		super.chant();
		System.out.println("��ɮ�");
	}
}