class StringIterator {
    
    private String s;
    private int i;
    private char ch;
    private int count;

    public StringIterator(String compressedString) {
        s = compressedString;
        i = 0;
        ch = ' ';
        count = 0;
        if (s != null && s.length() > 0) {
            uncompressNext();
        }
    }
    
    public char next() {
        if (hasNext()) {
            count--;
            return ch;
        }
        return ' ';
    }
    
    public boolean hasNext() {
        if (ch == ' ')  return false;
        while (count == 0) {
            if (i >= s.length()) {
                return false;
            }
            uncompressNext();
        }
        return true;
    }
    
    private void uncompressNext() {
        ch = s.charAt(i++);
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            count = count * 10 + (s.charAt(i++) - '0');
        } 
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */