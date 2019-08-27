/*
 * @Author: Hao Liu
 * @Date: 2019-08-26 22:44:34
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-08-26 22:44:45
 * @Description: Monotonic Stack
 */

 class Solution {
    
    class Pair {
        int val;
        int count;
        Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    private final int MOD = 1000000007;
    public int sumSubarrayMins(int[] A) {
        Stack<Pair> st = new Stack<>();
        int ans = 0;
        int delta = 0;
        for (int j = 0; j < A.length; j++) {
            int count = 1;
            while (!st.isEmpty() && st.peek().val >= A[j]) {
                Pair p = st.pop();
                delta -= p.val * p.count;
                count += p.count;
            }
            st.push(new Pair(A[j], count));
            delta += A[j] * count;
            ans += delta;
            ans %= MOD;
        }
        return ans;
    }
}
