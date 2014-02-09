public class Problem28
{
	public static void main(String[] args)
	{
		/*
		Starting with the number 1 and moving to the right in a clockwise
		direction a 5 by 5 spiral is formed as follows:

		21 22 23 24 25
		20  7  8  9 10
		19  6  1  2 11
		18  5  4  3 12
		17 16 15 14 13

		It can be verified that the sum of the numbers on the diagonals is 101.

		What is the sum of the numbers on the diagonals in a 1001 by 1001
		spiral formed in the same way?

		Answer=669171001
		*/

		// Could probably find a non-iterative formula also.
		long sum = 0;
		for (int i = 500; i > 0; i--) {
			long temp = (2 * i + 1);
			sum += (4 * (temp * temp)) - (12 * i);
		}
		System.out.println(sum + 1);
	}
}