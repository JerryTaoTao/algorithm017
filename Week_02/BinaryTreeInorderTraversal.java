  //给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 720 👎 0

  package com.leetcode.editor.en;

  import com.leetcode.editor.cn.TreeNode;
  import java.util.ArrayList;
  import java.util.Collections;
  import java.util.LinkedList;
  import java.util.List;

  public class BinaryTreeInorderTraversal {
      public static void main(String[] args) {
           Solution solution = new BinaryTreeInorderTraversal().new Solution();
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (stack.size() > 0 || root != null) {
            while (root != null) {
                //从跟节点出发访问左子树，并将访问的节点入栈，直到左子树的节点到头，开始处理
                stack.add(root);
                //中间不再将访问节点放入result list；
                root = root.left;
            }
            //左子树到头，开始处理
            TreeNode node = stack.removeLast();
            result.add(node.val);
            //开始处理node 的右节点，处理方式一样
            root = node.right;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }