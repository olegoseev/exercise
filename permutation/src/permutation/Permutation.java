package permutation;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {
		// Given two string. check if one is permutation of the other one
		String s1 = "abcdefg";
		String s2 = "bcafgde";
		String s3 = "abcdefg";
		String s4 = "bcafsde";
		System.out.println("Given two string. check if one is permutation of the other one");
		System.out.println("Using Hash");
		String result = isPermutationByHash(s1, s2) ? " " : " not ";
		System.out.println("Strings - " + s1 + " - and - " + s2 + " - are " + result + "permutation of each other" );
		result = isPermutationByHash(s3, s4) ? " " : " not ";
		System.out.println("Strings - " + s3 + " - and - " + s4 + " - are " + result + "permutation of each other" );
		
		System.out.println("Using Sorted arrays");
		result = isPermutationBySort(s1, s2) ? " " : " not ";
		System.out.println("Strings - " + s1 + " - and - " + s2 + " - are " + result + "permutation of each other" );
		result = isPermutationBySort(s3, s4) ? " " : " not ";
		System.out.println("Strings - " + s3 + " - and - " + s4 + " - are " + result + "permutation of each other" );
	}
	
	static boolean isPermutationBySort(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		
		if(l1 != l2) {
			return false;
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		for (int i = 0; i< l1; i++) {
			if (c1[i] != c2[i]) {
				return false;
			}
		}

		return true;
	}
	
	static boolean isPermutationByHash(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		
		if(l1 != l2) {
			return false;
		}

		Set<Character> testSet = new HashSet<>();
		for (int i = 0; i < l1; i++) {
			testSet.add(Character.valueOf(s1.charAt(i)));
		}

		for (int i = 0; i < l2; i++) {
			if(testSet.contains(Character.valueOf(s2.charAt(i))) ==  false) {
			 	return false;
			}
		}
		return true;
	}

}
