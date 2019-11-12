class FileSystem {
    
    class TrieNode {
        public Map<String, TrieNode> children;
        public int value;
        public TrieNode() {
            children = new HashMap<>();
            value = -1;
        }
    }

    private TrieNode root;
    
    public FileSystem() {
        root = new TrieNode();
    }
    
    public boolean createPath(String path, int value) {
        TrieNode cur = root;
        boolean exist = false;
        String[] sArr = path.split("/");
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i].length() == 0)    continue;
            if (i != sArr.length - 1 && !cur.children.containsKey(sArr[i])
               || i == sArr.length - 1 && cur.children.containsKey(sArr[i])) {
                return false;
            }
            if (!cur.children.containsKey(sArr[i])) {
                cur.children.put(sArr[i], new TrieNode());
            }
            cur = cur.children.get(sArr[i]);
        }
        cur.value = value;
        return true;
    }
    
    public int get(String path) {
        TrieNode cur = root;
        for (String s : path.split("/")) {
            if (s.length() == 0)    continue;
            if (!cur.children.containsKey(s)) {
                return -1;
            }
            cur = cur.children.get(s);
        }
        return cur.value;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */