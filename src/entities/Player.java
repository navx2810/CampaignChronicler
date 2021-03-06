package entities;

import java.io.Serializable;

public class Player implements Serializable
{
	private static final long serialVersionUID = 1757142403627798478L;
	private String character_name, player_name;
	private Backpack backpack;
	
	public Player(String character_name, String player_name) 
	{
		this.character_name = character_name;
		this.player_name = player_name;
		backpack = new Backpack();
	}
	
	public Backpack getBackpack() 
	{
		return backpack;
	}
	
	public String getCharacterName() 
	{
		return character_name;
	}
	
	public String getPlayerName() 
	{
		return player_name;
	}
	
	@Override
	public String toString() 
	{
		return character_name;
	}
}
