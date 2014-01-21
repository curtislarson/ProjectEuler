import java.math.BigInteger;

public class Problem16
{
	public static void main(String[] args)
	{
		/*
		2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

		What is the sum of the digits of the number 2^1000?

		Answer=1366
		*/

		// Kind of feels like cheating...
		BigInteger val = BigInteger.valueOf(2);
		val = val.pow(1000);
		String str = val.toString();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Character.getNumericValue(str.charAt(i));
		}
		System.out.println(sum);
	}
}