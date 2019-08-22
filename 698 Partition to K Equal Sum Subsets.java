/*
 * @Author: Hao Liu
 * @Date: 2019-08-22 15:53:31
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-22 15:53:32
 * @Description: DFS
 */

 class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0)   return false;
        int[] visited = new int[nums.length];
        return dfs(nums, visited, 0, sum / k, k, 0);
    }
    
    private boolean dfs(int[] nums, int[] visited, int curSum, int target, int k, int s) {
        if (k == 0) {
            return true;
        }
        if (curSum > target) {
            return false;
        }
        if (curSum == target) {
            return dfs(nums, visited, 0, target, k - 1, 0);
        }
        for (int i = s; i < nums.length; i++) {
            if (visited[i] == 1)    continue;
            visited[i] = 1;
            if (dfs(nums, visited, curSum + nums[i], target, k, i + 1)) {
                return true;
            }
            visited[i] = 0;
        }
        return false;
    }
}
