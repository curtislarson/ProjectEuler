import java.util.*;

public class Problem21
{
	public static void main(String[] args)
	{
		/*
		Let d(n) be defined as the sum of proper divisors of n (numbers less
		than n which divide evenly into n).
		If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable
		pair and each of a and b are called amicable numbers.

		For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20,
		22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284
		are 1, 2, 4, 71 and 142; so d(284) = 220.

		Evaluate the sum of all the amicable numbers under 10000.

		Answer=31626
		*/
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		for (int i = 1; i < 10000; i++) {
			map.put(i, getDivisorSum(i));
		}
		int totalSum = 0;
		for (int i = 1; i < 10000; i++) {
			int divisorSum = map.get(i);
			if (divisorSum == i) {
				continue;
			}
			Integer result = map.get(divisorSum);
			if (result != null) {
				if (result == i) {
					totalSum += i;
				}
			}
		}
		System.out.println(totalSum);
	}

	public static int getDivisorSum(int n)
	{
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
}