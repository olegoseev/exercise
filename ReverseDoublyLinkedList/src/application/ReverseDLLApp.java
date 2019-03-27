package application;

public class ReverseDLLApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list;
		list = new LinkedList();

		/* Let us create a sorted linked list to test the functions 
		Created linked list will be 10->8->4->2 */
		list.push(2); 
		list.push(4); 
		list.push(8); 
		list.push(10); 

		System.out.println("Original linked list "); 
		list.printList(list.head); 

		list.reverse(); 
		System.out.println(""); 
		System.out.println("The reversed Linked List is "); 
		list.printList(list.head); 
	}

}
