package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modele.Client;

class ClientTest {

//	@Test
//	public void testPaysSuisseOK() {
//		try {
//			Client c = new Client();
//			c.setPays("sUISSE");
//		} catch ( IllegalArgumentException iae ) {
//			fail("Exception lancée par erreur !");
//		}
//	}
//	
//	@Test
//	public void testPaysSchweizOK() {
//		try {
//			Client c = new Client();
//			c.setPays("    SchweIZ      ");
//		} catch ( IllegalArgumentException iae ) {
//			fail("Exception lancée par erreur !");
//		}
//	}
//	
//	@Test
//	public void testPaysLetzebuergOK() {
//		try {
//			Client c = new Client();
//			c.setPays("          LETZEbuerg");
//		} catch ( IllegalArgumentException iae ) {
//			fail("Exception lancée par erreur !");
//		}
//	}
//	
//	@Test
//	public void testPaysLuxembourgOK() {
//		try {
//			Client c = new Client();
//			c.setPays("LuxembOURG        ");
//		} catch ( IllegalArgumentException iae ) {
//			fail("Exception lancée par erreur !");
//		}
//	}
//	
//	@Test
//	public void testPaysBelgiumOK() {
//		try {
//			Client c = new Client();
//			c.setPays("                      belgium");
//		} catch ( IllegalArgumentException iae ) {
//			fail("Exception lancée par erreur !");
//		}
//	}
//	
//	@Test
//	public void testPaysBelgiqueOK() {
//		try {
//			Client c = new Client();
//			c.setPays("BELGIQUe");
//		} catch ( IllegalArgumentException iae ) {
//			fail("Exception lancée par erreur !");
//		}
//	}
//	
//	@Test
//	public void testPaysVideNOK() {
//		try {
//			Client c = new Client();
//			c.setPays("                           ");
//			fail("Exception non lancée !");
//		} catch ( IllegalArgumentException iae ) {
//			// rien
//		}
//	}
//	
//	@Test
//	public void testPaysAutre() {
//		try {
//			Client c = new Client();
//			c.setPays("france ");
//			fail("Exception non lancée !");
//		} catch ( IllegalArgumentException iae ) {
//			//rien
//		}
//	}
	
	// Diagnostique Pays : TOUT OK!
	
	
	@Test
	public void testVilleSimpleOK() {
		try {
			Client c = new Client();
			c.setVille("mETZ    ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testVilleLesOK() {
		try {
			Client c = new Client();
			c.setVille("    st julien les metz     ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testVilleEspacesOK() {
		try {
			Client c = new Client();
			c.setVille("    los angeles    ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testVilleLeDebutOK() {
		try {
			Client c = new Client();
			c.setVille("la grange    ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	// Diagnostique Ville : Tout OK !
	
	public void codepostaleTest(String code_postal) {
        
	    int stringLength = code_postal.length();
	            
	    code_postal = code_postal.replaceAll("[^\\d.]", "");
	    code_postal = code_postal.replaceAll("-", "");
	    
	    while (stringLength < 5 ) {
	        code_postal =( "0"+ code_postal);
	    }
	    
	}
	
	

}
