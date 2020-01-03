class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            ans += map.getOrDefault(sum - k, 0);
        }
        return ans;
    }
}