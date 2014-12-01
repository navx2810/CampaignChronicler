package entities;

public class Item {
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
	
	
}
