package 蓝桥杯官方.国赛.真题2016;

public class Problem1 {
	static float meter =1000;
	static int v1 = 40;
	static int v2 = 60;
	static int vb = 20;
	static int direction = 0;
	public static void main(String[] args) {
		int count = 0;
		while(meter > 20){
			if(direction == 0){//向右
				meter = meter - vb*(meter/(v1+vb));
				count++;
			}else{
				meter = meter - vb*(meter/(v2));
			}
			change();
		}
		System.out.println(count);
	}
	public static void change(){
		direction^=1;
	}
}
