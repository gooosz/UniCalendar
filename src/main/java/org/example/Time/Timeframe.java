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
			throw new IllegalStateException("end before start");
		}
		this.start = start;
		this.end = end;
	}

	public Time getStart() {
		return start;
	}

	public Time getEnd() {
		return end;
	}

	public int getDuration() {
		int startMin = 60 * start.getHour() + start.getMin();
		int endMin = 60 * end.getHour() + end.getMin();
		return endMin - startMin;
	}

	@Override
	public boolean equals(Object tf) {
		if (!(tf instanceof Timeframe)) {
			return super.equals(tf);
		}
		return this.toString().equals(tf.toString());
	}

	/**
	 * @param tf
	 * @return true if both timeframes overlap by atleast 1min
	 * else false
	 */
	public boolean overlaps(Timeframe tf) {
		/*
		 * Case 1 true:
		 * ----|------|----
		 * ------|-|-------
		 *
		 * Case 2 true:
		 * ----|------|----
		 * --|----|--------
		 *
		 * Case 3 true:
		 * ----|------|----
		 * -------|------|-
		 *
		 * Case 4 false:
		 * --------|--|----
		 * --|--|----------
		*/
		if (this.getEnd().compareTo(tf.getStart()) != 1
			|| this.getStart().compareTo(tf.getEnd()) != -1)
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return start.toString() + "-" + end.toString();
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public void setEnd(Time end) {
		this.end = end;
	}
}
