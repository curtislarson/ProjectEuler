import java.util.ArrayList;

public class Problem46
{
	public static void main(String[] args)
	{
		/*
		It was proposed by Christian Goldbach that every odd composite number
		can be written as the sum of a prime and twice a square.

		9 = 7 + 2×12
		15 = 7 + 2×22
		21 = 3 + 2×32
		25 = 7 + 2×32
		27 = 19 + 2×22
		33 = 31 + 2×12

		It turns out that the conjecture was false.

		What is the smallest odd composite that cannot be written as the sum
		of a prime and twice a square?

		Answer=5777
		*/
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		// Generate the primes in the first million digits
		for (int i = 3; i <= 1000000; i += 2) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		System.out.println("Prime generation complete");

		// Not generate some squares
		ArrayList<Long> squares = new ArrayList<Long>();
		for (long i = 1; i < 1000; i++) {
			squares.add(i * i);
		}

		System.out.println("Square generation complete");

		// Now to find the number.

		int counter = 3;
		while(true) {
			if (primes.contains(counter)) {
				counter++;
				continue;
			}
			else {
				if (counter % 2 == 0) {
					counter++;
					continue;
				}
				boolean found = false;
				for (int i = 0; i < primes.size(); i++) {
					int prime = primes.get(i);
					if (prime >= counter) {
						break;
					}
					else {
						int temp = (counter - prime);
						if (temp % 2 != 0) {
							continue;
						}
						temp = temp / 2;
						if (squares.contains(Long.valueOf(temp))) {
							found = true;
							break;
						}
					}
				}
				if (!found) {
					System.out.println(counter);
					return;
				}
				counter++;
			}
		}
	}

	public static boolean isPrime(int n) {
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