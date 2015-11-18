import java.lang.StringBuilder;

public class Problem145
{
	public static void main(String[] args)
	{
		int n = 10000000;
		int count = 0;
		for (int i = 1; i < n; i++) {
			if (numTrailingZeros(i) != 0) {
				i
			}
			int first = first(i);
			int last = last(i);
			if (first % 2 == 0 && last % 2 == 0) {
				continue;
			}
			if (first % 2 != 0 && last % 2 != 0) {
				continue;
			}
			int sum = i + reverse(i);
			if (isReversible(sum)) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static int reverse(int n)
	{
		return Integer.parseInt(new StringBuilder("" + n).reverse().toString());
	}

	public static int first(int n)
	{
		return Character.getNumericValue(("" + n).charAt(0));
	}

	public static int numTrailingZeros(int n)
	{
		int count = 0;
		String str = "" + n;
		while (str.endsWith("0")) {
			count++;
			str = str.substring(0, str.length() - 1);
		}
		return count;
	}

	public static int last(int n)
	{
		String str = "" + n;
		return Character.getNumericValue(str.charAt(str.length() - 1));
	}

	public static boolean isReversible(int n)
	{
		int tmp = n;
		while (tmp != 0) {
			if (tmp % 2 == 0) {
				return false;
			}
			tmp /= 10;
		}
		return true;
	}
}