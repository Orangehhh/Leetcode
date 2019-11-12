// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    private Integer cache;
    private Iterator<Integer> iter;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    cache = null;
        iter = iterator;
        if (iter.hasNext()) {
            cache = iter.next();
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (hasNext()) {
            Integer ans = cache;
            if (iter.hasNext()) {
                cache = iter.next();
            }
            else {
                cache = null;
            }
            return ans;
        }
        return null;
	}

	@Override
	public boolean hasNext() {
	    if (cache != null) {
            return true;
        }
        return false;
	}
}