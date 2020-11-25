//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法 
// 👍 148 👎 0


//翻转对
package com.leetcode.editor.cn;
public class ReversePairs{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ReversePairs().new Solution();
		 //System.out.println(solution.reversePairs(new int[] {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
    	if (nums == null) return 0;
    	return  mergeSort(nums, nums.length, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int len, int left, int right) {
    	if (left >= right || nums == null) return 0;
    	int mid = (left + right) >> 1;
    	int c1 = mergeSort(nums, len, left, mid);
    	int c2 = mergeSort(nums, len, mid + 1, right);
    	int count = 0;
		int j = mid + 1;
		//因为左右有序，如果当i 大于右边（j - (mid + 1)）个，那么i + 1 以后的也一定从p开始，
		for (int i = left; i <= mid ; i++) {
			while (j <= right && nums[i] > 2 * (long) nums[j]) j++;
			count = count + j - (mid + 1);
		}
    	merge(nums, len, mid, left, right);
		return c1 + c2 + count;
	}
	public void merge(int[] nums, int len, int mid, int left, int right) {

    	int[] temp = new int[right - left + 1];
    	int k = 0;
    	int i = left;
    	int j = mid + 1;
    	while (i <= mid && j <= right) {
    		temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
		}
    	while (i <= mid) temp[k++] = nums[i++];
    	while (j <= right) temp[k++] = nums[j++];

		for (int t = 0; t < temp.length; t++) {
			nums[left + t] = temp[t];
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}