class MinStack {

    /** initialize your data structure here. */
    private long min;
    private Stack<Long> st;
    public MinStack() {
        min = 0;
        st = new Stack<>();
    }
    
    public void push(int x) {
        if (st.isEmpty()) {
            st.push(0L);
            min = x;
        }
        else {
            st.push(x - min);
            min = Math.min(min, x);
        }
    }
    
    public void pop() {
        if (!st.isEmpty()) {
            long x = st.pop();
            if (x < 0) {
                min -= x;
            }
        }
    }
    
    public int top() {
        if (!st.isEmpty()) {
            long x = st.peek();
            if (x <= 0) {
                return (int) min;
            }
            return (int) (x + min);
        }
        return 0;
    }
    
    public int getMin() {
        return (int) min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */