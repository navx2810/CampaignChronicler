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
	private ListView<Player> playerListView;
	@FXML 
	private ListView<Item> playerItemListView;
	
	@Override
	public void init() {
		itemListView.setItems(screenController.masterController.itemList);
		playerListView.setItems(screenController.masterController.playerList);
		playerItemListView.setItems(playerItems);
		playerItems.clear();
	}
	
	@FXML
	private void addItem()
	{
	}
	
	@FXML
	private void removeItem()
	{
		screenController.masterController.removeItemFromCampaign(itemListView.getSelectionModel().getSelectedItem());
	}
	
	@FXML
	private void addItemToPlayer()
	{
		
	}
	
	@FXML
	private void removeItemFromPlayer()
	{
		
	}
	
	@FXML
	private void updatePlayersItems()
	{
		playerItems.clear();
		Iterator<Entry<Item, Integer>> contents = playerListView.getSelectionModel().getSelectedItem().getBackpack().entrySet().iterator();
		while ( contents.hasNext() )
			playerItems.add(contents.next().getKey());
	}
	
}
