package graphic;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
    		//URL fxmlURL = getClass().getResource("/rrr.fxml");
    		//FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
    		BorderPane root = new BorderPane();
    		//Node root = fxmlLoader.load();
    		Scene scene = new Scene((BorderPane) root, 640, 400);
    		
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Ma première fenêtre JavaFX");
    		primaryStage.show();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
	
	public static void main(String[] args) {
		launch(args);

	}

}
