/*
 * @Author: Hao Liu
 * @Date: 2019-08-20 15:02:50
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-20 15:02:59
 * @Description: Trie
 */

class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        String word;
        TrieNode() {
            children = new HashMap<>();
            word = null;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trieRoot = buildTrie(words);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(ans, board, i, j, trieRoot);
            }
        }
        return ans;
    }
    
    private void dfs(List<String> ans, char[][] board, int i, int j, TrieNode cur) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n)     return;
        if (!cur.children.containsKey(board[i][j])) return;
        cur = cur.children.get(board[i][j]);
        if (cur.word != null) {
            ans.add(cur.word);
            cur.word = null;
        }
        char ch = board[i][j];
        board[i][j] = '.';
        dfs(ans, board, i + 1, j, cur);
        dfs(ans, board, i - 1, j, cur);
        dfs(ans, board, i, j + 1, cur);
        dfs(ans, board, i, j - 1, cur);
        board[i][j] = ch;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode trieRoot = new TrieNode();
        for (String word : words) {
            TrieNode cur = trieRoot;
            for (char ch : word.toCharArray()) {
                if (!cur.children.containsKey(ch)) {
                    cur.children.put(ch, new TrieNode());
                }
                cur = cur.children.get(ch);
            }
            cur.word = word;
        }
        return trieRoot;
    }
}