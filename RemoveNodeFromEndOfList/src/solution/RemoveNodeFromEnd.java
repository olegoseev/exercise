package solution;

public class RemoveNodeFromEnd {
	
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode h = dummy;
		ListNode a = dummy;
		ListNode b = dummy;
		
		int i = n;
		
		while (h != null) {
			h = h.next;
			if (--i < 0) { 
				a = b;
				b = b.next;
			}
		}
		
		a.next = b.next;
		
		return dummy.next;
	}
	
	public ListNode removeNthFromEnd2 (ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    // Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RemoveNodeFromEnd rm = new RemoveNodeFromEnd();
		ListNode head = rm.new ListNode(1);
		head.next = rm.new ListNode(2);
		head.next.next = rm.new ListNode(3);
		head.next.next.next = rm.new ListNode(4);
		head.next.next.next.next = rm.new ListNode(5);
		head.next.next.next.next.next = rm.new ListNode(6);
		head.next.next.next.next.next.next = rm.new ListNode(7);
		
		ListNode ln = rm.removeNthFromEnd(head, 3);
		
		while (ln != null) {
			System.out.println(ln.val);
			ln = ln.next;
		}
	}

}
