package org.example.Modul;

import org.example.Time.Time;
import org.example.Time.Timeframe;

import java.util.ArrayList;

// recursive generics for writing nice monads
public class Modul {
	private final String name;
	private ArrayList<Prof> profs;
	private String room;	// hoersaal
	private final VU type;	// vorlesung or uebung
	private Timeframe timeframe;

	public Modul(String name, VU type) {
		this.name = name;
		this.profs = new ArrayList<>();
		this.room = "";
		this.type = type;
		this.timeframe = new Timeframe(new Time(0));
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
		this.timeframe = new Timeframe(new Time(0));
	}
	public Modul withProfs(ArrayList<Prof> profs) {
		this.profs = profs;
		return this;
	}
	public Modul withRoom(String room) {
		this.room = room;
		return this;
	}
	public Modul withTimeframe(Timeframe t) {
		this.timeframe = t;
		return this;
	}
	public Modul withTimeframe(Time t1, Time t2) {
		this.timeframe = new Timeframe(t1, t2);
		return this;
	}
	public Modul withTimeframe(int h, int m) {
		this.timeframe = new Timeframe(new Time(h, m));
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

	public Timeframe getTimeframe() {
		return timeframe;
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

	public void setTimeframe(Timeframe timeframe) {
		this.timeframe = timeframe;
	}
}
