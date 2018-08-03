package 国赛恢复训练.算法复习;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

/**
 * 任意给定4个数，能否生成24点,通过+ - * /
 * 
 * @author Raven
 *
 */
public class Problem16 {
	static Random r = new Random();
	static int[] buff = new int[7];// 前4个存数字，后3个存操作;

	public static void main(String[] args) {

		// 初始化数字
		buff[0] = 3;
		buff[1] = 4;
		buff[2] = 5;
		buff[3] = 6;
		int N = 10000; // 数字交换次数
		int n = 10000; // 操作数交换次数
		int t = 0;
		for (int i = 0; i < N; i++) {
			swapFigure();
			// 生成新的操作数
			generageOpr();
			for (int j = 0; j < n; j++) {
				// 交换操作数
				swapOpr();
				// 计算
				t = calculate();
				if (t == 24) {
					show();
				}
			}
		}
	}
	private static void show() {	
		Stack<String> s = new Stack<String>();
		for(int i = 0;i<4;i++) {
			s.push(buff[i]+"");
		}
		for(int i = 4;i<7;i++) {
			switch(buff[i]) {
			case 0:
				s.push("("+s.pop()+"+"+s.pop()+")");break;
			case 1:
				String m1 = s.pop();
				String m2 = s.pop();
				s.push("("+m1+"-"+m2+")");
				break;
			case 2:
				s.push("("+s.pop()+"*"+s.pop()+")");
				break;
			case 3:
				s.push("("+s.pop()+"/"+s.pop()+")");
				break;
			}
		}
		System.out.println(s.pop());
	}
	private static int calculate() {
		Stack<Integer> s = new Stack<Integer>();
		// 前四个数牙栈
		for (int i = 0; i < 4; i++) {
			s.push(buff[i]);
		}
		// 后三个数计算
		try {
			for (int i = 4; i < 7; i++) {
				switch (buff[i]) {
				case 0:
					s.push(s.pop() + s.pop());
					break;
				case 1:
					s.push(s.pop() - s.pop());
					break;
				case 2:
					s.push(s.pop() * s.pop());
					break;
				case 3:
					int m1 = s.pop();
					int m2 = s.pop();
					if (m1 % m2 == 0) {
						s.push(m1 / m2);
					} else {
						System.out.println(m1 / 0);// 主动唤起异常
					}
					break;
				}
			}
		} catch (EmptyStackException e) {
			e.printStackTrace();
		} catch (Exception e) {
			return 0;
		}
		return s.pop();

	}

	private static void swapOpr() {
		// TODO Auto-generated method stub
		int i = 4 + r.nextInt(3);
		int j = 4 + r.nextInt(3);
		int t = buff[i];
		buff[i] = buff[j];
		buff[j] = t;
	}

	/**
	 * 0 + 1 - 2 * 3 /
	 */
	private static void generageOpr() {
		// TODO Auto-generated method stub
		for (int i = 4; i < 7; i++) {
			buff[i] = r.nextInt(4);
		}

	}

	private static void swapFigure() {
		// TODO Auto-generated method stub
		int i = r.nextInt(4);
		int j = r.nextInt(4);
		int t = buff[i];
		buff[i] = buff[j];
		buff[j] = t;
	}

}
