package Controller;

import java.io.IOException;

import modele.Client;
import dao.factory.DAOFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;

public class ControllerClient {
	
	@FXML
	private Button btn_suppr;
	@FXML
	private Button btn_modif;
	@FXML
	private Button btn_ajt1;
	
	
	@FXML
	private TextField txt_num;
	@FXML
	private TextField txt_nom;
	@FXML
	private TextField txt_prenom;
	@FXML
	private TextField txt_rue;
	@FXML
	private TextField txt_voie;
	@FXML
	private TextField txt_code;
	@FXML
	private TextField txt_ville;
	@FXML
	private TextField txt_pays;
	
	
	
	//--
	
	
	
	 @FXML
	    void creerModele(ActionEvent event) 
	    {
	    
	    	
	    	
	    	String nom = txt_nom.getText();
	    	String prenom = txt_prenom.getText();
			String rue = txt_rue.getText();
			String voie = txt_voie.getText();
	    	String code = txt_code.getText();
	    	String ville = txt_ville.getText();
	    	String pays = txt_pays.getText();
	    	
	    	
	    	Client c = new Client( nom, prenom, rue, voie, code, ville, pays );
	    	{
	    	
	    	daof.getClientDAO().create(c);
	    	
	    	}
	    	
	    	c.setIdClient(id);
			daof.getClientDAO().update(c);
			
			public void modifierClient(Client cli)
		    {
		    	
		    	
		    	txt_num = cli.getClient();
				txt_nom.setText(cli.getNom());
				txt_prenom.setText(cli.getPrenom());
				txt_rue.setText(cli.getrue());
				txt_voie.setText(cli.getvoie());
				txt_code.setText(cli.getCode());
				txt_ville.setText(cli.getVille());
				txt_pays.setText(cli.getPays());
				
				
		    }
			
			

	    	
	    	
	    	
	    }
}
