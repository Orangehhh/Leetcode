class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (true) {
            ans.add(matrix[i][j]);
            matrix[i][j] = Integer.MAX_VALUE;
            if (ans.size() == m * n) break;
            int r = i + dirs[k][0];
            int c = j + dirs[k][1];
            if (r < 0 || c < 0 || r >= m || c >= n ||
                matrix[r][c] == Integer.MAX_VALUE) {
                k = (k + 1) % 4;
                r = i + dirs[k][0];
                c = j + dirs[k][1];
            }
            i = r;
            j = c;
        }
        return ans;
    }
}