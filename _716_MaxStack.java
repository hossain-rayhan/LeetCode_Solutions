class MaxStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
    }
    
    public void push(int x) {
        pushHelper(x);
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack();
        while(stack.peek() != max){
            temp.push(stack.pop());
            maxStack.pop();
        }
        stack.pop();
        maxStack.pop();
        while(!temp.isEmpty()){
            pushHelper(temp.pop());
        }
        return max;
    }
    
    public void pushHelper(int x){
        int max = maxStack.isEmpty()? Integer.MIN_VALUE : maxStack.peek();
        if(x > max){
            max = x;
        }
        stack.push(x);
        maxStack.push(max);
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
