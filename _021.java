package main;

public class _021 {
	
	public static void main(String[] args) {
		ListNode node2 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node8 = new ListNode(8);
		
		node2.next = node6;
		node6.next = node8;
		
		node4.next = node5;
		
		ListNode x = mergeTwoLists(node4, node2);
		while(x!=null){
			System.out.println(x.val);
			x = x.next;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode m = null, start = null;
		if(l1 == null && l2 == null)
			return m;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				if(m == null){
					m = l1;
					l1 = l1.next;
					m.next = null;
					
					start = m;
				}else{
					m.next = l1;
					l1 = l1.next;
					m = m.next;
					m.next = null;
				}
			}else{
				if(m == null){
					m = l2;
					l2 = l2.next;
					m.next = null;
					
					start = m;
				}else{
					m.next = l2;
					l2 = l2.next;
					m = m.next;
					m.next = null;
				}
			}
			
		}
		
		while(l1 != null){
			if(m == null){
				m = l1;
				l1 = l1.next;
				m.next = null;
				
				start = m;
			}else{
				m.next = l1;
				l1 = l1.next;
				m = m.next;
				m.next = null;
			}
		}
		
		while(l2 != null){
			if(m == null){
				m = l2;
				l2 = l2.next;
				m.next = null;
				
				start = m;
			}else{
				m.next = l2;
				l2 = l2.next;
				m = m.next;
				m.next = null;
			}
		}
		
		return start;
    }

	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		    	  val = x; 
		      }
    }
}
