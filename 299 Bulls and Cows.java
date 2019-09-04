/*
 * @Author: Hao Liu
 * @Date: 2019-09-03 23:49:23
 * @LastEditors: Hao Liu
 * @LastEditTime: 2019-09-03 23:49:43
 * @Description: Array
 */

 class Solution {
    public String getHint(String secret, String guess) {
        int[] nums = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            int secretDigit = secret.charAt(i) - '0';
            int guessDigit = guess.charAt(i) - '0';
            if (secretDigit == guessDigit) {
                bulls++;
            }
            else {
                if (nums[secretDigit] < 0)  cows++;
                if (nums[guessDigit] > 0)   cows++;
                nums[secretDigit]++;
                nums[guessDigit]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
