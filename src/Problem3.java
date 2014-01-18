public class Problem3 
{
	public static void main(String[] args) 
	{
		/*
			The prime factors of 13195 are 5, 7, 13 and 29.
			What is the largest prime factor of the number 600851475143 ?

			Answer = 6517
		*/
		// We have to brute force it, can use a table of known primes
		// to make it faster, but too lazy :(

		long prime = 600851475143L;
		long divisor = 2;
		long largest = 0;
		while (prime != 1) {
			if (prime % divisor == 0) {
				prime /= divisor;
				if (divisor > largest) {
					largest = divisor;
				}
				divisor = 2;
			}
			else {
				divisor++;
			}
		}
		System.out.println(largest);

	}
}