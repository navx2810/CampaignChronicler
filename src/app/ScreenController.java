package app;

import app.controllers.CampaignController;
import app.controllers.EventController;
import app.controllers.ItemController;
import app.controllers.PlayerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class ScreenController {

	private GridPane rootPane;
	private BorderPane campaignView, playerView, itemView, eventView;
	public MasterController masterController;
	
	public ScreenController(GridPane pane, MasterController masterController) 
	{
		rootPane = pane;
		this.masterController = masterController;
	}
	
	
	public void switchToCampaignView()
	{
		switchToView(campaignView);
	}
	
	public void switchToItemView()
	{
		switchToView(itemView);
	}
	
	public void switchToPlayerView()
	{
		switchToView(playerView);
	}
	
	public void switchToEventView()
	{
		switchToView(eventView);
	}
	
	private void switchToView(BorderPane view)
	{
		rootPane.getChildren().clear();
		rootPane.getChildren().add(view);
	}
	
	public void init()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(getClass().getResource("controllers/CampaignView.fxml"));
			campaignView = (BorderPane) loader.load();
			CampaignController campaignController = loader.getController();
			campaignController.setScreenController(this);
			campaignController.init();
			
			loader = new FXMLLoader(getClass().getResource("controllers/EventView.fxml"));
			eventView = (BorderPane) loader.load();
			EventController eventController = loader.getController();
			eventController.setScreenController(this);
			eventController.init();
			
			loader = new FXMLLoader(getClass().getResource("controllers/ItemView.fxml"));
			itemView = (BorderPane) loader.load();
			ItemController itemController = loader.getController();
			itemController.setScreenController(this);
			itemController.init();
			
			loader = new FXMLLoader(getClass().getResource("controllers/PlayerView.fxml"));
			playerView = (BorderPane) loader.load();
			PlayerController playerController = loader.getController();
			playerController.setScreenController(this);
			playerController.init();
			
			
			switchToCampaignView();
		} catch(Exception e) { e.printStackTrace(); }
	}

}
