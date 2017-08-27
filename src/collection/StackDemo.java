package collection;

import java.util.LinkedList;

@SuppressWarnings("rawtypes")
public class StackDemo {

	private LinkedList list = new LinkedList<>();

	/**
	 * ģ���ջ
	 * @param obj
	 */
	public void in(Object obj) {
		list.addLast(obj);
	}

	/**
	 * ģ���ջ
	 * @param obj
	 */
	public Object out() {
		return list.removeLast();
	}

	/**
	 * �ж�ջ�ṹ�Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
