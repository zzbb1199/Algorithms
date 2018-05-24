package 国赛恢复训练.省赛2015;

public class Problem17 {

	public static void main(String[] args) {
		int[] data = new int[] {1,3,4,5234,13,1,4,5};
		//构建排序二叉树
		Node root = new Node(data[0],null,null);
		for(int i = 1;i<data.length;i++) {
			build(root,data[i]);
		}
		show(root);
	}
	
	public static void build(Node c,int v) {
		if(c.value >= v) {
			if(c.left == null) {
				c.left = new Node(v,null,null);
				return;
			}else {
				build(c.left,v);
			}
		}else {
			if(c.right == null) {
				c.right = new Node(v,null,null);
				return;
			}else {
				build(c.right,v);
			}
		}
	}
	public static void show(Node c) {
		if(c == null) {
			return;
		}
		show(c.left);
		System.out.println(c.value);
		show(c.right);
	}
	
	
	
	static class Node{
		int value;
		Node left;
		Node right;
		public Node(int value, Node left, Node right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
	}
}
