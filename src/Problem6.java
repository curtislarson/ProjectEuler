public class Problem6
{
	public static void main(String[] args)
	{
		/*
		The sum of the squares of the first ten natural numbers is,

		12 + 22 + ... + 102 = 385
		The square of the sum of the first ten natural numbers is,

		(1 + 2 + ... + 10)2 = 552 = 3025
		Hence the difference between the sum of the squares of the first ten
		natural numbers and the square of the sum is 3025 − 385 = 2640.

		Find the difference between the sum of the squares of the first one
		hundred natural numbers and the square of the sum.

		Answer = 25164150
		*/

		// Pretty straight forward
		int n = 100;
		long sum = 0;
		long sumSquares = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
			sumSquares += (i * i);
		}

		sum *= sum;

		System.out.println(sum - sumSquares);
	}
}

