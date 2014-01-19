import java.util.Arrays;

public class Problem50
{
	public static void main(String[] args)
	{
		/*
		The prime 41, can be written as the sum of six consecutive primes:

		41 = 2 + 3 + 5 + 7 + 11 + 13
		This is the longest sum of consecutive primes that adds to a prime
		below one-hundred.

		The longest sum of consecutive primes below one-thousand that adds to
		a prime, contains 21 terms, and is equal to 953.

		Which prime, below one-million, can be written as the sum of the
		most consecutive primes?

		Answer = 997651
		*/
		int n = 1000001;
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, Boolean.TRUE);
		for(int i = 1; i < n; i++) {
			primes[i] = isPrime(i);
		}

		int bestCounter = 0;
		int bestSum = 0;
		for(int i = 2; i < n; i++) {
			if (primes[i]) {
				int counter = 0;
				int sum  = 0;
				for (int j = i; j < n; j++) {
					if (primes[j]) {
						int prevSum = sum;
						sum += j;
						if (sum > n - 1) {
							if (primes[prevSum]) {
								if (counter > bestCounter) {
									bestCounter = counter;
									bestSum = prevSum;
								}
							}
							break;
						}
						counter++;
						if (primes[sum]) {
							if (counter > bestCounter) {
								bestCounter = counter;
								bestSum = sum;
							}
						}
					}
				}
			}
		}
		System.out.println(bestCounter);
		System.out.println(bestSum);
	}

	public static boolean isPrime(int n)
	{
		if (n == 1 || n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}