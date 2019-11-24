class Solution {
    public int shortestWay(String source, String target) {
        if (target == null || target.length() == 0) {
            return 0;
        }
        if (source == null || source.length() == 0) {
            return -1;
        }
        int ans = 0;
        int j = 0;
        while (ans <= target.length() && j < target.length()) {
            ans++;
            for (int i = 0; i < source.length(); i++) {
                if (j < target.length() && source.charAt(i) == target.charAt(j)) {
                    j++;
                }
            }
        }    
        return ans > target.length() ? -1 : ans;
    }
}