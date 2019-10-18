/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(-1);
        ListNode curFirst = first;
        ListNode curSecond = second;
        while (head != null) {
            if (head.val < x) {
                curFirst.next = head;
                curFirst = curFirst.next;
            }
            else {
                curSecond.next = head;
                curSecond = curSecond.next;
            }
            head = head.next;
        }
        curSecond.next = null;
        curFirst.next = second.next;
        return first.next;
    }
}