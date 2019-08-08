/*
 * @Author: Hao Liu
 * @Date: 2019-08-08 15:25:08
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-08 15:26:24
 * @Description: Max Stack, Doubly Linked List + PriorityQueue, push/pop/popMax O(log n)
 */

class MaxStack {
    
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int val) {
            this.val = val;
        }
    }
    
    private PriorityQueue<ListNode> pq;
    private ListNode head;
    private ListNode tail;
    
    /** initialize your data structure here. */
    public MaxStack() {
        pq = new PriorityQueue<>(1, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val != n2.val) {
                    return n2.val - n1.val;
                }
                return -1;
            }
        }); 
        head = null;
        tail = null;
    }
    
    public void push(int x) {
        ListNode n = new ListNode(x);
        pq.offer(n);
        if (head == null) {
            head = n;
            tail = n;
        }
        else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }
    
    public int pop() {
        ListNode n = tail;
        deleteTail();
        pq.remove(n);
        return n.val;
    }
    
    public int top() {
        return tail.val;
    }
    
    public int peekMax() {
        return pq.peek().val;
    }
    
    public int popMax() {
        ListNode n = pq.poll();
        deleteNode(n);
        return n.val;
    }
    
    private void deleteTail() {
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            tail.prev.next = null;
            tail = tail.prev;
        }
    }
    
    private void deleteHead() {
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
    }
    
    private void deleteNode(ListNode n) {
        if (n == head) {
            deleteHead();
        }
        else if (n == tail) {
            deleteTail();
        }
        else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }   
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