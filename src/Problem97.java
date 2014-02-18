import java.math.BigInteger;

public class Problem97
{
	public static void main(String[] args)
	{
		/*
		The first known prime found to exceed one million digits was discovered
		in 1999, and is a Mersenne prime of the form 26972593−1; it contains
		exactly 2,098,960 digits. Subsequently other Mersenne primes, of the
		form 2p−1, have been found which contain more digits.

		However, in 2004 there was found a massive non-Mersenne prime which
		contains 2,357,207 digits: 28433×27830457+1.

		Find the last ten digits of this prime number.

		Answer=8739992577
		*/
		long num = 1;
		for (int i = 0; i < 7830457; i++) {
			num *= 2;
			num = checkAndTruncate(num);
		}

		// This is pretty messy, but the easy part.
		BigInteger bigInt = BigInteger.valueOf(num);
		bigInt = bigInt.multiply(BigInteger.valueOf(28433));
		String result = bigInt.add(BigInteger.valueOf(1)).toString();
		result = result.substring(result.length() - 10, result.length());
		System.out.println(result);
	}

	public static long checkAndTruncate(long n)
	{
		String str = "" + n;
		int length = str.length();
		if (length > 10) {
			return Long.parseLong(str.substring(length - 10, length));
		}
		else {
			return n;
		}
	}
}