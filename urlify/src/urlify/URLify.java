package urlify;


public class URLify {

	public static void main(String[] args) {
		
		String str = "John Doe master";
		
		String urlify = URLifyString(str);
		
		System.out.println(str + " converted to " + urlify);
		
		String urlifysb = URLifyStringwithSB(str);
		System.out.println(str + " converted to " + urlifysb);

	}
	
	static String URLifyString(String s1) {
		char[]replace = {'%','2','0'};
		int spaces = 0;
		int len1 = s1.length();

		for(int i = 0; i < len1; i++) {
			char c = s1.charAt(i);
			if (c == ' ') {
				spaces++;
			}
		}
		int len2 = len1 + spaces * 3;
		char[] c2 = new char[len2];

		for (int i = 0, j = 0; i < len1 && j < len2; i++, j++) {
			char c = s1.charAt(i);
			if (c == ' ') {
				for (int k = 0; k < 3; k++, j++) {
					c2[j] = replace[k];
				}
			} else {
				c2[j] = c;
			}
		}

		return new String(c2);
	}
	
	static String URLifyStringwithSB(String s1) {
		char[]replace = {'%','2','0'};
		int len1 = s1.length();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < len1; i++) {
			char c = s1.charAt(i);
			if (c == ' ') {
				for (int k = 0; k < 3; k++) {
					sb.append(replace[k]);
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
