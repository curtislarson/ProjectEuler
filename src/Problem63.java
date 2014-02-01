import java.math.BigInteger;

public class Problem63
{
	public static void main(String[] args)
	{
		/*
		The 5-digit number, 16807=75, is also a fifth power.
		Similarly, the 9-digit number, 134217728=89, is a ninth power.

		How many n-digit positive integers exist which are also an nth power?

		Answer=49
		*/
		int count = 0;
		for (int i = 1; i < 10; i++) {
			int power = 1;
			BigInteger inc = BigInteger.valueOf(i);
			BigInteger temp = inc.pow(power);
			while (temp.toString().length() >= power) {
				if (temp.toString().length() == power) {
					count++;
				}
				power++;
				temp = inc.pow(power);
			}
		}

		System.out.println(count);
	}
}