package entities;

import java.io.Serializable;

public class Item implements Serializable
{
	private String name;
	
	public Item(String name, int count) {
		this.name = name;
	}

	public Item(String name) {
		this(name, 1);
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
