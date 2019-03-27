package element;

// simple linkedlist class with limited functionality
// to test the algorithm
public class LinkedList {

	Node head;
	
	public class Node {
		
		public String value;
		public Node next;
		
		public Node (String value) {
			this.value = value;
			this.next = null;
		}
	}
	
	public LinkedList () {
		this.head = null;
	}
	
	public void addLast (String val) {

		if (head == null) {
			head = new Node (val);
		} else {
			Node tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = new Node (val);
		}
	}
}
