class Solution {
    
    public class BIT {
        public int[] arr;
        public BIT(int n) {
            arr = new int[n + 1];
        }
        
        public void update(int idx, int val) {
            while (idx < arr.length) {
                arr[idx] += val;
                idx += lowBit(idx);
            }
        }
        
        public int query(int idx) {
            int ans = 0;
            while (idx > 0) {
                ans += arr[idx];
                idx -= lowBit(idx);
            }
            return ans;
        }
        
        private int lowBit(int x) {
            return x & (-x);
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0)   return new ArrayList<>();
        int n = nums.length;
        BIT bit = new BIT(n);
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        Map<Integer, Integer> rank = new HashMap<>();
        int i = 1;
        for (int num : copy) {
            if (rank.containsKey(num)) continue;
            rank.put(num, i++);
        }
        List<Integer> res = new ArrayList<>();
        for (int j = n - 1; j >= 0; j--) {
            bit.update(rank.get(nums[j]), 1);
            res.add(bit.query(rank.get(nums[j]) - 1));
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = res.size() - 1; j >= 0; j--) {
            ans.add(res.get(j));
        }
        return ans;
    }
}