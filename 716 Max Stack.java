/*
 * @Author: Hao Liu
 * @Date: 2019-08-08 15:04:50
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-08 15:05:46
 * @Description: Max Stack, Sub-optimal, push O(logn), popMax O(n)
 */

class MaxStack {
    
    class Node {
        int val;
        Node(int val) {
            this.val = val;
        }
    }
    
    /** initialize your data structure here. */
    private PriorityQueue<Node> pq;
    private LinkedList<Node> list;
    
    public MaxStack() {
        pq = new PriorityQueue<>(1, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.val != n2.val) {
                    return n2.val - n1.val;
                }
                else {
                    return -1;
                }
            }
        });
        list = new LinkedList<>();
    }
    
    public void push(int x) {
        Node n = new Node(x);
        list.add(n);
        pq.offer(n);
    }
    
    public int pop() {
        Node n = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        pq.remove(n);
        return n.val;
    }
    
    public int top() {
        Node n = list.get(list.size() - 1);
        return n.val;
    }
    
    public int peekMax() {
        Node n = pq.peek();
        return n.val;
    }
    
    public int popMax() {
        Node n = pq.poll();
        list.remove(n);
        return n.val;
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