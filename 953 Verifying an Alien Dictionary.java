class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] pos = new int[26];
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            pos[ch - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            String prevWord = words[i - 1];
            if (!check(word, prevWord, pos)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean check(String word, String prevWord, int[] pos) {
        for (int i = 0; i < word.length() && i < prevWord.length(); i++) {
            char ch = word.charAt(i);
            char prevCh = prevWord.charAt(i);
            if (ch == prevCh)   continue;
            if (pos[ch - 'a'] < pos[prevCh - 'a']) {
                return false;
            }
            else {
                return true;
            }
        }
        return prevWord.length() <= word.length();
    }
}