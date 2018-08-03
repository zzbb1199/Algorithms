package 蓝桥杯官方.国赛.真题2014;

public class Problem1 {
	public static void main(String[] args) {
		//5层循环
		int[]a = new int[6];
		for(a[0] = 0;a[0]<10;a[0]++) {//请
			for(a[1] = 0;a[1]<10;a[1]++) {//猜
				if(a[1] == a[0] ) {
					continue;
				}
				for(a[2] =0;a[2]<10;a[2]++) {//谜
					if(a[2] == a[1]||a[2] == a[0]) {
						continue;
					}
					for(a[3] = 0;a[3]<10;a[3]++) {//边
						if(a[3] == a[2]||a[3] == a[1]||a[3] == a[0]) {
							continue;
						}
						for(a[4] = 0;a[4]<10;a[4]++) {//赏
							if(a[4]==a[3]||a[4] == a[2]||a[4] == a[1]||a[4] == a[0]) {
								continue;
							}
							for(a[5]=0;a[5]<10;a[5]++) {//灯
								if(a[5]==a[4]||a[5]==a[3]||a[5]==a[2]||a[5]==a[1]||a[5]==a[0]) {
									continue;
								}
								//检查
									
								int ans1 = Integer.valueOf(""+a[0]+a[1]+a[2],10);
								int ans2 = Integer.valueOf(""+a[0]+a[3]+a[4]+a[5]+a[3]+a[1],10);
								if(ans1*ans1 == ans2) {
									System.out.println(""+a[0]+a[1]+a[2]);
								}
							}
						}
					
					}
				}
			}
			
		}
	}
}
