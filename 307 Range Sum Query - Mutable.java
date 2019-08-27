/*
 * @Author: Hao Liu
 * @Date: 2019-08-26 19:45:02
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-26 19:45:29
 * @Description: Binary Indexed Tree / Fenwick Tree
 */

class NumArray {

    private int[] sum;
    private int[] numbers;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        numbers = new int[nums.length];
        for (int i = 0; i < numbers.length; i++) {
            update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int prevVal = numbers[i];
        numbers[i] = val;
        i++;
        while (i < sum.length) {
            sum[i] += val - prevVal;
            i += lowBit(i);
        }
    }
    
    public int sumRange(int i, int j) {
        return sumRange(j) - sumRange(i - 1);
    }
    
    private int sumRange(int i) {
        int ans = 0;
        i++;
        while (i > 0) {
            ans += sum[i];
            i -= lowBit(i);
        }
        return ans;
    }
    
    private int lowBit(int num) {
        return num & -num;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */