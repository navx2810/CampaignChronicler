package models;

import java.util.ArrayList;

import entities.Event;

public class EventLogModel 
{
	private ArrayList<Event> events;
	
	public EventLogModel() {
		events = new ArrayList<Event>();
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}
}
