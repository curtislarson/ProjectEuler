public class Problem4
{
	public static void main(String[] args)
	{
		/*
		A palindromic number reads the same both ways. The largest palindrome
		made from the product of two 2-digit numbers is 9009 = 91 × 99.

		Find the largest palindrome made from the product of two 3-digit
		numbers.

		Answer = 906609
		*/

		// Let's start from the largest two three digit numbers and just
		// find the first palindrome we can.

		// I guess we could do the brute force way.
		int n = 999;
		int first = n;
		int second = n;
		int largest = 0;
		for (int i = first; i > 0; i--) {
			if (i * 999 < largest) {
				continue;
			}
			for (int j = second; j > 0; j--) {
				int result = i*j;
				if (isPalindrome(result) && result > largest) {
					largest = result;
				}
			}
		}

		System.out.println(largest);

	}

	public static boolean isPalindrome(int input)
	{
		String inputString = Integer.toString(input);
		int i = inputString.length() - 1;
		int j = 0;
		while (i != j) {
			if (inputString.charAt(i) != inputString.charAt(j)) {
				return false;
			}
			i--;
			if (i == j) {
				break;
			}
			j++;
		}
		return true;
	}
}