class MyHashMap {

    /** Initialize your data structure here. */
    class ListNode {
        public int key;
        public int value;
        public ListNode next;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private ListNode[] arrList;
    private final int length = 10001;
    
    public MyHashMap() {
        arrList = new ListNode[length];
    }
    
    private int getIndex(int key) {
        return Integer.hashCode(key) % length;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = getIndex(key);
        ListNode node = arrList[idx];
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        if (node != null) {
            node.value = value;
        }
        else {
            node = new ListNode(key, value);
            if (prev == null) {
                arrList[idx] = node;
            }
            else {
                prev.next = node;
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = getIndex(key);
        ListNode node = arrList[idx];
        while (node != null && node.key != key) {
            node = node.next;
        }
        if (node == null)   return -1;
        return node.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = getIndex(key);
        ListNode node = arrList[idx];
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        if (node == null)   return;
        if (prev == null) {
            arrList[idx] = node.next;
        }
        else {
            prev.next = node.next;
        }
        node = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */