package letterCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombinations {
	
	public static Map<Character, String[]> map = new HashMap<>();
	
	public static List<String[]> combinations(String[] letters, int size) {
		List<String[]> groups = new ArrayList<>();
		List<String> group = new ArrayList<>();
		int pos = 0;

		combine(letters, size, pos, group, groups);

		return groups;
	}

	public static void combine(String[] letters, int size, int pos, List<String> group, List<String[]> groups) {
		if (group.size() == size) {
			groups.add(group.toArray(new String[0]));
		} else if (pos < size) {
			List<String> temp = new ArrayList<>(group);
			temp.add(letters[pos]);
			combine(letters, size, pos + 1, temp, groups);
		}
	}
	
	
	public static void main(String[] args) {
		
		map.put('2', new String[] {"a","b","c"});
		map.put('3', new String[] {"d","e","f"});
		map.put('4', new String[] {"g","h","i"});
		map.put('5', new String[] {"j","k","l"});
		map.put('6', new String[] {"m","n","o"});
		map.put('7', new String[] {"p","q","r","s"});
		map.put('8', new String[] {"t","u","v"});
		map.put('9', new String[] {"w","x","y","z"});
		
		List<String[]> letters = combinations(new String[] {"a","b","c"}, 3);
		letters.forEach(str -> {
			System.out.println(Arrays.toString(str));
		});

	}

}
