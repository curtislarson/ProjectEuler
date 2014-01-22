import java.math.BigInteger;

public class Problem48
{
	public static void main(String[] args)
	{
		/*
		The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

		Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... 
		+ 1000^1000.

		Answer = 9110846700
		*/

		BigInteger total = BigInteger.valueOf(0);

		for (int i = 1; i <= 1000; i++) {
			BigInteger temp = BigInteger.valueOf(i);
			temp = temp.pow(i);
			total = total.add(temp);
		}
		String str = total.toString();
		System.out.println(str.substring(str.length() - 10, str.length()));

		// We can also do it without modulo.
		long result = 0;
		long modulo = 10000000000L;
		for (int i = 1; i <= 1000; i++) {
			long temp = i;
			for (int j = 1; j < i; j++) {
				temp *= i;
				temp %= modulo;
			}
			result += temp;
			result %= modulo;
		}

		System.out.println(result);
	}
}