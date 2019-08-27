/*
 * @Author: Hao Liu
 * @Date: 2019-08-26 21:47:44
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-26 21:48:05
 * @Description: Monotonic Stack
 */

class StockSpanner {
    
    class Pair {
        int price;
        int span;
        Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }
    
    private Stack<Pair> st;
    
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && st.peek().price <= price) {
            span += st.pop().span;
        }
        st.push(new Pair(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */