/*
 * @Author: Hao Liu
 * @Date: 2019-08-23 11:23:12
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-23 11:23:14
 * @Description: Trie
 */

 class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder sb = new StringBuilder();
        TrieNode root = buildTrie(dict);
        for (String str : sentence.split(" ")) {
            String prefix = getPrefix(root, str);
            if (prefix == null) {
                sb.append(str);
            }
            else {
                sb.append(prefix);
            }
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }
    
    private String getPrefix(TrieNode root, String str) {
        TrieNode cur = root;
        for (char ch : str.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                return null;
            }
            cur = cur.children[ch - 'a'];
            if (cur.word != null) {
                return cur.word;
            }
        }
        return null;
    }
    
    private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode();
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
        return root;
    }
}
