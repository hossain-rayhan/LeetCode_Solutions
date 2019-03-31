class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    Node[] map;;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new Node[1000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hash(key);
        if(map[index] == null){
            map[index] = new Node(key, value);
        }else{
            Node n = map[index];
            boolean found = false;
            while(n.next != null){
                if(n.key == key){
                    n.value = value;
                    found = true;
                    break;
                }
                n = n.next;
            }
            if(found){
                return;
            }else{
                if(n.key == key){
                    n.value = value;
                }else{
                    n.next = new Node(key, value);
                }
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hash(key);
        if(map[index] == null){
            return -1;
        }else{
            Node n = map[index];
            while(n != null){
                if(n.key == key){
                    return n.value;
                }
                n = n.next;
            }
            return -1;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hash(key);
        if(map[index] == null){
            return;
        }else{
            Node n = map[index];
            Node prev = n;
            
            //if the only element
            if(n.key == key && n.next == null){
                map[index] = null;
            }else{
                //if not the last element
                while(n.next != null){
                    if(n.key == key){
                        n.key = n.next.key;
                        n.value = n.next.value;
                        n.next = n.next.next;
                        return;
                    }
                    prev = n;
                    n = n.next;
                }
                
                //if the last element
                if(n.key == key){
                    prev.next = null;
                }
            }
        }
    }
    
    public int hash(int key){
        return key % 1000;
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
