package Time;

import org.example.Time.Time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTime {
	private Time t;

	@BeforeEach
	public void init() {
		t = new Time(10, 0); // 10:00 uhr
	}

	@Test
	public void testGetTime() {
		assertEquals("10:00", t.toString());
	}

	@Test
	public void addMin() {
		t.add(5);
		assertEquals("10:05", t.toString());

		t.add(5);
		assertEquals("10:10", t.toString());

		t.add(50);
		assertEquals("11:00", t.toString());

		t.add(60);
		assertEquals("12:00", t.toString());

		t.add(0);
		assertEquals("12:00", t.toString());
	}

	@Test
	public void testCompareToGreater() {
		Time t1 = new Time(9, 0);
		assertEquals(1, t.compareTo(t1));

		t.add(10);
		t1.setHour(10);
		assertEquals(1, t.compareTo(t1));
	}

	@Test
	public void testCompareToEqual() {
		Time t1 = new Time(10, 0);
		assertEquals(0, t.compareTo(t1));
	}

	@Test
	public void testCompareToLess() {
		Time t1 = new Time(12, 0);
		assertEquals(-1, t.compareTo(t1));

		t1.add(10);
		t.add(120);
		assertEquals("12:10", t1.toString());
		assertEquals("12:00", t.toString());
		assertEquals(-1, t.compareTo(t1));
	}

	@Test
	public void testCopyConstructor() {
		Time t1 = new Time(t);
		assertEquals(t, t1);
	}
}
