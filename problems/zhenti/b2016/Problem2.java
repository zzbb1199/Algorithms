package problem.zhenti.b2016;

public class Problem2 {
	public static void main(String[] args) {
		for(int i = 1;i<100;i++){//开始时间
			int sum = 0;
			for(int j = i;j<=100;j++){
				sum+=j;
				if(sum == 236){
					System.out.println(i);
					break;
				}
				if(sum > 236){
					break;
				}
			}
		}
	}//答案26岁
}
