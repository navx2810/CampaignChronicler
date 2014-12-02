package app;

import app.controllers.CampaignController;
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
			campaignController.setMasterController(masterController);
			campaignController.init();
			
			switchToCampaignView();
		} catch(Exception e) { e.printStackTrace(); }
	}

}
