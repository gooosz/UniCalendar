package org.example.Time;

public class Datum {
	private Day weekday;
	private int yy;
	private int mm;
	private int dd;

	private final int[] months;

	public Datum(int yy, int mm, int dd) {
		this.yy = yy;
		this.mm = mm;
		this.dd = dd;

		if (isLeapYear()) {
			months = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		} else {
			months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		}
	}

	public Datum withWeekday(Day weekday) {
		this.weekday = weekday;
		return this;
	}

	public Datum(Datum datum) {
		this.weekday = datum.getWeekday();
		this.yy = datum.getYear();
		this.mm = datum.getMonth();
		this.dd = datum.getDay();

		if (isLeapYear()) {
			months = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		} else {
			months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		}
	}

	public int getImplicitWeekday() {
		// called when no weekday is specified
		// algorithm found on: https://cs.uwaterloo.ca/~alopez-o/math-faq/node73.html
		int y = getYear();
		if (!(getMonth() < 3)) {
			y -= 1;
		}
		String idk = "-bed=pen+mad.";
		int expr = y + y / 4 - y / 100 + y / 400;
		expr += (int) idk.charAt(getMonth());
		expr += getDay();
		expr %= 7;
		return expr;
	}

	public Day getWeekday() {
		return weekday;
	}

	public int getYear() {
		return yy;
	}

	public int getMonth() {
		return mm;
	}

	public int getDay() {
		return dd;
	}

	public void setWeekday(Day day) {
		this.weekday = day;
	}
	public void setYear(int year) {
		this.yy = year;
	}
	public void setMonth(int mm) {
		this.mm = mm;
	}
	public void setDay(int dd) {
		this.dd = dd;
	}

	public void addDay(int days) {
		int sumOfDays = this.getDay() + days;
		int daysInCurrentMonth = months[getMonth()-1];
		while (sumOfDays > daysInCurrentMonth) {
			sumOfDays %= daysInCurrentMonth;
			addMonth(1);
		}
		setDay(sumOfDays);
	}
	public void addMonth(int months) {
		int sumOfMonths = this.getMonth() + months;
		// 12 months in a year
		while (sumOfMonths > 12) {
			sumOfMonths %= 12;
			addYear(1);
		}
		setMonth(sumOfMonths);
	}
	public void addYear(int years) {
		setYear(getYear() + years);
	}

	public boolean isLeapYear() {
		int year = getYear();
		/*
		 * Every year is a leap year
		 * that is divisible by 4
		 * except for years that are divisible by 100
		 * but years that are divisible by 400 are leap years
		*/
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	public void add(Datum d) {
		this.weekday = Day.add(this.getWeekday(), d.getWeekday());

		addDay(d.getDay());
		addMonth(d.getMonth());
		addYear(d.getYear());
	}

	@Override
	public boolean equals(Object d) {
		if (!(d instanceof Datum)) {
			return super.equals(d);
		}
		return this.toString().equals(d.toString())
			&& this.getWeekday() == ((Datum) d).getWeekday();
	}

	@Override
	public String toString() {
		// yyyy-mm-dd
		StringBuilder year = new StringBuilder(Integer.toString(yy));
		if (year.length() < 4) {
			// fill the front with zeroes
			for (int i=0; i<4-year.length(); i++) {
				year.insert(0, "0");
			}
		}
		StringBuilder month = new StringBuilder(Integer.toString(mm));
		if (mm < 10) {
			month.insert(0, "0");
		}
		StringBuilder dayString = new StringBuilder(Integer.toString(dd));
		if (dd < 10) {
			dayString.insert(0, "0");
		}
		return year + "-" + month + "-" + dayString;
	}
}
