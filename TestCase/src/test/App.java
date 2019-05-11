package test;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		
		int[] arr = {1,1,0,0,1,0,0,1};

		int days = 2;
		
		List<Integer> list = compete(arr, days);
		list.forEach(System.out::print);
		int a =  10;
		int b = 20;
		a = Math.max(a, b);
		
	}
	
	static List<Integer> compete(int[]arr, int days) {
		
		int bytes = 0;
		
		for (int i = 7, j = 0; i >= 0; i--, j++) {
			bytes |= arr[i] << j;
		}
		
		
		int left = bytes;
		int right = bytes;
		int result = 0;
		for (int i = 0; i < days; i++) {
			left <<= 1;
			left &= 0xFF;
			right >>= 1;
			right &= 0xFF;
			result = left ^ right;
			left = result;
			right = result;
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 7; i >=0; i--) {
			list.add(((result >> i) & 1) == 1 ? 1 : 0);
		}
		
		return list;
	}

}
