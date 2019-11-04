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
    public int closestValue(TreeNode root, double target) {
        TreeNode cur = root;
        int ans = cur.val;
        while (cur != null) {
            if (Math.abs(cur.val - target) < Math.abs(ans - target)) {
                ans = cur.val;
            }
            if (cur.val == target) break;
            else if (cur.val > target) {
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }
        return ans;
    }
}