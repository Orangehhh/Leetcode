/*
 * @Author: Hao Liu
 * @Date: 2019-08-07 22:43:58
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-07 22:45:34
 * @Description: Union Find
 */

 class Solution {
    /**
     * @Description: Define a disjoint set class.
     */
    public class DS {
        private int[] p;
        
        public DS(int n) {
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
        }
        
        public int find(int a) {
            if (a == p[a]) {
                return a;
            }
            p[a] = find(p[a]);
            return p[a];
        }
        
        public void union(int a, int b) {
            p[find(a)] = p[find(b)];
        }
    }
    
    
    public int largestComponentSize(int[] A) {
        int maxNum = 0;
        for (int num : A) {
            maxNum = Math.max(maxNum, num);
        }
        DS ds = new DS(maxNum + 1);
        int ans = 0;
        for (int num : A) {
            for (int k = 2; k <= Math.sqrt(num); k++) {
                if (num % k == 0) {
                    ds.union(num, k);
                    ds.union(num, num / k);
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            int rNum = ds.find(num);
            if (!map.containsKey(rNum)) {
                map.put(rNum, 0);
            }
            map.put(rNum, map.get(rNum) + 1);
            ans = Math.max(ans, map.get(rNum));
        }
        return ans;
    }
}
