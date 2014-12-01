package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.ObservableList;
import entities.Event;

public class EventLogModel implements Serializable
{
	private ArrayList<Event> events;
	
	public EventLogModel() 
	{
		events = new ArrayList<Event>();
	}
	
	public ArrayList<Event> getEvents() 
	{
		return events;
	}
	
	public void setEvents(ObservableList<Event> list)
	{
		events.clear();
		Iterator<Event> it = list.iterator();
		while(it.hasNext())
			events.add(it.next());
	}
}
