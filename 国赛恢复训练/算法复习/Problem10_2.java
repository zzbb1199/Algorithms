package 国赛恢复训练.算法复习;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;

/**
 * 筛选法求解素数
 * @author Raven
 *
 */
public class Problem10_2 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		//初始化
		for(int i = 2;i<=1000*100*13;i++) {
			list.add(i);
		}
		//筛选法，筛选
		for(int i = 0;i<list.size();i++) {
			for(int j = i+1;j<list.size();j++) {
				if(list.get(j)% list.get(i) == 0) {
					list.remove(j);
					j--;
				}
			}
		}
		try {
			System.out.println(list.get(100002));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
