package 国赛恢复训练.省赛2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼编码
 * @author 张兴锐
 *
 */
public class Problem18 {
	static final String NOCODE = "no";
	static List<Node> nodes = new ArrayList<Node>(Arrays.asList(
				new Node(1),
				new Node(10),
				new Node(103),
				new Node(5),
				new Node(51),
				new Node(103),
				new Node(14)
			));
	public static void main(String[] args) {
		Collections.sort(nodes);
		while(nodes.size() != 1) {
			Node m1 = nodes.get(0);
			Node m2 = nodes.get(1);
			Node m = new Node(m1.value+m2.value,m1,m2,NOCODE);
			nodes.remove(0);
			nodes.remove(0);
			insert(m);
		}
		Node root = nodes.get(0);
		code(root,"");
		preOrder(root);
	}
	public static void code(Node n,String c) {
		if(n == null) {
			return;
		}
		if(n.code == null) {
			n.code = c;
		}
		code(n.left,c+"0");
		code(n.right,c+"1");
	}
	public static void preOrder(Node n) {
		if(n == null) {
			return;
		}
		if(!n.code.equals(NOCODE)) {
			System.out.println(n.value+" "+n.code);
		}
		preOrder(n.left);
		preOrder(n.right);
	}
	public static void insert(Node m) {
		for(int i = 0;i<nodes.size();i++) {
			if(m.value <= nodes.get(i).value) {
				nodes.add(i,m);
				return;
			}
		}
		nodes.add(m);
	}
	static class Node implements Comparable<Node>{
		int value;
		Node left;
		Node right;
		String code;
		public Node(int value, Node left, Node right,String code) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
			this.code = code;
		}
		public Node(int value) {
			this.value = value;
		}
		public int compareTo(Node arg0) {
			return this.value - arg0.value;
		}
		
	}
}
