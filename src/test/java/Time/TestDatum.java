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
		datum = new Datum(2023, 4, 8).withWeekday(Day.SATURDAY);
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
		Datum datum1 = new Datum(2023, 4, 8).withWeekday(Day.SATURDAY);
		assertEquals(datum, datum1);

		Datum datum2 = new Datum(2023, 4, 10).withWeekday(Day.SATURDAY);
		assertNotEquals(datum, datum2);

		Datum datum3 = new Datum(2023, 4, 8).withWeekday(Day.MONDAY);
		assertNotEquals(datum, datum3);
	}

	@Test
	public void testLeapYear() {
		Datum ly = new Datum(2000, 10, 2);
		assertTrue(ly.isLeapYear());

		Datum nly1 = new Datum(2100, 10, 2);
		assertFalse(nly1.isLeapYear());

		Datum nly2 = new Datum(2023, 10, 2);
		assertFalse(nly2.isLeapYear());
	}
	@Test
	public void testAddDays() {
		// Datum is 2023-04-08
		datum.addDay(4);
		assertEquals("2023-04-12", datum.toString());

		datum.addDay(30);
		assertEquals("2023-05-12", datum.toString());
	}

	@Test
	public void testAddDaysInLeapYear() {
		Datum lyd = new Datum(2000, 2, 1);
		lyd.addDay(28);
		assertEquals("2000-02-29", lyd.toString());

		Datum nlyd = new Datum(2001, 2, 1);
		nlyd.addDay(28);
		assertEquals("2001-03-01", nlyd.toString());
	}

	@Test
	public void testAddMonths() {
		// Datum is 2023-04-08
		datum.addMonth(5);
		assertEquals("2023-09-08", datum.toString());

		datum.addMonth(4);
		assertEquals("2024-01-08", datum.toString());
	}

	@Test
	public void testAddYears() {
		// Datum is 2023-04-08
		datum.addYear(3);
		assertEquals("2026-04-08", datum.toString());
	}

	@Test
	public void testImplicitWeekday() {
		Datum monday = new Datum(2023, 4, 10);
		assertEquals(Day.MONDAY, monday.getImplicitWeekday());

		Datum tuesday = new Datum(2023, 4, 11);
		assertEquals(Day.TUESDAY, tuesday.getImplicitWeekday());

		Datum wednesday = new Datum(2023, 4, 12);
		assertEquals(Day.WEDNESDAY, wednesday.getImplicitWeekday());

		Datum thursday = new Datum(2023, 4, 13);
		assertEquals(Day.THURSDAY, thursday.getImplicitWeekday());

		Datum friday = new Datum(2023, 4, 14);
		assertEquals(Day.FRIDAY, friday.getImplicitWeekday());

		Datum saturday = new Datum(2023, 4, 15);
		assertEquals(Day.SATURDAY, saturday.getImplicitWeekday());

		Datum sunday = new Datum(2023, 4, 16);
		assertEquals(Day.SUNDAY, sunday.getImplicitWeekday());

		Datum monday2 = new Datum(2023, 4, 17);
		assertEquals(Day.MONDAY, monday2.getImplicitWeekday());
	}
}
