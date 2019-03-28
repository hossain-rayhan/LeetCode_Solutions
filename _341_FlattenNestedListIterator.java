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

    Queue<NestedInteger> queue;
    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        flatten(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext()? queue.remove().getInteger(): -1;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
    
    public void flatten(List<NestedInteger> list){
        if(list == null || list.size() == 0){
            return;
        }
        for(NestedInteger item : list){
            if(item.isInteger()){
                queue.offer(item);
            }else{
                flatten(item.getList());
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
