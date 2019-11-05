class AutocompleteSystem {
    
    class Node {
        String sentence;
        int time;
        Node(String sentence, int time) {
            this.sentence = sentence;
            this.time = time;
        }
    }
    
    class TrieNode {
        TrieNode[] children;
        String sentence;
        int time;
        TrieNode() {
            children = new TrieNode[27];
            time = 0;
            sentence = "";
        }
    }
    
    private TrieNode root;
    private TrieNode curTrieNode;
    private String curStr;
    
    private int getIdx(char ch) {
        return ch == ' ' ? 26 : ch - 'a';
    }
    
    private void insert(String s, int time) {
        TrieNode cur = root;
        for (char ch : s.toCharArray()) {
            if (cur.children[getIdx(ch)] == null) {
                cur.children[getIdx(ch)] = new TrieNode();
            }
            cur = cur.children[getIdx(ch)];
        }
        cur.time = time;
        cur.sentence = s;
    }
        
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        curTrieNode = root;
        curStr = "";
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            int time = times[i];
            insert(sentence, time);
        }
    }
    
    private void traverse(List<Node> res, TrieNode node) {
        if (node.time > 0) {
            res.add(new Node(node.sentence, node.time));
        }
        for (int i = 0; i < 27; i++) {
            if (node.children[i] != null) {
                traverse(res, node.children[i]);
            }
        }
    }
    
    public List<String> input(char c) {
        List<String> ans = new ArrayList<>();
        if (c != '#') {
            curStr += c;
            if (curTrieNode.children[getIdx(c)] == null) {
                curTrieNode.children[getIdx(c)] = new TrieNode();
            }
            curTrieNode = curTrieNode.children[getIdx(c)];
            TrieNode node = curTrieNode;
            List<Node> res = new ArrayList<>();
            traverse(res, node);
            Collections.sort(res, new Comparator<Node>() {
                @Override
                public int compare(Node n1, Node n2) {
                    return n1.time == n2.time ? n1.sentence.compareTo(n2.sentence) : n2.time - n1.time;
                }
            });
            for (int k = 0; k < 3 && k < res.size(); k++) {
                ans.add(res.get(k).sentence);
            }
        }
        else {
            curTrieNode.time++;
            curTrieNode.sentence = curStr;
            curTrieNode = root;
            curStr = "";
        }
        return ans;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */