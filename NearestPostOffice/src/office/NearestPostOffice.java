package office;

/**
 * Q3 K Nearest Post Offices
 * 
 * Find the k post offices located closest to you, given your location and a
 * list of locations of all post offices available. Locations are given in 2D
 * coordinates in [X, Y], where X and Y are integers. Euclidean distance is
 * applied to find the distance between you and a post office. Assume your
 * location is [m, n] and the location of a post office is [p, q], the Euclidean
 * distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q)
 * * (n - q)). K is a positive integer much smaller than the given number of
 * post offices. from aonecode.com
 * 
 * e.g. Input you: [0, 0] post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2],
 * [0, 3], [-5, -9]] k = 3
 * 
 * Output from aonecode.com [[-1, 2], [0, 3], [4, 3]]
 * 
 * @author alex
 *
 */

class Office {
	int x;
	int y;
	int z;

	Office next;

	Office(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		next = null;
	}

	@Override
	public String toString() {
		return "Office [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

}

class OfficeList {

	Office head;

	public OfficeList() {
		this.head = new Office(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

	public void addOffice(int x, int y, int z) {
		Office office = new Office(x, y, z);
		if (head.z > office.z) {
			office.next = head;
			head = office;
		} else {
			Office before = head;
			while (before.next.z < z) {
				before = before.next;
			}
			office.next = before.next;
			before.next = office;
		}
	}
}

public class NearestPostOffice {

	public static void main(String[] args) {

		int[][] postOffice = { { -16, 5 }, { -1, 2 }, { 4, 3 }, { 10, -2 }, { 0, 3 }, { -5, -9 } };
		int[] iam = { 0, 0 };
		int num = 3;

		findNearestOffices(postOffice, iam, num);
	}

	private static void findNearestOffices(int[][] postOffice, int[] iam, int num) {

		OfficeList offices = new OfficeList();

		for (int i = 0; i < postOffice.length; i++) {
			int x = postOffice[i][0];
			int y = postOffice[i][1];
			int rank = (int) Math.sqrt((iam[0] - x) * (iam[0] - x) + (iam[1] - y) * (iam[1] - y));
			offices.addOffice(x, y, rank);
		}

		Office office1 = offices.head;
		Office office2 = office1.next;
		Office office3 = office2.next;
		System.out.println(office1);
		System.out.println(office2);
		System.out.println(office3);
	}

}
