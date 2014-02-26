public class Problem43
{
	static long sum = 0;
	public static void main(String[] args)
	{
		/*
		The number, 1406357289, is a 0 to 9 pandigital number because it is
		made up of each of the digits 0 to 9 in some order, but it also has a
		rather interesting sub-string divisibility property.

		Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way,
		we note the following:

		d2d3d4=406 is divisible by 2
		d3d4d5=063 is divisible by 3
		d4d5d6=635 is divisible by 5
		d5d6d7=357 is divisible by 7
		d6d7d8=572 is divisible by 11
		d7d8d9=728 is divisible by 13
		d8d9d10=289 is divisible by 17
		Find the sum of all 0 to 9 pandigital numbers with this property.

		Answer=16695334890
		*/

		// Just brute force it. We could also do this by hand by just making
		// divisibility rules.
		String digits = "0123456789";
		permutation("", digits);
		System.out.println(sum);
	}

	public static void permutation(String prefix, String str)
	{
		int n = str.length();
		if (n == 1) {
			String newStr = prefix + str;
			if (hasProperty(newStr)) {
				sum += Long.parseLong(newStr);
			}
		}
		else {
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i),
							str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}

	public static boolean hasProperty(String str)
	{
		int val1 = Integer.parseInt(str.substring(1, 4));
		int val2 = Integer.parseInt(str.substring(2, 5));
		int val3 = Integer.parseInt(str.substring(3, 6));
		int val4 = Integer.parseInt(str.substring(4, 7));
		int val5 = Integer.parseInt(str.substring(5, 8));
		int val6 = Integer.parseInt(str.substring(6, 9));
		int val7 = Integer.parseInt(str.substring(7, 10));

		return (val1 % 2 == 0 && val2 % 3 == 0 && val3 % 5 == 0 &&
				val4 % 7 == 0 && val5 % 11 == 0 && val6 % 13 == 0 &&
				val7 % 17 == 0);
	}
}