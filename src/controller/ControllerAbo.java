package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.Periodicite;


	public class ControllerAbo implements Initializable {
	    @FXML private Button btn_ajt;
	    @FXML private Button btn_suppr;
	    @FXML private TextField txt_prenom;
	    @FXML private TextField txt_revue;
	    @FXML private TextField txt_datedeb;
	    
	    @FXML private ComboBox<Periodicite> combo_Periodicite;

}
