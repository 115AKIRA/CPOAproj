package graphic;

import java.net.URL;
import java.util.ResourceBundle;

import dao.factory.DAOFactory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label; 
import javafx.scene.control.ComboBox;
import modele.Periodicite;
import modele.Revue;


public class CtrlRevue  extends Application implements Initializable{
    @FXML private Button btn_creer;
    @FXML private TextField txt_Tarif;
    @FXML private TextField txt_Titre;
    @FXML private TextField txt_Description;
    @FXML private Label lbl_recap;
    @FXML private ComboBox<Periodicite> combo_Periodicite;
    
    private static DAOFactory DAO = null;

    
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    	
    try {
		combo_Periodicite.setItems(FXCollections.observableArrayList(DAO.getPeriodiciteDAO().findAll()));
		
		lbl_recap.setText("");
	} catch (Exception e) {
		e.printStackTrace();
		}

    }


    public void Afficherecap(ActionEvent event ) {
        String s1 = txt_Titre.getText();
        String s2 = txt_Tarif.getText();
        String recap = s1 + " ("+s2+" euros"+")";
        lbl_recap.setText(String.valueOf(recap));
    }


    public void creerModele(ActionEvent event) {
    	
    	if ( txt_Titre.getText().trim().isEmpty()) {
    		lbl_recap.setText(lbl_recap + " pas de titre");
    	}
    	
    	if ( txt_Description.getText().trim().isEmpty() ) {
    		lbl_recap.setText(lbl_recap + " pas de description");
    	}
    	
    	if ( txt_Tarif.getText().trim().isEmpty()) {
    		lbl_recap.setText(lbl_recap + " pas de tarif");
    	}
    	
    	if ( txt_Titre.getText().trim().isEmpty()) {
    		lbl_recap.setText("pas de titre");
    	}
    	
    	if ( combo_Periodicite.getItems().isEmpty() ) {
    		lbl_recap.setText(lbl_recap + " pas de periodicite");
    	}
    	
    	
    	if ( lbl_recap.getText().isEmpty()) {
    		
    		Revue r = new Revue();
    		r.setTitre(txt_Titre.getText());
    		r.setDescription(txt_Description.getText());
    		r.setTarifNumero(Float.parseFloat(txt_Tarif.getText()));
    		r.setIdPeriodicite(combo_Periodicite.getSelectionModel().getSelectedIndex());   
    		
    		try {
				DAO.getRevueDAO().create(r);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	
    	
    }
    
    public void start(Stage primaryStage) throws Exception {
    	try {
    		URL fxmlURL = getClass().getResource("/RevuePage.fxml");
    		FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
    		Node root = fxmlLoader.load();
    		Scene scene = new Scene((VBox) root, 640, 400);
    		
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Ma première fenêtre JavaFX");
    		primaryStage.show();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}