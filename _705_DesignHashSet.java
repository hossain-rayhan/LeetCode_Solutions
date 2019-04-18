class MyHashSet {

    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    Node[] set;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new Node[1000];
    }
    
    public void add(int key) {
        int index = hash(key);
        if(set[index] == null){
            //no element at this index
            set[index] = new Node(key);
        }else{
            Node prev = set[index], current = set[index];
            while(current != null){
                if(current.val == key){
                    return;
                }
                prev = current;
                current = current.next;
            }
            prev.next = new Node(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);
        if(set[index] == null){
            return;
        }
        Node dummyHead = new Node(-1);
        dummyHead.next = set[index];
    
        Node prev = dummyHead, current = dummyHead.next;
        while(current != null){
            if(current.val == key){
                prev.next = current.next;
            }
            
            prev = current;
            current = current.next;
        }
        set[index] = dummyHead.next;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        Node current = set[index];
        while(current != null){
            if(current.val == key){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public int hash(int key){
        return key % 1000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
