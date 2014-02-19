import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.io.File;

public class Problem81
{
	public static void main(String[] args)
	{
		/*
		In the 5 by 5 matrix below, the minimal path sum from the top left to
		the bottom right, by only moving to the right and down, is indicated
		in bold red and is equal to 2427.


		131	673	234	103	18
		201	96	342	965	150
		630	803	746	422	111
		537	699	497	121	956
		805	732	524	37	331

		Find the minimal path sum, in matrix.txt (right click and
		'Save Link/Target As...'), a 31K text file containing a 80 by 80
		matrix, from the top left to the bottom right by only moving right and
		down.

		Answer=427337
		*/
		int dim = 80;
		int[][] matrix = new int[dim][dim];
		try {
			Scanner s = new Scanner(new File("matrix.txt"));
			int idx = 0;
			while (s.hasNextLine()) {
				String line = s.nextLine();
				Scanner sc = new Scanner(line).useDelimiter(",");
				int subIdx = 0;
				while (sc.hasNext()) {
					matrix[idx][subIdx] = Integer.parseInt(sc.next());
					subIdx++;
				}
				idx++;
			}
		}
		catch(Exception ex) {}

		for (int i = dim - 2; i >= 0; i--) {
			matrix[dim - 1][i] += matrix[dim - 1][i + 1];
			matrix[i][dim - 1] += matrix[i + 1][dim - 1];
		}

		for (int i = dim - 2; i >= 0; i--) {
			for (int j = dim - 2; j >= 0; j--) {
				matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i][j + 1]);
			}
		}
		System.out.println(matrix[0][0]);
	}
}