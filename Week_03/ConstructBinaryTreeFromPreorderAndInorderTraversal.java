  //根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 718 👎 0

  package com.leetcode.editor.cn;

  import java.util.HashMap;
  import java.util.Map;

  public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
      public static void main(String[] args) {
           Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return func(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);
    }

    public TreeNode func(int[] preorder,int pStart, int pEnd,int[] inorder,int iStart, int iEnd, Map<Integer, Integer> inorderMap) {
        if (pStart > pEnd || iStart > iEnd) return null;
        int rootVal = preorder[pStart];
        //问题拆分用左区间求左子树和用右区间求右子树，最后当前节点指向左子树和右子树，以此按这样的逻辑进行拆分问题
        //直到子问题不能再拆分，也就是pstart > pEnd或者istart > iend
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInorderArray = inorderMap.get(rootVal);
        int leftRanger = rootIndexInorderArray - iStart;
        //从剩下的前序遍历的左子树和中序遍历的左子树，构造左子树
        root.left = func(preorder, pStart + 1, pStart + leftRanger, inorder, iStart, rootIndexInorderArray - 1, inorderMap);
        //从剩下的前序遍历的右子树和中序遍历的右子树，构造左右树
        root.right = func(preorder, pStart +leftRanger + 1, pEnd, inorder, rootIndexInorderArray + 1, iEnd, inorderMap);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }