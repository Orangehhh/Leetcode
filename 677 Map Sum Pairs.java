/*
 * @Author: Hao Liu
 * @Date: 2019-08-24 12:40:52
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-24 12:41:05
 * @Description: Trie
 */

class MapSum {

    /** Initialize your data structure here. */
    class TrieNode {
        TrieNode[] children;
        int val;
        TrieNode() {
            this.children = new TrieNode[26];
            this.val = 0;
        }
    }
    
    private TrieNode root;
    private Map<String, Integer> map;
    
    public MapSum() {
        root = new TrieNode();    
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
        int prevVal = -1;
        if (map.containsKey(key)) {
            prevVal = map.get(key);
        }
        map.put(key, val);
        cur.val = cur.val - (prevVal == -1 ? 0 : prevVal) + val;
        for (char ch : key.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
            cur.val = cur.val - (prevVal == -1 ? 0 : prevVal) + val;
        }
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        int ans = cur.val;
        for (char ch : prefix.toCharArray()) {
            if (cur.children[ch - 'a'] == null) {
                return 0;
            }
            cur = cur.children[ch - 'a'];
        }
        return cur.val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */