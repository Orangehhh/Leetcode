/*
 * @Author: Hao Liu
 * @Date: 2019-08-26 23:21:51
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-26 23:22:01
 * @Description: Monotonic Stack
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution { 
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.size()];
        for (int i = nums.size() - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums.get(i)) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? 0 : st.peek();
            st.push(nums.get(i));
        }
        return ans;
    }
}
