class Solution {
    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() == 0) {
            return dominoes;
        }
        dominoes += "R";
        int n = dominoes.length();
        char[] charArr = dominoes.toCharArray();
        int i = 0;
        int prevState = 0;
        for (int j = 0; j < n; j++) {
            char curChar = charArr[j];
            if (curChar == '.') continue;
            if (prevState == 0 && curChar == 'L') {
                while (i < j) {
                    charArr[i++] = 'L';
                }
            }
            else if (prevState == 0 && curChar == 'R') {
                prevState = 1;
            }
            else if (prevState == 1 && curChar == 'R') {
                while (i < j) {
                    charArr[i++] = 'R';
                }
            }
            else if (prevState == 1 && curChar == 'L') {
                int r = j;
                while (i < r) {
                    charArr[i++] = 'R';
                    charArr[r--] = 'L';
                }
                prevState = 0;
            }
            i = j;
        }
        return new String(charArr, 0, n - 1);
    }
}