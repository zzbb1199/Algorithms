package problems.base.pratice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 问题描述 平面上有两个矩形，它们的边平行于直角坐标系的X轴或Y轴。对于每个矩形，我们给出它的一对相对顶点的坐标，请你编程算出两个矩形的交的面积。 输入格式
 * 输入仅包含两行，每行描述一个矩形。 在每行中，给出矩形的一对相对顶点的坐标，每个点的坐标都用两个绝对值不超过10^7的实数表示。
 * 
 * @author zxr
 *
 */
public class IntersectingMatrixArea {
	static int type = 0; // 0代表x，1代表y

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 输入
		Scanner input = new Scanner(System.in);
		SortCoordinate[] cds = {
				new SortCoordinate(input.nextDouble(), input.nextDouble(),0),
				new SortCoordinate(input.nextDouble(), input.nextDouble(),0),
				new SortCoordinate(input.nextDouble(), input.nextDouble(),1),
				new SortCoordinate(input.nextDouble(), input.nextDouble(),1)
		};
		input.close();
		
		// 排序，相交位置一定在第1,2位（从0开始算)
		type = 0; // 先按x排序
		Arrays.sort(cds);
		//判定是否能相交
		double X1[] = new double[2];
		double X2[] = new double[2];
		int k1 = 0;
		int k2 = 0;
		for(int i = 0;i<cds.length;i++) {
			if(cds[i].index == 0) {
				X1[k1] = cds[i].x;
				k1++;
			}else {
				X2[k2] = cds[i].x;
				k2++;
			}
		}
		if(X1[0] > X2[1] || X1[1] < X2[0]) {
			System.out.println("0.00");
			return;
		}
		
		SortCoordinate x1 = cds[1];
		SortCoordinate x2 = cds[2];
		
		type = 1; // 再按y排序
		Arrays.sort(cds);
		//判定是否能相交
		double Y1[] = new double[2];
		double Y2[] = new double[2];
		 k1 = 0;
		 k2 = 0;
		for(int i = 0;i<cds.length;i++) {
			if(cds[i].index == 0) {
				Y1[k1] = cds[i].y;
				k1++;
			}else {
				Y2[k2] = cds[i].y;
				k2++;
			}
		}
		if(Y1[0] > Y2[1] || Y1[1] < Y2[0]) {
			System.out.println("0.00");
			return;
		}
		
		SortCoordinate y1 = cds[1];
		SortCoordinate y2 = cds[2];

		double result = Math.abs(x1.x - x2.x) * Math.abs(y1.y - y2.y);
		System.out.println(String.format("%.2f", result));

	}

	static class SortCoordinate implements Comparable<SortCoordinate> {
		double x;
		double y;
		int index;
		public SortCoordinate(double x, double y,int i) {
			super();
			this.x = x;
			this.y = y;
			this.index = i;
		}

		@Override
		public int compareTo(SortCoordinate o) {
			// TODO Auto-generated method stub
			if(type == 0) {
				if(this.x > o.x) {
					return 1;
				}else if(this.x == o.x) {
					return 0;
				}else {
					return -1;
				}
			}else {
				if(this.y > o.y) {
					return 1;
				}else if(this.y == o.y) {
					return 0;
				}else {
					return -1;
				}
			}
		}

	}

}
