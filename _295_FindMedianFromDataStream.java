class MedianFinder {

    //two queues, max and min. max is always larger than min
    PriorityQueue<Integer> min, max;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue();
        max = new PriorityQueue(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.remove());
        
        if(max.size() < min.size()){
            max.add(min.remove());
        }
    }
    
    public double findMedian() {
        return max.size() == min.size()? ((max.peek() + min.peek()) / 2.0) : max.peek()/1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
