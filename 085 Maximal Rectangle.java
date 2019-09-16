class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] height = new int[m][n];
        for (int j = 0; j < n; j++) {
            height[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                }
                else {
                    height[i][j] = height[i - 1][j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = Math.max(ans, getArea(height, i));
        }
        return ans;
    }
    
    private int getArea(int[][] height, int i) {
        int m = height.length;
        int n = height[0].length;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int area = 0;
        for (int j = 0; j < n; j++) {
            while (st.peek() != -1 && height[i][j] <= height[i][st.peek()]) {
                area = Math.max(area, 
                                height[i][st.pop()] * (j - st.peek() - 1));
            }
            st.push(j);
        }
        while (st.peek() != -1) {
            area = Math.max(area, height[i][st.pop()] * (n - st.peek() - 1));
        }
        return area;
    }
}