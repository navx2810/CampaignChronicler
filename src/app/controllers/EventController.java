package app.controllers;

import entities.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import abstracts.AbstractViewController;

public class EventController extends AbstractViewController 
{
	@FXML
	private ListView<Event> eventListView;
	
	@FXML
	private void removeEvent()
	{
		Event toRemove = eventListView.getSelectionModel().getSelectedItem();
		if ( toRemove != null)
			screenController.masterController.eventList.remove(toRemove);
	}

	@Override
	public void init() 
	{
		eventListView.setItems(screenController.masterController.eventList);
	}
	
	@FXML
	private void returnTo()
	{
		screenController.switchToCampaignView();
	}
}
