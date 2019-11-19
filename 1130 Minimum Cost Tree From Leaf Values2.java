class Solution {
    public int mctFromLeafValues(int[] arr) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        st.push(Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] >= st.peek()) {
                ans += st.pop() * Math.min(st.peek(), arr[i]);
            }
            st.push(arr[i]);
        }
        while (st.size() > 2) {
            ans += st.pop() * st.peek();
        }
        return ans;
    }
}