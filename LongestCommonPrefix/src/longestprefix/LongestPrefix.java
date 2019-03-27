package longestprefix;

import java.io.*;

/**
 * 
 * @author alex
 *
 *         Write a function to find the longest common prefix string amongst an
 *         array of strings. Longest common prefix for a pair of strings S1 and
 *         S2 is the longest string S which is the prefix of both S1 and S2. As
 *         an example, longest common prefix of "abcdefgh" and "abcefgh" is
 *         "abc".
 */
public class LongestPrefix {

	public static String[] stringToStringArray(String s) {
		s = s.trim();
		s = s.substring(1, s.length() - 1);

		String[] parts = s.split(",");

		for (int i = 0; i < parts.length; i++) {
//			parts[i] = parts[i].substring(1, parts[i].length() - 1);
			parts[i] = parts[i].trim();
		}

		return parts;
	}

	public String commonPrefix(String[] sa) {

		String prefix = "";
		String test = sa[0];

		for (int i = 0; i < test.length(); i++) {
			for (int j = 0; j < sa.length; j++) {
				if (sa[j].length() < i || !test.substring(0, i).equals(sa[j].substring(0, i))) {
					return prefix;
				}
			}
			prefix = test.substring(0, i);
		}

		return prefix;
	}

	// horizontal scanning
	public String longestCommonPrefixH(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		}
		return prefix;
	}

	// vertical scanning
	public String longestCommonPrefixV(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String s;
		String[] sa;

		LongestPrefix lp = new LongestPrefix();
		
		

		while ((s = in.readLine()) != null) {

			sa = stringToStringArray(s);
			String result = lp.longestCommonPrefixH(sa);
			System.out.println(result);
		}
	}

}
