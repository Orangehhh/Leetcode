    class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (st.peek() != -1 && heights[i] <= heights[st.peek()]) {
                ans = Math.max(ans, heights[st.pop()] * (i - st.peek() - 1));
            }
            st.push(i);
        }
        while (st.peek() != -1) {
            ans = Math.max(ans, heights[st.pop()] * (n - st.peek() - 1));
        }
        return ans;
    }
}