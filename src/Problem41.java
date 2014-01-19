public class Problem41
{
	static int largest = -1;

	public static void main(String[] args)
	{
		/*
		We shall say that an n-digit number is pandigital if it makes use of
		all the digits 1 to n exactly once. For example, 2143 is a 4-digit
		pandigital and is also prime.

		What is the largest n-digit pandigital prime that exists?

		Answer = 7652413
		*/
		String numbers = "123456789";
		while(true) {
			permutation("", numbers);
			if (largest != -1) {
				System.out.println(largest);
				return;		
			}
			numbers = numbers.substring(0, numbers.length() - 1);
		}

	}

	public static void permutation(String prefix, String str)
	{
		int n = str.length();
		if (n == 0) {
			int number = Integer.parseInt(prefix);
			if (isPrime(number)) {
				if (number > largest) {
					largest = number;
				}
			}
		}
		else {
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i),
							str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}

	public static boolean isPrime(int n)
	{
		if (n == 1 || n == 2) {
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