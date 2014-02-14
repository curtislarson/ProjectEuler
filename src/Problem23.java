import java.util.*;

public class Problem23
{
	public static void main(String[] args)
	{
		/*
		A perfect number is a number for which the sum of its proper divisors
		is exactly equal to the number. For example, the sum of the proper
		divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28
		is a perfect number.

		A number n is called deficient if the sum of its proper divisors is
		less than n and it is called abundant if this sum exceeds n.

		As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the
		smallest number that can be written as the sum of two abundant numbers
		is 24. By mathematical analysis, it can be shown that all integers
		greater than 28123 can be written as the sum of two abundant numbers.
		However, this upper limit cannot be reduced any further by analysis
		even though it is known that the greatest number that cannot be
		expressed as the sum of two abundant numbers is less than this limit.

		Find the sum of all the positive integers which cannot be written as
		the sum of two abundant numbers.

		Answer=4179871
		*/
		ArrayList<Integer> abundant = new ArrayList<Integer>();
		int limit = 28123;
		for (int i = 2; i <= limit; i++) {
			int divisorSum = divisorSum(i);
			if (divisorSum > i) {
				abundant.add(i);
			}
		}

		boolean[] canBeAbundant = new boolean[limit + 1];
		for (int i = 0; i < abundant.size(); i++) {
			for (int j = i; j < abundant.size(); j++) {
				int first = abundant.get(i);
				int second = abundant.get(j);
				if (first + second < limit) {
					canBeAbundant[first + second] = true;
				}
				else {
					break;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < limit; i++) {
			if (!canBeAbundant[i]) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	public static int divisorSum(int n)
	{
		int sum = 1;
		int inc = 2;
		while(inc <= n / 2) {
			if (n % inc == 0) {
				sum += inc;
			}
			inc++;
		}
		return sum;
	}
}