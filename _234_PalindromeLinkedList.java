/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode fast = head, newHead = null;
        //will reserse the first half while finding the middle
        //head will be placd in the middle
        
        while(fast != null){
            if(fast.next == null){
                head = head.next;
                break;
            }else{
                fast = fast.next.next;
            }
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;   
        }
        //now head is in the middle
        //first half is reversed, and the newHead is the head of reversed half
        while(head != null){
            if(head.val != newHead.val){
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
