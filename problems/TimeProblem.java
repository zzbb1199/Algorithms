package problems;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 时间问题
 * @author 张兴锐
 *
 */
public class TimeProblem {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1777);
		c.set(Calendar.MONTH, 4);
		c.set(Calendar.DAY_OF_MONTH, 30);
		
		c.add(Calendar.DAY_OF_YEAR, 8113-1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(c.getTime()));
		
		//国庆星期几
		int count= 0;
		for(int i = 1949;i<=2018;i++){
			c.set(i, 9,1);
			if(c.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
				count++;
			}
		}
		System.out.println(count);
		
		//经过了多少秒
		c.set(1, 1, 1, 15, 25,17);
		long m1 = c.getTimeInMillis();
		c.set(1, 1, 1, 16, 25,17);
		long m2 = c.getTimeInMillis();
		System.out.println((m2 - m1)/1000);
		
	}

}
