package problems.zhenti.b2017;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 年月日格式
 * @author 张兴锐
 *
 */
public class Problem7 {
	static Set<String> consist = new HashSet<String>();
	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		String a = input.nextLine();
		String[] date = a.split("/");
		String year=null,month=null,day=null;
		//找到数字中大于31的，一定为年份
		int yearIndex = -1;
		for(int i = 0;i<date.length;i++){
			if(Integer.valueOf(date[i]) >= 31){
				yearIndex = i;
				break;
			}
		}
		
		//判定是否存在这样的数
		if(yearIndex != -1){
			//存在则判定区间
			if(Integer.valueOf(date[yearIndex]) >= 60){
				year = "19"+date[yearIndex];
			}else{
				year = "20"+date[yearIndex];
			}
			//确定日份
			int dayIndex = -1;
			for(int i =  0;i<2;i++){
				if(i != yearIndex && Integer.valueOf(date[i])> 12){
					dayIndex = i;
					break;
				}
			}
			//判定是否存在这样的月份
			if(dayIndex != -1){
				//存在
				day = date[dayIndex];
				for(int i = 0;i<2;i++){
					if(i != yearIndex && i != dayIndex){
						month = date[i];
						break;
					}
				}
				consist.add(year+"-"+month+"-"+day);
			}else{
				//不存在，则两种均可
				String index = "012".replace(yearIndex+"", "");
				//月在前
				month = date[index.charAt(0)-'0'];
				day = date[index.charAt(1)-'0'];
				consist.add(year+"-"+month+"-"+day);
				//天在前
				day = date[index.charAt(0)-'0'];
				month = date[index.charAt(1)-'0'];
				consist.add(year+"-"+month+"-"+day);
			}
		}else{
			//不存在这样的区间
			//查看是否有大于12的数字
			int mayIndex = -1;
			for(int i = 0;i<2;i++){
				if(Integer.valueOf(date[i]) > 12){
					mayIndex = i;
					break;
				}
			}
			if(mayIndex != -1){
				if(mayIndex == 1){
					//只有可能是日
					day = date[1];
					year = "20"+date[0];
					month = date[2];
					consist.add(year+"-"+month+"-"+day);
					
					year = "20"+date[2];
					month = date[0];
					consist.add(year+"-"+month+"-"+day);
				}else{
					//年
					year = "20"+date[0];
					month = date[1];
					day = date[2];
					consist.add(year+"-"+month+"-"+day);
					
					year = "20"+date[2];
					month = date[1];
					day = date[0];
					consist.add(year+"-"+month+"-"+day);
				}
			}else{
				//不存在，则有三种情况
				//年月日
				year = "20"+date[0];
				month = date[1];
				day = date[2];
				consist.add(year+"-"+month+"-"+day);
				//月日年
				year = "20"+date[2];
				month = date[0];
				day = date[1];
				consist.add(year+"-"+month+"-"+day);
				//日月年
				year = "20"+date[2];
				month = date[1];
				day = date[0];
				consist.add(year+"-"+month+"-"+day);
			}
		}
		//对日期排序
		List<String> d = sort();
		//输出
		for (String string : d) {
			System.out.println(string);
		}
	}
	private static List<String> sort() throws ParseException {
		List<String> a = new ArrayList<String>();
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		long[] m = new long[consist.size()];
		int i = 0;
		for (String s: consist) {
			m[i] = sdf.parse(s).getTime();
			i++;
		}
		//数字排序
		Arrays.sort(m);
		//还原
		for (long l : m) {
			a.add(sdf.format(new Date(l)));
		}
		return a;
	}
}
