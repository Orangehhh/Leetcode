class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        int i = 0;
        int ans = 0;
        int[] count = new int[tree.length + 1];
        int k = 0;
        for (int j = 0; j < tree.length; j++) {
            if (count[tree[j]] == 0) {
                k++;
            }
            count[tree[j]]++;
            while (k > 2) {
                count[tree[i]]--;
                if (count[tree[i]] == 0) {
                    k--;
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}