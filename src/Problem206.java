import java.math.BigInteger;

public class Problem206
{
	public static void main(String[] args)
	{
		/*
		Find the unique positive integer whose square has the form
		1_2_3_4_5_6_7_8_9_0, where each “_” is a single digit.

		Answer=1389019170
		*/

		// The addition numbers for this were found using a bit of trial
		// and error. This could probably be refined to go faster.
		// Runtime: 0.687s
		long startTime = System.currentTimeMillis();
		long end = 10000000000L;
		for (long start = 1000000000; start <= end; start++) {
			long square = start * start;
			BigInteger val = BigInteger.valueOf(square);
			String str = val.toString();
			if (str.charAt(2) != '2') {
				start += 1000000;
			}
			else if (str.charAt(4) != '3') {
				start += 100;
			}
			else if (str.charAt(6) != '4') {
				start += 10;
			}
			else if (str.charAt(8) != '5') {
			}
			else if (str.charAt(10) != '6') {
			}
			else if (str.charAt(12) != '7') {
			}
			else if (str.charAt(14) != '8') {

			}
			else if (str.charAt(16) != '9') {

			}
			else {
				System.out.println(start);
				break;
			}

		}
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0 + "s");
	}
}