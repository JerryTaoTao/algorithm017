  //给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树 
// 👍 104 👎 0

  package com.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.Collections;
  import java.util.LinkedList;
  import java.util.List;

  public class NAryTreePostorderTraversal {
      public static void main(String[] args) {
           Solution solution = new NAryTreePostorderTraversal().new Solution();
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

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if (root == null) return res;
        stack.add(root);
        while (stack.size() > 0) {
          Node pop = stack.removeLast();
          res.add(pop.val);
          List<Node> nodes = pop.children;
          if (nodes != null) {
              nodes.forEach(node -> {
                  stack.add(node);
              });
          }
        }

        Collections.reverse(res);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }