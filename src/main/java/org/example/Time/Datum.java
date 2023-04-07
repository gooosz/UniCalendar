package org.example.Time;

public class Datum {
	private Day day;
	private int yy;
	private int mm;
	private int dd;
	private Time time;

	private static final int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public Datum(Day day, int yy, int mm, int dd) {
		this.day = day;
		this.yy = yy;
		this.mm = mm;
		this.dd = dd;
	}
	public Datum withTime(Time time) {
		this.time = time;
		return this;
	}

	public void addTime(Time t) {
		Time temp = time;
		// hours to min
		time.add(60 * t.getHour() + t.getMin());
		// check for overflow
		if (time.compareTo(temp) == -1) {
			// overflow, do add some days and stuff
		}
	}

}
