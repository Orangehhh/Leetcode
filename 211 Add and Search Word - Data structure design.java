class WordDictionary {

    /** Initialize your data structure here. */
    class TrieNode {
        public TrieNode[] children;
        public boolean endOfWord;
        public TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }
    }
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();    
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.endOfWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    
    private boolean dfs(String word, int pos, TrieNode node) {
        if (node == null)   return false;
        if (pos >= word.length()) {
            return node.endOfWord;
        }
        char ch = word.charAt(pos);
        if (ch == '.') {
            for (int k = 0; k < 26; k++) {
                if (dfs(word, pos + 1, node.children[k])) {
                    return true;
                }
            }
            return false;
        }
        else {
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            else {
                node = node.children[ch - 'a'];
                return dfs(word, pos + 1, node);
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */