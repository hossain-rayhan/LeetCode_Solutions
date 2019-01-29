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
        int carry = 0;
        ListNode root = null, current = null;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            if(root == null){
                    root = newNode;
                    current = newNode;
            }else{
                    current.next = newNode;
                    current = current.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            if(root == null){
                    root = newNode;
                    current = newNode;
            }else{
                    current.next = newNode;
                    current = current.next;
            }
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            if(root == null){
                    root = newNode;
                    current = newNode;
            }else{
                    current.next = newNode;
                    current = current.next;
            }
            l2 = l2.next;
        }
        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            current.next = newNode;
        }
        return root;
    }
}
