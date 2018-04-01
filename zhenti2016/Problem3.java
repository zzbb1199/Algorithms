package zhenti2016;

public class Problem3 {
	static char[] ans ;
	static int count;
	public static void main(String[] args) {
		String temp = "123456789";
		ans = temp.toCharArray();
		f(ans,0);
		System.out.println(count);
	}
	static void f(char[] a,int index) {
		if(index == a.length) {
			//测试
			if(test(a)) {
				count++;
			}
			return;
		}
		for(int i = index;i<a.length;i++) {
			char c = a[i];a[i] = a[index];a[index] = c;
			f(a,index+1);
			c = a[i];a[i] = a[index];a[index] = c;
		}
	}
	
	public static boolean test(char[] a) {
		Ra eq = new Ra(Integer.valueOf(a[0]+""),1);
		try {
			eq.add(new Ra(Integer.valueOf(a[1]+""),Integer.valueOf(a[2]+"")));
			eq.add(new Ra(Integer.valueOf(""+a[3]+a[4]+a[5]),Integer.valueOf(""+a[6]+a[7]+a[8])));
			if(eq.fenmu == 1 && eq.fenzi == 10) {
				return true;
			}
		}catch(Exception e) {
			return false;
		}
		return false;
	}
	static class Ra{
		int fenzi;
		int fenmu;
		public Ra(int fenzi,int fenmu) {
			int g = gcd(fenzi,fenmu);
			this.fenzi = fenzi/g;
			this.fenmu = fenmu/g;
		}
		public void add(Ra the) {
			int up = this.fenzi*the.fenmu+ this.fenmu*the.fenzi;
			int down = this.fenmu*the.fenmu;
			int g = gcd(up,down);
			this.fenzi = up/g;
			this.fenmu = down/g;
		}
		
		int gcd(int a,int b) {
			if(b == 0) {
				return a;
			}
			return gcd(b,a%b);
		}
		
		
	}
}
