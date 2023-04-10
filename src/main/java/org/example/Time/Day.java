package org.example.Time;

public enum Day {
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY;


	public static Day createDay(int d) {
		if (d < 0 || d > Day.values().length) {
			return null;
		}
		return Day.values()[d-1];
	}
	public int get() {
		return this.ordinal()+1;
	}

	public static Day add(int d1, int d2) {
		assert(d1 > 0 && d2 > 0);

		int sum = d1 + d2;
		int numOfDays = Day.values().length;
		if (sum > numOfDays) {
			// next week start over
			sum %= numOfDays;
		}
		return createDay(sum);
	}
	public static Day add(Day d1, Day d2) {
		return add(d1.get(), d2.get());
	}

	public static Day add(Day d1, int d2) {
		return add(d1.get(), d2);
	}

	public static Day add(int d1, Day d2) {
		return add(d1, d2.get());
	}
}
