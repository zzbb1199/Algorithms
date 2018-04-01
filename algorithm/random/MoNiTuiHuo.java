package algorithm.random;

import java.util.Arrays;
import java.util.Random;

/**
 * 模拟退火
 * @author zxr
 *
 */
public class MoNiTuiHuo {
	//初始参数
	static double T = 0.1;
	static double a = 0.999;
	static double t =1000000;
	
	//求解目标y(x) = sin(x)在-pi~pi的最小值
	//求解目标z(x,y) = sin(x)*cos(y)的极小值
	public static void main(String[] args) {
		Random r = new Random();
		double pi = Math.PI;
		double x0 = -pi+Math.random()*(pi - (-pi));
		double y0 = -pi+Math.random()*(pi-(-pi));
//		double currentE = Math.sin(x0);
		double currentE = Math.sin(x0)*Math.cos(y0);
		double bestE = currentE;
		double bestx0 = x0;
		double besty0 = y0;
		
//		while(t >= T) {
//			//产生新解
//			x0 = -pi+r.nextDouble()*(pi - (-pi));
//			double temp = Math.sin(x0);
//			double delta = temp - currentE;
//			//判定
//			if(delta < 0) {
//				//接受
//				currentE = temp;
//			}else if(Math.exp(-delta/t) > r.nextDouble()) {
//				//依照一定概率接受
//				currentE = temp;
//			}
//			if(bestE < currentE) {
//				bestE = currentE;
//			}
//			//降火
//			t = t*a;
//		}
	
		while(t >= T) {
			//产生新解
			x0 = -pi+Math.random()*(pi -(-pi));
			y0 = -pi+Math.random()*(pi-(-pi));
			double temp = Math.sin(x0)*Math.cos(y0);
			double delta = temp - currentE;
			//判定
			if(delta < 0) {
				//接受
				currentE = temp;
				if(bestE < currentE) {
					bestx0 = x0;
					besty0 = y0;
					bestE = currentE;
				}
			}else if(Math.exp(-delta/t) > Math.random()) {
				//依照一定概率接受
				currentE = temp;
			}
			
			t = t*a;
		}
		System.out.println(bestx0/pi);
		System.out.println(besty0/pi);
		System.out.println(bestE);

	}
}
