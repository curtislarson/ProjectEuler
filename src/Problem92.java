import java.util.*;

public class Problem92
{
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int[] squares = new int[10];

	public static void main(String[] args)
	{
		/*
		A number chain is created by continuously adding the square of the
		digits in a number to form a new number until it has been seen before.

		For example,

		44 → 32 → 13 → 10 → 1 → 1
		85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89

		Therefore any chain that arrives at 1 or 89 will become stuck in an
		endless loop. What is most amazing is that EVERY starting number
		will eventually arrive at 1 or 89.

		How many starting numbers below ten million will arrive at 89?

		Answer=8581146
		*/
		for (int i = 0; i < squares.length; i++) {
			squares[i] = (i * i);
		}
		int count = 0;
		for (int i = 1; i < 10000000; i++) {
			Integer n = chain(i);
			if (n == 89) {
				count++;
			}
		}

		System.out.println(count);
	}

	public static int chain(int n)
	{
		Integer mappedInt = map.get(n);
		if (mappedInt != null) {
			return mappedInt;
		}
		String str = ("" + n);
		int temp = 0;
		for (int i = 0; i < str.length(); i++) {
			temp += squares[Character.getNumericValue(str.charAt(i))];
		}
		if (temp == 1 || temp == 89) {
			map.put(n, temp);
			return temp;
		}
		else {
			return chain(temp);
		}
	}
}