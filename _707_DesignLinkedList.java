class MyLinkedList {

    class Node{
        int val;
        Node prev;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }
    private int size;
    private Node head, tail;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        head = new Node(-1000);
        tail = new Node(1000);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        int k = 0;
        Node current = head.next;
        while(current != null){
            if(k == index){
                return current.val;
            }
            k++;
            current = current.next;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        
        Node next = head.next;
        newNode.next = next;
        next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
        
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        
        Node prev = tail.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = tail;
        tail.prev = newNode;
        
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size){
            return;
        }
        if(index <= 0){
            addAtHead(val);
            return;
        }
        int k = 0;
        Node current = head.next;
        while(current != null){
            if(k == index){
                Node newNode = new Node(val);
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
                size++;
                return;
            }
            current = current.next;
            k++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        int k = 0;
        Node current = head.next;
        while(current != null){
            if(k == index){
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return;
            }
            current = current.next;
            k++;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
