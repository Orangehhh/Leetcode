class Solution {
    private final int kMod = 1000000007;
    public int threeSumMulti(int[] A, int target) {
        if (A == null || A.length < 3) {
            return 0;
        }
        Map<Integer, Long> count = new TreeMap<>();
        for (int num : A) {
            count.put(num, count.getOrDefault(num, 0L) + 1L);
        }
        int n = count.size();
        int[] keys = new int[n];
        int idx = 0;
        for (int k : count.keySet()) {
            keys[idx++] = k;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int k = n - 1;
            while (j <= k) {
                int total = keys[i] + keys[j] + keys[k];
                if (total == target) {
                    if (keys[i] == keys[j] && keys[j] == keys[k]) {
                        ans += count.get(keys[i]) * 
                                (count.get(keys[i]) - 1) *
                                (count.get(keys[i]) - 2) / 6;
                    }
                    else if (keys[i] == keys[j]) {
                        ans += count.get(keys[i]) * 
                               (count.get(keys[i]) - 1) * 
                               count.get(keys[k]) / 2;
                    }
                    else if (keys[j] == keys[k]) {
                        ans += count.get(keys[j]) * 
                               (count.get(keys[j]) - 1) * 
                               count.get(keys[i]) / 2;
                    }
                    else {
                        ans += count.get(keys[i]) * 
                               count.get(keys[j]) * count.get(keys[k]);
                    }
                    ans %= kMod;
                    j++;
                    k--;
                }
                else if (total > target) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return (int) ans;
    }                    
}