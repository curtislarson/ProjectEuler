import java.math.BigInteger;

public class Problem19
{
	public static void main(String[] args)
	{
		/*
		You are given the following information, but you may prefer to do some
		research for yourself.

		1 Jan 1900 was a Monday.
		Thirty days has September,
		April, June and November.
		All the rest have thirty-one,
		Saving February alone,
		Which has twenty-eight, rain or shine.
		And on leap years, twenty-nine.

		A leap year occurs on any year evenly divisible by 4, but not on a
		century unless it is divisible by 400.

		How many Sundays fell on the first of the month during the twentieth
		century (1 Jan 1901 to 31 Dec 2000)?

		Answer=171
		*/
		int day = 1;
		int daysInMonth;
		int[] months = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,
								  30, 31};
		int numSundays = 0;
		for (int year = 1900; year <= 2000; year++) {
			for (int month = 1; month <= 12; month++) {
				// February
				if (month == 2) {
					if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
						daysInMonth = 29;
					}
					else {
						daysInMonth = 28;
					}
				}
				else {
					daysInMonth = months[month];
				}
				day = day % 7;
				if (day == 0) {
					if (year >= 1901) {
						numSundays++;		
					}
				}
				day += daysInMonth;
			}
		}
		System.out.println(numSundays);
	}
}