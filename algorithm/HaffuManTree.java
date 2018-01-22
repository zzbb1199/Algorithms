package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 哈弗曼算法 可用于哈弗曼编码
 * 
 * @author zxr
 */
public class HaffuManTree {

	/**
	 * 声明系统可用字母
	 */

	private static Node[] nodes = { // 因为最开始各自成为一颗树，所以父亲节点，左右孩子都为null
			new Node("A", 100, null, null, null), 
			new Node("B", 30, null, null, null),
			new Node("C", 40, null, null, null), 
			new Node("D", 20, null, null, null),
			new Node("E", 5, null, null, null) 
			};
	private static final String NOT = "中间";

	public static void main(String[] args) {
		// 先排序
		Arrays.sort(nodes);
		// 装入集合，方便清除和插入
		List<Node> list = new ArrayList<>();
		for (Node node : nodes) {
			list.add(node);// 这个地方存的是node的引用，方便后续遍历树
		}
		while (list.size() != 1) {
			Node m1 = list.get(0);
			Node m2 = list.get(1);
			list.remove(0);
			list.remove(0);
			Node m = new Node(NOT, m1.weight + m2.weight, null, m1, m2);
			m1.parent = m;
			m2.parent = m;
			insert(list, m);
		}
		// outPut-首先要找到root，随便找一个节点一直向上回溯即可
		Node root = nodes[0];
		while (root.parent != null) {
			root = root.parent;
		}
		// 树的遍历，这里就用前序遍历了
		System.out.println("遍历:");
		preOrder(root);
		// 现在考虑编码，规定左子树为0，右子树为1
		System.out.println("编码:");
		code(root);
	}

	private static String code = "";
	private static void code(Node node) {
		if(node == null) {
			return;
		}
		if(!node.key.equals(NOT)) {
			node.outPutCode(code);
		}
		code += "0";
		code(node.left);
		code = code.substring(0,code.length()-1);//感觉这样写的效率太低，希望能够改进
		code += "1";
		code(node.right);
		code = code.substring(0,code.length()-1);
	}

	private static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		// 否则
		System.out.println(node);
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void insert(List<Node> list, Node node) {
		for (int i = 0; i < list.size(); i++) {
			if (node.weight < list.get(i).weight) {
				list.add(i, node);
				return;
			}
		}
		// 循环正常退出，说明还未插入，直接插入就行
		list.add(node);
	}

	private static class Node implements Comparable<Node> {// 实现comparable接口，方便排序
		String key;
		int weight;
		Node parent;
		Node left;
		Node right;

		public Node(String key, int weight, Node parent, Node left, Node right) {
			super();
			this.key = key;
			this.weight = weight;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}

		// 自定义toString
		@Override
		public String toString() {
			return "Node [key=" + key + ", weight=" + weight + "]";

		}

		public void outPutCode(String code) {
			System.out.println("Node [key=" + key + ", weight=" + weight + ",code=" + code +"]");
		}
	}
}