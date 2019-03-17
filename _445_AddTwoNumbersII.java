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
        if(l1 == null || l2 == null){
            return l1 == null? l2 : l1;    
        }
        
        Stack<Integer> stack1 = new Stack();
        Stack<Integer> stack2 = new Stack();
        while(l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode head = null;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int digit1 = stack1.isEmpty()? 0 : stack1.pop();
            int digit2 = stack2.isEmpty()? 0 : stack2.pop();
            
            int sum = (digit1 + digit2 + carry);
            carry = sum / 10;
            sum %= 10;
            ListNode newNode = new ListNode(sum);
            newNode.next = head;
            head = newNode;   
        }
        if(carry == 1){
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }
        
        return head == null? new ListNode(0) : head;
    }
}
