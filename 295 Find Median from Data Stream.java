class MedianFinder {

    /** initialize your data structure here. */
    private int size;
    private PriorityQueue<Integer> pq1;
    private PriorityQueue<Integer> pq2;
    
    public MedianFinder() {
        size = 0;
        pq1 = new PriorityQueue<>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.intValue() - a.intValue();
            }
        });
        pq2 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (size == 0) {
            pq1.offer(num);
            size++;
            return;
        }
        size++;
        if (num <= pq1.peek()) {
            pq1.offer(num);
            if (pq1.size() > (size + 1) / 2) {
                pq2.offer(pq1.poll());
            }
        }
        else {
            pq2.offer(num);
            if (pq2.size() > size / 2) {
                pq1.offer(pq2.poll());
            }
        }
    }
    
    public double findMedian() {
        if (size % 2 != 0) {
            return (double) pq1.peek();
        }
        else {
            return 0.5 * (pq1.peek() + pq2.peek());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */