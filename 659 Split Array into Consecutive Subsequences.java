class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int[] p = new int[3];
        int[] c = new int[3];
        int prev = -1;
        int i = 0;
        while (i < nums.length) {
            int cur = nums[i];
            int cnt = 0;
            while (i < nums.length && nums[i] == cur) {
                cnt++;
                i++;
            }
            if (cur != prev + 1) {
                if (p[0] > 0 || p[1] > 0)   return false;
                c[0] = cnt;
                c[1] = 0;
                c[2] = 0;
            }
            else {
                if (cnt < p[0] + p[1])  return false;
                c[1] = p[0];
                c[2] = p[1] + Math.min(p[2], cnt - (p[0] + p[1]));
                c[0] = Math.max(cnt - (p[0] + p[1] + p[2]), 0);
            }
            p = Arrays.copyOf(c, 3);
            prev = cur;
        }
        return p[0] == 0 && p[1] == 0;
    }
}