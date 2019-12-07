/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private Deque<Character> dq = new LinkedList<>();
    public int read(char[] buf, int n) {
        int idx = 0;
        int ans = 0;
        while (n > 0 && !dq.isEmpty()) {
            buf[idx++] = dq.pollFirst();
            n--;
            ans++;
        }
        while (n > 0) {
            char[] cache = new char[4];
            int len = read4(cache);
            if (len == 0)   break;
            if (n >= len) {
                for (int i = 0; i < len; i++) {
                    buf[idx++] = cache[i];
                }
                n -= len;
                ans += len;
            }
            else {
                for (int i = 0; i < n; i++) {
                    buf[idx++] = cache[i];
                }
                ans += n;
                for (int i = n; i < len; i++) {
                    dq.offerLast(cache[i]);
                }
                n = 0;
            }
        }
        return ans;
    }
}