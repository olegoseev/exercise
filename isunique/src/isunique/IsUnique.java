package isunique;

import java.util.HashSet;
import java.util.Set;


public class IsUnique {

	public static void main(String[] args) {
		String one = "abcdefg";
		String two = "abdcdgn";
		System.out.println("Checking if the string has duplicate characters");
		System.out.println("Using Hash");
		System.out.println("String - " + one + " has duplicates: " + isUniqueUsingHash(one));
		System.out.println("String - " + two + " has duplicates: " + isUniqueUsingHash(two));
		System.out.println("Using bits");
		System.out.println("String - " + one + " has duplicates: " + isUniqueUsingBits(one));
		System.out.println("String - " + two + " has duplicates: " + isUniqueUsingBits(two));

	}

	static boolean isUniqueUsingBits(String str) {
		int tset = 0;
		int strlen = str.length();
		for(int i = 0; i < strlen; i++) {
			int value = str.charAt(i) - 'a';
			if((tset & (1 << value)) > 0) {
				return true;
			}
			tset |= (1 << value);
		}
		return false;
	}
	
	static boolean isUniqueUsingHash(String str) {
		Set<Character> tSet = new HashSet<>();
		int strlen = str.length();
		for(int i =0; i < strlen; i++) {
			char c = str.charAt(i);
			if(tSet.contains(Character.valueOf(c))) {
				return true;
			}
			tSet.add(Character.valueOf(c));
		}
		return false;
	}
}
