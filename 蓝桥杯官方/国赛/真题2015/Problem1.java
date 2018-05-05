package 蓝桥杯官方.国赛.真题2015;

public class Problem1 {
	public static void main(String[] args) {
		int count = 0;
		for(int a1= 1;a1<=9;a1++){
			for(int a2 = 0;a2<=9;a2++){
				for(int a3=0;a3<=9;a3++){
					if(a1>a2 && a2 >a3){
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
