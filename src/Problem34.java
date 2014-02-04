public class Problem34
{
	public static void main(String[] args)
	{
		/*
		145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

		Find the sum of all numbers which are equal to the sum of the
		factorial of their digits.

		Note: as 1! = 1 and 2! = 2 are not sums they are not included.

		Answer=40730
		*/
		int[] factorials = new int[10];
		for (int i = 0; i < 10; i++) {
			factorials[i] = fact(i);
		}
		long sum = 0;
		// Not sure where we should stop, just go to a million I guess..
		for (long i = 3; i <= 1000000; i++) {
			String intStr = "" + i;
			long charFactSum = 0;
			for (int j = 0; j < intStr.length(); j++) {
				charFactSum +=
					factorials[Character.getNumericValue(intStr.charAt(j))];
			}
			if (i == charFactSum) {
				sum += i;
			}
		}

		System.out.println(sum);
	}

	public static int fact(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}