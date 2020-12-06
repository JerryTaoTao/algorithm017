//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2968 👎 0


//最长回文子串
package com.leetcode.editor.cn;
public class LongestPalindromicSubstring{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new LongestPalindromicSubstring().new Solution();
		 System.out.println(solution.longestPalindrome("babad"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String longestPalindrome(String s) {

    	String res = s.substring(0, 1);
    	int len = s.length();
    	for (int i = 0; i < s.length() - 1; i ++) {
    		//回文字符串中心是一个间隙
    		String c1 = isPalindrome(s, i, i + 1, len);
    		//回文字符串长度是一个奇数，从字符出发扩散
			String c2 = isPalindrome(s, i, i, len);
			String maxStr = c1.length() > c2.length() ? c1 : c2;
			if (maxStr.length() > res.length()) {
				res = maxStr;
			}
		}
    	return res;
    }

    public String isPalindrome(String s, int left, int right, int len) {
    	int l = left;
    	int r = right;
    	while (l >= 0 && r < len) {
    		if (s.charAt(l) == s.charAt(r)) {
    			l--;
    			r++;
			} else {
    			break;
			}
		}
    	//当跳出循环的时候，说明s.charAt(l) ！= s.charAt(r)，也即回文不包含l,r所以是从l+1， r；
    	return s.substring(l + 1, r);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}