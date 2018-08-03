package 国赛恢复训练.省赛2015;

/**
 * 线段树
 * @author Raven
 *
 */
public class Problem19 {
	static int[] data = {-1,1,4,12,56,16,7,5,6};//首位占位
	static Node[] nodes = new Node[4*(data.length-1)];
	public static void main(String[] args) {
		build(1,1,data.length-1);
		System.out.println(query_max(1,3,1));
		System.out.println(query_sum(1,3,1));
		update(2,100,1);
		System.out.println(query_max(1,3,1));
		System.out.println(query_sum(1,3,1));

	}
	/**
	 * 建树操作
	 * @author Raven
	 *
	 */
	static void build(int c,int l,int r) {
		nodes[c] = new Node();
		nodes[c].l = l;
		nodes[c].r = r;
		if(l == r) {
			nodes[c].sum = data[l];
			nodes[c].max = data[l];
		}else {
			int mid = (l+r)/2;
			build(c<<1,l,mid);
			build(c<<1|1,mid+1,r);
			push_up(c);
		}
	}
	static void push_up(int c) {
		nodes[c].sum = nodes[c<<1].sum+nodes[c<<1|1].sum;
		nodes[c].max = Math.max(nodes[c<<1].max, nodes[c<<1|1].max);
	}
	/**
	 * 更新操作
	 * @author Raven
	 *
	 */
	static void update(int id,int val,int c) {
		if(nodes[c].l == nodes[c].r) {
			nodes[c].sum = val;
			nodes[c].max = val;
		}else {
			int mid = (nodes[c].l+nodes[c].r)/2;
			if(id <= mid) {
				update(id,val,c<<1);
			}else {
				update(id,val,c<<1|1);
			}
			push_up(c);
		}
	}
	/**
	 * 查询操作
	 * @author Raven
	 *
	 */
	static int query_sum(int l,int r,int c) {
		if(nodes[c].l == l && nodes[c].r == r) {
			return nodes[c].sum;
		}
		int mid = (nodes[c].l+nodes[c].r)/2;
		if(r<=mid) {
			return query_sum(l,r,c<<1);
		}
		if(l>mid){
			return query_sum(l,r,c<<1|1);
		}
		return (query_sum(l,mid,c<<1)+ query_sum(mid+1,r,c<<1|1));
	}
	/**
	 * 
	 * @author Raven
	 *
	 */
	static int query_max(int l,int r,int c) {
		if(nodes[c].l == l && nodes[c].r == r) {
			return nodes[c].max;
		}
		int mid = (nodes[c].l+nodes[c].r)/2;
		if(r<=mid) {
			return query_max(l,r,c<<1);
		}
		if(l>=mid){
			return query_max(l,r,c<<1|1);
		}
		return Math.max(query_max(l,mid,c<<1), query_max(mid+1,r,c<<1|1));
	}
	static class Node{
		int l;
		int r;
		int sum;
		int max;
	}
}
