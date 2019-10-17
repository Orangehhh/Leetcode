class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num: nums2) {
            if (set.contains(num)) {
                ans.add(num);
            }
        }
        int[] res = new int[ans.size()];
        int idx = 0;
        for (int num : ans) {
            res[idx++] = num;
        }
        return res;
    }
}