package org.example.Modul;

import org.example.Time.Time;

import java.util.ArrayList;

// recursive generics for writing nice monads
public class Modul {
	private final String name;
	private ArrayList<Prof> profs;
	private String room;	// hoersaal
	private final VU type;	// vorlesung or uebung
	private Time time;

	public Modul(String name, VU type) {
		this.name = name;
		this.profs = new ArrayList<>();
		this.room = "";
		this.type = type;
		this.time = new Time(0);
	}
	public Modul withProfs(ArrayList<Prof> profs) {
		this.profs = profs;
		return this;
	}
	public Modul withRoom(String room) {
		this.room = room;
		return this;
	}
	public Modul withTime(Time t) {
		this.time = t;
		return this;
	}
	public Modul withTime(int h, int m) {
		this.time = new Time(h, m);
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

	public Time getTime() {
		return time;
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

	public void setTime(Time time) {
		this.time = time;
	}
}
