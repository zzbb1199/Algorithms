package 蓝桥杯官方.真题.省赛题.zhenti2015;
import java.util.Random;

public class Problem6 {
	//随机算法试试
	static int[] ope = new int[48];
	static int[] num = new int[49];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i =0;i<48;i++) {
			ope[i] = 1;
			num[i] = i+1;
		}
		Random r = new Random();
		num[48] = 49;
		int sum = 0;
		int index1 = r.nextInt(35);
		int index2 = r.nextInt(35);
		while(sum != 2015 || (int)Math.abs(index2-index1) == 1 || num[index1<index2?index1:index2] == 10) {
			sum =num[0];
			index1 = r.nextInt(35);
			index2 = r.nextInt(35);
			ope[index1] = 2;
			ope[index2] = 2;
			for(int i =0;i<48;i++) {
				if(ope[i] == 1) {
					sum+=num[i+1];
				}else if(ope[i] == 2) {
					sum-= num[i];
					sum+=num[i]*num[i+1];
				}
			}
			ope[index1] = 1;
			ope[index2] = 1;
			System.out.println(sum);
		}
		System.out.println(num[index1<index2?index1:index2]);
	}

}
