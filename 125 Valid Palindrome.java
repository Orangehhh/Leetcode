class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        char[] chArr = s.toLowerCase().toCharArray();
        int i = 0;
        int j = chArr.length - 1;
        while (i < j) {
            while (i < j && !isAlphaNumeric(chArr[i])) {
                i++;
            }
            while (i < j && !isAlphaNumeric(chArr[j])) {
                j--;
            }
            if (chArr[i] != chArr[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;   
    }
    
    private boolean isAlphaNumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}