package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeNumber {

    private static int reverse (int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
	
	public static boolean isPalindrome (int num) {
		if (num < 0 || (num % 10 == 0 && num != 0)) return false;
		
		int n1 = num;
		int n2 = reverse (num);
		
		if (n2 == 0) return false;

		while (n1 > 0 && n2 > 0) {
			if (n1 % 10 != n2 % 10) return false;
			n1 /= 10;
			n2 /= 10;
		}
		
		return true;
	}
	
	public static boolean isPalindrome2 (int num) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(num > revertedNumber) {
            revertedNumber = revertedNumber * 10 + num % 10;
            num /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return num == revertedNumber || num == revertedNumber/10;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		
		while ((s = in.readLine()) != null) {
			int i = Integer.parseInt(s);
			
			System.out.println("number is " +(isPalindrome(i) ? "palindrome" : "not a palindrome"));
		}
	}

}
