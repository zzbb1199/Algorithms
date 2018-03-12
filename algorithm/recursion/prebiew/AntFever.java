package algorithm.recursion.prebiew;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 长100厘米的细长直杆子上有n只蚂蚁。它们的头有的朝左，有的朝右。 每只蚂蚁都只能沿着杆子向前爬，速度是1厘米/秒。
 * 当两只蚂蚁碰面时，它们会同时掉头往相反的方向爬行。
 * 
 * 这些蚂蚁中，有1只蚂蚁感冒了。并且在和其它蚂蚁碰面时，会把感冒传染给碰到的蚂蚁。 请你计算，当所有蚂蚁都爬离杆子时，有多少只蚂蚁患上了感冒。
 * 
 * 【数据格式】 第一行输入一个整数n (1 < n < 50), 表示蚂蚁的总数。 接着的一行是n个用空格分开的整数 Xi (-100 < Xi <
 * 100),
 * Xi的绝对值，表示蚂蚁离开杆子左边端点的距离。正值表示头朝右，负值表示头朝左，数据中不会出现0值，也不会出现两只蚂蚁占用同一位置。其中，第一个数据代表的蚂蚁感冒了。
 * 
 * 要求输出1个整数，表示最后感冒蚂蚁的数目。
 * 
 * 例如，输入： 3 5 -2 8 程序应输出： 1
 * 
 * 再例如，输入： 5 -10 8 -20 12 25 程序应输出： 3
 * 
 * @author zxr
 *
 */
public class AntFever {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		List<Ant> ants = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			int k = input.nextInt();
			if (k < 0) {
				ants.add(new Ant(0, -k));
			} else {
				ants.add(new Ant(1, k));
			}
		}
		// 按坐标排序
		Collections.sort(ants);
		// 设置感染蚂蚁
		ants.get(0).isfever = true;
		int count = 1;
		// 开始仿真
		while (!check(ants)) {
			for (int i = 0; i < ants.size() ; i++) {
				// 寻找可能碰头的蚂蚁
				if (ants.get(i).direction == 0) {
					// 向下走蚂蚁
					if ( i -1 >= 0 && ants.get(i).cd - 1 == ants.get(i - 1).cd) {
						// 反向
						ants.get(i).direction = ants.get(i).direction^1;
						ants.get(i - 1).direction = ants.get(i - 1).direction^1;
						if (ants.get(i).isfever || ants.get(i-1).isfever) {
							ants.get(i - 1).isfever = true;
							ants.get(i).isfever = true;
							count++;
						}
					} else {
						ants.get(i).cd -= 1;
					}
				} else if (ants.get(i).direction == 1) {
					if ( i+ 1<= ants.size()-1 && ants.get(i).cd + 1 == ants.get(i + 1).cd) {
						// 反向
						ants.get(i).direction = ants.get(i).direction^1;
						ants.get(i + 1).direction = ants.get(i + 1).direction^1;
						if (ants.get(i).isfever || ants.get(i+1).isfever) {
							ants.get(i + 1).isfever = true;
							ants.get(i).isfever = true;
							count++;
						}
					} else {
						ants.get(i).cd += 1;
					}
				}
				if (ants.get(i).cd == 0 || ants.get(i).cd >= 100) {
					ants.remove(i);
					i--;// 因为list要更新
				}
			}
		}
		System.out.println(count);
	}

	/**
	 * 检查是否所有方向都一致
	 * 
	 * @param ants
	 * @return
	 */
	private static boolean check(List<Ant> ants) {
		int direct = ants.get(0).direction;
		for (int i = 1; i < ants.size(); i++) {
			if (direct != ants.get(i).direction) {
				return false;
			}
		}
		return true;
	}

	static class Ant implements Comparable<Ant> {
		int direction; // 方向 0 向下，1向上
		int cd; // 坐标
		boolean isfever = false; // 是否感冒

		public Ant(int direction, int cd) {
			super();
			this.direction = direction;
			this.cd = cd;
		}

		@Override
		public int compareTo(Ant o) {
			// TODO Auto-generated method stub
			return this.cd - o.cd;
		}

	}

}
