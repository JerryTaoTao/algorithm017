//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C
//的朋友。所谓的朋友圈，是指所有朋友的集合。
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。
//
//
//
// 示例 1：
//
// 输入：
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出：2
//解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回 2 。
//
//
// 示例 2：
//
// 输入：
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出：1
//解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
//
//
//
//
// 提示：
//
//
// 1 <= N <= 200
// M[i][i] == 1
// M[i][j] == M[j][i]
//
// Related Topics 深度优先搜索 并查集
// 👍 367 👎 0


//朋友圈

import java.util.LinkedList;

public class FriendCircles{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new FriendCircles().new Solution();
        //System.out.println(solution.findCircleNum(new int[][] {{1,1,0},{1,1,0},{0,0,1}}));
    }
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] M) {
            //return dfs(M);
            //return bfs(M);
            return unionFind(M);
        }

        //查找所有i的所有朋友，用i和其他小朋友做比较，如果找到再去找这个朋友的朋友
        private void dfs(int[][] m, int[] visited, int i, int n) {

            for (int j = 0; j < n; j++) {
                //只有j被联通才会标记为已经访问，然后从j开始
                if (m[i][j] == 1 && visited[j] == 0) {
                    visited[j] = 1;
                    dfs(m, visited, j, n);
                }
            }

        }

        public int dfs(int[][] M) {
            if (M == null || M.length == 0) return 0;
            int n = M.length;
            int count = 0;
            int[] visited = new int[n];
            //从任意节点出发进行图的dfs遍历，标记已经遍历（已经访问到的朋友）
            for (int i = 0; i < n; i++) {
                //查找每一个元素所有的朋友，标记这些朋友为已访问，不用再访问
                if (visited[i] == 0) {
                    dfs(M,visited, i, n);
                    count++;
                }
            }
            return count;
        }

        public  int bfs(int[][] M) {
            if (M == null) return 0;
            int n = M.length;
            int[] visited = new int[n];
            int count = 0;
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                //从任意节点出发进行一次图的bfs遍历
                if (visited[i] == 0) {
                    queue.add(i);
                    while (!queue.isEmpty()) {
                        int pop = queue.pollFirst();
                        for (int j = 0; j < n; j++) {
                            if (M[pop][j] == 1 && visited[j] == 0) {
                                queue.add(j);
                                visited[j] = 1;
                            }
                        }
                    }
                    count ++;
                }
            }
            return count;
        }

        class UnionFind {
            private int n;
            private int circleCount = 0;
            int[] parent = null;

            public UnionFind(int n) {
                parent = new int[n];
                this.n = n;
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int x) {
                while (x != parent[x]) {
                    x = parent[x];
                }
                return x;
            }

            public void union(int x, int y) {
                int px = find(x);
                int py = find(y);
                if (px != py) parent[px] = py;
            }

            public int getCircleCount() {
                int circleCount = 0;
                for (int i = 0; i < n; i++) {
                    if (parent[i] == i) {
                        circleCount++;
                    }
                }
                return circleCount;
            }
        }

        public int unionFind(int[][] M) {
            if (M == null || M.length == 0) return 0;
            int n = M.length;
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (M[i][j] == 1 && i  != j) {
                        unionFind.union(i, j);
                    }
                }
            }
            return unionFind.getCircleCount();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}