import java.util.ArrayList;

public class Problem47
{
	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args)
	{
		/*
		The first two consecutive numbers to have two distinct prime factors
		are:

		14 = 2 × 7
		15 = 3 × 5

		The first three consecutive numbers to have three distinct prime
		factors are:

		644 = 2² × 7 × 23
		645 = 3 × 5 × 43
		646 = 2 × 17 × 19.

		Find the first four consecutive integers to have four distinct prime
		factors. What is the first of these numbers?

		Answer=134043
		*/
		primes.add(2);
		for (int i = 3; i <= 1000000; i += 2) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}

		System.out.println("Prime generation complete");
		int idx = 1000;
		while (true) {
			if (numPrimeFactors(idx) == 4) {
				if (numPrimeFactors(idx + 1) == 4 &&
					numPrimeFactors(idx + 2) == 4 &&
					numPrimeFactors(idx + 3) == 4) {
					System.out.println(idx);
					return;
				}
			}
			idx++;
		}
	}

	public static int numPrimeFactors(int n)
	{
		int tmp = n;
		int count = 0;
		for (int i = 0; i < primes.size(); i++) {
			if (tmp == 1) {
				return count;
			}
			int prime = primes.get(i);
			if (prime > tmp) {
				return -1;
			}
			if (tmp % prime == 0) {
				count++;
				tmp /= prime;
			}
			while (tmp % prime == 0) {
				tmp /= prime;
			}
		}
		return count;
	}

	public static boolean isPrime(int n)
	{
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