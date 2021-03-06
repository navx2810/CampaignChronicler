package entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Backpack implements Serializable
{
	private static final long serialVersionUID = -2852107685418967302L;
	private HashMap<Item, Integer> contents;
	
	public Backpack() 
	{
		contents = new HashMap<Item, Integer>();
	}
	
	public void add(Item item, int amount)
	{
		contents.put(item, amount);
	}
	
	public void remove(Item item)
	{
		contents.remove(item);
	}
	
	public Iterator<Entry<Item, Integer>> getContents() 
	{
		return contents.entrySet().iterator();
	}
}
