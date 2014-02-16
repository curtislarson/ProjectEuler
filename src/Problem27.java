public class Problem27
{
	public static void main(String[] args)
	{
		/*
		Euler discovered the remarkable quadratic formula:

		n² + n + 41

		It turns out that the formula will produce 40 primes for the
		consecutive values n = 0 to 39. However, when n = 40, 402 + 40 + 41
		= 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² +
		41 + 41 is clearly divisible by 41.

		The incredible formula  n² − 79n + 1601 was discovered, which produces
		80 primes for the consecutive values n = 0 to 79. The product of the 
		coefficients, −79 and 1601, is −126479.

		Considering quadratics of the form:

		n² + an + b, where |a| < 1000 and |b| < 1000

		where |n| is the modulus/absolute value of n
		e.g. |11| = 11 and |−4| = 4
		Find the product of the coefficients, a and b, for the quadratic
		expression that produces the maximum number of primes for consecutive
		values of n, starting with n = 0.

		Answer=-59231
		*/

		// Brute force seems to run pretty well...
		boolean[] primes = new boolean[1000000];
		primes[2] = true;
		for (int i = 3; i < 1000000; i += 2) {
			primes[i] = isPrime(i);
		}
		System.out.println("Prime generation complete");

		int highest = 0;
		int bestA = 0;
		int bestB = 0;
		for (int a = -999; a < 1000; a++) {
			for (int b = -999; b < 1000; b++) {
				int currNum = 0;
				int n = 0;
				int val = calc(n, a, b);
				if (val < 0) {
					continue;
				}
				while(primes[val]) {
					currNum++;
					n++;
					val = calc(n, a, b);
					if (val < 0) {
						break;
					}
				}
				if (currNum > highest) {
					highest = currNum;
					bestA = a;
					bestB = b;
				}
			}
		}

		System.out.println(bestA * bestB);
	}

	public static boolean isPrime(int n) {
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

	public static int calc(int n, int a, int b) {
		return (n * n) + (a * n) + b;
	}
}