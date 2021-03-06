//https://www.youtube.com/watch?time_continue=1&v=S6IfqDXWa10

class LRUCache {
    class Node{
        int key;
        Node prev;
        Node next;
        
        public Node(int key){
            this.key = key;
            this.prev = null;
            this.next = null;
        }
    }
    
    int capacity, counter;
    HashMap<Integer, Integer> map = new HashMap<>();
    Node head, tail;
    
    public LRUCache(int capacity) {
        this.counter = 0;
        this.capacity = capacity;
        
        head = new Node(-100);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            int value = map.get(key);
            //update the doublylinkedlist
            updateLRU(key);
            return value;             
        }
    }
    
    public void put(int key, int value) {
        //if already in the map, just update the value
        if(map.containsKey(key)){
            map.put(key,value);
            updateLRU(key);
        }else{
            //if under capacity, just add it
            if(counter < capacity){
                map.put(key, value);
                counter++;
                addToLRU(key);
            }else{
                int removedKey = removeFromLRU();
                map.remove(removedKey);
                
                map.put(key, value);
                addToLRU(key);
            }       
        }
         
    }
    
    public void addToLRU(int key){
        //add a node to the first
        Node newNode = new Node(key);
        newNode.next = head.next;
        head.next.prev = newNode;
        newNode.prev = head;
        head.next = newNode;
    }
    public void updateLRU(int key){
    //search and move it to first
    //that means remove and then add again
        Node current = head.next;
        while(current.key != key){
            current = current.next;
        }
        
        //removing the current
        current.prev.next = current.next;
        current.next.prev = current.prev;
        //add it to the first
        addToLRU(key);
    }
    public int removeFromLRU(){
        //remove the last item
        Node toRemove = tail.prev;
        int lastKey = toRemove.key;
        toRemove.prev.next = tail;
        tail.prev = toRemove.prev;
        return lastKey;    
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
