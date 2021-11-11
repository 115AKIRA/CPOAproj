package Controller;

import java.io.IOException;


import dao.factory.DAOFactory;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



public class ControllerAccueil {
	
	@FXML
    private AnchorPane Accueil;
	
	@FXML
	ImageView climage;
	
	
	
	@FXML
    void versClient	(MouseEvent event) throws IOException {
    	ImageView climage = FXMLLoader.load(getClass().getResource("/ClientPage.fxml"));
    	Accueil.getChildren().setAll(climage);
    }
	
	@FXML
    void versRevue	(MouseEvent event) throws IOException {
    	ImageView climage = FXMLLoader.load(getClass().getResource("/RevuePage.fxml"));
    	Accueil.getChildren().setAll(climage);
    }
	
	@FXML
    void versAbo	(MouseEvent event) throws IOException {
    	ImageView climage = FXMLLoader.load(getClass().getResource("/AboPage.fxml"));
    	Accueil.getChildren().setAll(climage);
    }
	

	
}

