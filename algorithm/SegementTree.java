package algorithm;
/**
 * 线段树
 * @author 张兴锐
 *
 */
public class SegementTree {
	//原数据
	static int[] a = {0,1,3,4,51,4,6};
	//树的空间为原数据的4倍
	static Tree[] tree = new Tree[4*(a.length-1)];
	public static void main(String[] args) {
		build(1,1,a.length-1);
		
		show(1);
	}
	/**
	 * show
	 */
	public static void show(int x){
		try{
			System.out.println(tree[x].sum);
			show(x<<1);
			show(x<<1|1);
		}catch(Exception e){
			return;
		}
		
	}
	/**
	 * 建树
	 * @param x
	 * @param l
	 * @param r
	 */
	public static void build(int x,int l,int r){
		tree[x] = new Tree();
		tree[x].begin = l; tree[x].end = r;
		if(l == r){
			tree[x].sum = a[l];
			return;
		}
		//否则递归
		int mid = (l+r)/2;
		build(x<<1,l,mid);
		build(x<<1|1,mid+1,r);
		push_up(x);
	}
	/**
	 * 向上
	 */
	public static void push_up(int x){
		tree[x].sum = tree[x<<1].sum+tree[x<<1|1].sum;
	}
	
	/**
	 * 更新操作
	 * x: 要修改的位置
	 * c: 当前位置
	 */
	public static void update(int x,int c,int val){
		if(tree[c].begin == tree[c].end){
			tree[c].sum = val;
			return;
		}
		int begin = tree[c].begin;
		int end = tree[c].end;
		int mid = (begin+end)/2;
		if(begin<=x&&x<=mid){
			//左孩子
			update(x,c<<1,val);
		}else if(x>= mid+1 && x <= end){
			//右孩子
			update(x,c<<1|1,val);
		}
		//更新完
		push_up(x);
	}
	/**
	 * 查询 sum(l,r)
	 *
	 */
	public static int query(int c,int l,int r){
		if(tree[c].begin == l && tree[c].end == r){
			return tree[c].sum;
		}
		int mid = (tree[c].begin + tree[c].end)/2;
		if(l > mid){
			//查询右边
			return query(c<<1|1,l,r);
		}else if (r <= mid){
			//查询左边
			return query(c<<1,l,r);
		}else{
			//跨了区间
			return query(c<<1,l,mid)+query(c<<1|1,mid+1,r);
		}
	}
	static class Tree{
		int begin;
		int end;
		int sum;
	}
}
