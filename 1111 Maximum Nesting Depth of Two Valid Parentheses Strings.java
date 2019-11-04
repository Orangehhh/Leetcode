class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.length() == 0)   return new int[0];
        int d = 0;
        int count = 0;
        for (char ch : seq.toCharArray()) {
            if (ch == '(') {
                count++;
            }
            else {
                count--;
            }
            d = Math.max(d, count);
            if (count < 0) return new int[0];
        }
        if (count != 0) return new int[0];
        int l = 0;
        int r = d;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int[] tmp = check(mid, seq);
            if (tmp.length > 0) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return check(l, seq);
    }
    
    private int[] check(int mid, String seq) {
        int[] ans = new int[seq.length()];
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            if (ch == '(') {
                if (count1 < mid) {
                    count1++;
                    ans[i] = 0;
                }
                else if (count2 < mid) {
                    count2++;
                    ans[i] = 1;
                }
                else {
                    return new int[0];
                }
            }
            else {
                if (count1 > 0) {
                    count1--;
                    ans[i] = 0;
                }
                else if (count2 > 0) {
                    count2--;
                    ans[i] = 1;
                }
                else {
                    return new int[0];
                }
            }
        }
        return ans;
    }
}