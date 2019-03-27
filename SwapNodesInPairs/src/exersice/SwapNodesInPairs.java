package exersice;


public class SwapNodesInPairs {

	public class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode swapPairs(ListNode head) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy.next;
	    ListNode second = dummy.next.next;
	    
	    while (first != null || second != null) {
	    	ListNode l = second;
	    	second.next= first.next;
	    	first.next = l.next;
	    }
	    return dummy.next;
	}
	
	public static void main(String[] args) {

		SwapNodesInPairs snp = new SwapNodesInPairs();
		
		ListNode ln = snp.new ListNode(1);
		ln.next = snp.new ListNode(2);
		ln.next.next = snp.new ListNode(3);
		ln.next.next.next = snp.new ListNode(4);
		ln.next.next.next.next = snp.new ListNode(5);
		ln.next.next.next.next.next = snp.new ListNode(6);
		ln.next.next.next.next.next.next = snp.new ListNode(7);
		ln.next.next.next.next.next.next.next = snp.new ListNode(8);
		
		ListNode sln = snp.swapPairs(ln);

		while(sln != null) {
			System.out.println(sln.val);
			sln = sln.next;
		}
	}

}
