package zigzagconversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZigZag {

	
	public static String zigZag (String s, int rows) {
		
		if (rows == 1) return s;
		
		StringBuilder res = new StringBuilder();
		int len = s.length();
		
		int z = 2 * rows - 2;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j + i < len; j += z) {
				System.out.printf("%4d", i+j);
				res.append(s.charAt(j + i));
				if (i != 0 && i != rows - 1 && j + z - i < len) {
					res.append(s.charAt(j + z -i));
					System.out.printf("%4d", (j + z -i));
				} else {
					System.out.print("    ");
				}
			}
			System.out.println();
		}
		return res.toString();
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s = "";
		
		while ((s = in.readLine()) != null) {
			int rows = Integer.parseInt(in.readLine());
			
			System.out.println(zigZag (s, rows));
		}
		
	}

}
