class DLinkedListNode {
    public int val;
    public DLinkedListNode prev;
    public DLinkedListNode next;
    public DLinkedListNode(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    
    class DLinkedList {
        public DLinkedListNode head;
        public DLinkedListNode tail;
        public int size;
        public DLinkedList() {
            head = new DLinkedListNode(-1);
            tail = new DLinkedListNode(-1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        
        public void addAtHead(DLinkedListNode node) {
            addBefore(head.next, node);
        }
        
        public void addAtTail(DLinkedListNode node) {
            addBefore(tail, node);
        }
        
        public void addBefore(DLinkedListNode node, DLinkedListNode newNode) {
            node.prev.next = newNode;
            newNode.prev = node.prev;
            node.prev = newNode;
            newNode.next = node;
            size++;
        }
        
        public void remove(DLinkedListNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node = null;
            size--;
        }
        
        public DLinkedListNode getNodeAtIdx(int idx) {
            if (idx >= size) {
                return null;
            }
            DLinkedListNode cur = head.next;
            while (idx > 0) {
                cur = cur.next;
                idx--;
            }
            return cur;
        }
    }
    
    private DLinkedList dll;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        dll = new DLinkedList();
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        DLinkedListNode node = dll.getNodeAtIdx(index);
        if (node == null) {
            return -1;
        }
        return node.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        DLinkedListNode node = new DLinkedListNode(val);
        dll.addAtHead(node);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        DLinkedListNode node = new DLinkedListNode(val);
        dll.addAtTail(node);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        DLinkedListNode newNode = new DLinkedListNode(val);
        if (index == dll.size) {
            dll.addAtTail(newNode);
        }
        else {
            DLinkedListNode node = dll.getNodeAtIdx(index);
            if (node != null) {
                dll.addBefore(node, newNode);
            }
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        DLinkedListNode node = dll.getNodeAtIdx(index);
        if (node != null) {
            dll.remove(node);
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */