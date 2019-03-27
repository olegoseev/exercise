package exercise;

public class MergeTwoSortedList {
		
	public class ListNode {
		int val;
		ListNode next;
		
		ListNode(int val) {
			this.val = val;
		}
	}
	
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode dummy = new ListNode(0);
		ListNode f = dummy;
		
		ListNode one = new ListNode(0);
		ListNode two = new ListNode(0);
		one.next = l1;
		one = one.next;
		two.next = l2;
		two = two.next;
		
		while(one != null ||two != null) {
			
			if (one == null && two != null) {
				dummy.next = two;
				break;
			} else if (one != null && two == null) {
				dummy.next = one;
				break;
			} else if (one.val == two.val) {
				dummy.next = one;
				dummy = dummy.next;
				one = one.next;
				dummy.next = two;
				dummy = dummy.next;
				two = two.next;
			} else if (one.val > two.val) {
				dummy.next = two;
				dummy = dummy.next;
				two = two.next;
			} else {
				dummy.next = one;
				dummy = dummy.next;
				one = one.next;
			}
		}
		
		return f.next;
	}
	
	public static void main(String[] args) {

		MergeTwoSortedList mtl = new MergeTwoSortedList();
		
		ListNode l1 = mtl.new ListNode(1);
		ListNode l2 = mtl.new ListNode(1);
		
		l1.next = mtl.new ListNode(2);
		l1.next.next = mtl.new ListNode(4);
		l1.next.next.next = mtl.new ListNode(6);
		l1.next.next.next.next = mtl.new ListNode(7);
		l1.next.next.next.next.next = mtl.new ListNode(9);
		
		l2.next = mtl.new ListNode(3);
		l2.next.next = mtl.new ListNode(4);
		
		
		ListNode ln = mtl.mergeTwoLists(l1, l2);
		
		while (ln != null) {
			System.out.println(ln.val);
			ln = ln.next;
		}
	}

}
