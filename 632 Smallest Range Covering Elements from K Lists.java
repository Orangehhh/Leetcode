class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<int[]> candidates = 
            new PriorityQueue<>(k, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            candidates.offer(new int[]{nums.get(i).get(0), i, 0});
            largest = Math.max(largest, nums.get(i).get(0));
        }
        int[] ans = new int[]{-100001, 100001};
        while (true) {
            int[] smallest = candidates.poll();
            if (largest - smallest[0] < ans[1] - ans[0]) {
                ans = new int[] {smallest[0], largest};
            }
            int listIdx = smallest[1];
            int nextIdx = smallest[2] + 1;
            if (nextIdx >= nums.get(listIdx).size()) {
                break;
            }
            candidates.offer(new int[]{nums.get(listIdx).get(nextIdx), listIdx, nextIdx});
            largest = Math.max(largest, nums.get(listIdx).get(nextIdx));
        }
        return ans;
    }
}