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
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("null,");
            }
            else {
                sb.append(String.valueOf(node.val));
                sb.append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.substring(0, sb.length() - 1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] dataArr = data.split(",");
        if (dataArr[0].equals("null")) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null)   continue;
            if (i < dataArr.length) {
                TreeNode left = null;
                if (!dataArr[i].equals("null")) {
                    left = new TreeNode(Integer.parseInt(dataArr[i]));
                }
                i++;
                node.left = left;
                q.offer(left);
            }
            if (i < dataArr.length) {
                TreeNode right = null;
                if (!dataArr[i].equals("null")) {
                    right = new TreeNode(Integer.parseInt(dataArr[i]));
                }
                i++;
                node.right = right;
                q.offer(right);
            }
            
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));