package 国赛恢复训练.算法复习;
/**
 * 线段树
 * @author 张兴锐
 *
 */
public class Problem20 {
	static int[] data = new int[] {-1,3,41,25,124,14,213};
	static int N = data.length-1;
	static Tree[] trees = new Tree[4*N];
	public static void main(String[] args) {
		build(1,1,N);
		System.out.println(query(1,1,3));
		System.out.println(query(1,1,4));
		update(4,0,1);
		System.out.println(query(1,1,4));
	}
	/**
	 * 建树
	 * @author 张兴锐
	 *
	 */
	static void build(int id,int l,int r) {
		trees[id] = new Tree();
		trees[id].begin = l;
		trees[id].end = r;
		if(l == r) {
			trees[id].sum = data[l];
		}else {
			int mid =(l+r)/2;
			build(id<<1,l,mid);
			build(id<<1|1,mid+1,r);
			push_up(id);
		}
	}
	/**
	 * 更新
	 * 
	 */
	static void update(int p,int val,int id) {
		if(trees[id].begin == trees[id].end) {
			trees[id].sum = val;
		}else {
			int mid = (trees[id].begin+trees[id].end)/2;
			if(p <= mid) {
				update(p,val,id<<1);
			}else {
				update(p,val,id<<1|1);
			}
			push_up(id);
		}
		
	}
	/**
	 * 查询
	 * @param id
	 */
	static int query(int id,int l,int r) {
		int begin = trees[id].begin;
		int end = trees[id].end;
		if(l == begin && end == r) {
			return trees[id].sum;
		}
		int mid = (begin+end)/2;
		if(r <=mid) {
			return query(id<<1,l,r);
		}
		if(l > mid) {
			return query(id<<1|1,l,r);
		}
		return query(id<<1,l,mid)+query(id<<1|1,mid+1,r);
	}
	
	 private static void push_up(int id) {
		// TODO Auto-generated method stub
		trees[id].sum = trees[id<<1].sum+trees[id<<1|1].sum;
	}

	static class Tree{
		int begin;
		int end;
		int sum;
	}
}
