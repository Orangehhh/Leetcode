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
        if (root == null)   return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        st.push(cur);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            ans.add(node.val);
            if (node.left != null) st.push(node.left);
            if (node.right != null)  st.push(node.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}