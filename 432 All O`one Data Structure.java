class AllOne {

    /** Initialize your data structure here. */
    class DLinkedListNode {
        public int count;
        public Set<String> keySet;
        public DLinkedListNode next;
        public DLinkedListNode prev;
        public DLinkedListNode(int count) {
            this.count = count;
            keySet = new HashSet<>();
        }
    }
    
    class DLinkedList {
        public DLinkedListNode head;
        public DLinkedListNode tail;
        public DLinkedList() {
            head = new DLinkedListNode(0);
            tail = new DLinkedListNode(0);
            head.next = tail;
            tail.prev = head;
        }
        
        public void insertAfter(DLinkedListNode node, DLinkedListNode newNode) {
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
            newNode.prev = node;
        }
        
        public void insertBefore(DLinkedListNode node, DLinkedListNode newNode) {
            node.prev.next = newNode;
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev = newNode;
        }
        
        public void remove(DLinkedListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    
    private Map<String, Integer> keyMap;
    private Map<Integer, DLinkedListNode> countMap;
    private DLinkedList dll;
    
    public AllOne() {
        keyMap = new HashMap<>();
        countMap = new HashMap<>();
        dll = new DLinkedList();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!keyMap.containsKey(key)) {
            keyMap.put(key, 1);
            DLinkedListNode node = countMap.get(1);
            System.out.println(node);
            if (node == null) {
                node = new DLinkedListNode(1);
                countMap.put(1, node);
                dll.insertAfter(dll.head, node);
            }
            node.keySet.add(key);
        }
        else {
            int count = keyMap.get(key);     
            DLinkedListNode oldNode = countMap.get(count);
            oldNode.keySet.remove(key);
            count++;
            keyMap.put(key, count);
            DLinkedListNode newNode = countMap.get(count);
            if (newNode == null) {
                newNode = new DLinkedListNode(count);
                countMap.put(count, newNode);
                dll.insertAfter(oldNode, newNode);
            }
            newNode.keySet.add(key);
            if (oldNode.keySet.size() == 0) {
                dll.remove(oldNode);
                countMap.remove(oldNode.count);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!keyMap.containsKey(key))   return;
        int count = keyMap.get(key);
        DLinkedListNode oldNode = countMap.get(count);
        oldNode.keySet.remove(key);
        count--;
        if (count > 0) {
            keyMap.put(key, count);
            DLinkedListNode newNode = countMap.get(count);
            if (newNode == null) {
                newNode = new DLinkedListNode(count);
                countMap.put(count, newNode);
                dll.insertBefore(oldNode, newNode);
            }
            newNode.keySet.add(key);
        }
        else {
            keyMap.remove(key);
        }
        if (oldNode.keySet.size() == 0) {
            dll.remove(oldNode);
            countMap.remove(oldNode.count);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return dll.tail.prev == dll.head ? "" :                                                  (String) dll.tail.prev.keySet.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return dll.head.next == dll.tail ? "" :                                                  (String) dll.head.next.keySet.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */