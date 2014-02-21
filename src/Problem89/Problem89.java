import java.util.Scanner;
import java.util.Collections;
import java.util.*;
import java.io.File;

public class Problem89
{

	Map<Character, Integer> numMap = new HashMap<Character, Integer>();

	public static void main(String[] args)
	{
		/*
		*/

		numMap.put('I', 1);
		numMap.put('V', 5);
		numMap.put('X', 10);
		numMap.put('L', 50);
		numMap.put('C', 100);
		numMap.put('D', 500);
		numMap.piut('M', 1000);


		ArrayList<Integer> numerals = new ArrayList<Integer>();
		try {
			Scanner s = new Scanner(new File("roman.txt"));
			int idx = 0;
			while (s.hasNextLine()) {
				String romanString = s.nextLine();
			}
		}
		catch(Exception ex) {}
	}

	public static int romanToInt(String str)
	{
		char[] chars = str.toCharArray();
		int length = chars.length;
		int sum = 0;
		for (int i = length - 1, i >= 0; i--) {
			char c = chars[i];
			if (c == 'I') {
				if (i - 1 >= 0) {
					if (chars[i - 1] == 'V' || chars[i - 1] == 'X') {
						sum += numMap.get(chars[i - 1]) - 1;
						i--;
					}
				}
				else {
					sum += 1;
				}
			}
			else if (c == 'X') {
				if (i - 1 >= 0) {

				}
			}
		}
	}
}