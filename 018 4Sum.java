class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])    continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])    continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> tmp = Arrays.asList(new Integer[]{nums[i], nums[j], nums[k], nums[l]});
                        ans.add(tmp);
                        l--;
                        k++;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        } 
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                    else if (sum > target) {
                        l--;
                    }
                    else {
                        k++;
                    }  
                }
            }
        }
        return ans;
    }
}