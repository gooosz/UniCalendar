package Modul;

import org.example.Modul.Modul;

import java.util.ArrayList;

import org.example.Modul.Prof;
import org.example.Modul.VU;
import org.example.Time.Time;

import org.example.Time.Timeframe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestModul {
	private Modul modul;

	@BeforeEach
	public void init() {
		modul = new Modul("EidP", VU.Vorlesung)
			.withProfs(new ArrayList<Prof>())
			.withRoom("C120")
			.withTimeframe(new Timeframe(new Time(0)));
	}

	@Test
	public void testGetter() {
		assertEquals("EidP", modul.getName());
		assertEquals(0, modul.getProfs().size());
		assertEquals("C120", modul.getRoom());
		assertEquals(VU.Vorlesung, modul.getType());
		assertEquals("00:00", modul.getTimeframe().getStart().toString());
	}

	@Test
	public void testMonadConstructor() {
		ArrayList<Prof> profs = new ArrayList<>();
		profs.add(new Prof("Weil"));
		modul = new Modul("Mathe", VU.Vorlesung)
				.withProfs(profs)
				.withRoom("C118")
				.withTimeframe(new Timeframe(new Time(15)));

		assertEquals("Mathe", modul.getName());
		assertEquals("Weil", modul.getProfs().get(0).getName());
		assertEquals("C118", modul.getRoom());
		assertEquals(new Timeframe(new Time(15)), modul.getTimeframe());
	}

	@Test
	public void testAddProf() {
		Prof p = new Prof("Berrendorf");
		modul.addProf(p);
		assertEquals("Berrendorf", modul.getProfs().get(0).getName());
	}

	@Test
	public void testRemoveProf() {
		Prof p = new Prof("Weil");
		modul.addProf(p);

		Prof p1 = new Prof("Weil");
		modul.removeProf(p1);
		assertEquals(0, modul.getProfs().size());
	}
}
