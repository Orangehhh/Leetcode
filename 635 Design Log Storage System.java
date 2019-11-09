class LogSystem {
    
    private TreeMap<Long, Integer> map;
    private Map<String, Integer> helper;

    public LogSystem() {
        map = new TreeMap<>();
        helper = new HashMap<>();
        helper.put("Year", 0);
        helper.put("Month", 1);
        helper.put("Day", 2);
        helper.put("Hour", 3);
        helper.put("Minute", 4);
        helper.put("Second", 5);
    }
    
    private long convert(String timestamp, String gra, boolean end) {
        String[] tsArr = timestamp.split(":");
        int[] arr = new int[tsArr.length];
        for (int i = 0; i <= helper.get(gra); i++) {
            arr[i] = Integer.parseInt(tsArr[i]);
        }
        if (end) {
            arr[helper.get(gra)]++;
        }
        long ans = 0;
        ans = (arr[0] - 1999L) * 32 * 13 * 25 * 61 * 61 +
            arr[1] * 32 * 25 * 61 * 61 + arr[2] * 25 * 61 * 61 + 
            arr[3] * 61 * 61 + arr[4] * 61 + arr[5];
        return ans;
    }
    
    public void put(int id, String timestamp) {
        long ts = convert(timestamp, "Second", false);
        map.put(ts, id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> ans = new ArrayList<>();
        long start = convert(s, gra, false);
        long end = convert(e, gra, true);
        for (long key : map.tailMap(start).keySet()) {
            if (key >= start && key < end) {
                ans.add(map.get(key));
            }
        }
        return ans;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */