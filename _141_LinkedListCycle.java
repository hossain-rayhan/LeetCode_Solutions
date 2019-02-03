/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //use two pointers, walker and runner
    //walker moves steps by steps, runner moves two steps at a time
    //If the LinkedList has a cycle, walker and runner will meet at some points

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        
        ListNode walker = head, runner = head;
        while(runner.next != null && runner.next.next != null){
            walker = walker.next;
            runner = runner.next.next;
            
            if(walker == runner){
                return true;
            }
        }
        return false;
    }
}
