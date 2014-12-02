package app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import app.ScreenController;
import entities.Event;
import entities.Player;

public class CampaignController {
	
	@FXML
	private ChoiceBox<Player> playersChoiceBox;
	@FXML
	private TextField eventText;
	@FXML
	private ListView<Event> eventListView;
	
	private ScreenController screenController;
	
	public CampaignController() 
	{
		
	}
	
	public void setScreenController(ScreenController screenController) {
		this.screenController = screenController;
	}
	
	public void addEntry()
	{ 
		if ( !eventText.getText().isEmpty() )
			screenController.masterController.eventList.add( new Event( eventText.getText(), playersChoiceBox.getValue() ) ); 
		eventText.clear();
	}

	@FXML
	private void managePlayers() {}
	@FXML
	private void manageItems() {}
	@FXML
	private void manageEvents() {}
	@FXML
	private void save() 
	{
		screenController.masterController.save();
	}
	
	public void init()
	{
		eventListView.setItems(screenController.masterController.eventList);
		playersChoiceBox.setItems(screenController.masterController.playerList);
	}
	
	@FXML
	private void load() 
	{
		screenController.masterController.load();
	}
}
