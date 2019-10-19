class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] charArr = s.toCharArray();
        int l = 0;
        int r = charArr.length - 1;
        while (l < r) {
            while (l < r && !vowels.contains(charArr[l])) {
                l++;
            }
            while (l < r && !vowels.contains(charArr[r])) {
                r--;
            }
            char tmp = charArr[l];
            charArr[l] = charArr[r];
            charArr[r] = tmp;
            l++;
            r--;
        }
        return new String(charArr);
    }
}