class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (k == 0 && map.get(num) == 1) {
                    ans++;
                }
                map.put(num, map.get(num) + 1);
            }
            else {
                if (map.containsKey(num - k)) ans++;
                if (map.containsKey(num + k)) ans++;
                map.put(num, 1);
            }
        }
        return ans;
    }
}