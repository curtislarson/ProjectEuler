import java.util.Scanner;
import java.io.File;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.lang.Comparable;

public class Problem79
{
	public static void main(String[] args)
	{
		/*
		A common security method used for online banking is to ask the user
		for three random characters from a passcode. For example, if the
		passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters;
		the expected reply would be: 317.

		The text file, keylog.txt, contains fifty successful login attempts.

		Given that the three characters are always asked for in order,
		analyse the file so as to determine the shortest possible secret
		passcode of unknown length.

		Answer=73162890
		*/
		Problem79 p = new Problem79();
		p.run();
	}

	public void run()
	{
		Position[] positions = new Position[10];
		for (int i = 0; i < 10; i++) {
			positions[i] = new Position();
			positions[i].num = i;
		}
		try {
			Scanner s = new Scanner(new File("keylog.txt"));
			while (s.hasNextLine()) {
				String line = s.nextLine();
				char[] digits = line.toCharArray();
				int first = Character.getNumericValue(digits[0]);
				int second = Character.getNumericValue(digits[1]);
				int third = Character.getNumericValue(digits[2]);

				positions[first].firstCount++;
				positions[second].secondCount++;
				positions[third].thirdCount++;
			}
		}
		catch(Exception ex) {}
		Arrays.sort(positions);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			if (positions[i].firstCount + positions[i].secondCount +
				positions[i].thirdCount != 0) {
				sb.append(positions[i].num);
			}
		}
		System.out.println(sb.toString());
	}

	public class Position implements Comparable<Position>
	{
		int firstCount = 0;
		int secondCount = 0;
		int thirdCount = 0;
		int num = 0;

		// Going to implement a compareTo that does a reverse sort
		// So we can just print the result backwards to get the right answer.
		@Override
		public int compareTo(Position other)
		{
			if (this.thirdCount > other.thirdCount) {
				if (this.firstCount + this.secondCount != 0 &&
					other.firstCount + other.secondCount == 0) {
					return -1;
				}
				else {
					return 1;
				}
			}
			else if (this.thirdCount == other.thirdCount) {
				if (this.secondCount > other.secondCount) {
					return 1;
				}
				else if (this.secondCount == other.secondCount) {
					if (this.firstCount > other.firstCount) {
						// Switched because its the first number
						return -1;
					}
					else if (this.firstCount == other.firstCount) {
						return 0;
					}
					else {
						return 1;
					}
				}
				else {
					return -1;
				}
			}
			else {
				if (this.firstCount + this.secondCount == 0 &&
					other.firstCount + other.secondCount != 0) {
					return 1;
				}
				else {
					return -1;
				}
			}
		}
	}
}