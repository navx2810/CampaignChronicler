package app;

import java.util.Iterator;

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
	
	
	public void removeItemFromCampaign(Item item)
	{
		Iterator<Player> it = playerList.iterator();
		while ( it.hasNext() )
		{
			Player player = it.next();
			if ( player.getBackpack().containsKey(item) )
				player.getBackpack().remove(item);
		}
		
		itemList.remove(item);
	}
	
	public void removePlayerFromCampaign(Player player)
	{
		playerList.remove(player);
	}
	
	public void add(Item item) { itemList.add(item); }
	public void add(Player player) { playerList.add(player); }
	public void add(Event event) { eventList.add(event); }
	
	public void init(GridPane pane)
	{
		screenController = new ScreenController(pane, this);
		screenController.init();
	}
	
	public void save() 
	{
		campaignModel.getPlayerModel().setArrayList(playerList);
		campaignModel.getEventLogModel().setArrayList(eventList);
		campaignModel.getItemModel().setArrayList(itemList);
		
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
