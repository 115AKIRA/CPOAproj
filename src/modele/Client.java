package modele;

import java.sql.*;

import connexion.Connexion;

public class Client {

    //Supprimer Client
    
    public void ClientSuppr(int id_client) {
        try {
            Connexion c = new Connexion();
            Connection laConnexion = c.creeConnexion();
            PreparedStatement requete = 
            
            laConnexion.prepareStatement("delete from Client where id_client=?");
            requete.setInt(1, id_client);
            int nbLignes = requete.executeUpdate();
            System.out.println("Update:" + nbLignes);

        if (requete != null)
            requete.close();
            
        if (laConnexion != null)
            laConnexion.close();
            
    } catch (SQLException sqle) {
            System.out.println("Pb dans select " + sqle.getMessage());
            }
    }
    
    //Ajout Client
    
        public void ClientAjout(String nom, String prenom , String no_rue , String voie , String code_postal , String ville , String pays   ) {
            try {
                Connexion c = new Connexion();
                Connection laConnexion = c.creeConnexion();
                PreparedStatement requete = 
                        
                laConnexion.prepareStatement("insert into Client (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                requete.setString(1, nom);
                requete.setString(2, prenom);
                requete.setString(3, no_rue);
                requete.setString(4, voie);
                requete.setString(5, code_postal);
                requete.setString(6, ville);
                requete.setString(7, pays);
                int nbLignes = requete.executeUpdate();
                System.out.println("Update:" + nbLignes);
                ResultSet res = requete.getGeneratedKeys();
                if (res.next()) {
                int cle = res.getInt(1); 
                System.out.println("Cle:" + cle);
                    }
            
            if (res != null)
                res.close();
                
            if (requete != null)
                requete.close();
                
            if (laConnexion != null)
                laConnexion.close();
                
        } catch (SQLException sqle) {
                System.out.println("Pb dans select " + sqle.getMessage());
                }
        }    
    
        
        //Modifier Client

        public void ClientModif(int id_client, String nom, String prenom , String no_rue , String voie , String code_postal , String ville , String pays) {
            try {
                Connexion c = new Connexion();
                Connection laConnexion = c.creeConnexion();
                PreparedStatement requete = 
                        
                laConnexion.prepareStatement("update Client set nom =?, prenom =?, no_rue =?, voie =?, code_postal=?, ville=?, pays=? where id_client =?");
                requete.setString(1, nom);
                requete.setString(2, prenom);
                requete.setString(3, no_rue);
                requete.setString(4, voie);
                requete.setString(5, code_postal);
                requete.setString(6, ville);
                requete.setString(7, pays);
                requete.setInt(8, id_client);
                
                
                
                int nbLignes = requete.executeUpdate();
                System.out.println("Update:" + nbLignes);
                
            if (requete != null)
                requete.close();
                
            if (laConnexion != null)
                laConnexion.close();
                
        } catch (SQLException sqle) {
                System.out.println("Pb dans select " + sqle.getMessage());
                }
        }
        
        
        
}
