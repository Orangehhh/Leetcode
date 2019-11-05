/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null");
        }
        else {
            sb.append(String.valueOf(root.val));
            sb.append(",");
            buildString(root.left, sb);
            sb.append(",");
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] dataArr = data.split(",");
        Queue<String> q = new LinkedList<>();
        for (String s : dataArr) {
            q.offer(s);
        }
        return buildTree(q);
    }
    
    private TreeNode buildTree(Queue<String> q) {
        TreeNode root = null;
        String s = q.poll();
        if (!s.equals("null")) {
            root = new TreeNode(Integer.parseInt(s));
            root.left = buildTree(q);
            root.right = buildTree(q);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));