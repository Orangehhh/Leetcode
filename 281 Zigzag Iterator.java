public class ZigzagIterator {
    
    private int i;
    private int j;
    private List<List<Integer>> lists;
    private int max;
    

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        lists = new ArrayList<>();
        lists.add(v1);
        lists.add(v2);
        max = 0;
        if (v1 != null) max = Math.max(max, v1.size());
        if (v2 != null) max = Math.max(max, v2.size());
        i = 0;
        j = 0;
    }

    public int next() {
        if (hasNext()) {
            int val = lists.get(i).get(j);
            i++;
            if (i == lists.size()) {
                i = 0;
                j++;
            }
            return val;
        }
        return -1;
    }

    public boolean hasNext() {
        while (lists.get(i) == null || j >= lists.get(i).size()) {
            i++;
            if (i == lists.size()) {
                i = 0;
                j++;
            }
            if (j >= max) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */