class MaxStack {

    /** initialize your data structure here. */
    private Stack<Integer> st1;
    private Stack<Integer> st2;
    
    public MaxStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        if (st1.isEmpty() || x >= st2.peek()) {
            st2.push(x);
        }
        else {
            st2.push(st2.peek());
        }
        st1.push(x);
    }
    
    public int pop() {
        st2.pop();
        return st1.pop();
    }
    
    public int top() {
        return st1.peek();
    }
    
    public int peekMax() {
        return st2.peek();
    }
    
    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack<>();
        while (top() != max) {
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
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