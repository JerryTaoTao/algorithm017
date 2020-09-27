  //给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组 
// 👍 550 👎 0

  package com.leetcode.editor.cn;
  public class PlusOne {
      public static void main(String[] args) {
           Solution solution = new PlusOne().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int cary = 0;
        if (digits == null) {
            return digits;
        }
        int len = digits.length;
        int carry = 0;
        for (int j = len -1; j >= 0; j--) {
            int sum = digits[j]  + carry;
            if (j == len - 1) {
                sum +=1;
            }
            carry = sum / 10;
            if (carry != 0) {
                sum = sum % 10;
            }
            digits[j] = sum;
        }
        if (carry == 1) {
            int [] news = new int[len + 1];
            news[0] = 1;
            System.arraycopy(digits,0, news,1, len);
            return news;
        }
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }