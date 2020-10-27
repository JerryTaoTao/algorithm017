  //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1366 👎 0

  package com.leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.List;

  public class GenerateParentheses {
      public static void main(String[] args) {
           Solution solution = new GenerateParentheses().new Solution();
          System.out.println(solution.generateParenthesis(3));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", 0, 0, n);
        return res;
    }

    public void dfs(List<String> res, String s,int left, int right, int max) {
        if (left == max && right == max) {
            res.add(s);
            return;
        }
        if ( left < max) dfs(res, s + "(", left + 1,right, max);

        if (right <left)  dfs(res, s + ")", left,right + 1, max);



    }

    public void helper2(int left, int rigth, int n, String s, List<String> res) {
        if (left == n && rigth == n) {
            res.add(s);
            return;
        }
        if (left < n) {
            helper2(left+1, rigth, n,s + "(", res);
        }

        if (left > rigth) {
            helper2(left, rigth+1,n, s + ")", res);
        }
    }

          private void helper(int level, int max, String s, List<String> res) {
        //递归终止，加入res
        if (level >= max) {
             res.add(s);
             return;
         }
        //处理当前层
         String s1 = s + "(";
         String s2 = s + ")";

         //递推到下一层
         helper(level + 1, max, s1, res);
         helper(level + 1, max, s2, res);

          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }