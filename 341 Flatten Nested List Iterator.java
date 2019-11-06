/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    
    private Stack<Integer> st;

    public NestedIterator(List<NestedInteger> nestedList) {
        st = new Stack<>();
        init(nestedList, st);
    }
    
    private void init(List<NestedInteger> list, Stack<Integer> st) {
        for (int i = list.size() - 1; i >= 0; i--) {
            NestedInteger ni = list.get(i);
            if (ni.isInteger()) {
                st.push(ni.getInteger());
            }
            else {
                init(ni.getList(), st);
            }
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return st.pop();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */