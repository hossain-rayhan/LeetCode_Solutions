class MedianFinder {

    //two queues, max and min. max is always larger than min
    PriorityQueue<Integer> maxHeap, minHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        
        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.remove());
        }
    }
    
    public double findMedian() {
        return maxHeap.size() == minHeap.size()? ((maxHeap.peek() + minHeap.peek()) / 2.0) : maxHeap.peek()/1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
