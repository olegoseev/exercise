package letterCombinations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombinations {
	
	public static Map<Character, String[]> map = new HashMap<>();
	
		
	public List<String> letterCombinations (String digits) {
		String letters = "";
		int len = digits.length();
		List<String> sa = new LinkedList<>();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < len; i++) {
			String[] s = map.get(digits.charAt(i));
			sb.append(s[0]);
		}
		
		sa.add(sb.toString());
		
		for (int i = 0; i < len; i++) {
			
		}

	}
	
	private List<String> combinatinos (String a, String[] b) {
		
		List<String> sa = new LinkedList<>();
		
		for (int i = 1; i < b.length; i++) {
			sa.add(a + b[i]);
		}
		return sa;
	}
	
	
	public static void main(String[] args) throws IOException {
		
		map.put('2', new String[] {"a","b","c"});
		map.put('3', new String[] {"d","e","f"});
		map.put('4', new String[] {"g","h","i"});
		map.put('5', new String[] {"j","k","l"});
		map.put('6', new String[] {"m","n","o"});
		map.put('7', new String[] {"p","q","r","s"});
		map.put('8', new String[] {"t","u","v"});
		map.put('9', new String[] {"w","x","y","z"});
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String digits;
		
		List<String> letters = null;
		
		PhoneLetterCombinations pl = new PhoneLetterCombinations();
		
		while ((digits = in.readLine()) != null) {
		
			letters = pl.letterCombinations(digits);
		}
	}

}
