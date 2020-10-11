  //给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 372 👎 0

  package com.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.LinkedList;
  import java.util.List;
  import java.util.TreeMap;

  public class BinaryTreePreorderTraversal {
      public static void main(String[] args) {
           Solution solution = new BinaryTreePreorderTraversal().new Solution();
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
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return  result;
        while (stack.size() > 0 || root != null) {

            while (root != null) {
                //前序遍历一直往左走，在走的过程中，将访问的节点作为处理节点加入返回List
                result.add(root.val);
                //将访问的节点入栈
                stack.add(root);
                root = root.left;
            }
            //左边走完以后，代表着左边的路线完成了遍历，接着处理stack里面的每个节点的右节点
            TreeNode treeNode = stack.removeLast();
            if (treeNode != null) {
                root = treeNode.right;
            }

        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }