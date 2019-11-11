class FileSystem {
    
    class File {
        public String fileName;
        public String content;
        public File(String fileName, String content) {
            this.fileName = fileName;
            this.content = content;
        }
        public void append(String c) {
            this.content += c;
        }
    }
    
    class TrieNode {
        public Map<String, TrieNode> children;
        public File file;
        public TrieNode() {
            children = new HashMap<>();
            file = null;
        }
    }
    
    private TrieNode root;

    public FileSystem() {
        root = new TrieNode();
    }
    
    public List<String> ls(String path) {
        List<String> ans = new ArrayList<>();
        TrieNode cur = root;
        String[] sArr = path.split("/");
        for (String s : sArr) {
            if (s.equals("")) continue;
            cur = cur.children.get(s);
        }
        if (cur.file != null) {
            ans.add(cur.file.fileName);
            return ans;
        }
        for (String key : cur.children.keySet()) {
            ans.add(key);
        }
        // for (Map.Entry<String, TrieNode> entry : cur.children.entrySet()) {
        //     ans.add(entry.getKey());
        // }
        Collections.sort(ans);
        return ans;
    }
    
    public void mkdir(String path) {
        TrieNode cur = root;
        String[] sArr = path.split("/");
        for (String s : sArr) {
            if (s.equals("")) continue;
            if (!cur.children.containsKey(s)) {
                cur.children.put(s, new TrieNode());
            }
            cur = cur.children.get(s);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        TrieNode cur = root;
        String[] sArr = filePath.split("/");
        for (String s : sArr) {
            if (s.equals("")) continue;
            if (!cur.children.containsKey(s)) {
                cur.children.put(s, new TrieNode());
            }
            cur = cur.children.get(s);
        }
        if (cur.file == null) {
            File file = new File(sArr[sArr.length - 1], content);
            cur.file = file;
        }
        else {
            cur.file.append(content);
        }
    }
    
    public String readContentFromFile(String filePath) {
        TrieNode cur = root;
        String[] sArr = filePath.split("/");
        for (String s : sArr) {
            if (s.equals("")) continue;
            if (!cur.children.containsKey(s)) {
                cur.children.put(s, new TrieNode());
            }
            cur = cur.children.get(s);
        }
        return cur.file.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */