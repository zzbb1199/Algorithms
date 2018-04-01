import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 17;
		//扩展欧几里得****a*x+b*y = gcd(a,b)**/
		int[] xy = new int[2];
		e_gcd(a,b,xy);
		System.out.println(Arrays.toString(xy));
		//暴力破解
		int gcd = gcd(a,b);
		for(int i = 1;i<100;i++) {
			if((gcd - b*i) % a == 0) {
				System.out.println("x="+((gcd - b*i)/a));
				System.out.println("y="+i);
				System.out.println();
//				return;
			}
		}
	}
	static void e_gcd(int a,int b,int[] xy) {
		if(b == 0) {
			xy[0] = 1;
			xy[1] = 0;
			return ;
		}
		e_gcd(b,a%b,xy);
		int x2 = xy[0];
		xy[0] = xy[1];
		xy[1] = x2 - a/b*xy[1];
	}
	static int gcd(int a,int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b,a%b);
	}
	
}
