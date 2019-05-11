package island;

import java.util.ArrayDeque;
import java.util.Queue;

class Point {
	public int x;
	public int y;
	public int steps;
	
	Point(int x, int y, int steps) {
		this.x = x;
		this.y = y;
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", steps=" + steps + "]";
	}
	
}


public class TreasureIsland {

	private static final int[] rowStep = {-1, 0, 0, 1};
	private static final int[] colStep = {0, -1, 1, 0};
	
	private static boolean canMove(char[][] map, boolean visited[][], int row, int col) {
		return (row >= 0) && (row < map.length) && (col >= 0) && (col < map[0].length) && (map[row][col] == 'O') && !visited[row][col];
	}
	
	public static void main(String[] args) {
		char[][] seaMap = {
					{'O','O','O','O'},
					{'D','O','D','O'},
					{'O','O','O','O'},
					{'O','D','D','O'}
				};
		
		
		int steps = shortestPath (seaMap, new Point(0, 0, 0), new Point(3, 0, 0));
		
		if (steps == -1) {
			System.out.println("Path not found");
		} else {
			System.out.println("Number of steps to the treasure: " + steps);
		}
		
	}
	
	public static int shortestPath(char[][] seaMap, Point start, Point end) {
		
		Queue<Point> q = new ArrayDeque<>();
		
		boolean[][] visited = new boolean [seaMap.length][seaMap[0].length];
		
		visited[start.x][start.y] = true;
		q.add(new Point(start.x, start.y, 0));
		
		while(!q.isEmpty()) {
			
			Point point = q.poll();
			System.out.println(point);
			if (point.x == end.x && point.y == end.y) {
				return point.steps;
			}
			
			for(int i = 0; i < 4; i++) {
				int row = point.x + rowStep[i];
				int col = point.y + colStep[i];
				if(canMove(seaMap, visited, row, col)) {
					visited[row][col] =  true;
					q.add(new Point(row, col, point.steps + 1));
					
				}
			}
		}
		
		return -1;
	}
}
