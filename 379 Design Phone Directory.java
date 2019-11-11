class PhoneDirectory {

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    PriorityQueue<Integer> pq;
    Set<Integer> set;
    
    public PhoneDirectory(int maxNumbers) {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        for (int i = 0; i < maxNumbers; i++) {
            pq.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (pq.isEmpty())   return -1;
        int number = pq.poll();
        set.add(number);
        return number;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (set.contains(number)) {
            set.remove(number);
            pq.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */