class Solution {
    
    class TreeNode {
        int val;
        int count;
        int leftCount;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            count = 0;
            leftCount = 0;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(updateTree(root, nums[i]));
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            ans.add(res.get(i));
        }
        return ans;
    }
    
    private int updateTree(TreeNode root, int num) {
        TreeNode cur = root;
        if (cur.val == num) {
            cur.count++;
            return cur.leftCount;
        }
        else if (cur.val > num) {
            cur.leftCount++;
            if (cur.left == null) {
                cur.left = new TreeNode(num);
            }
            return updateTree(cur.left, num);
        }
        else {
            if (cur.right == null) {
                cur.right = new TreeNode(num);
            }
            return cur.count + cur.leftCount + updateTree(cur.right, num);
        }
    }
}