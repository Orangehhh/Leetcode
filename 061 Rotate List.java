/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)   return head;
        int len = 0;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            len++;
            fast = fast.next;
        }
        fast = head;
        for (int i = 0; i < k % len; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}