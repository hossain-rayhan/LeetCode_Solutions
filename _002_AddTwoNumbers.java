/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, current = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            int val1 = 0, val2 = 0;
            if(l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }
            int val = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            ListNode newNode = new ListNode(val);
            if(head == null){
                    head = newNode;
                    current = newNode;
            }else{
                    current.next = newNode;
                    current = current.next;
            }
        }
        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }
        return head;
    }
}
