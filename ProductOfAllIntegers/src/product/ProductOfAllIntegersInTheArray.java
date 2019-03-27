package product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProductOfAllIntegersInTheArray {
	
	public static int[] stringToIntegerArray(String input) {
		
		// remove extra white spaces
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		
		if (input.length() == 0) {
			return new int[0];
		}
		
		String[] parts = input.split(",");
		int[] output = new int[parts.length];

		for(int i = 0; i < parts.length; i++) {
			output[i] = Integer.parseInt(parts[i].trim());
		}
		
		return output;
	}
	
	public static String integerArrayToString(int[] arr) {
		if (arr.length == 0) {
			return "[]";
		}
		
		String output = "";
		
		for (int i = 0; i < arr.length; i++) {
			output += Integer.toString(arr[i]) + ", ";
		}
		
		output = output.substring(0, output.length() - 2);
		
		return "[" + output + "]";
	}
	
	public static int productAboveIndex(int[] arr, int index) {
		int product = 1;
		for (int i = index+1; i <= arr.length-1; i++) {
			product *= arr[i];
		}
		return product;
	}
	
	public static int productBelowIndex(int[] arr, int index) {
		int product = 1;
		for (int i = 0; i <= index-1; i++) {
			product *= arr[i];
		}
		return product;
	}
	
	public static int[] productOfArray(int[] arr) {
		if (arr.length == 0) {
			return arr;
		}
		
		int[] product = new int[arr.length];
		
		for (int i = 0; i <= arr.length - 1; i++) {
			product[i] = productAboveIndex(arr, i) * productBelowIndex(arr, i);
		}
		
		return product;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		System.out.println("Plese enter array as follow: [1, 2, 3, 4, 5]");
		while((input = in.readLine()) != null) {
			
			int[] arr = stringToIntegerArray(input);
			int[] productArray = productOfArray(arr);
			
			String output = integerArrayToString(productArray);
			
			System.out.println(output);
		}
	}

}
