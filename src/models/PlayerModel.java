package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.ObservableList;
import entities.Player;

public class PlayerModel implements Serializable 
{
	private ArrayList<Player> players;
	
	public PlayerModel() 
	{
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player)
	{
		players.add(player);
	}
	
	public void setPlayers(ObservableList<Player> list) 
	{
		players.clear();
		Iterator<Player> it = list.iterator();
		while(it.hasNext())
			players.add(it.next());
	}
}
