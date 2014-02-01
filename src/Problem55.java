import java.util.*;
import java.math.BigInteger;

public class Problem55
{
	static Map<BigInteger, Boolean> map = new HashMap<BigInteger, Boolean>();
	static int count = 0;

	public static void main(String[] args)
	{
		/*
		If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.

		Not all numbers produce palindromes so quickly. For example,

		349 + 943 = 1292,
		1292 + 2921 = 4213
		4213 + 3124 = 7337

		That is, 349 took three iterations to arrive at a palindrome.

		Although no one has proved it yet, it is thought that some numbers,
		like 196, never produce a palindrome. A number that never forms a
		palindrome through the reverse and add process is called a Lychrel
		number. Due to the theoretical nature of these numbers, and for the
		purpose of this problem, we shall assume that a number is Lychrel until
		proven otherwise. In addition you are given that for every number below
		ten-thousand, it will either (i) become a palindrome in less than fifty
		iterations, or, (ii) no one, with all the computing power that exists,
		has managed so far to map it to a palindrome. In fact, 10677 is the
		first number to be shown to require over fifty iterations before
		producing a palindrome: 4668731596684224866951378664 (53 iterations,
		28-digits).

		Surprisingly, there are palindromic numbers that are themselves
		Lychrel numbers; the first example is 4994.

		How many Lychrel numbers are there below ten-thousand?

		NOTE: Wording was modified slightly on 24 April 2007 to emphasise the
		theoretical nature of Lychrel numbers.

		Answer=249
		*/
		for (int i = 1; i < 10000; i++) {
			int iteration = 0;
			boolean result = lychrel(BigInteger.valueOf(i), iteration);
			if (result) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean lychrel(BigInteger n, int iteration)
	{
		boolean lych = false;
		Boolean mapValue = map.get(n);
		if (mapValue == null) {
			if (iteration >= 50) {
				map.put(n, true);
				return true;
			}
			BigInteger reverse = reverse(n);
			BigInteger newN = n.add(reverse);
			boolean isPalindrome = isPalindrome(newN);
			if (!isPalindrome) {
				lych = lychrel(newN, ++iteration);
			}
			if (!lych) {
				map.put(n, lych);
				map.put(reverse, lych);
			}
			return lych;
		}
		else {
			return mapValue;
		}
	}

	public static BigInteger reverse(BigInteger n)
	{
		String reverseString =
			new StringBuilder(n.toString()).reverse().toString();
		return new BigInteger(reverseString);
	}

	public static boolean isPalindrome(BigInteger n)
	{
		return n.equals(reverse(n));
	}
}