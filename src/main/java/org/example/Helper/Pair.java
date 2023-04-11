package org.example.Helper;

public class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}


	@Override
	public boolean equals(Object p) {
		if (!(p instanceof Pair<?, ?>)) {
			return super.equals(p);
		}
		return getKey().equals(((Pair<?, ?>) p).getKey())
			&& getValue().equals(((Pair<?, ?>) p).getValue());
	}

	@Override
	public String toString() {
		return getKey().toString() + ": " + getValue().toString();
	}

}
