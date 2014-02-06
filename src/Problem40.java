import java.lang.StringBuilder;

public class Problem40
{
	public static void main(String[] args)
	{
		/*
		An irrational decimal fraction is created by concatenating the
		positive integers:

		0.123456789101112131415161718192021...

		It can be seen that the 12th digit of the fractional part is 1.

		If dn represents the nth digit of the fractional part,
		find the value of the following expression.

		d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

		Answer=210
		*/

		// This can be done with offsets.. But this just looks so
		// much cleaner.
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		while(sb.length() < 1000000) {
			sb.append(counter);
			counter++;
		}

		int product = 1;
		int current = 1;
		while (current <= 1000000) {
			product *= Character.getNumericValue(sb.charAt(current - 1));
			current *= 10;
		}

		System.out.println(product);
	}
}