public class Problem39
{
	public static void main(String[] args)
	{
		/*
		If p is the perimeter of a right angle triangle with integral length
		sides, {a,b,c}, there are exactly three solutions for p = 120.

		{20,48,52}, {24,45,51}, {30,40,50}

		For which value of p ≤ 1000, is the number of solutions maximised?

		Answer=840
		*/
		int[] solutions = new int[1001];

		for (int a = 1; a <= 1000; a++) {
			for (int b = a; b <= 1000; b++) {
				int a2 = a * a;
				int b2 = b * b;
				double c = Math.sqrt(a2 + b2);
				if (isSquare(c)) {
					if (a + b + (int)c <= 1000) {
						solutions[a + b + (int)c]++;
					}
					else {
						break;
					}
				}
			}
		}
		int best = 0;
		int largest = 0;
		for (int i = 1; i <= 1000; i++) {
			if (solutions[i] > largest) {
				largest = solutions[i];
				best = i;
			}
		}
		System.out.println(best);
	}

	public static boolean isSquare(double n)
	{
		double x = n % 1;
		x = x - Math.floor(x);
		if (x > 0) {
			return false;
		}
		else {
			return true;
		}
	}
}