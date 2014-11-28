package models;

import java.util.ArrayList;

import entities.Player;

public class PlayerModel 
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
	
	public Player getPlayer(Player player)
	{
		int index = players.indexOf(player);
		return players.get(index);
	}
}
