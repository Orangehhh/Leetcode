class MyHashSet {

    /** Initialize your data structure here. */
    class ListNode {
        public int key;
        public ListNode next;
        public ListNode(int key) {
            this.key = key;
        }
    }
    
    private ListNode[] arr;
    private final int len = 10001;
    
    private int getIdx(int key) {
        return Integer.hashCode(key) % len;
    }
    
    public MyHashSet() {
        arr = new ListNode[len];
    }
    
    public void add(int key) {
        if (contains(key)) return;
        ListNode newNode = new ListNode(key);
        int idx = getIdx(key);
        ListNode node = arr[idx];
        if (node != null) {
            newNode.next = node;
        }
        arr[idx] = newNode;
    }
    
    public void remove(int key) {
        int idx = getIdx(key);
        ListNode node = arr[idx];
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        if (node == null)   return;
        if (prev == null) {
            arr[idx] = node.next;
        }
        else {
            prev.next = node.next;
        }
        node = null;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = getIdx(key);
        ListNode node = arr[idx];
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return node != null;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */