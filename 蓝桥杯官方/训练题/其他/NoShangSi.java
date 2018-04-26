package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author zxr
 *
 */
public class NoShangSi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[][] a = new int[num][3];// 第1列为父亲，第2列为儿子,第3列为儿子节点的权至
		for (int i = 0; i < num; i++) {
			a[i][0] = input.nextInt();
			a[i][1] = input.nextInt();
			a[i][2] = input.nextInt();
		}
		int root_val = input.nextInt();
		input.close();
		// 建树
		build(a);
		// 尝试遍历
		Node root = findRoot();
		root.value = root_val;
		visted(root);
		int[][] d = new int[count + 1][2];
		dfs(d, root);
		System.out.println(Math.max(d[root.index][0], d[root.index][1]));
	}

	static void dfs(int[][] d, Node node) {
		int index = node.index;
		d[index][0] = 0;
		d[index][1] = node.value;
		for (Node son : node.sons) {
			dfs(d, son);
			d[index][0] += Math.max(d[son.index][0], d[son.index][1]);
			d[index][1] += node.value;
			// d[index][1] > d[son.index][0]+node.value?d[index][1]:
		}
	}

	static int count;

	static void visted(Node node) {
		if (node == null) {
			return;
		}
		count++;
		System.out.println(node.index + "-->" + node.value);
		for (Node son : node.sons) {
			visted(son);
		}
	}

	static Set<Integer> check_con = new HashSet<>();// 检查是否已经添加过节点
	static List<Node> list = new ArrayList<>();

	static Node findNode(int index) {
		for (Node node : list) {
			if (node.index == index) {
				return node;
			}
		}
		return null;
	}

	static Node findRoot() {
		Node current = list.get(0);
		while (current.parent != null) {
			current = current.parent;
		}
		return current;
	}

	static void build(int[][] input) {
		for (int[] is : input) {
			int father = is[0];
			int son = is[1];
			int value = is[2];
			Node f;
			if (!check_con.contains(father)) {
				check_con.add(father);
				f = new Node(father);
				list.add(f);
			} else {
				f = findNode(father);
			}
			check_con.add(son);
			Node s = new Node(son);// 儿子只能有一个父亲节点
			list.add(s);
			s.parent = f;
			s.value = value;
			f.sons.add(s);
		}
	}

	static class Node {
		int index;
		int value;
		List<Node> sons = new ArrayList<>();
		Node parent;

		public Node(int index) {
			super();
			this.index = index;
		}

	}
}
