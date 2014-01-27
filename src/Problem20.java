import java.math.BigInteger;

public class Problem20
{
	public static void main(String[] args)
	{
		/*
		n! means n × (n − 1) × ... × 3 × 2 × 1

		For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
		and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 +
		0 = 27.

		Find the sum of the digits in the number 100!

		Answer = 648
		*/

		int n = 100;
		BigInteger value = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			BigInteger inc = BigInteger.valueOf(i);
			value = value.multiply(inc);
		}

		String str = value.toString();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Character.getNumericValue(str.charAt(i));
		}

		System.out.println(sum);
	}
}