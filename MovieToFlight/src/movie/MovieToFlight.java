package movie;

public class MovieToFlight {

	public static void main(String[] args) {
		
		
		int[] movies = {90, 85, 75, 60, 120, 150, 125, 30, 200, 110, 240, 120, 145, 130};
		int flightLength = 250;
		int offset = 30;
		
		int[] moviesFound = findMovie(flightLength, offset, movies);
		
		System.out.println("Best movies for the flight: " + moviesFound[0] + " and " + moviesFound[1]);
	}
	
	/**
	 * since the array of the movie length is unsorted will traverse through the array. time complexity (worst O(n^2))
	 * @param duration
	 * @param offset
	 * @param movies
	 * @return
	 */
	public static int[] findMovie(int duration, int offset, int[] movies) {
		int timeLimit = duration - offset;
		
		int maxLenght = 0;
		int[] bestChoice = new int[2];

		for (int i = 0;  i < movies.length; i++) {
			for (int j = i + 1; j < movies.length; j++) {
				int totalTime = movies[i] + movies[j];
				if( totalTime <= timeLimit) {
					if( totalTime > maxLenght) {
						maxLenght = totalTime;
						bestChoice[0] = movies[i];
						bestChoice[1] = movies[j];
					}
				}
			}
		}
		return bestChoice;
	}

}
