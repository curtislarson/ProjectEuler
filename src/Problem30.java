import java.lang.Math;

public class Problem30
{
	public static void main(String[] args)
	{
		/*
		Surprisingly there are only three numbers that can be written as
		the sum of fourth powers of their digits:

		1634 = 14 + 64 + 34 + 44
		8208 = 84 + 24 + 04 + 84
		9474 = 94 + 44 + 74 + 44
		As 1 = 14 is not a sum it is not included.

		The sum of these numbers is 1634 + 8208 + 9474 = 19316.

		Find the sum of all the numbers that can be written as the sum of
		fifth powers of their digits.

		Answer=443839
		*/
		// Generate the 9 powers
		int[] powers = new int[10];
		for (int i = 0; i < 10; i++) {
			powers[i] = (i * i * i * i * i);
		}
		long totalSum = 0;
		// There may be some upper limit on what we should iterate too.
		// But Im to lazy to figure it out :p
		for (int i = 2; i < 10000000; i++) {
			int sum = 0;
			String str = ("" + i);
			for (int j = 0; j < str.length(); j++) {
				int idx = Character.getNumericValue(str.charAt(j));
				sum += powers[idx];
				if (sum > i) {
					continue;
				}
			}
			if (sum == i) {
				totalSum += sum;
			}
		}
		System.out.println(totalSum);
	}
}