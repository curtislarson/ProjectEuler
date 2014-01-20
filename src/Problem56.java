import java.util.ArrayList;
import java.math.BigInteger;

public class Problem56
{
	public static void main(String[] args)
	{
		/*
		Consider all integer combinations of ab for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:
		A googol (10100) is a massive number: one followed by one-hundred 
		zeros; 100100 is almost unimaginably large: one followed by 
		two-hundred zeros. Despite their size, the sum of the digits 
		in each number is only 1.

		Considering natural numbers of the form, ab, where a, b < 100, 
		what is the maximum digital sum?

		Answer=972
		*/
		ArrayList<String> distinct = new ArrayList<String>();

		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				BigInteger number = BigInteger.valueOf(i);
				number = number.pow(j);
				String str = number.toString();
				if (!distinct.contains(str)) {
					distinct.add(str);
				}
			}
		}

		long sum = 0;
		for (int i = 0; i < distinct.size(); i++) {
			String str = distinct.get(i);
			long currSum = 0;
			for (int j = 0; j < str.length(); j++) {
				currSum += Character.getNumericValue(str.charAt(j));
			}
			if (currSum > sum) {
				sum = currSum;
			}
		}

		System.out.println(sum);
	}
}