class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        while (i >= 0 || j >= 0) {
            int cnt = 0;
            while (i >= 0 && (cnt > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') {
                    cnt++;
                }
                else {
                    cnt--;
                }
                i--;
            }
            cnt = 0;
            while (j >= 0 && (cnt > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') {
                    cnt++;
                }
                else {
                    cnt--;
                }
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            }
            else {
                break;
            }
        }
        if (i < 0 && j < 0) return true;
        return false;
    }
}