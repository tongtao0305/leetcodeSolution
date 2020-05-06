/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = l1;
        ListNode r = l2;
        ListNode headNode = new ListNode(0); // 保存头节点
        ListNode curNode = headNode; // 保存新生成的节点
        int carry = 0; // 用来保存数字的进位

        while (l != null || r != null) {
            // 获取l和r保存的数值，并进行计算
            int x = (l == null) ? 0 : l.val;
            int y = (r == null) ? 0 : r.val;
            int sum = x + y + carry;
            carry = sum / 10;

            // 根据计算结果新建节点
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;

            // 更新l和r
            if (l != null)
                l = l.next;
            if (r != null)
                r = r.next;
        }

        // 如果还有进位，则新建一个节点
        if (carry > 0) {
            curNode.next = new ListNode(carry);
        }

        return headNode.next;
    }
}
// @lc code=end
