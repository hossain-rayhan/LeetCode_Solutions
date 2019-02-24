class MyQueue {

    Stack<Integer> original, reverse;
    /** Initialize your data structure here. */
    public MyQueue() {
        original = new Stack<>();
        reverse = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        original.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(reverse.isEmpty()){
            while(!original.isEmpty()){
                reverse.push(original.pop());
            }
        }
        
        return reverse.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(reverse.isEmpty()){
            while(!original.isEmpty()){
                reverse.push(original.pop());
            }
        }
        return reverse.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(!reverse.isEmpty()){
            return false;
        }
        return original.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
