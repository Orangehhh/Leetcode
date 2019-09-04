/*
 * @Author: Hao Liu
 * @Date: 2019-09-03 23:04:12
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-09-03 23:04:14
 * @Description: Tree
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
 
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = height(root);
        if (h - 1 == height(root.right)) {
            return (1 << h) + countNodes(root.right);
        }
        else {
            return (1 << (h - 1)) + countNodes(root.left);
        }
    }
    
    private int height(TreeNode node) {
        return node == null ? -1 : 1 + height(node.left);
    }
}
