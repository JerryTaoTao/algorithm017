  //给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 400 👎 0

  package com.leetcode.editor.en;

  import com.leetcode.editor.cn.TreeNode;
  import java.util.ArrayList;
  import java.util.Collections;
  import java.util.LinkedList;
  import java.util.List;

  public class BinaryTreePostorderTraversal {
      public static void main(String[] args) {
           Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return res;
        }

        TreeNode processedNode =  null;
        while (stack.size() > 0 || root != null) {
            //仍然访问其左子树
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            TreeNode node = stack.removeLast();
            //如果当前节点的没有右儿子，或者右儿子已经被处理掉，那么直接弹出该元素，否则重新入栈，接着访问起右儿子
            if (node.right == null || node.right == processedNode) {
                res.add(node.val);
                //处理过的节点标记为当前节点
                processedNode = node;
                //root = null,访问下一个栈内元素
                root = null;
            } else {
                stack.add(node);
                root = node.right;
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }