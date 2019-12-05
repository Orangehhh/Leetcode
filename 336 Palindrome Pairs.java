class Solution {
    class TrieNode {
        TrieNode[] children;
        int index;
        List<Integer> indices;
        TrieNode() {
            children = new TrieNode[26];
            index = -1;
            indices = new ArrayList<>();
        }
    }
    
    private TrieNode root;
    
    private void insert(String word, int idx) {
        TrieNode cur = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            if (isPalindrome(word.substring(0, i + 1))) {
                cur.indices.add(idx);
            }
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.indices.add(idx);
        cur.index = idx;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        root = new TrieNode();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            insert(words[i], i);
        } 
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            check(ans, word, i);
        }
        return ans;
    }
    
    private void check(List<List<Integer>> ans, String word, int idx) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.index != -1 && cur.index != idx 
                & isPalindrome(word.substring(i))) {
                ans.add(Arrays.asList(idx, cur.index));
            }
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                return;
            }
            cur = cur.children[ch - 'a'];
        }
        for (int j : cur.indices) {
            if (idx == j)   continue;
            ans.add(Arrays.asList(idx, j));  
        }
    }
    
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}