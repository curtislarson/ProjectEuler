import java.math.BigInteger;

public class Problem17
{
	public static void main(String[] args)
	{
		/*
		If the numbers 1 to 5 are written out in words: one, two, three, four,
		five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

		If all the numbers from 1 to 1000 (one thousand) inclusive were
		written out in words, how many letters would be used?


		NOTE: Do not count spaces or hyphens. For example, 342
		(three hundred and forty-two) contains 23 letters and 115
		(one hundred and fifteen) contains 20 letters.
		The use of "and" when writing out numbers is in compliance with
		British usage.

		Answer=21124
		*/
		int hundred = 7;
		int thousand = 8;

		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i <= 10) {
				sum += getSingleDigitValue(i);
			}
			else if (i < 100) {
				sum += getDoubleDigitValue(i);
			}
			else if (i < 1000) {
				// Get first digit
				int first = Character.getNumericValue(("" + i).charAt(0));
				sum += getSingleDigitValue(first);
				sum += hundred;
				// Now the second digit;
				int rest = i - (first * 100);
				// And the and
				if (i % 100 != 0) {
					sum += 3;			
				}
				sum += getDoubleDigitValue(rest);
			}
			else {
				sum += 3 + thousand;
			}
		} 
		System.out.println(sum);
	}

	public static int getDoubleDigitValue(int n)
	{
		// double digits.
		// eleven twelve thirteen fourteen fifteen sixteen seventeen
		// eighteen nineteen twenty
		int[] doubleD = new int[] {0, 6, 6, 8, 8, 7, 7, 9, 8, 8, 6};

		// ten, twenty, thirty, forty, fifty, sixty, seventy, eighty, ninety
		int[] ends = new int[] {0, 3, 6, 6, 5, 5, 5, 7, 6, 6};

		int sum = 0;
		if (n > 10 && n <= 20) {
			int adjust = n - 10;
			sum += doubleD[adjust];
		}
		else if (n < 10) {
			sum += getSingleDigitValue(n);
		}
		else {
			// Find the first digit
			int first = Character.getNumericValue(("" + n).charAt(0));
			sum += ends[first];
			// Find the second digit
			sum += getSingleDigitValue(n % 10);
		}
		return sum;
	}

	public static int getSingleDigitValue(int n)
	{
		// one two three four five six seven eight nine ten
		int[] digits = new int[] {0, 3, 3, 5, 4, 4, 3, 5, 5, 4 , 3};
		return digits[n];
	}
}