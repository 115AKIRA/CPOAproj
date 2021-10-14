package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modele.Client;

class ClientTest {

/*	@Test
	public void testPaysSuisseOK() {
		try {
			Client c = new Client();
			c.setPays("sUISSE");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysSchweizOK() {
		try {
			Client c = new Client();
			c.setPays("    SchweIZ      ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysLetzebuergOK() {
		try {
			Client c = new Client();
			c.setPays("          LETZEbuerg");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysLuxembourgOK() {
		try {
			Client c = new Client();
			c.setPays("LuxembOURG        ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysBelgiumOK() {
		try {
			Client c = new Client();
			c.setPays("                      belgium");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysBelgiqueOK() {
		try {
			Client c = new Client();
			c.setPays("BELGIQUe");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysVideNOK() {
		try {
			Client c = new Client();
			c.setPays("                           ");
			fail("Exception non lancée !");
		} catch ( IllegalArgumentException iae ) {
			 //rien
		}
	}
	
	@Test
	public void testPaysAutre() {
		try {
			Client c = new Client();
			c.setPays("france ");
			fail("Exception non lancée !");
		} catch ( IllegalArgumentException iae ) {
			//rien
		}
	}
	
	 //Diagnostique Pays : TOUT OK!
	
	
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
			c.setVille("    st julien LES metz     ");
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
*/	
	 //Diagnostique Ville : Tout OK !
	
	
	@Test
	public void testVoieNOK() {
       try {
	    	Client c = new Client();
	    	c.setVoie("         ");
	    	fail("Exception non lancée !");
	    } catch(IllegalArgumentException iae) {
	    	//rien
	    }
    }
	
	@Test
	public void testVoie1erCharLettreNOK() {
       try {
	    	Client c = new Client();
	    	c.setVoie("b 15 rue des capucins");
	    	fail("Exception non lancée !");
	    } catch(IllegalArgumentException iae) {
	    	//rien
	    }
    }
	
	@Test
	public void testVoieAvenueOK() {
       try {
	    	Client c = new Client();
	    	c.setVoie("15 AV. Victor Hugo");
	    } catch(IllegalArgumentException iae) {
	    	fail("Exception lancée par erreur !");
	    }
    }
	
	@Test
	public void testVoieBoulevardOK() {
       try {
	    	Client c = new Client();
	    	c.setVoie("37 boul du tilleul");
	    } catch(IllegalArgumentException iae) {
	    	fail("Exception lancée par erreur !");
	    }
    }
	
	@Test
	public void testVoieRueOK() {
       try {
	    	Client c = new Client();
	    	c.setVoie("117 rue du martyr");
	    } catch(IllegalArgumentException iae) {
	    	fail("Exception lancée par erreur !");
	    }
    }
	
	 //Diagnostique Voie : Tout OK !
	
	
	
	

}
