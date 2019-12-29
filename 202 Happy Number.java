class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = process(slow);
            fast = process(process(fast));
        } while (slow != fast);
        return slow == 1;
    }
    
    private int process(int n) {
        int ans = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            ans += digit * digit;
        }
        return ans;
    }
}