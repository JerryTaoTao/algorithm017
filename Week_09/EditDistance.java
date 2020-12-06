//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 1280 👎 0


//编辑距离
package com.leetcode.editor.cn;
public class EditDistance{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new EditDistance().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
    	if (word1 == null && word2 == null) return 0;
    	int len1 = word1.length();
    	int len2 = word2.length();
    	if (len1 + len2 == len1) return len1;
    	if (len1 + len2 == len2) return len2;
    	//dp[i][j] word1 sub(0, i)经过三种操做转化成word2c subString(0, j)所需要的最少操作
		//dp[i][j] = word.charAt(i) = word2.charAt(j) ? dp[i- 1][j- 1] : Math.min()
		int[][] dp = new int[len1 + 1][len2 + 1];
		//让字符串首字符为''
		//base case dp[i][0]或者dp[0][j]为0，因为''能转化为多长的字符，就是增加多少个字符，多个个字符能转为''，就是减少多少个字符
		// 因为从''开始，所以字符串对应的是charAt（i- 1）
		for (int i = 0; i < len1 + 1; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j < len2 + 1; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= len1; i++) {
			for (int j =1; j <= len2; j++) {
				//word1 插入1个和j相同的=>dp[i][j - 1], word1删除一个=>dp[i - 1][j], word1替换成word2.charAt(j) => dp[i - 1][j - 1]
				//为什么这里是word1.charAt(i - 1) == word2.charAt(j - 1)，因为前面加了空字符，word1.charAt(i - 1)
				dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
			}
		}
		return dp[len1][len2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}