package Time;

import org.example.Time.Day;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDayEnum {
	private Day day;

	@BeforeEach
	public void init() {
		day = Day.MONDAY;
	}

	@Test
	public void testGetter() {
		assertEquals(Day.MONDAY, day);
		assertEquals(1, day.get());
	}
	@Test
	public void testSet() {
		day = Day.createDay(7);
		assertEquals(Day.SUNDAY, day);

		Day day2 = Day.createDay(4);
		day = day2;
		assertEquals(Day.THURSDAY, day);
	}

	@Test
	public void testAdd() {

	}

	@Test
	public void testAddDaysWithInt() {
		/*
		 * MONDAY + THURSDAY = FRIDAY
		 *   1    +    4     =   5
		 */
		assertEquals(Day.FRIDAY, Day.add(1, 4));

		/*
		 * SATURDAY + TUESDAY = MONDAY
		 *   6    +    2     =   1
		 */
		assertEquals(Day.MONDAY, Day.add(6, 2));

		/*
		 * SATURDAY + SUNDAY = SATURDAY
		 *   6    +    7     =   6
		 */
		assertEquals(Day.SATURDAY, Day.add(6, 7));
	}

	@Test
	public void testAddDaysWithDay() {
		/*
		 * MONDAY + THURSDAY = FRIDAY
		 *   1    +    4     =   5
		 */
		Day day2 = Day.THURSDAY;
		assertEquals(Day.FRIDAY, Day.add(day, day2));

		/*
		 * THURSDAY + SATURDAY = WEDNESDAY
		 *   4    +    6     =   3
		*/
		assertEquals(Day.WEDNESDAY, Day.add(Day.THURSDAY, Day.SATURDAY));
	}

	@Test
	public void testAddDaysWithDayInt() {
		/*
		 * MONDAY + THURSDAY = FRIDAY
		 *   1    +    4     =   5
		 */
		assertEquals(Day.FRIDAY, Day.add(Day.MONDAY, 4));

		/*
		 * THURSDAY + SATURDAY = WEDNESDAY
		 *   4    +    6     =   3
		 */
		assertEquals(Day.WEDNESDAY, Day.add(4, Day.SATURDAY));
	}
}
