import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

import java.math.BigInteger;

public class Problem13
{
	public static void main(String[] args)
	{
		/*
		Work out the first ten digits of the sum of the following
		one-hundred 50-digit numbers.

		Answer =
		*/

		// We can also do this manually with strings, but why bother
		// when we have BigInteger :)
		BigInteger sum = BigInteger.valueOf(0);
		try {
			Scanner s = new Scanner(new File("numbers.txt"));
			while (s.hasNextLine()) {
				String line = s.nextLine();
				BigInteger bigInt = new BigInteger(line);
				sum = sum.add(bigInt);
			}			
		}
		catch (Exception ex) {}

		// Just convert it to a string and print the first 10 digits
		String sumString = sum.toString();
		System.out.println(sumString.substring(0, 10));

	}
}