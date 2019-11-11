class MovingAverage {

    /** Initialize your data structure here. */
    private int[] nums;
    private int sum;
    private int n;
    
    public MovingAverage(int size) {
        nums = new int[size];
        sum = 0;
        n = 0;
    }
    
    public double next(int val) {
        sum += val;
        int idx = n % nums.length;
        n++;
        sum -= nums[idx];
        nums[idx] = val;
        return sum * 1.0 / Math.min(n, nums.length);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */