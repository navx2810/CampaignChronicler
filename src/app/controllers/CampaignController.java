package app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import app.MasterController;
import entities.Event;
import entities.Player;

public class CampaignController {
	
	@FXML
	private ChoiceBox<Player> playersChoiceBox;
	@FXML
	private TextField eventText;
	@FXML
	private ListView<Event> eventListView;
	
	private MasterController masterController;
	
	public CampaignController() 
	{
		
	}
	
	public void setMasterController(MasterController masterController) {
		this.masterController = masterController;
	}
	
	public void addEntry()
	{ 
		if ( !eventText.getText().isEmpty() )
			masterController.eventList.add( new Event( eventText.getText(), playersChoiceBox.getValue() ) ); 
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
		masterController.save();
	}
	
	public void init()
	{
		eventListView.setItems(masterController.eventList);
		playersChoiceBox.setItems(masterController.playerList);
	}
	
	@FXML
	private void load() 
	{
		masterController.load();
	}
}
