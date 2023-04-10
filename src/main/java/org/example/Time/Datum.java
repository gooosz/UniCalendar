package org.example.Time;

public class Datum {
	private Day weekday;
	private int yy;
	private int mm;
	private int dd;

	private static final int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public Datum(Day weekday, int yy, int mm, int dd) {
		this.weekday = weekday;
		this.yy = yy;
		this.mm = mm;
		this.dd = dd;
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

	}
	public void addMonth(int months) {

	}
	public void addYear(int years) {

	}

	public void add(Datum d) {
		this.weekday = Day.add(this.getWeekday(), d.getWeekday());
		// TODO: add Date ints together
		/*
		  * 2020 + 2020 = 2020
		  * but 2020 + 2021 = 2021
		*/
		this.setYear(this.yy + Math.abs(this.getYear() - d.getYear()));
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
