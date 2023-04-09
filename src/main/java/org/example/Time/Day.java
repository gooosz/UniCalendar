package org.example.Time;

public enum Day {
	MONDAY(1),
	TUESDAY(2),
	WEDNESDAY(3),
	THURSDAY(4),
	FRIDAY(5),
	SATURDAY(6),
	SUNDAY(7);


	private int day;
	Day(int d) {
		day = d;
	}
	public int get() {
		return day;
	}
	public static Day createDay(int d) {
		if (d < 0 || d > Day.values().length) {
			return null;
		}
		return Day.values()[d-1];
	}
	public void set(Day d) {
		day = d.get();
	}

	public void add(int d) {
		day = (day + d) % Day.values().length;	// mod amount of days
	}
	public void add(Day d) {
		day = (day + d.get()) % Day.values().length;	// mod amount of days
	}
}
