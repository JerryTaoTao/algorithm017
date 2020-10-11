  //给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 108 👎 0

  package com.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.LinkedList;
  import java.util.List;

  public class NAryTreePreorderTraversal {
      public static void main(String[] args) {
           Solution solution = new NAryTreePreorderTraversal().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<Node>();
        if (root == null) return res;
        stack.add(root);
        while (stack.size() > 0) {
          Node cur = stack.pollLast();
          res.add(cur.val);
          List<Node> childs = cur.children;
          if (childs != null) {
              int len = childs.size();
              int j = len -1;
              while (j >= 0) {
                  stack.add(childs.get(j--));
              }
          }
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

  }