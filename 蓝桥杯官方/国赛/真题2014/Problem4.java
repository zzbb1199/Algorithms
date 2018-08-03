package 蓝桥杯官方.国赛.真题2014;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Problem4 {
	static String line2;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line1 = input.next();
		line2 = input.next();
		int start = line1.indexOf(".");
		int end = line2.indexOf(".");
		Node sn = new Node(line1,0);
		System.out.println(bfs(sn));
		
	}
	public static int bfs(Node start) {
		Queue<Node> q = new LinkedList<Node>();
		Set<String> set = new HashSet<String>(); //去重
		q.add(start);
		set.add(start.status);
		while(!q.isEmpty()) {
			Node c = q.poll();//取出当前状态
			int[] xy = getCor(c.status.indexOf("."));
			int saveX = xy[0];
			int saveY = xy[1];
			//扫描周边
			for(int i = 0;i<4;i++) {
				switch(i) {
				case 0:
					xy[0]-=1;break;
				case 1:
					xy[0]+=1;break;
				case 2:
					xy[1]-=1;break;
				case 3:
					xy[1]+=1;break;
				}
				if(xy[0]>=0&&xy[0]<=2&&xy[1]>=0&&xy[1]<=2){
					String nextStauts = swap(c.status,xy[0],xy[1],saveX,saveY);
					if(nextStauts.equals(line2)) {
						return c.count+1;
					}
					if(!set.contains(nextStauts)) {
						Node next = new Node(nextStauts,c.count+1);
						q.add(next);
						set.add(nextStauts);
					}
					
				}
				xy[0] = saveX;
				xy[1] = saveY;
			}
			
		}
		return -1;
	}
	
	public static String swap(String status,int fx,int fy,int tx,int ty) {
		char[] c = status.toCharArray();
		int x = fx*3+fy;
		int y = tx*3+ty;
		char t = c[x];
		c[x] = c[y];
		c[y] = t;
		return String.valueOf(c);
	}
	public static int[] getCor(int index) {
		int[] x= new int[2];
		x[0] = index/3;
		x[1] = index %3;
		return x;
	}
	
	static class Node{
		String status;
		int count;
		public Node(String status, int count) {
			super();
			this.status = status;
			this.count = count;
		}
		
	}
}
