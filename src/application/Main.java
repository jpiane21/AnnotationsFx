package application;
	
import application.view.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.WindowEvent;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			String resMain = "/application/view/MainWindow.fxml";

			FXMLLoader loader;
			Parent root;
		    
			loader = new FXMLLoader(getClass().getResource(resMain));
			root = (Parent)loader.load();
			MainWindow mw = loader.getController();
			mw.setStage(primaryStage);
		    primaryStage.setTitle("Worm Video");
		    Scene mwScene = new Scene(root, 1550, 775);
		    mwScene.getStylesheets().add("/application/application.css");
		    primaryStage.setScene(mwScene);
	        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	            public void handle(WindowEvent we) {

	            	mw.checkSave();
	            }
			
	        });        
	        primaryStage.show();
	     
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws FailedToLoadFxmlException {

		launch(args);
	
	}
}
