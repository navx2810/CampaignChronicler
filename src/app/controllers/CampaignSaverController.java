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
	
	public void addPlayer() {}
	public void addItem() {}
	public void addEntry()
	{ 
		if ( !eventText.getText().isEmpty() )
			eventList.add( new Event( eventText.getText(), playersChoiceBox.getValue() ) ); 
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
		if ( FileHelper.saveCampaign(campaignModel) )
			System.out.println("Save Complete");
		else
			System.out.println("Save Failed");
	}
	@FXML
	private void initialize()
	{
		loadLists();
		
		eventListView.setItems(eventList);
		playersChoiceBox.setItems(playerList);
	}
	
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
		itemList.addAll(campaignModel.getItemModel().getArrayList());
		
		playerList.add(new Player("TemporaryGreg", "Greg"));
	}


}
