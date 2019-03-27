package anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

	public static boolean isAnagram(String s, String t) {

		int tend = t.length() - 1;
		int send = s.length() - 1;

		int tstart = 0;
		int sstart = 0;

		int i = tend;

		while (sstart <= send && tend >= tstart) {

			if (s.charAt(sstart) == t.charAt(i--)) {

				if (tend == tstart)
					return true;

			}  else {
				i = tend;
			}
			sstart++;
		}

		return false;
	}

	public static boolean isAnagram2(String s, String t) {

		int tend = t.length() - 1;
		int send = s.length() - 1;

		int tstart = 0;
		int sstart = 0;

		while (sstart <= send && tstart <= tend) {

			if (s.charAt(sstart) == t.charAt(tend)) {

				if (tend == tstart)
					return true;

			} else {
				return false;
			}
			sstart++;
			tend--;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String s = in.readLine();

		String t = in.readLine();

		System.out.println("t is anagram? " + (isAnagram2(s, t) ? "yes" : "no"));
	}

}
