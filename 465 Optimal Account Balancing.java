class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> balance = new HashMap<>();
        for (int[] tran : transactions) {
            balance.put(tran[0], balance.getOrDefault(tran[0], 0) - tran[2]);
            balance.put(tran[1], balance.getOrDefault(tran[1], 0) + tran[2]);
        }
        List<Integer> list = new ArrayList<>(balance.values());
        return dfs(list, 0);
    }
    
    private int dfs(List<Integer> list, int pos) {
        int count = Integer.MAX_VALUE;
        while (pos < list.size() && list.get(pos) == 0) {
            pos++;
        }
        if (pos == list.size()) return 0;
        int fromBalance = list.get(pos);
        for (int i = pos + 1; i < list.size(); i++) {
            int toBalance = list.get(i);
            if (toBalance * fromBalance >= 0) continue;
            list.set(i, toBalance + fromBalance);
            count = Math.min(count, 1 + dfs(list, pos + 1));
            list.set(i, toBalance);
        }
        return count == Integer.MAX_VALUE ? 0 : count;
    }
}