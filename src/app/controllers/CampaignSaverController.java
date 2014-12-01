package app.controllers;

import utils.FileHelper;
import models.CampaignModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import abstracts.AbstractViewController;
import entities.Event;
import entities.Item;
import entities.Player;

public class CampaignSaverController extends AbstractViewController {
	
	@FXML
	private ChoiceBox<Player> playersChoiceBox;
	@FXML
	private TextField eventText;
	@FXML
	private ListView<Event> eventListView;
	
	private CampaignModel campaignModel;
	
	private ObservableList<Player> playerList;
	private ObservableList<Event> eventList;
	private ObservableList<Item> itemList;
	
	public CampaignSaverController() 
	{
		playerList = FXCollections.observableArrayList();
		eventList = FXCollections.observableArrayList();
		itemList = FXCollections.observableArrayList();
		
		campaignModel = new CampaignModel();
	}
	
	@FXML
	private void initialize()
	{
		loadLists();
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
	private void load() 
	{
		CampaignModel temp = FileHelper.loadCampaign();
		if ( temp != null )
		{
			campaignModel = temp;
			loadLists();
		}
			
	}
	
	private void loadLists() 
	{
		playerList.clear();
		eventList.clear();
		itemList.clear();
		
		playerList.addAll(campaignModel.getPlayerModel().getArrayList());
		eventList.addAll(campaignModel.getEventLogModel().getArrayList());
	}

	

	@FXML
	private void addEntry() { System.out.println("I got here"); }
}
