package app;
	
import java.io.IOException;

import app.controllers.CampaignSaverController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public GridPane rootPane;
	private BorderPane campaignPane;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		loadPanes();
		
		Scene scene = new Scene(rootPane);
		scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void loadPanes() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("views/RootPaneView.fxml"));
		rootPane = (GridPane) loader.load();
		
		loader = new FXMLLoader(getClass().getResource("controllers/CampaignSaverView.fxml"));
		campaignPane = (BorderPane) loader.load();
		CampaignSaverController saverController = loader.getController();
		saverController.setRootPane(rootPane);
		
		rootPane.getChildren().add(campaignPane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
