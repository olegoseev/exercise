package palindrome_permutation;

import java.util.HashSet;
import java.util.Set;
/**
 * 
 * Given a string, write a function to check if it is a permutation of a palindrome
 */
public class PalindromePermutation {

	public static void main(String[] args) {
		
		String s2 = "atco cta";
		
		
		System.out.println("String '" + s2 + "' is permutation? " + isPalindromPermutationHash(s2));
	}

	static boolean isPalindromPermutationHash(String str) {
		Set<Character> set = new HashSet<>();

		int len = str.length();
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (c == ' ') continue;

			if (set.contains(Character.valueOf(c))) {
				set.remove(Character.valueOf(c));
			} else {
				set.add(Character.valueOf(c));
			}
		}

		return set.size() == 0 || set.size() == 1;
	}
	
	static boolean isPalindromPermutationBit(String str) {
		int len = str.length();
		return false;
	}
}
