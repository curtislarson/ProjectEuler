import java.util.ArrayList;

public class Problem60
{
	public static void main(String[] args)
	{
		/*
		The primes 3, 7, 109, and 673, are quite remarkable. By taking any
		two primes and concatenating them in any order the result will always
		be prime. For example, taking 7 and 109, both 7109 and 1097 are prime.
		The sum of these four primes, 792, represents the lowest sum for a set
		of four primes with this property.

		Find the lowest sum for a set of five primes for which any
		two primes concatenate to produce another prime.

		Answer=9183
		*/

		// Generate a bunch of primes
		int n = 1000000;
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 3; i <= n; i += 2) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		System.out.println("Prime generation complete");

		int sum = 0;
		int counter = 0;
		int size = primes.size();
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				
			}
		}
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