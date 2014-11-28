package entities;

import java.util.ArrayList;

public class Backpack 
{
	private ArrayList<Item> contents;
	
	public Backpack() {
		contents = new ArrayList<Item>();
	}
	
	public void Add(Item item)
	{
		contents.add(item);
	}
	
	public void Remove(Item item)
	{
		contents.remove(item);
	}
	
	public ArrayList<Item> getContents() {
		return contents;
	}
}
