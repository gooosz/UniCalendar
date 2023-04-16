package Modul;

import org.example.Helper.Pair;
import org.example.Modul.Modul;

import java.util.ArrayList;

import org.example.Modul.Prof;
import org.example.Modul.VU;
import org.example.Time.Day;
import org.example.Time.Time;

import org.example.Time.Timeframe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestModul {
	private Modul modul;

	@BeforeEach
	public void init() {
		modul = new Modul("EidP")
			.withProfs(new ArrayList<Prof>())
			.withRoom("C120")
			.withType(VU.Vorlesung);
	}

	@Test
	public void testGetter() {
		assertEquals("EidP", modul.getName());
		assertEquals(0, modul.getProfs().size());
		assertEquals("C120", modul.getRooms().get(0));
		assertEquals(VU.Vorlesung, modul.getTypes().get(0));
		assertTrue(modul.getSchedule().isEmpty());
	}

	@Test
	public void testMonadConstructor() {
		ArrayList<Prof> profs = new ArrayList<>();
		profs.add(new Prof("Weil"));
		modul = new Modul("Mathe")
				.withProfs(profs)
				.withRoom("C118");

		assertEquals("Mathe", modul.getName());
		assertEquals("Weil", modul.getProfs().get(0).getName());
		assertEquals("C118", modul.getRooms().get(0));
	}

	@Test
	public void testCopyConstructor() {
		Modul m2 = new Modul("Mathe")
			.withRoom("C120")
			.withType(VU.Uebung);
		modul = new Modul(m2);
		assertEquals("Mathe", modul.getName());
		assertEquals(0, modul.getProfs().size());
		assertEquals("C120", modul.getRooms().get(0));
		assertEquals(VU.Uebung, modul.getTypes().get(0));
		assertEquals(0, modul.getSchedule().size());
	}

	@Test
	public void testAddToSchedule() {
		// schedule is empty
		Timeframe tf = new Timeframe(new Time(10));
		Pair<Day, Timeframe> pair = new Pair<>(Day.MONDAY, tf);
		modul.addToSchedule(pair);
		assertEquals(new Pair<>(Day.MONDAY, tf), modul.getSchedule().get(0));
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

	@Test
	public void testGetDays() {
		Timeframe tf1 = new Timeframe(new Time(10));
		Timeframe tf2 = new Timeframe(new Time(15));
		Pair<Day, Timeframe> p1 = new Pair<>(Day.MONDAY, tf1);
		Pair<Day, Timeframe> p2 = new Pair<>(Day.TUESDAY, tf1);
		Pair<Day, Timeframe> p3 = new Pair<>(Day.THURSDAY, tf1);
		Pair<Day, Timeframe> p4 = new Pair<>(Day.TUESDAY, tf2);
		modul.addToSchedule(p1);
		modul.addToSchedule(p2);
		modul.addToSchedule(p3);
		modul.addToSchedule(p4);

		ArrayList<Day> compared = new ArrayList<>();
		compared.add(p1.getKey());
		compared.add(p2.getKey());
		compared.add(p3.getKey());
		assertEquals(compared, modul.getDays());
	}

	@Test
	public void testSetProfs() {
		ArrayList<Prof> profs = new ArrayList<>();
		profs.add(new Prof("Weil"));
		profs.add(new Prof("Huelsmann"));
		modul.setProfs(profs);
		assertEquals(profs, modul.getProfs());
	}

	@Test
	public void testSetRooms() {

	}
}
