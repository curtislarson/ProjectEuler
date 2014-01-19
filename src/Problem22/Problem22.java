import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.io.File;

public class Problem22
{
	public static void main(String[] args)
	{
		ArrayList<String> names = new ArrayList<String>();
		try {
			Scanner s = new Scanner(new File("names.txt")).useDelimiter("\"*\",");
			while (s.hasNext()) {
				String str = s.next();
				str = str.replace("\"","");
				names.add(str);
			}
			Collections.sort(names);

			long total = 0;
			for (int i = 0; i < names.size(); i++) {
				String name = names.get(i);
				int sum = 0;
				for(int j = 0; j < name.length(); j++) {
					sum += ((int)name.charAt(j) - 64);
				}
				sum *= (i + 1);
				total += sum;
			}
			System.out.println(total);
		}
		catch(Exception ex) {}

	}
}