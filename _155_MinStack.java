//https://www.youtube.com/watch?v=nGwn8_-6e7w

class MinStack {

    /** initialize your data structure here. */
    class MinValue{
        int value;
        int count;
        public MinValue(int value, int count){
            this.value = value;
            this.count = count;
        }
    }
    Stack<Integer> stack = new Stack<>();
    Stack<MinValue> stackMin = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int x) {
        stack.push(x);
        if(stackMin.isEmpty()){
            stackMin.push(new MinValue(x, 1));
        }else{
            MinValue mv = stackMin.peek();
            if(x < mv.value){
                stackMin.push(new MinValue(x, 1));
            }else if(x == mv.value){
                MinValue temp = stackMin.pop();
                temp.count = temp.count + 1;
                stackMin.push(temp);
            }
        }
    }
    
    public void pop() {
        int pop = stack.pop();
        if(pop == stackMin.peek().value){
            MinValue temp = stackMin.pop();
                temp.count = temp.count - 1;
                if(temp.count > 0){
                    stackMin.push(temp);
                }
                
        }
    }
    
    public int top() {
        return stack.peek();    
    }
    
    public int getMin() {
        return stackMin.peek().value;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
