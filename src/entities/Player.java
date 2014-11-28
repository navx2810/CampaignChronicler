package entities;

public class Player {
	private String character_name, player_name;
	private Backpack backpack;
	
	public Player(String character_name, String player_name) {
		this.character_name = character_name;
		this.player_name = player_name;
		backpack = new Backpack();
	}
	
	public Backpack getBackpack() {
		return backpack;
	}
	
	@Override
	public String toString() {
		return character_name;
	}
}
