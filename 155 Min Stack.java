/*
 * @Author: Hao Liu
 * @Date: 2019-08-08 14:32:19
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-08 14:35:03
 * @Description: Min Stack
 */

class MinStack {

    /** initialize your data structure here. */
    private Stack<Long> st;     // overflow if using int, e.g. Integer.MAX_VALUE - Integer.MIN_VALE
    private long minNum;    
    
    public MinStack() {
        st = new Stack<>();
        minNum = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (st.isEmpty()) {
            st.push(0L);
            minNum = x;
        }
        else {
            st.push((long)x - minNum); 
            minNum = Math.min(minNum, x);
        }
    }
    
    public void pop() {
        long num = st.pop();
        if (num < 0) {
            minNum = minNum - num;
        }
    }
    
    public int top() {
        long num = st.peek();
        if (num > 0) {
            return (int) (num + minNum);
        }
        else {
            return (int) minNum;
        } 
    }
    
    public int getMin() {
        return (int) minNum;   
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