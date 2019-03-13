/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/

// flattentail: flatten the node "head" and return the tail in its child (if exists)
// the tail means the last node after flattening "head"

// Five situations:
// 1. null - no need to flatten, just return it
// 2. no child, no next - no need to flatten, it is the last element, just return it
// 3. no child, next - no need to flatten, go next
// 4. child, no next - flatten the child and done
// 5. child, next - flatten the child, connect it with the next, go next


class Solution {
    public Node flatten(Node head) {
        flattenTail(head);
        
        return head;
    }
    
    public Node flattenTail(Node current){
        //CASE- 1
        if(current == null)
            return current;
        
        if(current.child == null){
            Node next = current.next;
            if(next == null){
                return current; //CASE- 2
            }else{
                return flattenTail(current.next); //CASE- 3
            }
        }else{
            Node child = current.child;
            Node next = current.next;
            
            current.next = child;
            Node childTail = flattenTail(child);
            
            current.child = null;
            child.prev = current;
            
            if(next != null){
                childTail.next = next;
                next.prev = childTail;
                return flattenTail(next); //CASE- 5
            }else{
                return childTail; // CASE- 4
            }
        }
    }
}
