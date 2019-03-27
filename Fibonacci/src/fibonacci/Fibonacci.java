package fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author alex
 *
 * Calculate N-th Fibonacci number
 */
public class Fibonacci {
	
	
	public static int fibonacciR(int n) {
		return n <= 1 ? n : fibonacciR(n - 1) + fibonacciR(n - 2);
	}
	
	public static int fibonacciI(int n) {
		int fibnum = 1;

		if (n < 1) return 0;
		
		int f0 = 0;
		int f1 = 1;
		
		for (int i = 1; i < n; i++) {
			fibnum = f0 + f1;
			f0 = f1;
			f1 = fibnum;
		}
		
		return fibnum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input;
		
		while((input = in.readLine()) != null) {
			int num = Integer.parseInt(input.trim());
			int fibnum = fibonacciR(num);
			System.out.println(fibnum);
			fibnum = fibonacciI(num);
			System.out.println(fibnum);
		}
		
	}

}
