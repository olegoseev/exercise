package containerWithMostWater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MostWater {
	
	public int containerWithMostWater (int[] arr) {
		int vol = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int temp = Math.min(arr[i], arr[j]) * (j - i);
				vol = Math.max(vol, temp);
			}
		}
		return vol;
	}
	
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
	
	public static int[] stringToIntegerArray (String s) {
		
		if (s.length() == 0) return new int[0];
		
		s = s.trim();
		s = s.substring(1, s.length() - 1);
		
		String[] parts = s.split(",");
		
		int[] arr = new int[parts.length];
		
		for (int i = 0; i < parts.length; i++) {
			arr[i] = Integer.parseInt(parts[i].trim());
		}
		
		return arr;
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String s;
		MostWater mw = new MostWater();
		
		while ((s = in.readLine()) != null) {
			int[] arr = stringToIntegerArray(s);
			int vol = mw.containerWithMostWater(arr);
			
			System.out.println("Water Volume: " + vol);
			
			vol = mw.maxArea(arr);
			
			System.out.println("Water Volume: " + vol);
		}
	}

}
