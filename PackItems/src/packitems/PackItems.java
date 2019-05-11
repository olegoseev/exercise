package packitems;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author alex
 * given number of items
 * calculate total time to pack them
 * example
 * items = [2, 8, 4, 10, 6]
 * total time
 *  2+ 4 = 6 items [6, 8, 10, 6]
 *  6 + 6 = 12 items [12, 8, 10]
 *  8 + 10 = 18 items [12, 18]
 *   total time 12 + 18 = 30
 *  
 */
public class PackItems {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(8);
		list.add(4);
		list.add(10);
		list.add(6);
		
		int totalTime = packingTime(list.size(), list);
		
		System.out.println("Packing time " + totalTime);
	}
	
	
	public static int packingTime(int numItems, List<Integer> arr) {	
		int num = arr.size();
		int totalTime = 0;
		return totalTime;
	}
	
}
