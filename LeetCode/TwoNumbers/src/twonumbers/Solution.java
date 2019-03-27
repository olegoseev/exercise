package twonumbers;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    	ListNode l1ptr = l1;
    	ListNode l2ptr = l2;
    	ListNode dummyRoot = new ListNode(0);
    	ListNode lptr = dummyRoot;
    	
    	int carry = 0;
    	
    	while (l1ptr != null || l2ptr != null) {

    		int x = (l1ptr != null) ? l1ptr.val : 0;
    		int y = (l2ptr != null) ? l2ptr.val : 0;
    		
    		int sum = carry + x + y;
    		carry = sum / 10;
    		
    		lptr.next = new ListNode(sum % 10);
    		
    		lptr = lptr.next;
    		if(l1ptr != null) l1ptr = l1ptr.next;
    		if(l2ptr != null) l2ptr = l2ptr.next;
    	}
    	
        return dummyRoot.next;
    }
}
