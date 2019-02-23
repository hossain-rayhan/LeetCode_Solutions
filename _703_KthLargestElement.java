//Max Heap using Priority Queue

class KthLargest {
    final PriorityQueue<Integer> maxHeap;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        maxHeap = new PriorityQueue<>();
        for(int n : nums){
            maxHeap.add(n);
        }
    }
    
    public int add(int val) {
        maxHeap.add(val);
        removeExtra();
        
        return maxHeap.peek();
    }
    
    public void removeExtra(){
        while(maxHeap.size() > k){
            maxHeap.remove();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
