public class ZigzagIterator {
    List<List<Integer>> list;
    Queue<Integer> queue;
    int index;    
    
    //2 vectors
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<List<Integer>>();
        queue = new LinkedList<Integer>();
        index = 0;
        
        this.list.add(v1);
        this.list.add(v2);
    }
    
    //k vectors
    public ZigzagIterator(List<List<Integer>> list){
        list = new ArrayList<List<Integer>>();
        queue = new LinkedList<Integer>();
        index = 0;
        
        this.list = list;
    }

    public int next() {
        if(!hasNext()){
            return -1;
        }
        if(!queue.isEmpty()){
            return queue.poll();
        }
        for(List<Integer> l : list){
            if(index < l.size()){
                queue.offer(l.get(index));
            }
        }
        index++;
        return next();
    }

    public boolean hasNext() {
        if(!queue.isEmpty()) return true;
        for(List<Integer> l : list){
            if(index < l.size()){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
