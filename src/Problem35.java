import java.util.ArrayList;

public class Problem35
{
	public static void main(String[] args)
	{
		/*
		The number, 197, is called a circular prime because all rotations
		of the digits: 197, 971, and 719, are themselves prime.

		There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31,
		37, 71, 73, 79, and 97.

		How many circular primes are there below one million?

		Answer=55
		*/

		// Could potentially make this a bit faster by consider substrings..
		// But not to sure about that.
		// And ofc you can also do a more efficient method of rotating numbers
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for (int i = 3; i <= 1000000; i +=2 ) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}

		System.out.println("Prime generation complete");

		int circularPrimes = 0;

		for(int i = 0; i < primes.size(); i++) {
			int prime = primes.get(i);
			String str = ("" + prime);
			int length = str.length();
			int counter = 1;
			boolean isCircular = true;
			while(counter != length) {
				str = str.charAt(str.length() - 1) +
					str.substring(0, str.length() - 1);
				int newPrime = Integer.parseInt(str);
				if (!primes.contains(newPrime)) {
					isCircular = false;
					break;
				}
				counter++;
			}
			if (isCircular) {
				circularPrimes++;
			}
		}

		System.out.println(circularPrimes);
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