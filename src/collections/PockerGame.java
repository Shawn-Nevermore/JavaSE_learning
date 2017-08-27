package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * ������ģ������
 * 	1.��һ���˿�
 * 		a.���������飬�ֱ�洢��ɫ�����֣���С3�����2��
 * 		b.��HashMap��������
 * 	2.ϴ��
 * 		a.��ArrayList�������Ƶ�����
 * 		b.��Collections.shuffle()ϴ��
 * 	c.����
 * 		a.��������TreeSet���ϣ������������
 * 		b.����3�ŵ��ƣ�ʣ��51���ư�ģ3��ֵ����
 * 	d.����
 * 		��������TreeSet���ϣ����
 * @author ����
 *
 */
public class PockerGame {

	public static void main(String[] args) {

		// ����
		String[] number = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", };
		String[] color = { "Heart", "Diamond", "spade", "club" };

		int index = 1;
		// ϴ�����飨ϴ������shuffle()����ֻ����List��
		ArrayList<Integer> list = new ArrayList<>();

		// ����
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

		// ϴ��
		Collections.shuffle(list);

		// ����
		TreeSet<Integer> player1 = new TreeSet<>();
		TreeSet<Integer> player2 = new TreeSet<>();
		TreeSet<Integer> me = new TreeSet<>();
		TreeSet<Integer> landlord = new TreeSet<>();

		for (int i = 0; i < list.size(); i++) {
			// �������ŵ���
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

		// ����
		show(player1, hm, "���һ");
		show(player2, hm, "��Ҷ�");
		show(me, hm, "��");
		show(landlord, hm, "����");
	}

	public static void show(TreeSet<Integer> set, HashMap<Integer, String> map, String name) {
		System.out.print(name + "�����ǣ�[");
		for (int i : set) {
			System.out.print(map.get(i) + ", ");
		}
		System.out.println("]");
	}

}
