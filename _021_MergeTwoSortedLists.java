/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, current = null;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                if(head == null){
                    head = l1;
                    current = head;
                }else{
                    current.next = l1;
                    current = current.next;
                }
                l1 = l1.next;
            }else{
                if(head == null){
                    head = l2;
                    current = head;
                }else{
                    current.next = l2;
                    current = current.next;
                }
                l2 = l2.next;
            }
        }
        while(l1 != null){
            if(head == null){
                head = l1;
                current = head;
            }else{
                current.next = l1;
                current = current.next;
            }
            l1 = l1.next;
        }
        while(l2 != null){
            if(head == null){
                head = l2;
                current = head;
            }else{
                current.next = l2;
                current = current.next;
            }
            l2 = l2.next;
        }
        return head;
    }
    
    
}
