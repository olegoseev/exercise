package longestPalindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given a string s, find the longest palindromic substring
 * contained in s. Your function should return a string.
 * You may assume that the maximum length of s is 1000
 */
public class LongestPalindrome {

	private static int expandAroundCenter(String s, int left, int right) {
	    int l = left, r = right;
	    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
	        l--;
	        r++;
	    }
	    return r - l - 1;
	}
	
	public static String longestPalindrome (String s) {
		
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}
	
	
	private static int palindromeLength (String s, int start, int end) {
		int l = start, r = end;
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}
	
	public static String longestPalindromeString (String s) {
		// length of found Palindrome
		// symmetrical and asymmetrical Palindrome strings
		int l1 = 0, l2 = 0;
		int start = 0, end = 0;
		
		for (int i = 0; i < s.length(); i++) {
			l1 = palindromeLength (s, i, i); // asymmetrical
			l2 = palindromeLength (s, i, i + 1); // symmetrical
			int len = Math.max(l1, l2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		
		return s.substring(start, end + 1);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the string");
		
		String s = "";
		
		while ((s = in.readLine()) != null) {

			s = longestPalindrome(s);
			System.out.println(s.length() > 0 ? s : "no palindrome found");	
			
			s = longestPalindromeString(s);
			System.out.println(s.length() > 0 ? s : "no palindrome found");	
		}
		

	}
}
