package party;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Party {

	public static void main(String[] args) {

		String[] guests = new String[] { "A", "B", "C", "D" }; //, "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P" };
		int tableSize = 3;

		List<String[]> iter = combinations(guests, tableSize);
		
		iter.forEach(str -> {
			System.out.println(Arrays.toString(str));
		});
		
		System.out.println("Total number of combinations: " + iter.size());
	}

	public static List<String[]> combinations(String[] guests, int size) {
		List<String[]> groups = new ArrayList<>();
		List<String> group = new ArrayList<>();
		int pos = 0;

		combine(guests, size, pos, group, groups);

		return groups;
	}

	public static void combine(String[] guests, int size, int pos, List<String> group, List<String[]> groups) {
		if (group.size() == size) {
			groups.add(group.toArray(new String[0]));
		} else if (pos < guests.length) {
			// leave
			combine(guests, size, pos + 1, group, groups);
			// take
			List<String> temp = new ArrayList<>(group);
			temp.add(guests[pos]);
			combine(guests, size, pos + 1, temp, groups);
		}
	}
}
