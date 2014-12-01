package app.controllers;

import java.util.ArrayList;

import entities.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import abstracts.AbstractViewController;

public class CampaignSaverController extends AbstractViewController {
	
	@FXML
	private ChoiceBox<Player> players;
	@FXML
	private TextField eventText;
	
	private ArrayList<Player> playersList;
	private ObservableList<Player> items;
	
	public CampaignSaverController() {
		playersList = new ArrayList<Player>();
		items = FXCollections.observableArrayList(playersList);
		
	}
	
	@FXML
	private void initialize()
	{
		players.setItems(items);
	}
	
	@FXML
	private void addPlayer() {}
	
	@FXML
	private void addItem() {}
	
	@FXML
	private void viewPlayers() {}
	
	@FXML
	private void save() {}
	
	@FXML
	private void load() {}
	
	@FXML
	private void addEntry() {}
}
