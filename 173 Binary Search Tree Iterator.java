/*
 *   Copyright (c) 2019 Hao Liu
 *   All rights reserved.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    private Stack<TreeNode> st;
    
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            st.push(cur);
            cur = cur.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.pop();
        int val = node.val;
        node = node.right;
        while (node != null) {
            st.push(node);
            node = node.left;
        }
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */