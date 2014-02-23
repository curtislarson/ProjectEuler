import java.util.*;

public class Problem37
{
	/*
	The number 3797 has an interesting property. Being prime itself,
	it is possible to continuously remove digits from left to right, and
	remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work
	from right to left: 3797, 379, 37, and 3.

	Find the sum of the only eleven primes that are both truncatable from left
	to right and right to left.

	NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

	Answer=748317
	*/
	public static void main(String[] args)
	{
		// We could make this faster by storing the previous state of
		// lesser primes (whether they are truncatable left or truncatable
		// right so that we wouldent have to do the same check on a prime
		// multiple times). For now this is fast enough
		int numTruncatable = 0;
		int sum = 0;
		int idx = 11;
		while (numTruncatable != 11) {
			if (isPrime(idx)) {
				boolean truncateRight = truncateRight(idx);
				boolean truncateLeft = truncateLeft(idx);
				if (truncateRight && truncateLeft) {
					numTruncatable++;
					sum += idx;
				}
			}
			idx += 2;
		}

		System.out.println(sum);
	}

	public static boolean truncateLeft(int n)
	{
		String str = ("" + n);
		str = str.substring(1, str.length()).replaceFirst("^0+(?!$)", "");
		int newN = Integer.parseInt(str);
		if (isPrime(newN)) {
			if (str.length() > 1) {
				return truncateLeft(newN);
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}

	public static boolean truncateRight(int n)
	{
		String str = "" + n;
		str = str.substring(0, str.length() - 1).replaceFirst("^0+(?!$)", "");
		int newN = Integer.parseInt(str);
		if (isPrime(newN)) {
			if (str.length() > 1) {
				return truncateRight(newN);			
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}

	public static boolean isPrime(int n)
	{
		if (n == 1) {
			return false;
		}
		if (n == 2) {
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