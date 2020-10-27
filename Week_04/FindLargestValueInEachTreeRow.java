  //您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 98 👎 0

  package com.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Arrays;
  import java.util.Comparator;
  import java.util.List;

  public class FindLargestValueInEachTreeRow {
      public static void main(String[] args) {
           Solution solution = new FindLargestValueInEachTreeRow().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(Arrays.asList(root), ans);
        return ans;
    }

    public void dfs(List<TreeNode> levelChilds, List<Integer> result) {
        //递归终止条件
        if (levelChilds == null || levelChilds.isEmpty()) return;
        //处理当前层
        List<TreeNode> nextGeneration = new ArrayList<>();
        int currentMax = Integer.MIN_VALUE;
        for (int i  = 0; i < levelChilds.size(); i++) {
            TreeNode node = levelChilds.get(i);
            if (node != null) {
                int val = node.val;
                if (val > currentMax) currentMax = val;
                if (node.left != null) nextGeneration.add(node.left);
                if (node.right != null) nextGeneration.add(node.right);
            }
        }
        result.add(currentMax);
        //drill down
        dfs(nextGeneration, result);

        //clear
        levelChilds = null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }