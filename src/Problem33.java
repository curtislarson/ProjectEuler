public class Problem33
{
	public static void main(String[] args)
	{
		/*
		The fraction 49/98 is a curious fraction, as an inexperienced
		mathematician in attempting to simplify it may incorrectly believe
		that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

		We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

		There are exactly four non-trivial examples of this type of fraction,
		less than one in value, and containing two digits in the numerator and
		denominator.

		If the product of these four fractions is given in its lowest common
		terms, find the value of the denominator.

		Answer=100
		*/
		int[] num = new int[4];
		int[] dom = new int[4];
		int counter = 0;
		for (int i = 10; i <= 99; i++) {
			for (int j = i + 1; j <= 99; j++) {
				String numStr = (i + "");
				String domStr = (j + "");
				int num1 = Character.getNumericValue(numStr.charAt(0));
				int num2 = Character.getNumericValue(numStr.charAt(1));

				int dom1 = Character.getNumericValue(domStr.charAt(0));
				int dom2 = Character.getNumericValue(domStr.charAt(1));

				String reduced = reducedFraction(i, j);
				//System.out.println(numStr + "/" + domStr);
				if (num1 != 0 && dom1 != 0 && num1 == dom1) {
					String fracStr = reducedFraction(num2, dom2);
					if (fracStr.equals(reduced)) {
						num[counter] = i;
						dom[counter] = j;
						counter++;
					}
				}
				if (num1 != 0 && dom2 != 0 && num1 == dom2) {
					String fracStr = reducedFraction(num2, dom1);
					if (fracStr.equals(reduced)) {
						num[counter] = i;
						dom[counter] = j;
						counter++;
					}
				}

				if (num2 != 0  && dom1 != 0 && num2 == dom1) {
					String fracStr = reducedFraction(num1, dom2);
					if (fracStr.equals(reduced)) {
						num[counter] = i;
						dom[counter] = j;
						counter++;
					}
				}
				else if (num2 != 0 && dom2 != 0 && num2 == dom2) {
					String fracStr = reducedFraction(num1, dom1);
					if (fracStr.equals(reduced)) {
						num[counter] = i;
						dom[counter] = j;
						counter++;
					}
				}
			}
		}

		int totalNum = 1;
		int totalDom = 1;
		for (int i = 0; i < 4; i++) {
			totalNum *= num[i];
			totalDom *= dom[i];
		}

		int gcm = gcm(totalNum, totalDom);
		System.out.println(totalDom / gcm);
	}

	public static String reducedFraction(int a, int b)
	{
		int gcm = gcm(a, b);
		return (a / gcm) + "/" + (b / gcm);
	}

	public static int gcm(int a, int b)
	{
		return b == 0 ? a : gcm(b, a % b);
	}
}