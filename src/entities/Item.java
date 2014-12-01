package entities;

import java.io.Serializable;

public class Item implements Serializable
{
	private static final long serialVersionUID = -805771972739606068L;
	private String name;
	
	public Item(String name, int count) {
		this.name = name;
	}

	public Item(String name) {
		this(name, 1);
	}
	
	@Override
	public String toString() {
		return name;
	}
}
