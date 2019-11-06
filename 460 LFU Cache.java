class LFUCache {
    class DLinkedListNode {
        int key;
        int value;
        int freq;
        DLinkedListNode next;
        DLinkedListNode prev;
        DLinkedListNode(int key, int value, int freq) {
            this.key = key;
            this.value = value;
            this.freq = freq;
        }
    }
    
    private Map<Integer, DLinkedListNode> keyMap;
    private Map<Integer, DLinkedListNode> freqMap;
    private DLinkedListNode head;
    private DLinkedListNode tail;
    private int capacity;
    private int size;
    
    public LFUCache(int capacity) {
        head = new DLinkedListNode(-1, -1, 1);
        tail = new DLinkedListNode(-1, -1, -1);
        head.next = tail;
        tail.prev = head;
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
        freqMap.put(1, head);
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        DLinkedListNode node = keyMap.get(key);
        addFreqByOne(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;
        if (!keyMap.containsKey(key)) {
            size++;
            if (size > capacity) {
                DLinkedListNode node = head.next;
                if (freqMap.get(node.freq) == node) {
                    if (node.freq == 1) {
                        freqMap.put(node.freq, head);
                    }
                    else {
                        if (node.freq == node.prev.freq) {
                            freqMap.put(node.freq, node.prev);
                        }
                        else {
                            freqMap.remove(node.freq);
                        }
                    }
                }
                deleteNode(node);
                keyMap.remove(node.key);
            }
            DLinkedListNode newNode = new DLinkedListNode(key, value, 1);
            DLinkedListNode dstNode = freqMap.get(1);
            addAfter(newNode, dstNode);
            keyMap.put(key, newNode);
            freqMap.put(1, newNode);
        }
        else {
            DLinkedListNode node = keyMap.get(key);
            node.value = value;
            addFreqByOne(node);
        }
    }
    
    private void addFreqByOne(DLinkedListNode node) {
        if (freqMap.get(node.freq) == node) {
            if (node.freq == node.prev.freq) {
                freqMap.put(node.freq, node.prev);
            }
            else {
                freqMap.remove(node.freq);
            }
        }
        else {
            deleteNode(node);
            addAfter(node, freqMap.get(node.freq));
        }
        node.freq++;
        if (freqMap.containsKey(node.freq)) {
            DLinkedListNode dstNode = freqMap.get(node.freq);
            deleteNode(node);
            addAfter(node, dstNode);    
        }
        freqMap.put(node.freq, node);
    }
    
    private void deleteNode(DLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void addAfter(DLinkedListNode node, DLinkedListNode dstNode) {
        dstNode.next.prev = node;
        node.next = dstNode.next;
        node.prev = dstNode;
        dstNode.next = node;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */