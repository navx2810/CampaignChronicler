package app.controllers;

import java.util.Iterator;
import java.util.Map.Entry;

import entities.Item;
import entities.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import abstracts.AbstractViewController;

public class ItemController extends AbstractViewController {

	public ObservableList<Item> playerItems = FXCollections.observableArrayList();
	
	@FXML
	private TextField itemName;
	@FXML
	private ListView<Item> itemListView;
	@FXML
	private ListView<Player> playerListViewForAdd;
	@FXML
	private ListView<Player> playerListViewForDelete;
	@FXML 
	private ListView<Item> playerItemListView;
	
	@Override
	public void init() {
		itemListView.setItems(screenController.masterController.itemList);
		playerListViewForAdd.setItems(screenController.masterController.playerList);
		playerListViewForDelete.setItems(screenController.masterController.playerList);
		playerItemListView.setItems(playerItems);
		playerItems.clear();
	}
	
	@FXML
	private void addItem()
	{
		if ( !itemName.getText().isEmpty() )
		{
			screenController.masterController.add(new Item( itemName.getText() ));
			itemName.clear();
		}
	}
	
	@FXML
	private void removeItem()
	{
		screenController.masterController.removeItemFromCampaign(itemListView.getSelectionModel().getSelectedItem());
	}
	
	@FXML
	private void addItemToPlayer()
	{
		Player selectedPlayer = playerListViewForAdd.getSelectionModel().getSelectedItem();
		Item selectedItem = itemListView.getSelectionModel().getSelectedItem();
		
		if ( selectedItem != null || selectedPlayer != null )
			if ( selectedPlayer.getBackpack().containsKey(selectedItem) )
				selectedPlayer.getBackpack().put(selectedItem, selectedPlayer.getBackpack().get(selectedItem) + 1);
			else
				selectedPlayer.getBackpack().put(selectedItem, 1);
	}
	
	@FXML
	private void removeItemFromPlayer()
	{
		Player selectedPlayer = playerListViewForDelete.getSelectionModel().getSelectedItem();
		Item selectedItem = itemListView.getSelectionModel().getSelectedItem();
		
		if ( selectedItem != null || selectedPlayer != null )
			if ( selectedPlayer.getBackpack().containsKey(selectedItem) )
				selectedPlayer.getBackpack().remove(selectedItem);
		
		updatePlayersItems();
	}
	
	@FXML
	private void updatePlayersItems()
	{
		playerItems.clear();
		Iterator<Entry<Item, Integer>> contents = playerListViewForDelete.getSelectionModel().getSelectedItem().getBackpack().entrySet().iterator();
		while ( contents.hasNext() )
			playerItems.add(contents.next().getKey());
	}
	
	@FXML
	private void returnTo()
	{
		screenController.switchToCampaignView();
	}
}
