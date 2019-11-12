class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    class DLinkedListNode {
        public int value;    
        public DLinkedListNode prev;
        public DLinkedListNode next;
        public DLinkedListNode(int value) {
            this.value = value;
        }
    }

    class DLinkedList {
        public DLinkedListNode head;
        public DLinkedListNode tail;
        public int size;
        public int capacity;
        public DLinkedList(int capacity) {
            head = new DLinkedListNode(-1);
            tail = new DLinkedListNode(-1);
            head.next = tail;
            tail.prev = head;
            size = 0;
            this.capacity = capacity;
        }
        
        public void remove(DLinkedListNode node) {
            if (node == head || node == tail) {
                return;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        public void insertFirst(DLinkedListNode node) {
            if (node == null) {
                return;
            }
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            size++;
        }
        
        public void insertLast(DLinkedListNode node) {
            if (node == null) {
                return;
            }
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
            size++;
        }
    }
    
    private DLinkedList dll;
    
    public MyCircularQueue(int k) {
        dll = new DLinkedList(k);
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        dll.insertLast(new DLinkedListNode(value));
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty())  return false;
        dll.remove(dll.head.next);
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) return -1;
        return dll.head.next.value;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty())  return -1;
        return dll.tail.prev.value;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return dll.size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return dll.size == dll.capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */