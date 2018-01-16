package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Prim {
	private static final int INF = 1000;
    /**
     * 原始矩阵
     */
    private static int[][] D = {
            {0, 6, 1, 5, INF, INF},
            {6, 0, 5, INF, 3, INF},
            {1, 5, 0, 5, 6, 4},
            {5, INF, 5, 0, INF, 2},
            {INF, 3, 6, INF, 0, 6},
            {INF, INF, 4, 2, 6, 0}
    };
    public static void main(String[] args){
        int start = 0;
        List<Integer> addTree = new ArrayList<>();
        addTree.add(start);
        boolean[] added = new boolean[D.length];
        added[start] = true;
        int minValue;
        int minIndex;
        int sum = 0;
        while (addTree.size() != D.length){
            minValue = INF;
            minIndex = -1;
            for(int i = 0;i<D.length;i++){
                if(added[i]){
                    continue;
                }
                //如果是还没有加入的点
                //循环遍历当前已加入集合，找到最小值对应的点
                for(int j = 0;j<addTree.size();j++){
                    int point = addTree.get(j);
                    if(minValue > D[point][i]){
                        minValue = D[point][i];
                        minIndex = i;
                    }
                }
            }
            //1 3 6 4 2 5
            //加入
            addTree.add(minIndex);
            added[minIndex] = true;
            sum+=minValue;
        }
        System.out.println("总权值:"+sum);
        System.out.println("加入顺序:");
        outPut(addTree);

    }
    private static void outPut(List<Integer> list){
        for(int i : list){
            System.out.print(i+"\t");
        }
    }
}
