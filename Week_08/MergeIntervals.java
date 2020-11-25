  //给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 629 👎 0

  package com.leetcode.editor.cn;

  import java.util.*;

  public class MergeIntervals {
      public static void main(String[] args) {
           Solution solution = new MergeIntervals().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        List<Pair> ans = new ArrayList<>();
        if (intervals == null) return null;
        int n = intervals.length;
        PriorityQueue<Pair> pairPriorityQueue = new PriorityQueue<>(n, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.left - o2.left;
            }
        });

        for (int i = 0; i < n; i++) {
            pairPriorityQueue.add(new Pair(intervals[i][0], intervals[i][1]));
        }

        Pair p = null;
        for (int i = 0; i < n; i++) {
            Pair pair = pairPriorityQueue.poll();
            if (p == null) {
                p = pair;
            } else {
                int oldR = p.right;
                int curL = pair.left;
                if (oldR >= curL) {
                    int right = pair.right >= oldR ? pair.right : oldR;
                    p = new Pair(p.left, right);
                } else {
                    ans.add(p);
                    p = pair;
                }
            }
        }
        ans.add(p);

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            Pair p1 = ans.get(i);
            res[i] = new int[] {p1.left, p1.right};
        }
        return res;
    }

    class Pair {
        private int left;
        private int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }