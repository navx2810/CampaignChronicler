package app.controllers;

import entities.Player;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import abstracts.AbstractViewController;

public class PlayerController extends AbstractViewController{

	@FXML
	private TextField playerName;
	@FXML
	private TextField characterName;
	@FXML
	private ListView<Player> playerListView;
	
	@Override
	public void init() 
	{
		playerListView.setItems(screenController.masterController.playerList);
	}

	@FXML
	private void addPlayer()
	{
		if ( !playerName.getText().isEmpty() && !characterName.getText().isEmpty() )
			screenController.masterController.add(new Player(characterName.getText(), playerName.getText()));
	}
	
	@FXML 
	private void deletePlayer()
	{
		Player toDelete = playerListView.getSelectionModel().getSelectedItem();
		if (  toDelete != null )
			screenController.masterController.removePlayerFromCampaign(toDelete);
	}

}
