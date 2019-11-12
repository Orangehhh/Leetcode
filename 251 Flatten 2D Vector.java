class Vector2D {
    
    private int m;
    private int i;
    private int j;
    private int[][] v;

    public Vector2D(int[][] v) {
        this.v = v;
        if (v == null) {
            m = 0;
        }
        else {
            m = v.length;   
        }
        i = 0;
        j = 0;
    }
    
    public int next() {
        if (hasNext()) {
            int val = v[i][j];
            j++;
            return val;
        }
        return -1;
    }
    
    public boolean hasNext() {
        if (i >= m) return false;
        int n = 0;
        if (v[i] != null) {
            n = v[i].length;
        }
        while (j >= n) {
            i++;
            if (i >= m) return false;
            if (v[i] != null) {
                n = v[i].length;
            }
            else {
                n = 0;
            }
            j = 0;
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */