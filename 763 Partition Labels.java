class Solution {
    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return new ArrayList<>();
        }
        int[] pos = new int[26];
        int n = S.length();
        char[] charArr = S.toCharArray();
        for (int i = 0; i < n; i++) {
            pos[charArr[i] - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            r = Math.max(r, pos[charArr[i] - 'a']);
            if (i == r) {
                ans.add(r - l + 1);
                l = r + 1;
            }
        }
        return ans;
    }
}