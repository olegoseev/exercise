package islands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
* given a matrix with 0s and 1s. find number of islands -
* number of groups of 1s connected horizontally and vertically
* 
*  m = [[1,0,1,1,0],
*  		[1,1,0,1,1],
*  		[0,0,1,0,1],
*  		[1,0,1,1,0],
*		[1,1,0,1,1],
*		[0,0,1,0,1]]
* 
*/

public class NumberOfIslands {
	
	public static int[] stringToIntegerArray(String s) {
		
		s = s.trim();
		s = s.substring(1, s.length() - 1);
		
		if (s.length() == 0) return new int[0];
		
		String[] parts = s.split(",");
		
		int[] arr = new int[parts.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(parts[i].trim());
		}
		
		return arr;
	}

	public static void findPartsOfIsland(int[][] m, int i, int j, int row, int col) {
		
		Deque<int[]> q = new ArrayDeque<>();

		q.push(new int[] {i,j});
		
		while(!q.isEmpty()) {
			int[] e = q.pop();
			int ii = e[0];
			int jj = e[1];
			
			if (m[ii][jj] == 1) {
				m[ii][jj] = 2;
				addToQueueIf (q, ii+1, jj, row, col);
				addToQueueIf (q, ii-1, jj, row, col);
				addToQueueIf (q, ii, jj+1, row, col);
				addToQueueIf (q, ii, jj-1, row, col);
			}
		}
	}
	
	public static void addToQueueIf (Deque<int[]> q, int ii, int jj, int row, int col) {
		if (ii >= 0 && ii < row && jj >= 0 && jj < col) {
			q.push(new int[] {ii, jj});
		}
	}
	
	public static int numberOfIslands (int[][] m) {
		int islands = 0;
		
		int row = m.length;
		int col = m[0].length;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (m[i][j] == 1) {
					islands++;
				}
				findPartsOfIsland(m, i, j, row, col);
			}
		}
		
		return islands;
	}
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("Enter matrix dimention [r,c]");
		
		String s = in.readLine();
		
		int[] d = stringToIntegerArray(s);
		
		int[][] m = new int[d[0]][d[1]];
		
		System.out.println("Enter matrix rows");
		
		for (int i = 0; i < d[0]; i++) {
			s = in.readLine();
			int[] a = stringToIntegerArray(s);
			m[i] = a;
		}
		
		int islands = numberOfIslands(m);
		
		System.out.println("Number is islands: " + Integer.toString(islands));
	}

}
