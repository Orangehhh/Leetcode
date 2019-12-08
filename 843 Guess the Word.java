/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0; i < 10; i++) {
            int idx = new Random().nextInt(wordlist.length);
            int x = master.guess(wordlist[idx]);
            if (x == 6) return;
            List<String> newWordList = new ArrayList<>();
            for (String word : wordlist) {
                if (match(wordlist[idx], word) == x) {
                    newWordList.add(word);
                }
            }
            wordlist = new String[newWordList.size()];
            for (int j = 0; j < wordlist.length; j++) {
                wordlist[j] = newWordList.get(j);
            }
        }
    }
    
    private int match(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}