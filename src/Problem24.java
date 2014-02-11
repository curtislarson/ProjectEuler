public class Problem24
{
	static int count = 0;
	public static void main(String[] args)
	{
		/*
		A permutation is an ordered arrangement of objects. For example, 3124
		is one possible permutation of the digits 1, 2, 3 and 4. If all of the
		permutations are listed numerically or alphabetically, we call it
		lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

		012   021   102   120   201   210

		What is the millionth lexicographic permutation of the digits 0, 1, 2,
		3, 4, 5, 6, 7, 8 and 9?

		Answer=2783915460
		*/
		String digits = "0123456789";
		permutation("", digits);
	}

	public static void permutation(String prefix, String str)
	{
		int n = str.length();
		if (n == 1) {
			count++;
			if (count == 1000000) {
				System.out.println(prefix + str);
				System.exit(0);		
			}
		}
		else {
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i),
							str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}
}