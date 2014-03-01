import java.util.ArrayList;

public class Problem69
{
	public static void main(String[] args)
	{
		/*
		Euler's Totient function, φ(n) [sometimes called the phi function],
		is used to determine the number of numbers less than n which are
		relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all
		less than nine and relatively prime to nine, φ(9)=6.

		n	Relatively Prime	φ(n)	n/φ(n)
		2	1	1	2
		3	1,2	2	1.5
		4	1,3	2	2
		5	1,2,3,4	4	1.25
		6	1,5	2	3
		7	1,2,3,4,5,6	6	1.1666...
		8	1,3,5,7	4	2
		9	1,2,4,5,7,8	6	1.5
		10	1,3,7,9	4	2.5
		It can be seen that n=6 produces a maximum n/φ(n) for n ≤ 10.

		Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.

		Answer=510510
		*/
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		for (int i = 0; i < 50000; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		int n = 1000000;
		int i = 0;
		int result = 1;
		while (result * primes.get(i) < n) {
			result *= primes.get(i);
			i++;
		}
		System.out.println(result);
	}

	public static boolean isPrime(int n)
	{
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}