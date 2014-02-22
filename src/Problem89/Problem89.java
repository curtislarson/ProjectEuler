import java.util.*;
import java.lang.StringBuilder;
import java.io.File;

public class Problem89
{

	public static void main(String[] args)
	{
		/*
		The rules for writing Roman numerals allow for many ways of writing
		each number (see About Roman Numerals...). However, there is always a
		"best" way of writing a particular number.

		For example, the following represent all of the legitimate ways of
		writing the number sixteen:

		IIIIIIIIIIIIIIII
		VIIIIIIIIIII
		VVIIIIII
		XIIIIII
		VVVI
		XVI

		The last example being considered the most efficient, as it uses the
		least number of numerals.

		The 11K text file, roman.txt (right click and 'Save Link/Target As...'),
		contains one thousand numbers written in valid, but not necessarily
		minimal, Roman numerals; that is, they are arranged in descending
		units and obey the subtractive pair rule (see About Roman Numerals...
		for the definitive rules for this problem).

		Find the number of characters saved by writing each of these in their
		minimal form.

		Note: You can assume that all the Roman numerals in the file contain
		no more than four consecutive identical units.

		Answer=743
		*/
		int savedCharacters = 0;
		try {
			Scanner s = new Scanner(new File("roman.txt"));
			int idx = 0;
			while (s.hasNextLine()) {
				String romanString = s.nextLine();
				int originalLength = romanString.length();
				int newLength = intToRoman(romanToInt(romanString)).length();
				savedCharacters += (originalLength - newLength);
			}
		}
		catch(Exception ex) {}

		System.out.println(savedCharacters);
	}

	public static String intToRoman(int n)
	{
		StringBuilder sb = new StringBuilder();
		int tmp = n;
		while (tmp != 0) {
			if (tmp / 1000 != 0) {
				sb.append("M");
				tmp -= 1000;
			}
			else if (tmp / 900 != 0) {
				sb.append("CM");
				tmp -= 900;
			}
			else if (tmp / 500 != 0) {
				sb.append("D");
				tmp -= 500;
			}
			else if (tmp / 400 != 0) {
				sb.append("CD");
				tmp -= 400;
			}
			else if (tmp / 100 != 0) {
				sb.append("C");
				tmp -= 100;
			}
			else if (tmp / 90 != 0) {
				sb.append("XC");
				tmp -= 90;
			}
			else if (tmp / 50 != 0) {
				sb.append("L");
				tmp -= 50;
			}
			else if (tmp / 40 != 0) {
				sb.append("XL");
				tmp -= 40;
			}
			else if (tmp / 10 != 0) {
				sb.append("X");
				tmp -= 10;
			}
			else if (tmp / 9 != 0) {
				sb.append("XI");
				tmp -= 9;
			}
			else if (tmp / 5 != 0) {
				sb.append("V");
				tmp -= 5;
			}
			else if (tmp / 4 != 0) {
				sb.append("IV");
				tmp -= 4;
			}
			else {
				sb.append("I");
				tmp--;
			}
		}
		return sb.toString();
	}

	public static int romanToInt(String str)
	{
		char[] chars = str.toCharArray();
		int length = chars.length;
		int sum = 0;
		for (int i = length - 1; i >= 0; i--) {
			char c = chars[i];
			if (c == 'I') {
				sum += 1;
			}
			else if (c == 'V') {
				if (i - 1 >= 0) {
					if (chars[i - 1] == 'I') {
						sum += 4;
						i--;
					}
					else {
						sum += 5;
					}
				}
				else {
					sum += 5;
				}
			}
			else if (c == 'X') {
				if (i - 1 >= 0) {
					if (chars[i - 1] == 'I') {
						sum += 9;
						i--;
					}
					else {
						sum += 10;
					}
				}
				else {
					sum += 10;
				}
			}
			else if (c == 'L') {
				if (i - 1 >= 0) {
					if (chars[i - 1] == 'X') {
						sum += 40;
						i--;
					}
					else {
						sum += 50;
					}
				}
				else {
					sum += 50;
				}
			}
			else if (c == 'C') {
				if (i - 1 >= 0) {
					if (chars[i - 1] == 'X') {
						sum += 90;
						i--;
					}
					else {
						sum += 100;
					}
				}
				else {
					sum += 100;
				}
			}
			else if (c == 'D') {
				if (i - 1 >= 0) {
					if (chars[i - 1] == 'C') {
						sum += 400;
						i--;
					}
					else {
						sum += 500;
					}
				}
				else {
					sum += 500;
				}
			}
			else if (c == 'M') {
				if (i - 1 >= 0) {
					if (chars[i - 1] == 'C') {
						sum += 900;
						i--;
					}
					else {
						sum += 1000;
					}
				}
				else {
					sum += 1000;
				}
			}
		}

		return sum;
	}
}