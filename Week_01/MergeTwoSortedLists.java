  //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1280 👎 0

  package com.leetcode.editor.en;

  import com.leetcode.editor.cn.ListNode;

  public class MergeTwoSortedLists {
      public static void main(String[] args) {
           Solution solution = new MergeTwoSortedLists().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        while (l1 != null && l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            if (x < y){
                tmp.next = new ListNode(x);
                tmp = tmp.next;
                l1 = l1.next;
            } else {
                tmp.next = new ListNode(y);
                tmp = tmp.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            if (l2 != null) {
                tmp.next = l2;
            }
        }

        if (l2 == null) {
            if (l1 != null) {
                tmp.next = l1;
            }
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }