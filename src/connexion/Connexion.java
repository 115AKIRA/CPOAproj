package connexion;

import java.sql.*;

public class Connexion {
	public Connection creeConnexion() {
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/baggioko1u_javatd1";
		url += "?serverTimezone=Europe/Paris";
		String login = "baggioko1u_appli";
		String pwd = "32019084";
		Connection maConnexion = null;
		try {
			maConnexion = DriverManager.getConnection(url, login, pwd);
		} catch (SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnexion;
	}
	
}
