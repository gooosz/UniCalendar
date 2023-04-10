package Time;

import org.example.Time.Datum;
import org.example.Time.Day;
import org.example.Time.Timeframe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDatum {
	private Datum datum;

	@BeforeEach
	public void init() {
		datum = new Datum(Day.SATURDAY, 2023, 4, 8);
	}

	@Test
	public void testToString() {
		assertEquals("2023-04-08", datum.toString());
	}

	@Test
	public void testGetter() {
		assertEquals(Day.SATURDAY, datum.getWeekday());
		assertEquals(2023, datum.getYear());
		assertEquals(4, datum.getMonth());
		assertEquals(8, datum.getDay());
	}

	@Test
	public void testSetter() {
		datum.setWeekday(Day.FRIDAY);
		assertEquals(Day.FRIDAY, datum.getWeekday());

		datum.setYear(2022);
		assertEquals(2022, datum.getYear());

		datum.setMonth(8);
		assertEquals(8, datum.getMonth());

		datum.setDay(2);
		assertEquals(2, datum.getDay());
	}

	@Test
	public void testEquals() {
		Datum datum1 = new Datum(Day.SATURDAY, 2023, 4, 8);
		assertEquals(datum, datum1);

		Datum datum2 = new Datum(Day.SATURDAY, 2023, 4, 10);
		assertNotEquals(datum, datum2);

		Datum datum3 = new Datum(Day.MONDAY, 2023, 4, 8);
		assertNotEquals(datum, datum3);
	}

}
