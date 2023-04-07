package org.example.Time;

public class Timeframe {
	private Time start;
	private Time end;

	public Timeframe(Time start) {
		this.start = start;
		// default 90min later
		this.end = new Time(start);
		this.end.add(90);
	}

	public Timeframe(Time start, Time end) {
		if (start.compareTo(end) == 1) {
			// start is later than end -> error
			System.out.println("Error: end is before start, couldn't initialize Timeframe");
			return;
		}
		this.start = start;
		this.end = end;
	}
}
