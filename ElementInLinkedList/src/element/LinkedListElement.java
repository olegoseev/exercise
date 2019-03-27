package element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import element.LinkedList.Node;

/**
 * 
 * @author alex
 *
 * Retrieve last N-th element from the linked list
 */
public class LinkedListElement {

	// using Queue
	public static String findLinkedListElement(LinkedList ll, int el) {
		Deque<String> q = new ArrayDeque<>();

		Node n = ll.head;
		int i = el;

		while (n != null) {
			q.push(n.value);
			n = n.next;
		}

		while (--i > 0) {
			q.pop();
		}

		String s = q.pop();

		q.clear();

		return s;
	}

	// following behind N nodes
	public static String findLinkedListElement2(LinkedList ll, int el) {
		Node n = ll.head;
		Node x = ll.head;

		int i = el;

		while (n != null) {
			n = n.next;
			if (--i < 0) {
				x = x.next;
			}
		}

		return x.value;
	}

	public static void main(String[] args) throws IOException {

		LinkedList ll = new LinkedList();

		String s = "Locality of reference can be improved by keeping the nodes together in memory"
				+ " and by periodically rearranging them although this can also be done in a general store";
		String[] parts = s.split(" ");

		for (String p : parts) {
			ll.addLast(p);
		}

		String l = "";

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Element from the end (number)");
		while ((l = in.readLine()) != null) {

			int el = Integer.parseInt(l);

			l = findLinkedListElement(ll, el);

			System.out.println("Element: " + l);

			l = findLinkedListElement2(ll, el);

			System.out.println("Element: " + l);
		}
	}

}
