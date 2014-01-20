import java.util.Scanner;
import java.io.File;

public class Problem99
{
	public static void main(String[] args)
	{
		/*
		Comparing two numbers written in index form like 211 and 37 is not
		difficult, as any calculator would confirm that 211 = 2048 < 37 = 2187.

		However, confirming that 632382518061 > 519432525806 would be much
		more difficult, as both numbers contain over three million digits.

		Using base_exp.txt (right click and 'Save Link/Target As...'), a
		22K text file containing one thousand lines with a base/exponent pair
		on each line, determine which line number has the greatest numerical
		value.

		NOTE: The first two lines in the file represent the numbers in the
		example given above.

		Answer=709
		*/
		double largest = 0;
		int counter = 1;
		int largestCounter = 0;
		try {
			Scanner s = new Scanner(new File("base_exp.txt"));
			while (s.hasNextLine()) {
				String line = s.nextLine();
				Integer base = Integer.parseInt(line.split(",")[0]);
				double exp = (double)Integer.parseInt(line.split(",")[1]);
				double val = Math.log(base) * exp;

				if (val > largest) {
					largest = val;
					largestCounter = counter;
				}
				counter++;
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(largestCounter);

	}
}