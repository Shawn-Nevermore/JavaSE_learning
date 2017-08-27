package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * 斗地主模拟生成
 * 	1.买一副扑克
 * 		a.建两个数组，分别存储花色和数字（最小3，最大2）
 * 		b.建HashMap存入牌组
 * 	2.洗牌
 * 		a.建ArrayList，存入牌的索引
 * 		b.用Collections.shuffle()洗牌
 * 	c.发牌
 * 		a.建立三个TreeSet集合，代表三个玩家
 * 		b.留出3张底牌，剩下51张牌按模3的值发出
 * 	d.看牌
 * 		遍历三个TreeSet集合，输出
 * @author 先生
 *
 */
public class PockerGame {

	public static void main(String[] args) {

		// 买牌
		String[] number = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", };
		String[] color = { "Heart", "Diamond", "spade", "club" };

		int index = 1;
		// 洗牌数组（洗索引，shuffle()方法只接受List）
		ArrayList<Integer> list = new ArrayList<>();

		// 牌组
		HashMap<Integer, String> hm = new HashMap<>();
		for (int i = 0; i < number.length; i++) {
			for (int j = 0; j < color.length; j++) {
				hm.put(index, color[j].concat(number[i]));
				list.add(index);
				index++;
			}
		}
		hm.put(53, "black joker");
		list.add(index++);
		hm.put(54, "red joker");
		list.add(index++);

		// 洗牌
		Collections.shuffle(list);

		// 发牌
		TreeSet<Integer> player1 = new TreeSet<>();
		TreeSet<Integer> player2 = new TreeSet<>();
		TreeSet<Integer> me = new TreeSet<>();
		TreeSet<Integer> landlord = new TreeSet<>();

		for (int i = 0; i < list.size(); i++) {
			// 先留三张底牌
			if (i >= list.size() - 3) {
				landlord.add(list.get(i));
			} else if (i % 3 == 0) {
				player1.add(list.get(i));
			} else if (i % 3 == 1) {
				player2.add(list.get(i));
			} else {
				me.add(list.get(i));
			}
		}

		// 看牌
		show(player1, hm, "玩家一");
		show(player2, hm, "玩家二");
		show(me, hm, "我");
		show(landlord, hm, "底牌");
	}

	public static void show(TreeSet<Integer> set, HashMap<Integer, String> map, String name) {
		System.out.print(name + "的牌是：[");
		for (int i : set) {
			System.out.print(map.get(i) + ", ");
		}
		System.out.println("]");
	}

}
