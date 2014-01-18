public class Problem5
{
	public static void main(String[] args)
	{
		/*
		2520 is the smallest number that can be divided by each of the numbers
		from 1 to 10 without any remainder.

		What is the smallest positive number that is evenly divisible by all
		of the numbers from 1 to 20?

		Answer = 232792560
		*/


		// Probably could do this faster...
		int n = 9699690;
		int start = n;
		while(true) {
			if (start % 11 == 0 && start % 12 == 0 && start % 13 == 0 &&
				start % 14 == 0 && start % 15 == 0 && start % 16 == 0 &&
				start % 17 == 0 && start % 18 == 0 && start % 19 == 0 &&
				start % 20 == 0) {
				System.out.println(start);
				return;
			}
			start += 210;
		}
	}
}

