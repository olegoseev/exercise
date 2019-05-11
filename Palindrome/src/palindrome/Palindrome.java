package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

	public static boolean isPalindrome(String text) {
		
		int start = 0;
		int end = text.length() - 1;
		
		while (end >= start) {
			if (text.charAt(start) != text.charAt(end)) {
				return false;
			}
			start +=1;
			end -=1;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String text;
		System.out.println("Enter a string to test it");
		
		while((text = in.readLine()) != null) {
			System.out.println("Entered string is " + (isPalindrome(text) ? "a polindrom" : "not a polindrome"));
		}
	}
}
