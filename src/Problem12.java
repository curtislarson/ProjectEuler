import java.util.ArrayList;

public class Problem12
{
	public static void main(String[] args)
	{
		/*
			What is the value of the first triangle number to have
			over five hundred divisors?

			Answer=76576500
		*/
		// Build some primes
		int n = 750000;

		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for (int i = 3; i < n; i +=2 ) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		int counter = 1;
		int triangleNumber = 0;
		System.out.println("Primes calculated");
		while(true) {
			triangleNumber += counter;
			int numFactors = primeFactorization(triangleNumber, primes);
			if (numFactors > 500) {
				System.out.println(triangleNumber);
				return;
			}
			counter++;
		}
	}

	public static int primeFactorization(int n, ArrayList<Integer> primes)
	{
		int divisors = 1;
		int exp = 1;
		int remain = n;
		for (int i = 0; i < primes.size(); i++) {
			int prime = primes.get(i);
			if (prime * prime > n) {
				return divisors * 2;
			}
			exp = 1;
			while (remain % prime == 0) {
				exp++;
				remain /= prime;
			}
			divisors *= exp;
			if (remain == 1) {
				return divisors;
			}
		}
		return divisors;
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