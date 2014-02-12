import java.util.*;

public class Problem49
{
	public static void main(String[] args)
	{
		/*
		The arithmetic sequence, 1487, 4817, 8147, in which each of the
		terms increases by 3330, is unusual in two ways: (i) each of the
		three terms are prime, and, (ii) each of the 4-digit numbers are
		permutations of one another.

		There are no arithmetic sequences made up of three 1-, 2-, or 3-digit
		primes, exhibiting this property, but there is one other 4-digit
		increasing sequence.

		What 12-digit number do you form by concatenating the three terms in
		this sequence?

		Answer=296962999629
		*/

		// Note: This will also print out the example in the prompt.
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 1000; i <= 9999; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}

		for (int i = 0; i < primes.size(); i++) {
			for (int j = i + 1; j < primes.size(); j++) {
				int firstPrime = primes.get(i);
				int secondPrime = primes.get(j);
				int result = secondPrime + (secondPrime - firstPrime);
				if (result < 10000 && primes.contains(result)) {
					String first = sort("" + firstPrime);
					String second = sort("" + secondPrime);
					String third = sort("" + result);
					if (first.equals(second) && second.equals(third)) {
						System.out.println(firstPrime + "" + secondPrime +
							"" + result);
					}
				}
			}
		}
	}

	public static String sort(String str)
	{
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
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