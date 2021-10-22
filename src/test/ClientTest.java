package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modele.Client;

class ClientTest {
	
	private Client c;
	
	@BeforeEach
	public void setUp() {
		this.c = new Client();
	}

	@Test
	public void testPaysSuisseOK() {
		try {
			
			this.c.setPays("sUISSE");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysSchweizOK() {
		try {
			
			this.c.setPays("    SchweIZ      ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysLetzebuergOK() {
		try {
			
			this.c.setPays("          LETZEbuerg");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysLuxembourgOK() {
		try {
			
			this.c.setPays("LuxembOURG        ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysBelgiumOK() {
		try {
			
			this.c.setPays("                      belgium");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysBelgiqueOK() {
		try {
			
			this.c.setPays("BELGIQUe");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testPaysVideNOK() {
		try {
			
			this.c.setPays("                           ");
			fail("Exception non lancée !");
		} catch ( IllegalArgumentException iae ) {
			 //rien
		}
	}
	
	@Test
	public void testPaysAutre() {
		try {
			
			this.c.setPays("france ");
			fail("Exception non lancée !");
		} catch ( IllegalArgumentException iae ) {
			//rien
		}
	}
	
	 //Diagnostique Pays : TOUT OK!
	
	
	@Test
	public void testVilleSimpleOK() {
		try {
			
			this.c.setVille("mETZ    ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testVilleLesOK() {
		try {
			
			this.c.setVille("    st julien LES metz     ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testVilleEspacesOK() {
		try {
			
			this.c.setVille("    los angeles    ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
	
	@Test
	public void testVilleLeDebutOK() {
		try {
			
			this.c.setVille("la grange    ");
		} catch ( IllegalArgumentException iae ) {
			fail("Exception lancée par erreur !");
		}
	}
		
	 //Diagnostique Ville : Tout OK !
	
	
	@Test
	public void testVoieNOK() {
       try {
	    	
	    	this.c.setVoie("         ");
	    	fail("Exception non lancée !");
	    } catch(IllegalArgumentException iae) {
	    	//rien
	    }
    }
	
	@Test
	public void testVoie1erCharLettreNOK() {
       try {
	    	
	    	this.c.setVoie("b 15 rue des capucins");
	    	fail("Exception non lancée !");
	    } catch(IllegalArgumentException iae) {
	    	//rien
	    }
    }
	
	@Test
	public void testVoieAvenueOK() {
       try {
	    	
	    	this.c.setVoie("15 AV. Victor Hugo");
	    } catch(IllegalArgumentException iae) {
	    	fail("Exception lancée par erreur !");
	    }
    }
	
	@Test
	public void testVoieBoulevardOK() {
       try {
	    	
	    	this.c.setVoie("37 boul du tilleul");
	    } catch(IllegalArgumentException iae) {
	    	fail("Exception lancée par erreur !");
	    }
    }
	
	@Test
	public void testVoieRueOK() {
       try {
	    	
	    	this.c.setVoie("117 rue du martyr");
	    } catch(IllegalArgumentException iae) {
	    	fail("Exception lancée par erreur !");
	    }
    }
    
	 //Diagnostique Voie : Tout OK !
	
	@Test
    public void testCodePostal1OK() {
        try {
            
            this.c.setCodePostal("57000");
        } catch ( IllegalArgumentException iae ) {
        	fail("Exception anormale!");
        }
    }
	
	@Test
	public void testCodePostal2OK() {
        try {
            
            this.c.setCodePostal("L-50");
        } catch ( IllegalArgumentException iae ) {
        	fail("Exception anormale !");
        }
    }
	
	@Test
	public void testCodePostal3NOK() {
        try {
            
            this.c.setCodePostal("abc");
            fail("Exception non lancée !");
        } catch ( IllegalArgumentException iae ) {

        }
    }
	
	@Test
	public void testCodePostal4NOK() {
        try {
            
            this.c.setCodePostal("");
            fail("Exception non lancée !");
        } catch ( IllegalArgumentException iae ) {

        }
    }
	
	//Diagnostique Code Postal : Tout OK !

}
