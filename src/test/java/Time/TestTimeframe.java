package Time;

import org.example.Time.Time;
import org.example.Time.Timeframe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTimeframe {
	private Timeframe tf;

	@BeforeEach
	public void init() {
		Time start = new Time(10);
		Time end = new Time(12);
		tf = new Timeframe(start, end);
	}

	@Test
	public void testConstructor() {
		assertEquals("10:00-12:00", tf.toString());

		assertThrows(IllegalStateException.class,
			() -> new Timeframe(new Time(10), new Time(9)));

		tf = new Timeframe(new Time(10));
		assertEquals("10:00-11:30", tf.toString());
	}

	@Test
	public void testGetter() {
		assertEquals("10:00", tf.getStart().toString());
		assertEquals("12:00", tf.getEnd().toString());
	}

	@Test
	public void testGetDuration() {
		assertEquals(120, tf.getDuration());
	}

	@Test
	public void testEquals() {
		assertEquals(tf, tf);

		Timeframe tf1 = new Timeframe(new Time(10), new Time(12));
		assertEquals(tf1, tf);
	}

	@Test
	public void testOverlap() {
		Timeframe tf1 = new Timeframe(new Time(10), new Time(12));
		assertTrue(tf1.overlaps(tf));

		Timeframe tf2 = new Timeframe(new Time(9), new Time(11));
		assertTrue(tf2.overlaps(tf));

		Timeframe tf3 = new Timeframe(new Time(11, 50), new Time(13));
		assertTrue(tf3.overlaps(tf));

		Timeframe tf4 = new Timeframe(new Time(7), new Time(8));
		assertFalse(tf4.overlaps(tf));

		// start and end on same time should not overlap
		Timeframe tf5 = new Timeframe(new Time(9), new Time(10));
		assertFalse(tf5.overlaps(tf));

		Timeframe tf6 = new Timeframe(new Time(12), new Time(14));
		assertFalse(tf6.overlaps(tf));

		Timeframe tf7 = new Timeframe(new Time(13), new Time(14));
		assertFalse(tf7.overlaps(tf));
	}
}
