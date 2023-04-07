package org.example.Modul;

public class Prof {
	private final String name;

	public Prof(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object p) {
		if (!(p instanceof Prof)) {
			return super.equals(p);
		}
		String pName = ((Prof) p).getName();
		return this.getName().equals(pName);
	}

	@Override
	public String toString() {
		return getName();
	}
}
