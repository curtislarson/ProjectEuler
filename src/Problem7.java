public class Problem7
{
	public static void main(String[] args)
	{
		/*
		By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
		see that the 6th prime is 13.

		What is the 10 001st prime number?

		Answer = 104743
		*/

		// Could always build a prime table to help out.
		int n = 10001;
		int counter = 1;
		int currPrime = 0;
		int start = 3;
		while (counter != n) {
			if (isPrime(start)) {
				counter++;
				currPrime = start;
			}
			start += 2;
		}

		System.out.println(currPrime);
	}

	public static boolean isPrime(int n)
	{
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}

