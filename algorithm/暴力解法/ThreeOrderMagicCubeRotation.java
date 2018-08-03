package algorithm.violence;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Raven
 * 
 */
public class ThreeOrderMagicCubeRotation {
	/**
	 * 颜色映射表
	 */
	static Map<Integer, String> colorMap = new HashMap<Integer, String>();
	static MagicArea[] ma = {
		new MagicArea(0, new int[] { 0, 0, 0, 0 }),
		new MagicArea(1, new int[] { 1, 1, 1, 1 }),
		new MagicArea(2, new int[] { 2, 2, 2, 2 }),
		new MagicArea(3, new int[] { 3, 3, 3, 3 }),
		new MagicArea(4, new int[] { 4, 4, 4, 4 }),
		new MagicArea(5, new int[] { 5, 5, 5, 5 }),
		};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 初始化魔方
		initColorMap();
		Scanner input = new Scanner(System.in);
		String d = input.nextLine();
		// 方向变动
		for(int i =0;i<d.length();i++){
			chang(d.charAt(i));
		}
		//输出
		System.out.println(colorMap.get(ma[0].colors[1]));
		System.out.println(colorMap.get(ma[2].colors[0]));
		System.out.println(colorMap.get(ma[4].colors[2]));
	}

	private static void chang(char c) {
		// TODO Auto-generated method stub
		if(c == 'x'){
			//变动为3[1,2] --> 4[3,2] --> 2[0,3] --> 5[0,1]
			//保存第3面
			int[] temp1  = new int[]{ma[3].colors[1],ma[3].colors[2]};
			 ma[3].colors[1] = ma[5].colors[0];
			 ma[3].colors[2] = ma[5].colors[1];
			 
			 //保存第4面
			 int[] temp2 = new int[]{ma[4].colors[3],ma[4].colors[2]};
			 //更新第4面
			 ma[4].colors[3] = temp1[0];
			 ma[4].colors[2] = temp1[1];
			 
			 //保存第2面
			 temp1[0] = ma[2].colors[0];temp1[1] = ma[2].colors[3];
			 //更新第2面
			 ma[2].colors[0] = temp2[0];
			 ma[2].colors[3] = temp2[1];
			 
			 //更新第5面
			 ma[5].colors[0] = temp1[0];
			 ma[5].colors[1] = temp1[1];
			 
			 //更新第0面
			 ma[0].change();
		}else if(c == 'y'){
			//变动为0[1,2] --> 4[1,2]  --> 1[3,0] --> 5[3,0]
			//保存第0面
			int[] temp1  = new int[]{ma[0].colors[1],ma[0].colors[2]};
			//更新第0面
			 ma[0].colors[1] = ma[5].colors[3];
			 ma[0].colors[2] = ma[5].colors[0];
			 
			 //保存第4面
			 int[] temp2 = new int[]{ma[4].colors[1],ma[4].colors[2]};
			 //更新第4面
			 ma[4].colors[1] = temp1[0];
			 ma[4].colors[2] = temp1[1];
			 
			 //保存第1面
			 temp1[0] = ma[1].colors[3];temp1[1] = ma[1].colors[0];
			 //更新第1面
			 ma[1].colors[3] = temp2[0];
			 ma[1].colors[0] = temp2[1];
			 
			 //更新第5面
			 ma[5].colors[3] = temp1[0];
			 ma[5].colors[0] = temp1[1];
			 
			 //更新第2面
			 ma[2].change();
		}else if(c == 'z'){
			//变动为0[0,1] --> 3[0,1]  --> 1[0,1] --> 2[0,1]
			//保存第0面
			int[] temp1  = new int[]{ma[0].colors[0],ma[0].colors[1]};
			//更新第0面
			 ma[0].colors[0] = ma[2].colors[0];
			 ma[0].colors[1] = ma[2].colors[1];
			 
			 //保存第3面
			 int[] temp2 = new int[]{ma[3].colors[0],ma[3].colors[1]};
			 //更新第3面
			 ma[3].colors[0] = temp1[0];
			 ma[3].colors[1] = temp1[1];
			 
			 //保存第1面
			 temp1[0] = ma[1].colors[0];temp1[1] = ma[1].colors[1];
			 //更新第1面
			 ma[1].colors[0] = temp2[0];
			 ma[1].colors[1] = temp2[1];
			 
			 //更新第5面
			 ma[2].colors[0] = temp1[0];
			 ma[2].colors[1] = temp1[1];
			 
			 //更新第4面
			 ma[4].change();     
		}
	}


	private static void initColorMap() {
		// TODO Auto-generated method stub
		/**
		 * 方向对应 
		 * 		前 后 
		 * x	 0 1 
		 * y	 2 3
		 * z	 4 5
		 */
		colorMap.put(0, "绿");
		colorMap.put(1, "蓝");
		colorMap.put(2, "红");
		colorMap.put(3, "橙");
		colorMap.put(4, "白");
		colorMap.put(5, "黄");
	}

	/**
	 * 魔方面
	 * 
	 * @author Raven
	 * 
	 */
	static class MagicArea {
		int key; // 表明是哪一个面
		int[] colors; // 该面有4个小块，分别为什么颜色

		public MagicArea(int key, int[] colors) {
			this.key = key;
			this.colors = colors;
		}
		public void change(){
			//存0
			int t1 = colors[0];
			//更0
			colors[0] = colors[3];
			
			//存1
			int t2 = colors[1];
			//更1
			colors[1] = t1;
			
			//存2
			t1 = colors[2];
			//更2
			colors[2] = t2;
			
			//更3
			colors[3] = t1;
		}
	}

}
