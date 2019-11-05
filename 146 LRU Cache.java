class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    private Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            map.put(key, node);
            addNodeToHead(node);
            size++;
            if (size > capacity) {
                Node n = deleteLastNode();
                map.remove(n.key);
                size--;
            }
        }
        else {
            Node node = map.get(key);
            moveToHead(node);
            node.value = value;
        }
    }
    
    private void moveToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    private void addNodeToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    private Node deleteLastNode() {
        Node node = tail.prev;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */