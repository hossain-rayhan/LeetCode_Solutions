class FreqStack {

    int max;
    HashMap<Integer, Integer> freqMap;
    HashMap<Integer, Stack<Integer>> freqVsStackMap;
    public FreqStack() {
        max = Integer.MIN_VALUE;
        freqMap = new HashMap<>();
        freqVsStackMap = new HashMap<>();
    }
    
    public void push(int x) {
        int freq = freqMap.getOrDefault(x, 0) + 1;
        freqMap.put(x, freq);
        
        if(freq > max){
            max = freq;
        }
        
        if(!freqVsStackMap.containsKey(freq)){
            freqVsStackMap.put(freq, new Stack<>());
        }
        freqVsStackMap.get(freq).push(x);
    }
    
    public int pop() {
        int val = freqVsStackMap.get(max).pop();
        if(freqVsStackMap.get(max).isEmpty()){
            max--;
        }
        freqMap.put(val, freqMap.getOrDefault(val, 0) - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
