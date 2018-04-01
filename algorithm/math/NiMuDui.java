package algorithm.math;
/**
 * 有3堆硬币，分别是3,4,5
二人轮流取硬币。
每人每次只能从某一堆上取任意数量。
不能弃权。
取到最后一枚硬币的为赢家。

求先取硬币一方有无必胜的招法。
 * @author zxr
 * 运用了模２加的方法,如果所有堆数量的模２加后等于０，则当前人必输，否则可以赢。
 */
public class NiMuDui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] d = { 3,4,5 };
		f(d);
	}

	static void f(int[] a) {
		int sum = 0;
		for (int i : a) {
			sum ^= i;
		}
		if (sum == 0) {
			System.out.println("输");
			return;
		}
		for (int i : a) {
			int x = sum ^ i;
			if (x < i) {
				System.out.println(i + "-->" + x);
			}
		}

	}

}
