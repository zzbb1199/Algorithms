package 国赛恢复训练.算法复习;

import java.util.Calendar;

public class Problem14 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(1948, 9, 1);
		int count = 0;
		for(int i = 0;i<=63;i++) {
			c.add(Calendar.YEAR, 1);
			System.out.println(c.getTime());
			if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				count++;
			}
		}
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(count);
	}
}
