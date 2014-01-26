import java.math.BigInteger;

public class Problem15
{

	public static void main(String[] args)
	{
		/*
		Starting in the top left corner of a 2×2 grid, and only being able to
		move to the right and down, there are exactly 6 routes to the bottom
		right corner.

		How many such routes are there through a 20×20 grid?

		Answer=137846528820
		*/

		// binomial coefficient (dim + dim / dim)
		int dimension = 20;
		BigInteger fact = factorial(dimension);
		BigInteger doubleFact = factorial(dimension + dimension);
		BigInteger result = doubleFact.divide(fact.multiply(fact));
		System.out.println(result);
	}

	public static BigInteger factorial(int n) {
		BigInteger result = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			BigInteger value = BigInteger.valueOf(i);
			result = result.multiply(value);
		}
		return result;
	}
}