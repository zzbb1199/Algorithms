package 国赛恢复训练.省赛2015;

import java.util.Random;

/**
 * 模拟退火 求解sin(x)的最小值
 * @author Raven
 *
 */
public class Problem16 {
	public static void main(String[] args) {
		//初始化参数
		double t = 100;
		double te = 3;
		double a = 0.999;	//衰减因子
		
		double current_x = getRandom(-pi/2,pi/2);
		double E_current = fx(current_x);
		double E_best = E_current;
		while(t >= te) {
			double E_new = fx(getRandom(-pi/2, pi/2));
			if(E_new < E_current) {
				E_current = E_new;
			}else if(-(E_new - E_current)/t > Math.random()){
				E_current = E_new;
			}
			if(E_best > E_current) {
				E_best = E_current;
			}
			t *= a;
		}
		System.out.println(E_best);
	}
	static double pi = Math.PI;
	static Random r =  new Random();
	public static  double getRandom(double start,double end) {
		return start+r.nextDouble()*(end-start);
	}
	public static double fx(double x) {
		return Math.sin(x);
	}
}
