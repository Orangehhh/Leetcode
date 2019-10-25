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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(root, ans);
        return ans;
    }
    
    private void traverse(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        traverse(node.left, ans);
        traverse(node.right, ans);
        ans.add(node.val);
    }
}