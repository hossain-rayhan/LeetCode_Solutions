class MovingAverage {
    /** Initialize your data structure here. */
    Queue<Integer> window;
    double sum;
    int size;
    
    public MovingAverage(int size) {
        window = new LinkedList();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        if(window.size() == size){
            // window/ queue full
            sum = sum - window.remove();
        }
        sum = sum + val;
        window.add(val);
        
        return sum / window.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
