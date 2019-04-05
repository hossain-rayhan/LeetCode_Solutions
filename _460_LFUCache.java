class LFUCache {
    HashMap<Integer, Integer> cache, freqMap;
    HashMap<Integer, LinkedHashSet<Integer>> list; //frequecy vs keys
    int min, capacity, size;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        min = -1;
        
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        list = new HashMap<>();
        list.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        int value = cache.get(key);
        update(key);
        
        return value;
    }
    
    public void put(int key, int value) {
        if(capacity <= 0){
            return;
        }
        
        if(cache.containsKey(key)){
            cache.put(key, value);
            //update the cache
            update(key);
            return;
        }
        
        //cache is full: remove and make a free space
        if(size >= capacity){
            int removeKey = list.get(min).iterator().next(); //get the least recently used
            list.get(min).remove(removeKey);
            cache.remove(removeKey);
            size--;
        }
        
        //Now add the new element
        cache.put(key, value);
        freqMap.put(key, 1);
        size++;   
        min = 1;
        list.get(1).add(key);
    }
    
    public void update(int key){
        int freq = freqMap.get(key);
        freqMap.put(key, freq+1);
        list.get(freq).remove(key); //remove as the earlier freq does not exist
        if(freq == min && list.get(freq).size() == 0){
            min++; //no more item with earlier min
        }
        if(!list.containsKey(freq+1)){
            list.put(freq+1, new LinkedHashSet<>());
        }
        list.get(freq+1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
