import java.util.Arrays;

public class Problem31
{
	public static void main(String[] args)
	{
		/*
			In England the currency is made up of pound, £, and pence, p,
			and there are eight coins in general circulation:

			1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
			It is possible to make £2 in the following way:

			1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
			How many different ways can £2 be made using any number of coins?

			Answer=73682
		*/

		// Recursion makes this a bit easier to solve

		int total = 200;
		int[] coins = new int[] {200, 100, 50, 20, 10, 5, 2, 1};
		int diffWays = 0; // For the 200 coin
		for(int i = 0; i < coins.length; i++) {
			diffWays += getWays(total,
								coins[i],
								Arrays.copyOfRange(coins, i + 1, coins.length));
		}

		System.out.println(diffWays);
	}

	public static int getWays(int total, int currCoin, int[] coins) {
		if (coins.length == 0) {
			return 1;
		}
		int diffWays = 0;
		if (currCoin > total) {
			return 0;
		}
		total -= currCoin;
		if (total == 0) {
			return 1;
		}
		else if (total > 0) {
			diffWays += getWays(total, currCoin, coins);
		}
		for (int i = 0; i < coins.length; i++) {
			diffWays += getWays(total,
								coins[i],
								Arrays.copyOfRange(coins, i + 1, coins.length));
		}
		return diffWays;
	}
}