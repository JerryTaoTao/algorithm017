  //编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找 
// 👍 245 👎 0

  package com.leetcode.editor.cn;
  public class SearchA2dMatrix {
      public static void main(String[] args) {
           Solution solution = new SearchA2dMatrix().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //return reduceSpace(matrix, target);
        return binarySearch(matrix, target);
    }

    public boolean binarySearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            if ( binarySearch(matrix[i], target) != -1) {
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] subArray, int target) {
        int start = 0;
        int end = subArray.length - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            int cur = subArray[mid];
            if (cur > target) end = mid - 1;
            if (cur < target) start = mid + 1;
            if (cur == target) return mid;
        }
        return  -1;
    }

    public boolean reduceSpace(int[][] matrix,int target) {
        if (matrix == null) return false;
        if (matrix.length <= 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            int cur = matrix[i][j];
            if (cur == target) return true;
            if (cur > target) j--;
            if (cur < target) i++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }