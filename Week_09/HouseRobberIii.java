//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 648 👎 0


//打家劫舍 III
package com.leetcode.editor.cn;
public class HouseRobberIii{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new HouseRobberIii().new Solution();
	 }
//力扣代码
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
    public int rob(TreeNode root) {
    	if (root == null) return 0;
    	int[] res = robHelper(root);
    	return Math.max(res[0], res[1]);
    }

    public int[] robHelper(TreeNode root) {
    	if (root == null) return  new int[2];
    	int[] left = robHelper(root.left);
    	int[] right = robHelper(root.right);

    	int[] res = new int[2];
    	//当前节点不偷时=》左儿子能偷的最大钱 + 右儿子能偷的最大钱(偷或者不偷的最大值)
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		//当前节点偷 =》当前值 + 不偷左儿子得到钱 + 不偷右儿子所能得到的最大钱
		res[1] = root.val + left[0] + right[0];
		return  res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}