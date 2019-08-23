/*
 * @Author: Hao Liu
 * @Date: 2019-08-23 10:55:53
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-23 10:56:03
 * @Description: Trie
 */

class Trie {

    /** Initialize your data structure here. */
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
        }
        cur.endOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        return cur.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            if (!cur.children.containsKey(ch)) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */