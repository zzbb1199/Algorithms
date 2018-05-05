package 测试;

public class Prim {
	public static final int INF = 1000;
	public static int[][] D = { 
			{ 0, 6, 1, 5, INF, INF },
			{ 6, 0, 5, INF, 3, INF }, 
			{ 1, 5, 0, 5, 6, 4 },
			{ 5, INF, 5, 0, INF, 2 },
			{ INF, 3, 6, INF, 0, 6 },
			{ INF, INF, 4, 2, 6, 0 } };
	public static void main(String[] args) {
		//Prim算法。最小生成数，贪心算法思想
		int N = D.length;
		boolean[] visted = new boolean[N];
		int start = 0;
		visted[start] = true;
		int current = start;
		while(!hasVistedAll(visted)){
			int minPoint = -1;
			int minValue = INF;
			for(int i = 0;i<N;i++){
				if(visted[i]){
					for(int j = 0;j<N;j++){
						if(!visted[j]){
							if(minValue > D[j][i]){
								minValue = D[j][i];
								minPoint = j;
							}
						}
					}
				}
			}
			//更新
			visted[minPoint] = true;
			System.out.println("add point"+minPoint+" "+"edge value:"+minValue);
		}
	}
	public static boolean hasVistedAll(boolean[] v){
		for (boolean b : v) {
			if(!b){
				return false;
			}
		}
		return true;
	}
}
