class TwoSum {
    //assuming add would be called a lot, and find for a small number of times
    HashMap<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        int count = map.getOrDefault(number, 0);
        map.put(number, count + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int diff = value - num;
            if(num == diff){
                if(map.get(num) > 1){
                    return true;
                }
            }else{
                if(map.containsKey(diff)){
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
