package org.example.Time;

import java.awt.font.TextHitInfo;

public class Time {
	private int hour;	// 0 <= hour <= 23	// (mod 24)
	private int min;	// 0 <= min <= 59	// (mod 60)

	public Time(int hour) {
		this.hour = hour % 24;
		this.min = 0;
	}

	public Time(int hour, int min) {
		this.hour = hour % 24;
		this.min = min % 60;
	}

	public Time(Time t) {
		this.hour = t.getHour();
		this.min = t.getMin();
	}

	public int getHour() {
		return hour;
	}
	public int getMin() {
		return min;
	}

	public void setHour(int hour) {
		this.hour = hour % 24;
	}
	public void setMin(int min) {
		this.min = min % 60;
	}

	public void add(int min) {
		// may be >= 60
		int addedMin = this.min + min;
		hour += (addedMin / 60) % 24;
		this.min = addedMin % 60;
	}

	/**
	 * @param t
	 * @return 1, if this is greater than t
	 * 	   0, if equal
	 * 	   -1, if this is less than t
	 */
	public int compareTo(Time t) {
		if (equals(t)) {
			return 0;
		}
		if (getHour() > t.getHour()
			|| (getHour() == t.getHour() && getMin() > t.getMin())) {
			return 1;
		}
		return -1;
	}

	@Override
	public boolean equals(Object t) {
		if (!(t instanceof Time)) {
			return super.equals(t);
		}
		int tHour = ((Time) t).getHour();
		int tMin = ((Time) t).getMin();
		return (getHour() == tHour) && (getMin() == tMin);
	}

	@Override
	public String toString() {
		String hourString = Integer.toString(hour);
		String minString = Integer.toString(min);
		if (hour < 10) {
			// make single digit double
			hourString = "0" + hour;
		}
		if (min < 10) {
			minString = "0" + min;
		}
		return hourString + ":" + minString;
	}
}
