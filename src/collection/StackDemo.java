package collection;

import java.util.LinkedList;

@SuppressWarnings("rawtypes")
public class StackDemo {

	private LinkedList list = new LinkedList<>();

	/**
	 * 模拟进栈
	 * @param obj
	 */
	public void in(Object obj) {
		list.addLast(obj);
	}

	/**
	 * 模拟出栈
	 * @param obj
	 */
	public Object out() {
		return list.removeLast();
	}

	/**
	 * 判断栈结构是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
