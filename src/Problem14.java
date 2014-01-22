import java.util.*;

public class Problem14
{
	public static void main(String[] args)
	{
		/*
		The following iterative sequence is defined for the set of positive
		integers:

		n → n/2 (n is even)
		n → 3n + 1 (n is odd)

		Using the rule above and starting with 13, we generate the following
		sequence:

		13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
		It can be seen that this sequence (starting at 13 and finishing at 1)
		contains 10 terms. Although it has not been proved yet
		(Collatz Problem), it is thought that all starting numbers finish at 1.

		Which starting number, under one million, produces the longest chain?

		NOTE: Once the chain starts the terms are allowed to go above one
		million

		Answer=837799
		*/
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int n = 1000000;
		long sum = 0;
		int longestSequence = 0;
		int startingNumber = 0;
		for (int i = 1; i <= n; i++) {
			int currSequence = 0;
			sum = i;
			while (sum != 1) {
				if (map.containsKey(sum)) {
					currSequence += map.get(sum);
					break;
				}
				else if (sum % 2 == 0) {
					sum = sum / 2;
				}
				else {
					sum = (3 * sum) + 1;
				}
				currSequence++;
			}
			map.put(i, currSequence);
			if (currSequence > longestSequence) {
				longestSequence = currSequence;
				startingNumber = i;
			}
		}

		System.out.println(startingNumber);
	}
}