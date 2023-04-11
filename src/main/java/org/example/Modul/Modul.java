package org.example.Modul;

import org.example.Helper.Pair;
import org.example.Time.Day;
import org.example.Time.Time;
import org.example.Time.Timeframe;

import java.lang.reflect.Array;
import java.util.ArrayList;

// recursive generics for writing nice monads
public class Modul {
	private final String name;
	private ArrayList<Prof> profs;
	private String room;	// hoersaal
	private final VU type;	// vorlesung or uebung
	private ArrayList<Pair<Day, Timeframe>> schedule;

	public Modul(String name, VU type) {
		this.name = name;
		this.profs = new ArrayList<>();
		this.room = "";
		this.type = type;
		this.schedule = new ArrayList<>();
		schedule.add(new Pair<>(Day.MONDAY, new Timeframe(new Time(0))));
	}

	public Modul(Modul m, VU type) {
		/*
		 * same name, profs
		 * but else different
		 * e.g. Vorlesung of modul, Uebung of same modul
		*/
		this.name = m.getName();
		this.profs = m.getProfs();
		this.room = "";
		this.type = type;
		this.schedule = m.getSchedule();
	}
	public Modul withProfs(ArrayList<Prof> profs) {
		this.profs = profs;
		return this;
	}
	public Modul withRoom(String room) {
		this.room = room;
		return this;
	}
	public Modul withSchedule(ArrayList<Pair<Day, Timeframe>> schedule){
		this.schedule = schedule;
		return this;
	}

	public void addToSchedule(Day d, Timeframe t) {
		schedule.add(new Pair<>(d, t));
	}
	public Modul withTimeframe(Day d, Time t1, Time t2) {
		schedule.add(new Pair<>(d, new Timeframe(t1, t2)));
		return this;
	}
	public Modul withTimeframe(Day d, int h, int m) {
		schedule.add(new Pair<>(d, new Timeframe(new Time(h, m))));
		return this;
	}

	public String getName() {
		return name;
	}
	public ArrayList<Prof> getProfs() {
		return profs;
	}
	public String getRoom() {
		return room;
	}
	public VU getType() {
		return type;
	}

	public ArrayList<Pair<Day, Timeframe>> getSchedule() {
		return schedule;
	}

	// change of profs related stuff

	public void setProfs(ArrayList<Prof> profs) {
		this.profs = profs;
	}
	public void addProf(Prof p) {
		profs.add(p);
	}
	public void removeProf(Prof p) {
		profs.remove(p);
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public void setSchedule(ArrayList<Pair<Day, Timeframe>> schedule) {
		this.schedule = schedule;
	}
}
