package solution;


/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
	
	public static int longestSubstring(String input) {
		int sublen = 0;
		int start = 0;
		int end = 0;
		int length = input.length();
		String substring = "";
		
		
		while (start < length && end < length) {
			substring = input.substring(start, end);
			if (substring.indexOf(input.charAt(end)) > -1) {
				start++;
			} else {
				end++;
			}
			sublen = Math.max(sublen, end - start);
		}
		return sublen;
	}

	
	public static int longestSubstringHashSet(String input) {
		int sublen = 1;
		int start = 0;
		int end = 0;
		int length = input.length();
		
		Set<Character> set =  new HashSet<>();

		while (start < length && end < length) {
			if (!set.contains(input.charAt(end))) {
				set.add(input.charAt(end++));
				sublen = Math.max(sublen, end - start);
			} else {
				set.remove(input.charAt(start++));
			}
		}
		
		return sublen;
	}
	
	
	public static int longestSubstringHashMap(String input) {
		int sublen = 0;
		int length = input.length();
		int start = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		
		for (int end = 0; end < length; end++) {
			if (map.containsKey(input.charAt(end))) {
				start = Math.max(map.get(input.charAt(end)), start);
			}
			sublen = Math.max(sublen, end - start + 1);
			map.put(input.charAt(end), end + 1);
		}
		
		return sublen;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in =  new BufferedReader(new InputStreamReader(System.in));

		String input;
		
		while((input = in.readLine()) != null) {
			int length = longestSubstring(input);
			System.out.println(Integer.toString(length));
			length = longestSubstringHashSet(input);
			System.out.println(Integer.toString(length));
			length = longestSubstringHashMap(input);
			System.out.println(Integer.toString(length));

		}
	}

}
