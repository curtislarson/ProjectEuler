import java.util.Arrays;

public class Problem52
{
	public static void main(String[] args)
	{
		/*
		It can be seen that the number, 125874, and its double, 251748,
		contain exactly the same digits, but in a different order.

		Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x,
		and 6x, contain the same digits.

		Answer = 142857
		*/	
		long num = 1;
		while(true) {
			long[] nums = new long[] {num * 2,
								      num * 3,
								      num * 4,
								      num * 5,
								      num * 6};
			long[] numSums = new long[] {sumDigit(nums[0]),
										 sumDigit(nums[1]),
										 sumDigit(nums[2]),
										 sumDigit(nums[3]),
										 sumDigit(nums[4])};
			long numSum = sumDigit(num);
			if (numSum == numSums[0] && numSum == numSums[1] &&
				numSum == numSums[2] && numSum == numSums[3] &&
				numSum == numSums[4]) {
				char[] tempStr = ("" + num).toCharArray();
				Arrays.sort(tempStr);
				String numStr = new String(tempStr);
				boolean success = true;
				for (int i = 0; i < nums.length; i++) {
					char[] temp = ("" + nums[i]).toCharArray();
					Arrays.sort(temp);
					String str = new String(temp);
					if (!str.equals(numStr)) {
						success = false;
						break;
					}
				}
				if (success) {
					System.out.println(num);
					return;
				}
			}
			num++;
		}
	}

	public static long sumDigit(long n) {
		return (n % 9 == 0 && n != 0) ? 0 : n % 9;
	}
}