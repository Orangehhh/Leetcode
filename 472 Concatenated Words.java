class Solution {
    
    class TrieNode {
        TrieNode[] children;
        boolean endOfword;
        TrieNode() {
            children = new TrieNode[26];
            endOfword = false;
        }
    }
    
    private TrieNode root;
    
    private void insertWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.endOfword = true;
    }
    
    private boolean checkWord(String word, int start) {
        if (word.length() == 0) {
            return false;
        }
        if (start == word.length()) {
            return true;
        }
        TrieNode cur = root;
        for (int i = start; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = cur.children[ch - 'a'];
            if (node == null)   return false;
            cur = node;
            if (cur.endOfword && checkWord(word, i + 1)) {
                return true;
            }
        }
        return false;
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        root = new TrieNode();
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            if (checkWord(word, 0)) {
                ans.add(word);
            }
            insertWord(word);
        }
        return ans;
    }
}