/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

//https://www.youtube.com/watch?time_continue=460&v=OvpKeraoxW0
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        //return copyNSpace(head);
        
        return copyConstantSpace(head);
    }
    
    public RandomListNode copyConstantSpace(RandomListNode head){
        if(head == null)
            return head;
        RandomListNode current = head;
        while(current != null){
            RandomListNode clone = new RandomListNode(current.label);
            clone.next = current.next;
            current.next = clone;
            
            current = clone.next;
        }
        
        current = head;
        while(current != null){
            if(current.random != null){
                current.next.random = current.random.next;
            } 
            current = current.next.next;
        }
        
        current = head;
        RandomListNode cloneHead = current.next;
        RandomListNode cloneCurrent = cloneHead;
        RandomListNode next;
        while(current!= null){
            next = current.next.next;
            if(cloneCurrent.next != null)
                cloneCurrent.next = cloneCurrent.next.next;
            current.next = next;
            
            current = next;
            cloneCurrent = cloneCurrent.next;
        }
        
        return cloneHead;
        
        
    }
    
    public RandomListNode copyNSpace(RandomListNode head){
        if(head == null)
            return head;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode current = head;
        
        while(current != null){
            map.put(current, new RandomListNode(current.label));
            current = current.next;
        }
        current = head;
        while(current != null){
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            
            current = current.next;
        }
        return map.get(head);
    }
}
