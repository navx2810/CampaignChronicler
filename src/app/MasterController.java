package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import entities.Event;
import entities.Item;
import entities.Player;
import models.CampaignModel;
import utils.FileHelper;

public class MasterController {

	public CampaignModel campaignModel;
	public ScreenController screenController;
	
	public ObservableList<Player> playerList;
	public ObservableList<Event> eventList;
	public ObservableList<Item> itemList;
	
	public MasterController() {
		playerList = FXCollections.observableArrayList();
		eventList = FXCollections.observableArrayList();
		itemList = FXCollections.observableArrayList();
		
		campaignModel = new CampaignModel();
	}
	
	public void init(GridPane pane)
	{
		screenController = new ScreenController(pane, this);
		screenController.init();
	}
	
	public void save() 
	{
		if ( FileHelper.saveCampaign(campaignModel) )
			System.out.println("Save Complete");
		else
			System.out.println("Save Failed");
	}
	
	public void load() 
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