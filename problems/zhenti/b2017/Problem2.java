package problems.zhenti.b2017;


import java.util.ArrayList;
import java.util.List;


public class Problem2 {

	/**
	 * @param args
	 */
	static List<Integer> a = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//找到一堆素数
		findSu();
		//遍历查找
		//起点
		for(int i = 0;i<a.size();i++){
			int a1 = a.get(i);
			for(int d = 1;d<=1000;d++){//公差
				boolean is = true;
				for(int k = 1;k<10;k++){//寻找10个数
					int temp = a1+k*d;
					if(!a.contains(temp)){
						is = false;
						break;
					}
				}
				if(is){
					System.out.println(d);
					break;
				}
			}
		}
	}
	private static void findSu() {
		// TODO Auto-generated method stub
		for(int i = 2;i<= 10000;i++){
			boolean is = true;
			for(int j = 2;j<i;j++){
				if(i % j == 0){
					is = false;
					break;
				}
			}
			if(is){
				a.add(i);
			}
		}
	}

}
