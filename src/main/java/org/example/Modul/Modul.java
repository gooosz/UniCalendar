package org.example.Modul;

import org.example.Helper.Pair;
import org.example.Time.Day;
import org.example.Time.Time;
import org.example.Time.Timeframe;

import java.util.ArrayList;

/*
 * TODO: change String room to ArrayList<String> rooms
 *  VU type to ArrayList<VU> types
 *
 * every element in schedule then has its attributes in rooms and types at respective position
 * e.g. Vorlesung at Monday 9:00 in schedule[0] has it's room at rooms[0] and type at types[0]
*/


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

	public void addToSchedule(Pair<Day, Timeframe> pair) {
		schedule.add(pair);
	}
	public void addToSchedule(Day d, Timeframe t) {
		schedule.add(new Pair<>(d, t));
	}
	public void addToSchedule(Day d, Time t1, Time t2) {
		schedule.add(new Pair<>(d, new Timeframe(t1, t2)));
	}
	public void addToSchedule(Day d, int h, int m) {
		schedule.add(new Pair<>(d, new Timeframe(new Time(h, m))));
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

	public ArrayList<Day> getDays() {
		ArrayList<Day> days = new ArrayList<>();
		for (Pair<Day, Timeframe> p: schedule) {
			if (!days.contains(p.getKey())) {
				days.add(p.getKey());
			}
		}
		return days;
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

	@Override
	public boolean equals(Object m) {
		if (!(m instanceof Modul mm)) {
			return super.equals(m);
		}
		return this.getName().equals(mm.getName())
			&& this.getProfs().equals(mm.getProfs())
			&& this.getRoom().equals(mm.getRoom())
			&& this.getType().equals(mm.getType())
			&& this.getSchedule().equals(mm.getSchedule());
	}

}
