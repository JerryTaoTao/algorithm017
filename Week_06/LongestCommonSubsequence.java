//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划 
// 👍 276 👎 0


//最长公共子序列

public class LongestCommonSubsequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new LongestCommonSubsequence().new Solution();
		 System.out.println(solution.longestCommonSubsequence("dknkdizqxkdczafixidorgfcnkrirmhmzqbcfuvojsxwraxe", "dknkdizqxkdczafixidorgfcnkrirmhmzqbcfuvojsxwraxe"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
    	//define subproblem
		// i != j ,f(i, j) = max(f(i -1, j), f(i, j - 1)
		//i = j , f(i, j)  = 1 + f(i -1, j - 1);
		//i > n || j >m, f(i,j) = 0;
		int l1 = text1.length();
		int l2 = text2.length();
		int[][] dp = new int[l2][l1];
		//init dp;
		if (text1.charAt(0) == text2.charAt(0)) {
			dp[0][0] = 1;
		} else {
			dp[0][0] = 0;
		}
		for (int i = 1; i < l1; i++) {
			dp[0][i] = text2.charAt(0) == text1.charAt(i) ? 1 :  dp[0][i - 1];
		}

		for (int j = 1; j < l2; j++) {
			dp[j][0] = text1.charAt(0) == text2.charAt(j) ? 1 :  dp[j - 1][0];
		}

		for (int i = 1; i < l2; i++) {
			for (int j = 1; j < l1; j++) {
				dp[i][j] = text2.charAt(i) == text1.charAt(j) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[l2 - 1][l1 - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}