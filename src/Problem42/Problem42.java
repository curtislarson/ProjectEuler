import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.io.File;

public class Problem42
{
	public static void main(String[] args)
	{
		/*
		The nth term of the sequence of triangle numbers is given by,
		tn = ½n(n+1); so the first ten triangle numbers are:

		1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

		By converting each letter in a word to a number corresponding to
		its alphabetical position and adding these values we form a word value.
		For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.
		If the word value is a triangle number then we shall call the word a
		triangle word.

		Using words.txt (right click and 'Save Link/Target As...'), a 16K text
		file containing nearly two-thousand common English words, how many are
		triangle words?

		Answer=162
		*/
		ArrayList<Integer> triangles = new ArrayList<Integer>();
		// The first 1k or so should be more than enough.
		for (int i = 1; i < 1000; i++) {
			triangles.add(triangle(i));
		}

		int numTriangles = 0;
		try {
			Scanner s = new Scanner(new File("words.txt")).useDelimiter("\"*\",");
			while (s.hasNext()) {
				String str = s.next();
				str = str.replace("\"","");
				if (triangles.contains(stringToInt(str))) {
					numTriangles++;
				}
			}
		}
		catch(Exception ex) {}

		System.out.println(numTriangles);

	}

	public static int triangle(int n)
	{
		return (int)((n * .5) * (n + 1));
	}

	public static int stringToInt(String str)
	{
		int total = 0;
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			total += (int)chars[i] - 64;
		}
		return total;
	}
}