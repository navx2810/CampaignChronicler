package entities;

public class Item {
	private String name;
	private int count;
	
	public Item(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public Item(String name) {
		this(name, 1);
	}
	
	public int getCount() {
		return count;
	}
	
	public String getName() {
		return name;
	}
	
	
}
