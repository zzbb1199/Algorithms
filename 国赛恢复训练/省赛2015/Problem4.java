package 国赛恢复训练.省赛2015;

import java.util.Vector;

public class Problem4 {
	public static int f(int n, int m)
	{
		n = n % m;	
		Vector v = new Vector();
		for(;;)
		{
			v.add(n);
			n *= 10;
			n = n % m;
			if(n==0) return 0;
			if(v.indexOf(n)>=0)
				return v.size() - v.indexOf(n);  //填空
		}
	}
	public static void main(String[] args) {
		System.out.println(f(39, 190));
	}
}
