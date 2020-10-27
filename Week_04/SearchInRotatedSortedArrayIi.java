  //假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。 
//
// 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。 
//
// 示例 1: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 0
//输出: true
// 
//
// 示例 2: 
//
// 输入: nums = [2,5,6,0,0,1,2], target = 3
//输出: false 
//
// 进阶: 
//
// 
// 这是 搜索旋转排序数组 的延伸题目，本题中的 nums 可能包含重复元素。 
// 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 238 👎 0

  package com.leetcode.editor.cn;
  public class SearchInRotatedSortedArrayIi {
      public static void main(String[] args) {
           Solution solution = new SearchInRotatedSortedArrayIi().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean search(int[] nums, int target) {
        return bs1(nums, target) != -1;
    }
          public int bs1(int[] nums, int t) {
              int l = 0;
              int r = nums.length - 1;
              while (l <= r) {
                  int mid = (l + r) >>> 1;
                  int midVal = nums[mid];
                  if (midVal == t) return mid;
                  if (nums[l] == midVal) {
                      l++;
                      continue;
                  }
                  if (nums[l] < midVal) {
                      if (nums[l] <= t && t <= midVal) {
                          r = mid - 1;
                      } else {
                          l = mid + 1;
                      }
                  } else {
                      if (midVal <= t && t <= nums[r]) {
                          l = mid + 1;
                      } else {
                          r = mid - 1;
                      }
                  }
              }
              return -1;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }