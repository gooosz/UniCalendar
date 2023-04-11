package Helper;

import org.example.Helper.Pair;
import org.example.Time.Timeframe;
import org.example.Time.Time;
import org.example.Time.Day;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TestPair {
	private Pair<Day, Timeframe> pair;

	@BeforeEach
	public void init() {
		Day day = Day.MONDAY;
		Timeframe tf = new Timeframe(new Time(10));
		pair = new Pair<Day, Timeframe>(day, tf);
	}

	@Test
	public void testGetter() {
		assertEquals(Day.MONDAY, pair.getKey());
		assertEquals("10:00-11:30", pair.getValue().toString());
	}

	@Test
	public void testSetter() {
		pair.setKey(Day.FRIDAY);
		pair.setValue(new Timeframe(new Time(0)));

		assertEquals(Day.FRIDAY, pair.getKey());
		assertEquals("00:00-01:30", pair.getValue().toString());
	}

	@Test
	public void testEquals() {
		Day day2 = Day.MONDAY;
		Timeframe tf2 = new Timeframe(new Time(10));
		Pair<Day, Timeframe> pair2 = new Pair<>(day2, tf2);
		assertEquals(pair, pair2);

		Day day3 = Day.TUESDAY;
		Timeframe tf3 = new Timeframe(new Time(10));
		Pair<Day, Timeframe> pair3 = new Pair<>(day3, tf3);
		assertNotEquals(pair, pair3);

		Day day4 = Day.MONDAY;
		Timeframe tf4 = new Timeframe(new Time(10, 1));
		Pair<Day, Timeframe> pair4 = new Pair<>(day4, tf4);
		assertNotEquals(pair, pair4);
	}

	@Test
	public void testToString() {
		assertEquals("MONDAY: 10:00-11:30", pair.toString());
	}
}
