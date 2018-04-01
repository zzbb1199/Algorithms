package algorithm;

/**
 * 模拟退火
 * 
 * @author zxr
 *
 */
public class SA {
	static double pi = Math.PI;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 初始参数
		double T0 = 100;
		double t = T0;
		double Te = 3;
		double a = 0.99;
		double x0 = rand();
		double Ecurrent = target(x0);
		double Ebest = Ecurrent;
		int markvon = 100;
		while (t > Te) {
			for (int i = 0; i < markvon; i++) {
				x0 = rand();
				double Enew = target(x0);
				if (Enew < Ecurrent) {
					Ecurrent = Enew;
				}else if(Math.exp(-(Enew-Ecurrent)/t) > Math.random()){
					Ecurrent = Enew;
				}
				if(Ecurrent < Ebest) {
					Ebest = Ecurrent;
				}
			}
			t *= a;
		}
		System.out.println(Ebest);
	}

	static double rand() {
		return -pi + (Math.random()) * (2 * pi);
	}

	static double target(double x) {
		return Math.sin(x);
	}

}
