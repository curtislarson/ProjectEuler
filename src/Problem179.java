public class Problem179
{
	public static void main(String[] args)
	{
		/*
		Find the number of integers 1 < n < 107, for which n and n + 1 have the
		same number of positive divisors. For example, 14 has the positive
		divisors 1, 2, 7, 14 while 15 has 1, 3, 5, 15.

		Answer=986262
		*/

		// This runs in 58.2s so I should probably make it faster..
		// For now it passes the rule of proj euler.
		long startTime = System.currentTimeMillis();
		int first = 0;
		int second = 1;
		int sameDivisorsCount = 0;
		for (int i = 1; i < 10000000; i++) {
			first = second;
			second = numDivisors(i + 1);
			if (first == second) {
				sameDivisorsCount++;
			}
		}
		System.out.println(sameDivisorsCount);
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0 + "s");
	}

	public static int numDivisors(long n)
	{
		int numDivisors = 1;
		long idx = 2;
		while(idx * idx <= n) {
			int power = 0;
			while (n % idx == 0) {
				power++;
				n /= idx;
			}
			numDivisors *= (power + 1);
			idx++;
		}
		if (n != 1) {
			numDivisors *= 2;
		}
		return numDivisors;
	}
}