import java.util.Scanner;
import java.io.File;

public class Problem11
{
	public static void main(String[] args)
	{
		/*
		What is the greatest product of four adjacent numbers in the same
		direction (up, down, left, right, or diagonally) in the 20×20 grid?

		Answer=70600674
		*/
		int[][] grid = new int[20][20];
		try {
			Scanner s = new Scanner(new File("grid.txt"));
			int i = 0;
			int j = 0;
			while (s.hasNextLine()) {
				String line = s.nextLine();
				Scanner sc = new Scanner(line);
				while (sc.hasNextInt()) {
					grid[j][i] = sc.nextInt();
					j++;
				}
				i++;
				j = 0;
			}
		}
		catch(Exception ex) {}

		int greatest = -1;
		for (int col = 0; col < 20; col++) {
			for (int row = 0; row < 20; row++) {
				if (col - 1 >= 0 && col + 2 < 20) {
					int leftRight = grid[row][col - 1] *
									grid[row][col] *
									grid[row][col + 1] *
									grid[row][col + 2];
					if (leftRight > greatest) {
						greatest = leftRight;
					}
				}
				if (row - 1 >= 0 && row + 2 < 20) {
					int upDown = grid[row - 1][col] *
								 grid[row][col] *
								 grid[row + 1][col] *
								 grid[row + 2][col];
					if (upDown > greatest) {
						greatest = upDown;
					}
				}
				if (row - 1 >= 0 && col - 2 >= 0 && row + 2 < 20 &&
					col + 1 < 20) {
					int diag = grid[row-1][col+1] *
							   grid[row][col] *
							   grid[row + 1][col - 1] *
							   grid[row + 2][col - 2];
					if (diag > greatest) {
						greatest = diag;
					}
				}
				if (row - 2 >= 0 && col - 1 >= 0 && row + 1 < 20 &&
					col + 2 < 20) {
					int diag = grid[row+1][col-1] *
							   grid[row][col] *
							   grid[row - 1][col + 1] *
							   grid[row - 2][col + 2];
					if (diag > greatest) {
						greatest = diag;
					}
				}
			}
		}

		System.out.println(greatest);

	}
}