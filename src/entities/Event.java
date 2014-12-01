package entities;

import java.io.Serializable;

public class Event implements Serializable 
{
	private static final long serialVersionUID = 6889154278632776422L;
	private String event;
	private Player player;
	
	public Event(String event, Player player) {
		this.event = event;
		this.player = player;
	}

	public String getEvent() {
		return event;
	}

	public Player getPlayer() {
		return player;
	}
	
	@Override
	public String toString() {
		return String.format("[%s]: %s", player, event);
	}
}
