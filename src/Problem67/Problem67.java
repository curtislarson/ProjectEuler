import java.util.*;
import java.io.File;

public class Problem67
{
	public static void main(String[] args)
	{
		/*
		By starting at the top of the triangle below and moving to adjacent
		numbers on the row below, the maximum total from top to bottom is 23.

		Find the maximum total from top to bottom in triangle.txt
		(right click and 'Save Link/Target As...'), a 15K text file containing
		a triangle with one-hundred rows.

		NOTE: This is a much more difficult version of Problem 18. 
		It is not possible to try every route to solve this problem, 
		as there are 299 altogether! If you could check one trillion (1012)
		routes every second it would take over twenty billion years to check
		them all. There is an efficient algorithm to solve it. ;o)

		Answer=7273
		*/

		// This is the exact same solution as Problem 18
		try {
			Scanner s = new Scanner(new File("triangle.txt"));
			String line = s.nextLine();
			ArrayList<Integer> result = triangle(s, line);
			System.out.println(result.get(0));
		}
		catch (Exception ex) {

		}
	}

	public static ArrayList<Integer> triangle(Scanner s, String line) {
		if (s.hasNextLine()) {
			ArrayList<Integer> ints = new ArrayList<Integer>();
			ArrayList<Integer> nextInts = null;
			Scanner sc = new Scanner(line);
			while (sc.hasNextInt()) {
				ints.add(sc.nextInt());
			}

			String nextLine = s.nextLine();
			if (s.hasNextLine()) {
				nextInts = triangle(s, nextLine);
			}
			else {
				// So line is the second to last, nextLine is the last.
				sc = new Scanner(nextLine);
				nextInts = new ArrayList<Integer>();
				while (sc.hasNextInt()) {
					nextInts.add(sc.nextInt());
				}
			}

			for(int i = 0; i < nextInts.size() - 1; i++) {
					int first = nextInts.get(i);
					int second = nextInts.get(i + 1);
					if (first > second) {
						ints.set(i, ints.get(i) + first);
					}
					else {
						ints.set(i, ints.get(i) + second);
					}
			}
			return ints;
		}
		else {
			// Well this should never happen...
			System.out.println("THIS SHOULD NEVER HAPPEN");
		}
		return null;
	}
}