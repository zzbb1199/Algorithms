package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 想象你是一个在Warsaw的游客，而且预订了一次乘车旅行，去城镇外看一些令人惊异的景点。这辆公共汽车首先围绕城镇行驶一段时间（一段很长的时间，由于Warsaw是一个大城市），把在各自旅馆的人们带上。接着它就去了那个令人惊异的景点，几个小时后又回到城市中，再一次行驶到每一个旅馆，这一次把乘客放下。
 * 由于某种原因，每当你这样做的时候，你的旅馆总是第一个要上车的，而且是最后一个才下车的，意味着你不得不忍受两段经过所有当地旅馆的不那么愉快的旅行。这很明显不是你想要做的事（除非由于某种原因你真的要进入那些旅馆），所以让我们来做个改变。我们将开发一些软件使得那些观光公司能够把它们的乘车旅行路线安排得更公平——尽管这有时候可能会导致每一个人的总距离更长，但公平就是公平，不是吗？
 * 对于这个问题，有一个起始位置（观光公司的总部），h个需要接送游客的旅馆和一个目的地位置（令人惊异的景点）。我们需要找到一条路径，从总部出发，经过所有的旅馆，到景点去，再回来再一次经过所有的旅馆（可能按照不同的顺序），最后返回总部。为了保证没有一个游客（特别是你）被迫忍受两个完整的旅馆旅行，我们要求在去景点的路上接游客的前个旅馆，在回来的路上也得是前个让游客下车的。受制于这些限制条件，我们想让整个公车旅行尽可能短。注意这些限制条件可能会迫使公共汽车经过某个旅馆但是不停下来（这不算做让游客下车），后来再来这里让游客下车，样例就说明了这种情况。
 * 输入格式 第一行包含两个整数n和m满足3≤n≤20,2≤m，n是位置的总数（旅馆，总部和景点），m是汽车能在两个位置之间行驶的路径条数。
 * n个不同的位置被标号为0到n-1,0是总部，1到n-2是旅馆，而n-1是景点。假定任意一对位置之间最多只有一条直接路径，而且从任意一个位置都能到达任意另一个位置（并不一定直接到达）。
 * 接下来m行，每行包含三个整数u，v和t，满足0≤u，v≤n-1，u≠v，1≤t≤3600，表示公共汽车可以在t秒的时间内直接在u和v之间到达（两个方向都可以）。
 * 输出格式 一个整数，表示可能的最短路线的总耗时。
 * 
 * @author zxr
 *
 */
public class BusTour {

	//共多少站
	static int n ;
	//共多少边
	static int m;
	//较大的一个数
	static int INF = 50000;
	//邻接矩阵
	static int[][] adj;
	//遍历
	static boolean[] visted;
	static int currentCost;
	static int minCost ;
	//记录接客顺序
	static List<Integer> minRecord ;
	static List<Integer> currentRecord;
	public static void main(String[] args) {
		//输入
		input();
		//初始化其它信息
		init();
		//计算从旅馆到景点，遍历所有点的最短距离，及各点加入顺序
		visted[0] = true;
		startToEndMin(0);
		System.out.println(minCost);
	}
	/**
	 * 用于计算从起点到终点的遍历所有点的最短距离
	 */
	private static void startToEndMin(int to) {
		
	}
	private static boolean checkAllVist() {
		for (boolean b : visted) {
			if(!b) {
				return false;
			}
		}
		return true;
	}
	private static void init() {
		visted = new boolean[n];
		currentCost = 0;
		minCost  = INF;
		currentRecord = new ArrayList<>();
		minRecord = new ArrayList<>();
	}

	private static void input() {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		adj = new int[n][n];
		m = input.nextInt();
		for(int i = 0;i<m;i++) {
			adj[input.nextInt()][input.nextInt()] = input.nextInt();
		}
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				if(adj[i][j] == 0) {
					adj[i][j] = INF;
				}
			}
		}
		input.close();
	}

}
