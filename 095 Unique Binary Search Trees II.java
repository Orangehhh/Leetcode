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
        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int start, int end) {
            List<TreeNode> ans = new ArrayList<>();
            if (start > end) {
                return ans;
            }
            for (int i = start; i <= end; i++) {
                TreeNode root = new TreeNode(i);
                for (TreeNode left : generateTrees(start, i - 1)) {
                    for (TreeNode right : generateTrees(i + 1, end)) {
                        root.left = left;
                        root.right = right;
                    }
                }
                ans.add(root);
            }
            return ans;
        }
    }