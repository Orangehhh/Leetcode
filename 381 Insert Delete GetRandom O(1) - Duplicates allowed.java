class RandomizedCollection {

    /** Initialize your data structure here. */
    class DLinkedListNode {
        public int val;
        public DLinkedListNode next;
        public DLinkedListNode prev;
        public DLinkedListNode(int val) {
            this.val = val;
        }
    }
    
    private Map<Integer, Set<Integer>> valMap;
    private Map<Integer, DLinkedListNode> idxMap;
    private DLinkedListNode head;
    private DLinkedListNode tail;
    private int size;
    private Random rd;
    
    public RandomizedCollection() {
        valMap = new HashMap<>();
        idxMap = new HashMap<>();
        size = 0;
        head = new DLinkedListNode(-1);
        tail = new DLinkedListNode(-1);
        head.next = tail;
        tail.prev = head;
        rd = new Random();
    }
    
    private void addToLast(DLinkedListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    
    private void remove(DLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ans = false;
        Set<Integer> idxList = valMap.get(val);
        if (idxList == null) {
            ans = true;
            idxList = new HashSet<>();
            valMap.put(val, idxList);
        }
        idxList.add(size);
        DLinkedListNode node = new DLinkedListNode(val);
        addToLast(node);
        idxMap.put(size, node);
        size++;
        return ans;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> idxList = valMap.get(val);
        if (idxList == null) {
            return false;
        }
        int idx = idxList.iterator().next();
        idxList.remove(idx);
        if (idxList.size() == 0) {
            valMap.remove(val);
        }
        DLinkedListNode node = idxMap.get(idx);
        remove(node);
        size--;
        if (size != idx && size > 0) {
            DLinkedListNode anotherNode = idxMap.get(size);
            idxMap.put(idx, anotherNode);
            valMap.get(anotherNode.val).remove(size);
            valMap.get(anotherNode.val).add(idx);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int idx = rd.nextInt(size);
        return idxMap.get(idx).val;
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */