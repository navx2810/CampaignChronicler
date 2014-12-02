package app;
	
import java.io.IOException;

import app.controllers.CampaignController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public GridPane rootPane;
	private BorderPane campaignPane;
	private MasterController masterController;
	
	@Override
	public void start(Stage primaryStage) throws IOException 
	{
		masterController = new MasterController();
		
		loadPanes();
		
		Scene scene = new Scene(rootPane);
		scene.getStylesheets().add(Main.class.getResource("main.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void loadPanes() throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("views/RootPaneView.fxml"));
		rootPane = (GridPane) loader.load();
		
		masterController.init(rootPane);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
