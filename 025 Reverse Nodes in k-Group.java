/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curHead = dummy;
        while (curHead != null) {
            curHead = reverse(curHead, k);
            // if (curHead != null) System.out.println(curHead.val);
            // else System.out.println(curHead);
        }
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head, int k) {
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            cur = cur.next;   
            if (cur == null) {
                return null;
            }
        }
        ListNode nextNode = cur.next;
        ListNode nextHead = null;
        cur = head.next;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            if (i == 0) {
                cur.next = nextNode;
                nextHead = cur;
            }
            else {
                cur.next = head.next;
                head.next = cur;
            }
            cur = next;
        }
        return nextHead;
    }
}