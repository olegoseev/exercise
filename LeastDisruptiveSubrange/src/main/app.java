package main;

public class app {

	public static void main(String[] args) {
		int[] source = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] replacement = new int[] {3, 5, 3};

		int index = leastDisruptiveSubrange(source, replacement);
		
		System.out.println("Index found: " + index);
	}

	
	public static int leastDisruptiveSubrange(int[] source, int[] replacement ) {
		
		int distance = Integer.MAX_VALUE;
		int index = 0;
		int tempValue = 0;
		for (int i = 0; i <= source.length - replacement.length; i++) {
			tempValue = 0;
			for (int j = 0; j < replacement.length; j++) {
				tempValue += (int)Math.abs(source[i+j] - replacement[j]);
			}
			if (tempValue < distance) {
				distance = tempValue;
				index = i;
			}
		}
		return index;
	}
}
