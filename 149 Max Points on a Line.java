class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length < 3) {
            return points.length;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            map.clear();
            int duplicates = 0;
            int tmp = 0;
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                int x = p2[0] - p1[0];
                int y = p2[1] - p1[1];
                if (x == 0 && y == 0) {
                    duplicates++;
                    continue;
                }
                int z = gcd(x, y);
                x = x / z;
                y = y / z;
                if (!map.containsKey(x)) {
                    map.put(x, new HashMap<>());
                }
                map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
                tmp = Math.max(tmp, map.get(x).get(y));
            }
            ans = Math.max(ans, 1 + tmp + duplicates);
        }
        return ans;
    }
    
    private int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }
}