## 1.目录

[TOC]



## 2.详情

### 2.1 按算法分类

| 算法名                                      | 算法描述          |
| :--------------------------------------- | :------------ |
| [BFS.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/BFS.java) | 图的深度遍历        |
| [DFS.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/DFS.java) | 图的广度遍历        |
| [Dijkstra.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/Dijkstra.java) | 单源最短路径算法      |
| [Floyd.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/Floyd.java) | 全局最短路径算法-动态规划 |
| [Kursal.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/Kursal.java) | 最小生成树算法-从边入手  |
| [Prim.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/Prim.java) | 最小生成树算法-从点入手  |
| [WarShall.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/WarShall.java) | 闭包算法-动态规划     |
| [BackTrack.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/BackTrack.java) | 回溯法（0-1背包问题）  |
| [BestBinarySearchTree.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/BestBinarySearchTree.java) | 最优二叉查找树（动态规划） |
| [Bissearch.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/Bissearch.java) | 折半查找          |
| [MergeSort.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/MergeSort.java) | 合并排序（分治法）     |
| [FastSort.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/FastSort.java) | 快速排序（分治法）     |
| [HaffuManTree.java](https://github.com/zzbb1199/Algorithms/blob/master/algorithm/HaffuManTree.java) | 哈弗曼树及哈弗曼编码    |



#### 2.1.1 BFS-图的广度遍历

代码中使用的图为：

![BFS](https://github.com/zzbb1199/Algorithms/blob/master/picture/BFS%26DFS)

邻接矩阵:

```java
{0,1,1,1,0,0},
{1,0,1,0,1,0},
{1,1,0,1,1,1},
{1,0,1,0,0,1},
{0,1,1,0,0,1},
{0,0,1,1,1,0}
```



#### 2.1.2 DFS-图的广度遍历

代码中使用的图为：

![DFS](https://github.com/zzbb1199/Algorithms/blob/master/picture/BFS%26DFS)

邻接矩阵：

```java
{0,1,1,1,0,0},
{1,0,1,0,1,0},
{1,1,0,1,1,1},
{1,0,1,0,0,1},
{0,1,1,0,0,1},
{0,0,1,1,1,0}
```
#### 2.1.3 Dijkstra算法

> 单源最短路径算法，可求得在一个图中一个点到其余任意节点的最小距离及所经路径。

代码中使用的图为：

![Dijkstra](https://github.com/zzbb1199/Algorithms/blob/master/picture/Dijkstra%26Floyd%26K%26P)

邻接矩阵：

```java
{ 0, 6, 1, 5, INF, INF },
{ 6, 0, 5, INF, 3, INF },
{ 1, 5, 0, 5, 6, 4 },
{ 5, INF, 5, 0, INF, 2 }, 
{ INF, 3, 6, INF, 0, 6 }, 
{ INF, INF, 4, 2, 6, 0 }
```

#### 2.1.4 Floyd算法

> Floyd算法是另一类最短路径算法，和D算法不同的是，Floyd算法所能求得的是全局任意两点之间的最短路径。

在代码中使用的图为：

![Floyd](https://github.com/zzbb1199/Algorithms/blob/master/picture/Dijkstra%26Floyd%26K%26P)

邻接矩阵:

```java
{ 0, 6, 1, 5, INF, INF },
{ 6, 0, 5, INF, 3, INF },
{ 1, 5, 0, 5, 6, 4 },
{ 5, INF, 5, 0, INF, 2 }, 
{ INF, 3, 6, INF, 0, 6 }, 
{ INF, INF, 4, 2, 6, 0 }
```



#### 2.1.4 Kursal算法

> Kursal算法为最小生成树算法的一种，其思想从边入手，在代码中为检查是否形成环，使用到了压缩路径的并查集。

代码中的图为：

![Kursal](https://github.com/zzbb1199/Algorithms/blob/master/picture/Dijkstra%26Floyd%26K%26P)

邻接矩阵:

```java
{ 0, 6, 1, 5, INF, INF },
{ 6, 0, 5, INF, 3, INF },
{ 1, 5, 0, 5, 6, 4 },
{ 5, INF, 5, 0, INF, 2 }, 
{ INF, 3, 6, INF, 0, 6 }, 
{ INF, INF, 4, 2, 6, 0 }
```

#### 2.1.5 Prim算法

> Prim算法是另一种最小生成树算法，该算法的核心思想从边入手，每次加入一个点。在实际操作中，推荐使用该算法（因为不用使用到并查集这种额外的数据结构）。

在代码中使用到的图为：

![Prim](https://github.com/zzbb1199/Algorithms/blob/master/picture/Dijkstra%26Floyd%26K%26P)

邻接矩阵：

```java
{ 0, 6, 1, 5, INF, INF },
{ 6, 0, 5, INF, 3, INF },
{ 1, 5, 0, 5, 6, 4 },
{ 5, INF, 5, 0, INF, 2 }, 
{ INF, 3, 6, INF, 0, 6 }, 
{ INF, INF, 4, 2, 6, 0 }
```
#### 2.1.6 WarShall算法

> WarShall算法为一种传递闭包的算法，可用在游戏开发，检验人物是否能到达某个地点。

在代码中使用到的图为：

![WarShall](https://github.com/zzbb1199/Algorithms/blob/master/picture/WarShall)

邻接矩阵:

```java
{0,1,0,1,0,0},
{1,0,1,0,0,0},
{0,1,0,0,0,0},
{1,0,0,0,1,0},
{0,0,0,1,0,0},
{0,0,0,0,0,0}
```


#### 2.1.7 BackTrack算法

> 回溯算法，是一种非常有用的算法，甚至有“通用解法”的美称。关于回溯算法更多介绍，可看[我的博文](https://www.jianshu.com/p/f6d3732e86fb)

在代码中，使用N皇后和0-1背包问题进行说明。

#### 2.1.8 BestBinarySearchTree算法

> 最右二叉查找树：给定一个有序序列K={k1<k2<k3<,……,<kn}和他们被查询的概率P={p1,p2,p3,……,pn}，要求构造一棵二叉查找树T，使得查询所有元素的总的代价最小。

#### 2.1.9 Bissearch算法

> 二分查找也称为折半查找，是一种高效率的查找算法，不过它要求数组是有序的。



#### 2.1.10 MergeSort算法

> 基于分治法的排序算法之一，时间复杂度低。



#### 2.1.11 FastSort算法

> 基于分治法的排序算法之一，时间复杂度低。



#### 2.1.12 HaffuManTree算法

> 给定n个权值作为n个叶子结点，构造一棵二叉树，若带权路径长度达到最小，称这样的二叉树为最优二叉树，也称为哈夫曼树(Huffman Tree)。哈夫曼树是带权路径长度最短的树，权值较大的结点离根较近。常用编码中。





### 2.2 按问题分类

| 问题名                                      | 问题描述           |
| ---------------------------------------- | -------------- |
| [NQueen.java](https://github.com/zzbb1199/Algorithms/blob/master/problems/NQueen.java) | N皇后问题，回溯法解决    |
| [KnapsackB.java](https://github.com/zzbb1199/Algorithms/blob/master/problems/KnapsackB.java) | 0-1背包问题，回溯法解决  |
| [KnapsackD.java](https://github.com/zzbb1199/Algorithms/blob/master/problems/KnapsackD.java) | 0-1背包问题，动态规划解决 |
| [KMinSelect.java](https://github.com/zzbb1199/Algorithms/blob/master/problems/KMinSelect.java) | 第K小问题          |

#### 2.2.1NQueen

> 一个ｎ×ｎ的国际象棋棋盘上放置ｎ个皇后，使其不能相互攻击，即任何两个皇后都不能处在棋盘的同一行、同一列、同一条斜线上，试问共有多少种摆法？

常用n=8，解答为92种 

#### 2.2.2 0-1背包问题

> 给定n种物品和一背包。物品i的重量是wi，其价值为vi，背包的容量为C。问应如何选择装入背包的物品，使得装入背包中物品的总价值最大?

常用的方法有：[回溯法](https://github.com/zzbb1199/Algorithms/blob/master/problems/KnapsackB.java),[动态规划](https://github.com/zzbb1199/Algorithms/blob/master/problems/KnapsackD.java)，分支界限法。

#### 2.2.3 第K小问题

> 给定一组随机数据，查找这个数据中的第K小元素的值。