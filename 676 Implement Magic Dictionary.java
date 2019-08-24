/*
 * @Author: Hao Liu
 * @Date: 2019-08-24 12:05:51
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-24 12:06:52
 * @Description: DFS
 */

class MagicDictionary {

    /** Initialize your data structure here. */
    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    private TrieNode root;
    
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String str : dict) {
            TrieNode cur = root;
            for (char ch : str.toCharArray()) {
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new TrieNode();
                }
                cur = cur.children[ch - 'a'];
            }
            cur.word = str;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        TrieNode cur = root;
        return dfs(cur, word, 0, 1);
    }
    
    private boolean dfs(TrieNode cur, String word, int pos, int replaced) {
        if (cur == null || replaced < 0) {
            return false;
        }
        if (pos == word.length()) {
            if (cur.word != null && replaced == 0) {
                return true;
            }
            return false;
        }
        char ch = word.charAt(pos);
        if (dfs(cur.children[ch - 'a'], word, pos + 1, replaced)) {
            return true;
        }
        for (int k = 0; k < 26; k++) {
            if (ch - 'a' == k) continue;
            if (dfs(cur.children[k], word, pos + 1, replaced - 1)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
