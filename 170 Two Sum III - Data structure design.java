class TwoSum {

    /** Initialize your data structure here. */
    
    private Map<Integer, Integer> map;
    
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int num : map.keySet()) {
            if (num == value - num && map.get(num) >= 2) {
                return true;
            }
            if (num != value - num && map.containsKey(value - num)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */