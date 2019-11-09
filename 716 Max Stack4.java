class MaxStack {

    /** initialize your data structure here. */
    
    class DLinkedListNode {
        int val;
        DLinkedListNode prev;
        DLinkedListNode next;
        DLinkedListNode(int val) {
            this.val = val;
        }
    }
    
    private TreeMap<Integer, List<DLinkedListNode>> map;
    private DLinkedListNode head;
    private DLinkedListNode tail;
    
    private void addNodeToLast(DLinkedListNode node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    
    private void removeNode(DLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public MaxStack() {
        head = new DLinkedListNode(-1);
        tail = new DLinkedListNode(-1);
        head.next = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }
    
    public void push(int x) {
        DLinkedListNode node = new DLinkedListNode(x);
        addNodeToLast(node);
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(node);
    }
    
    public int pop() {
        DLinkedListNode node = tail.prev;
        removeNode(node);
        int val = node.val;
        List<DLinkedListNode> list = map.get(val);
        list.remove(list.size() - 1);
        if (list.size() == 0) {
            map.remove(val);
        }
        return val;
    }
    
    public int top() {
        return tail.prev.val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        List<DLinkedListNode> list = map.get(map.lastKey());
        DLinkedListNode node = list.get(list.size() - 1);
        removeNode(node);
        list.remove(list.size() - 1);
        if (list.size() == 0) {
            map.remove(node.val);
        }
        return node.val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */