package median;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfSortedArrays {

	public static int[] stringToIntegerArray(String s) {

		s = s.trim();
		s = s.substring(1, s.length() - 1);
		
		if (s.length() == 0) {
			return new int[0];
		}
		
		String[] parts = s.split(",");
		
		int[] arr = new int[parts.length];
		
		for (int i = 0; i < parts.length; i++) {
			arr[i] = Integer.parseInt(parts[i].trim());
		}
		
		return arr;
	}
	
	
	public static String integerArrayToString(int[] arr) {
		
		String s = "";
		for (int i = 0; i < arr.length; i++) {
			s += Integer.toString(arr[i]) + ", ";
		}
		
		s = s.substring(0, s.length() - 2);
		
		return "[" + s + "]";
	}
	
	
	public static double findMedianOfTwoSortedArrays(int[] arr1, int[] arr2) {
		
		int arr[] = mergeTwoSortedArrays(arr1, arr2);
		double median = 0.0;
		
		if ((arr.length % 2) > 0) {
			median = arr[arr.length / 2];
		} else {
			median = (double)(arr[(arr.length / 2 - 1)] + arr[(arr.length / 2)]) / 2;
		}
		
		return median;
	}
	
	// !!! Assume two arrays are not empty, so no check for emptiness
	public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
		int[] arr = new int[arr1.length + arr2.length];
		int i = 0, j = 0, k = 0;
		
		while (i < arr1.length && j < arr2.length) {
			arr[k++] = arr1[i] >= arr2[j] ? arr2[j++] : arr1[i++];
		}
		
		if (i < arr1.length) {
			System.arraycopy(arr1, i, arr, k, arr1.length - i);
		}
		
		
		if (j < arr2.length) {
			System.arraycopy(arr2, j, arr, k, arr2.length - j);
		}
		
		return arr;
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		
		while ((s = in.readLine()) != null) {
			int[] arr1 = stringToIntegerArray(s);
			s = in.readLine();
			int[] arr2 = stringToIntegerArray(s);
			double median = findMedianOfTwoSortedArrays(arr1, arr2);
			System.out.println("median: " + median);
		}
	}
}
