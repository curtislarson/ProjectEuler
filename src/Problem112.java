public class Problem112
{
	public static void main(String[] args)
	{

		/*
		Working from left-to-right if no digit is exceeded by the digit to its
		left it is called an increasing number; for example, 134468.

		Similarly if no digit is exceeded by the digit to its right it is
		called a decreasing number; for example, 66420.

		We shall call a positive integer that is neither increasing nor
		decreasing a "bouncy" number; for example, 155349.

		Clearly there cannot be any bouncy numbers below one-hundred, but just
		over half of the numbers below one-thousand (525) are bouncy.
		In fact, the least number for which the proportion of bouncy numbers
		first reaches 50% is 538.

		Surprisingly, bouncy numbers become more and more common and by the
		time we reach 21780 the proportion of bouncy numbers is equal to 90%.

		Find the least number for which the proportion of bouncy numbers is
		exactly 99%.

		Answer=1587000
		*/
		int i = 0;
		int numBouncy = 0;
		while(true) {
			if (isBouncy(i)) {
				numBouncy++;
			}

			if ((double)numBouncy / (double)i == .99) {
				System.out.println(i);
				return;
			}
			i++;
		}
	}

	public static boolean isBouncy(int n)
	{
		String number = String.valueOf(n);
		if (number.length() <= 2) {
			return false;
		}
		if (isIncreasing(number) || isDecreasing(number)) {
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean isIncreasing(String number)
	{
		for (int i = 1; i < number.length(); i++) {
			int left = Character.getNumericValue(number.charAt(i - 1));
			int middle = Character.getNumericValue(number.charAt(i));

			if (left > middle) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDecreasing(String number)
	{
		for (int i = 0; i < number.length() - 1; i++) {
			int middle = Character.getNumericValue(number.charAt(i));
			int right = Character.getNumericValue(number.charAt(i + 1));

			if (right > middle) {
				return false;
			}
		}
		return true;
	}
}