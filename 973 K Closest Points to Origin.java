class Solution {
    int[][] points;
    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        partition(0, this.points.length - 1, K);
        return Arrays.copyOf(this.points, K);
    }
    
    private void partition(int i, int j, int K) {
        if (i > j)  return;
        int pivot = dist(this.points[i]);
        int start = i;
        int end = j;
        i++;
        while (i <= j) {
            while (i <= j && dist(this.points[i]) < pivot) {
                i++;
            }
            while (i <= j && dist(this.points[j]) >= pivot) {
                j--;
            }
            if (i > j) break;
            swap(i, j);
        }
        swap(start, j);
        int leftLen = j - start + 1;
        if (leftLen > K) {
            partition(start, j - 1, K);
        }
        else if (leftLen < K) {
            partition(j + 1, end, K - leftLen);
        }
    }
    
    private void swap(int i, int j) {
        int tmp0 = this.points[i][0];
        int tmp1 = this.points[i][1];
        this.points[i][0] = this.points[j][0];
        this.points[i][1] = this.points[j][1];
        this.points[j][0] = tmp0;
        this.points[j][1] = tmp1;
    }
    
    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}