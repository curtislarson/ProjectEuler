import java.util.*;

public class Problem36
{
	public static void main(String[] args)
	{
		/*
		The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

		Find the sum of all numbers, less than one million, which are
		palindromic in base 10 and base 2.

		(Please note that the palindromic number, in either base, may not
		include leading zeros.)

		Answer=872187
		*/
		long sum = 0;
		for (int i = 1; i < 1000000; i++) {
			if (isPalindrome("" + i)) {
				String binary = Integer.toBinaryString(i);
				if (isPalindrome(binary)) {
					sum += i;
				}
			}
		}

		System.out.println(sum);
	}

	public static boolean isPalindrome(String str) {
		str.replaceFirst("^0+(?!$)", "");
		String reverse = new StringBuilder(str).reverse().toString();
		return str.equals(reverse.replaceFirst("^0+(?!$)", ""));
	}
}