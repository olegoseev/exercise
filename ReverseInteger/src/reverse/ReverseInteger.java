package reverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseInteger {
	
	public static int reverse (int i) {
		
		boolean negative = i > 0 ? false : true;
		
		int in = Math.abs(i);
		
		Queue<Integer> q = new LinkedList<>();

		for (int j = 0; j < 10 && in > 0; j++) {
			
			int e = in % 10;
			q.add(e);	
			in /= 10;
		}

		int[] r = new int[q.size()];

		for (int j = 0; j < 32 && !q.isEmpty(); j++) {
			r[j] = q.remove();
		}
		
		int out = r[0];
		
		boolean inrange = true;
		
		for (int j = 1; j < r.length && inrange; j++ ) {
			
			if ((Integer.MAX_VALUE/10 - out) < 0) {
				inrange = false;
			} else {
				out *= 10;
				out += r[j];
			}
		}
		
		if (inrange == false) return 0;
		
		return negative ? - out : out;
	}

    public static int reverse2 (int x) {
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
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String s = "";
		
		while ((s = in.readLine()) != null) {
			
			int i = Integer.parseInt(s);
			int r = reverse (i);
			
			System.out.println(Integer.toString(r));
		}
	}

}
